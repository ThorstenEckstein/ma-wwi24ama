package de.dhbw.solution.inheritance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InheritanceSolutionTest {

    @Test
    @DisplayName("Übung 3: Eine Klassen 'Fernzug' erbt von einer Klassen 'Zug'")
    public void solution3() {
        // given
        Zug zug = new Fernzug();

        // when

        // then
        assertNotNull(zug);
    }

    @Test
    @DisplayName("Übung 3 (extended): Eine Klassen 'Fernzug' erbt von einer Klassen 'Zug'")
    public void solution1_extended() {
        // given
        // Zug zug = new Fernzug();
        Fernzug zug = new Fernzug();

        // when
        String number = zug.getNumber();
        double maxSpeed = zug.getMaxSpeed();

        // then
        assertNull(number);
        assertEquals(289.0, maxSpeed);
    }

}
