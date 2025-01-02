package de.dhbw.solution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatatypesSolutionTest {

    @Test
    @DisplayName("Übung 1a : 'char -> int' Umwandlung")
    public void exercise1a() {
        // given
        char c = '1';

        // when
        int i = c;

        // then
        assertEquals(49, i);
    }

    @Test
    @DisplayName("Übung 1b : 'int -> byte' Umwandlung")
    public void exercise1b() {
        // given
        int i = 127;

        // when
        byte b = (byte)i;

        // then
        assertEquals(127, b);
    }

}