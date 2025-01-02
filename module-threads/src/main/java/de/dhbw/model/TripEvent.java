package de.dhbw.model;

import java.time.Duration;
import java.util.Objects;

public class TripEvent {

    public enum EventType { Arrival, Departure, Via; }

    private String station;
    private EventType type;
    private Duration duration;

    private TripEvent(String station, EventType type, Duration duration) {
        this.station = station;
        this.type = type;
        this.duration = duration;
    }

    public static TripEvent of(String station, EventType type, Duration duration) {
        return new TripEvent(station, type, duration);
    }

    public static TripEvent of(String station, EventType type, int duration) {
        return new TripEvent(station, type, Duration.ofMinutes(duration));
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTransition() {
        String transition = "";
        switch (type) {
            case Arrival -> {
                transition = "waiting";
            }
            case Departure -> {
                transition = "running";
            }
            case Via -> {
                transition = "running slowly";
            }
        }
        return transition;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripEvent tripEvent = (TripEvent) o;
        return station.equals(tripEvent.station) && type == tripEvent.type && duration.equals(tripEvent.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(station, type, duration);
    }

    @Override
    public String toString() {
        return "TripEvent{" +
                "station='" + station + '\'' +
                ", type=" + type +
                ", duration=" + duration +
                '}';
    }
}
