public void handleGpsZugMeldung(final GpsGeoBsMeldung pGpsMeldung) {
  GpsGeoBsMeldung lGpsMeldung = pGpsMeldung;

  final Integer lZugNummer = pGpsMeldung.getZugNummer();
  final String lStartBf = pGpsMeldung.getZugStartDs100();
  final Date lStartZeit = pGpsMeldung.getZugStartZeit();
  final String lSendendesFahrzeug = pGpsMeldung.getSendendesFahrzeug();

  final String lMsgToken = lGpsMeldung.getMsgToken() + " " + lZugNummer + " " + lStartBf + " " + lStartZeit + " HANDLE_GPS_ZUG ";

  final List<GpsGeoBsMeldung> lAllGpsCacheMsg = mGpsGeoMeldungRepo.getAllMeldungenByZugID(lGpsMeldung);

  final List<FahrplanDO> lAllZugFahrplan = mFahrplanRepo.findFahrplanByKey(lGpsMeldung);

  if (lAllZugFahrplan.isEmpty()) {
    logger.debug(pGpsMeldung.getMsgToken() + " we could not find Zug's Information in our Database for ZugNummer: " + pGpsMeldung.getZugNummer()
        + " ZugStartDs100: " + pGpsMeldung.getZugStartDs100() + " ZugStartZeit: " + pGpsMeldung.getZugStartZeit()
        + "... Message is having wrong information so we will ignore it ...");
    return;
  }

  final LocalDateTime lGpsTimeStampLocal = LocalDateTime.ofInstant(lGpsMeldung.getTimestamp().toInstant(), ZoneId.systemDefault());
  final LocalDateTime lSollZeitZugStartLocal = LocalDateTime.ofInstant(lAllZugFahrplan.get(0).getSollZeit().toInstant(), ZoneId.systemDefault());

  if (isVorAkzeptiertVor(lGpsTimeStampLocal, lSollZeitZugStartLocal)) {
    logger.debug(lMsgToken + " The message is earlier as the accepted time ["
        + mParameterRepository.getParameterByKey(ParameterConstants.AKZEPTIERT_VOR_PLANSTART) + "] and will be ignored!");
    return;
  }

  final FluegelZugDO lFluegelZugDO = mFluegelZugHandler.getFluegelZug(lGpsMeldung);
  if (lFluegelZugDO != null && lFluegelZugDO.isGetrennt()) {
    logger.info(lMsgToken + " GpsMeldungIgnoriert GPS-Meldung wird nicht verarbeitet, da der Vereinigungsstatus des"
        + " Zuges Fahrzeug getrennt ist. Es senden mindestens zwei Fahrzeuge aus unterschiedlichen Geo-Positionen: " + lGpsMeldung);
    return;
  }

  boolean lIsFluegelZugOnVereingung = lFluegelZugDO != null && mFluegelZugHandler.isFlugelZugOnVereinigungStrecke(lFluegelZugDO, lGpsMeldung);
  boolean isFluegelZugScenaroiToBeConsidered = isFluegelZugScenarioToBeConsidered(lGpsMeldung, lMsgToken, lFluegelZugDO, lIsFluegelZugOnVereingung);

  if (lIsFluegelZugOnVereingung && !isFluegelZugScenaroiToBeConsidered) {
    logger.debug(lMsgToken + " isFluegelZugScenaroiToBeConsidered? false");
    return;
  }

  if (lGpsMeldung.getStreckenNummer()== null) {
    logger.info(lMsgToken + " Strecke number is null");
    StreckenPunktDO lStreckePunktDO = getStreckePunktDO(lGpsMeldung, lAllZugFahrplan, lAllGpsCacheMsg);
    if(lStreckePunktDO == null) {
      logger.info(lMsgToken + logGeoStreckeNichtGefunden(lGpsMeldung.toString()));
      return;
    }
    lGpsMeldung.setStreckenNummer(lStreckePunktDO.getStreckenNummer());
    lGpsMeldung.setRichtung(lStreckePunktDO.getRichtung());
  }

  mZugGeoPositionEventProducer.send(pGpsMeldung);

  if (lAllGpsCacheMsg.isEmpty()) {
    logger.debug(lMsgToken + " - Noch keine akzeptierte Meldungen für den Zug");
    // Activity: "A.1.6"
    handleInitialMessage(lGpsMeldung, lAllZugFahrplan);
    return;
  }

  final GpsGeoBsMeldung lLastGpsMeldung = lAllGpsCacheMsg.get(lAllGpsCacheMsg.size() - 1);

  if (lLastGpsMeldung.isGetrennt()) {
    logger.debug(lMsgToken + " isSenderFahrzeugGetrennt11? [" + true + "]");
    return;
  }

  boolean lIsHauptSenderSet = false;
  boolean lIsHauptSender = false;
  boolean lIsHauptSenderMsgTooOld = false;

  if (!isFluegelZugScenaroiToBeConsidered) {

//tag::bad-code-example-2[]
    ...
    lIsHauptSenderSet = mHauptSenderEvaluator.isHauptSenderSet(lZugNummer, lStartBf,
        lStartZeit, lSendendesFahrzeug, lMsgToken);
    lIsHauptSender = mHauptSenderEvaluator.isTrainHauptSender(lZugNummer, lStartBf,
        lStartZeit, lSendendesFahrzeug, lMsgToken);
    lIsHauptSenderMsgTooOld = mHauptSenderEvaluator.isHauptSenderMsgToolOld(lZugNummer, lStartBf,
        lStartZeit, lSendendesFahrzeug, lGpsMeldung.getTimestamp().getTime(), lMsgToken);
        ...
//end::bad-code-example-2[]

    boolean trainSeparationDetected = isSenderFahrzeugGetrennt(
            lGpsMeldung,
            mGpsGeoMeldungRepo.findPreviousMeldungForHauptSender(lZugNummer, lStartBf, lStartZeit)
    );

    if (!lIsHauptSenderSet && trainSeparationDetected) {
      lGpsMeldung.setIsGetrennt(true);
      saveMeldung(lGpsMeldung);
      logger.debug(lMsgToken + " isSenderFahrzeugGetrennt? [" + true + "]");
      return;
    }
  }

  if (!lIsHauptSenderSet || lIsHauptSender || lIsHauptSenderMsgTooOld || lIsFluegelZugOnVereingung) {

    lGpsMeldung.setHauptSender(lSendendesFahrzeug);

    final int lDS100_RADIUS = Integer.parseInt(mParameterRepository.getParameterByKey(ParameterConstants.GPS_DS100_RADIUS));

    logger.debug(lMsgToken + " Check if the train is on a station.");
    final FahrplanDO lCurrentDs100 = GeoBsZugHandlerHelper.isZugAmFPHalt(lGpsMeldung, lAllZugFahrplan, lDS100_RADIUS);
    final boolean lIsZugAmHalt = (lCurrentDs100 != null) ? true : false;

    if (ZugZustand.FAHRT.equals(lLastGpsMeldung.getZugZustand())) {
      handleFahrtForGpsZug(lGpsMeldung, lAllZugFahrplan, lAllGpsCacheMsg, lCurrentDs100, lIsZugAmHalt, lLastGpsMeldung);
    } else if (ZugZustand.HALT.equals(lLastGpsMeldung.getZugZustand())) {
      handleHaltForGpsZug(lGpsMeldung, lAllGpsCacheMsg, lCurrentDs100, lAllZugFahrplan);
    } else if (ZugZustand.ZUG_STEHT.equals(lLastGpsMeldung.getZugZustand()) && lCurrentDs100 == null) {
      handleZugStehtMsg(lGpsMeldung, lAllZugFahrplan, lLastGpsMeldung);
    } else {
      logger.debug(lMsgToken + " Geo Message is unprocessed");
    }
  }
}