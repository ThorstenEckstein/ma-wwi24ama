package de.dhbw.model;

import static de.dhbw.model.TripEvent.EventType.Arrival;
import static de.dhbw.model.TripEvent.EventType.Departure;

public class TripBuilder {

    /**
     * <pre>
     * "Mainz" >> "Frankfurt"
     * </pre>
     */
    public Trip mock_MZ_to_FFM() {
        Trip trip = new Trip();

        section(trip, "MZ",   5, "FFM",  1);

        return trip;
    }

    /**
     * <pre>
     * "Fulda" >> "Hanau"-"Hanau" >> "Frankfurt"
     * </pre>
     */
    public Trip mock_FU_to_FFM() {
        Trip trip = new Trip();

        section(trip, "FU",   3, "HN",  1);
        section(trip, "HN",   4, "FFM",  1);

        return trip;
    }

    /**
     * <pre>
     * "Mannheim" >> "Biblis"-"Biblis" >> "Stockstadt"-"Stockstadt" >> "Frankfurt"
     * </pre>
     */
    public Trip mock_MA_to_FFM() {
        Trip trip = new Trip();

        section(trip, "MA",   2, "BIB",  1);
        section(trip, "BIB",  4, "SSTD", 1);
        section(trip, "SSTD", 3, "FFM",  1);

        return trip;
    }

    private void section(
            Trip trip,
            String departedFrom,
            int runningDuration,
            String arrivalAt,
            int waitingDuration) {

        trip.add(TripEvent.of(departedFrom, Departure, runningDuration));
        trip.add(TripEvent.of(arrivalAt, Arrival, waitingDuration));

    }

}