package de.dhbw.demo;

import de.dhbw.model.TripBuilder;
import de.dhbw.model.TimeTable;
import de.dhbw.model.Train;
import de.dhbw.model.Trip;
import org.junit.jupiter.api.Test;

public class TripDemoTests {

    private TripBuilder builder = new TripBuilder();

    @Test
    public void canCreateTrip() {
        // given

        // when
        Trip trip = builder.mock_MA_to_FFM();
        trip.setTrain(new Train("RE-13"));

        // then
        System.out.println(trip);
    }

    @Test
    public void canRunSingleTrip() {
        // given
        Trip trip = builder.mock_FU_to_FFM();
        trip.setTrain(new Train("RB-1234"));

        // when
        trip.run();

        // then
    }

    @Test
    public void canRunMultipleTrips() {
        // given
        Trip trip1 = builder.mock_MA_to_FFM();
        Trip trip2 = builder.mock_MZ_to_FFM();
        Trip trip3 = builder.mock_FU_to_FFM();

        TimeTable timeTable = new TimeTable();
        timeTable.putTrip("RE-23",   trip1);
        timeTable.putTrip("S8",      trip2);
        timeTable.putTrip("RB-2461", trip3);

        // when
        timeTable.run();

        // then
    }

}