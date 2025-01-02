package de.dhbw.funcprog.demo;

import java.util.function.Predicate;

public class Validator {

    public static boolean validate(Schedule schedule, Predicate<Schedule> validation) {
        return validation.test(schedule);
    }

    public static Predicate<Schedule> isScheduledFor2023() {
        return buildValidationForYear(2023);
    }

    private static Predicate<Schedule> buildValidationForYear(int year) {
        return schedule -> schedule.getDeparture().getYear() == year;
    }

}
