package de.dhbw.solution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticsSolutionTest {

    @Test
    @DisplayName("Übung 1: Car Factory")
    public void exercise1() {
        // given

        // when
        Car car1 = CarFactory.createCar("Mercedes");
        Car car2 = CarFactory.createCar("BMW");
        Car car3 = CarFactory.createCar("VW Golf");

        // then
        assertEquals("Mercedes", car1.getType());
        assertEquals("BMW",      car2.getType());
        assertEquals("VW Golf",  car3.getType());
    }

}
