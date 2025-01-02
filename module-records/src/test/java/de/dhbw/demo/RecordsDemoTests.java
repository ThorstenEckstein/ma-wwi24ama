package de.dhbw.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecordsDemoTests {

    @Test
    @DisplayName("Demo 1: Records Getter")
    public void demo1() {
        // given
        Station station = new Station("Bahnhofstraße 1","1000");

        // when
        String address = station.address();

        // then
        assertEquals("Bahnhofstraße 1", address);
    }

    @Test
    @DisplayName("Demo 2: Records equals() & hashCode()")
    public void demo2() {
        // given
        Station station1 = new Station("Bahnhofstraße 1","1000");
        Station station2 = new Station("Bahnhofstraße 1","1000");

        // when
        boolean instancesAreEqual = station1.equals(station2);
        boolean hashCodesAreEqual = station1.hashCode() == station2.hashCode();

        // then
        assertTrue(instancesAreEqual);
        assertTrue(hashCodesAreEqual);
    }

    @Test
    @DisplayName("Demo 3: Records mit Erweiterungen")
    public void demo3() {
        // given
        Station ffm;

        // when
        ffm = Station.FRANKFURT_MAIN_STATION;

        // then
        System.out.println(ffm);
    }

}
