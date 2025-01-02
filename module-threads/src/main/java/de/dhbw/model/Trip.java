package de.dhbw.model;

import de.dhbw.commons.Logger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Trip implements Runnable {

    private final Logger logger = new Logger(Trip.class);

    private Train train;

    private List<TripEvent> events = new LinkedList<>();

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void add(TripEvent event) {
        this.events.add(event);
    }

    public List<TripEvent> getEvents() {
        return events;
    }

    public void setEvents(List<TripEvent> events) {
        this.events = events;
    }

    @Override
    public void run() {
        getEvents().forEach(event -> {
            try {

                Thread.sleep(event.getDuration().toMinutes() * 1000);
                logger.log(format(event));

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<TripEvent> iterator = events.iterator();
        while (iterator.hasNext()) {
            TripEvent event = iterator.next();
            builder.append(format(event));
        }
        return builder.toString();
    }

    public String format(TripEvent event) {
        return String.format("%7s: (%-4s| %-9s) .. %s %2s'",
                getTrain() != null ? getTrain().getKey() : "?",
                event.getStation(),
                event.getType(),
                event.getTransition(),
                event.getDuration().toMinutes()
        );
    }

}
