package de.dhbw.funcprog.demo;

import de.dhbw.commons.DateTimeUtil;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Schedule {

    /**
     * Departure Station
     */
    private String from;

    /**
     * Arrival Station
     */
    private String to;

    private ZonedDateTime departure;

    private Duration duration;

    public Schedule() {
    }

    public static Schedule of(String from, String to, ZonedDateTime departure, int duration) {
        Schedule schedule = new Schedule();
        schedule.setFrom(from);
        schedule.setTo(to);
        schedule.setDeparture(departure);
        schedule.setDuration(Duration.ofMinutes(duration));
        return schedule;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public ZonedDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(ZonedDateTime departure) {
        this.departure = departure;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return from + " -> " + to + " at " + DateTimeUtil.asSimpleStringWithTime(departure);
    }
}