package de.dhbw.model.timetable;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    /**
     * Departure Station
     */
    private String from;

    /**
     * Arrival Station
     */
    private String to;

    private List<Journey> journeys;

    public Schedule() {
        this.journeys = new ArrayList<>();
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

    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
