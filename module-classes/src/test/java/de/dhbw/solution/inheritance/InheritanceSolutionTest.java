package de.dhbw.solution.inheritance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InheritanceSolutionTest {

    @Test
    @DisplayName("Übung 1: Fernzug erbt von Zug")
    public void solution1() {
        // given
        Fernzug zug = new Fernzug();

        // when
        String number = zug.getNumber();
        double maxSpeed = zug.getMaxSpeed();

        // then
        assertNull(number);
        assertEquals(289.0, maxSpeed);
    }

}
