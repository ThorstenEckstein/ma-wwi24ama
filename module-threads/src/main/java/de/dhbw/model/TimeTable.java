package de.dhbw.model;

import de.dhbw.commons.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeTable {

    private final Logger logger = new Logger(TimeTable.class);

    private Map<String, Trip> trips = new HashMap<>();

    public void run() {
        ExecutorService service = Executors.newFixedThreadPool(1);
        trips.forEach((key, trip) -> {
            service.execute(trip);
        });
        service.shutdown();
        // Wait until all threads are finish. Returns true if all tasks have completed following shut down.
        // Note that isTerminated is never true unless either shutdown or shutdownNow was called first.
        while (!service.isTerminated()) { /* empty body */ }
        logger.log("Finished all threads");
    }

    public Trip getTrip(String key) {
        if (trips.containsKey(key)) {
            return trips.get(key);
        } else {
            throw new IllegalArgumentException("No train found for key '" + key + "'!");
        }
    }

    public Map<String, Trip> getTrips() {
        return trips;
    }

    public void putTrip(String key, Trip trip) {
        trip.setTrain(new Train(key));
        this.trips.put(key, trip);
    }

    public void setTrips(Map<String, Trip> trips) {
        this.trips = trips;
    }

}