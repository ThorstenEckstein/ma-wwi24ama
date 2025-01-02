
    //tag::bad-code-example-1[]
    public StateMachine<Task, TaskState, TaskAction, ObjectId> getTaskWorkflow(){
        return StateMachine.<Task,TaskState,TaskAction, ObjectId>build()
            .withLogger(log)
            .withDefaultState(TaskState.DEFAULT)
            ...
    //end::bad-code-example-1[]
            .withService(taskService)
            .withDefaultTransitionAction(auditLoggingService::logWorkflowTransition)
            .withTransitionFrom(TaskState.draft).trigger(TaskAction.publish).to(TaskState.published)
                .withActor(task -> task.getOwner())
                //KMP-101: Task responsible employees are allowed to publish a task
                .validator((entity, data, from, to, user) -> securityService.assertRole(user, ROLE_TASK_RESP)) 
                .validator(userIsOwnerValidator)
                .validator((task, data, from, to, user) -> {
                    Set<String> missing = new HashSet<>();
                    Map<String,String> invalid = new HashMap<>();
                    if (task.getCapacity() == null) {
                        missing.addAll(Arrays.asList("capacity.start", "capacity.end", "capacity.minutesPerWeek", "capacity.numEmployees"));
                    } else {
                        Capacity capacity = task.getCapacity();
                        if (capacity.getStart() == null) {
                            missing.add("capacity.start");
                        }
                        if (capacity.getEnd() == null) {
                            missing.add("capacity.end");
                        }
                        if(capacity.getStart() != null && capacity.getEnd() != null){
                            Date maxEnd = DateHelper.addDuration(capacity.getStart(),taskConfig.getMaxDuration());
                            if(capacity.getEnd().after(maxEnd) && !DateUtils.isSameDay(maxEnd, capacity.getEnd())) {
                                invalid.put("capacity.end", "A Task MUST NOT be longer as duration: '"+taskConfig.getMaxDuration()
                                        +"' (start: " + ISO_DATE_FORMAT.format(capacity.getStart()) 
                                        + ", end: " +ISO_DATE_FORMAT.format(capacity.getEnd()) + ")");
                            }
                        }
                        if (task.getCapacity().getMinutesPerWeek() == null) {
                            missing.add("capacity.minutesPerWeek");
                        }
                        if(task.getCapacity().getNumEmployees() == null){
                            missing.add("capacity.numEmployees");
                        }
                    }
                    if (StringUtils.isBlank(task.getCustomerField())) {
                        missing.add("customerField");
                    }
                    if (!task.hasDescription()) {
                        missing.add("description");
                    }
                    if (!task.hasTitle()) {
                        missing.add("title");
                    }
                    if (task.getValidUntil() == null) {
                        missing.add("validUntil");
                    }
                    if (!task.hasWhatWeOffer()) {
                        missing.add("whatWeOffer");
                    }
                    if (task.getWorkLocation() == null || StringUtils.isBlank(task.getWorkLocation().getName())) {
                        missing.add("worklocation.name");
                    }
                    ValidationHelper.validateSkillData(skillService, task, missing);
                    if (!missing.isEmpty() || !invalid.isEmpty()) {
                        throw new InvalidOrMissingFieldsException(TASK_PUBLISH_VALIDATION_FAILED, Task.class, invalid, missing);
                    } //else everything looks fine :)
                })
                .action((task, data, from, to, user) -> {
                    taskMailingService.taskPublishedNotification(task, user);
                    return task;
                })
                .createAndAdd()
            .withTransitionFrom(TaskState.published).trigger(TaskAction.archive).to(TaskState.archived)
                .withActor(task -> task.getOwner())
                .validator((entity, data, from, to, user) -> securityService.assertRole(user, ROLE_TASK_RESP))
                .validator(userIsOwnerValidator)
                .validator((task, data, from, to, user) -> {
                    Date now = new Date();
                    Date end = task.getCapacity() == null ? null : task.getCapacity().getEnd();
                    boolean expired = end != null && end.before(now) && !DateUtils.isSameDay(end, now);
                    if(!expired){
                        Iterable<Tender> awardedTenders = tenderService.getTaskTenders(task.getId(),EnumSet.of(TenderState.awarded));
                        if(awardedTenders.iterator().hasNext()){
                            throw new ConflictException(TASK_ARCHIVE_NOT_EXPIRED_AND_AWARDED_TENDER, Task.class, ImmutableMap.<String,Object>builder()
                                    .put("expired", false) 
                                    .put("awardedTenders", StreamSupport.stream(awardedTenders.spliterator(), false)
                                            .map(Tender::getId).map(ObjectId::toHexString).collect(Collectors.toList())).build());
                        } //else no awarded tenders ... the task can be archived before it is expired
                    } //expired task can be archived with awarded tenders
                })
                .validator((task, data, from, to, user) -> {
                    Date now = new Date();
                    Date end = task.getCapacity() == null ? null : task.getCapacity().getEnd();
                    boolean expired = end != null && end.before(now) && !DateUtils.isSameDay(end, now);
                    log.debug("validate Applications and Tenders for Task[id: {}, expired: {}]", task.getId(), expired);
                    Map<String, Object> conflicts = new HashMap<>();
                    boolean declineApplications = expired || Boolean.parseBoolean(String.valueOf(data.get("declineApplications")));
                    if(!declineApplications) {
                        Iterable<Application> activeApps = appService.getTaskApplications(task.getId(), 
                                EnumSet.of(ApplicationState.interview, ApplicationState.invited, ApplicationState.submitted));
                        if(activeApps.iterator().hasNext()){
                            conflicts.put("activeApplications", StreamSupport.stream(activeApps.spliterator(), false)
                                    .map(Application::getId).map(ObjectId::toHexString)
                                    .collect(Collectors.toList()));
                        }
                    }
                    boolean withdrawTenders = expired || Boolean.parseBoolean(String.valueOf(data.get("withdrawTenders")));
                    if(!withdrawTenders) {
                        Iterable<Tender> activeTenders = tenderService.getTaskTenders(task.getId(), 
                                EnumSet.of(TenderState.approved,TenderState.inReview));
                        if(activeTenders.iterator().hasNext()){
                            conflicts.put("activeTenders", StreamSupport.stream(activeTenders.spliterator(), false)
                                    .map(Tender::getId).map(ObjectId::toHexString)
                                    .collect(Collectors.toList()));
                        }
                    } //we are allowed to withdraw tenders ... so we have nothing to validate
                    if(!conflicts.isEmpty()){
                        throw new ConflictException(TASK_ARCHIVE_CONFLICTS, Task.class, conflicts);
                    }
                })
                .validator((task, data, from, to, user) -> {
                    StreamSupport.stream(appService.getTaskApplications(task.getId(), 
                            ApplicationState.ONGOING_APPLICATION_STATES).spliterator(),false)
                        .forEach(app -> appWorkflow.apply(user, app, ApplicationAction.decline));
                    StreamSupport.stream(tenderService.getTaskTenders(task.getId(), 
                            TenderState.REJECTABLE_STATES).spliterator(),false)
                        .forEach(tender -> tenderWorkflow.apply(user, tender, TenderAction.withdraw));
                })
                .action((task, data, from, to, user) -> taskService.setDeletionDate(task.getId()))
                .action((task, data, from, to, user) -> {
                    switch (from) {
                        case published:
                            taskMailingService.taskArchivedNotification(task, user);
                            break;
                        default:
                            //nop
                    }
                    return task;
                })
                .createAndAdd()
            .create();
    }