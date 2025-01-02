package de.dhbw.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperatorSolutionTests {

    @Test
    @DisplayName("Übung 1: Erstelle eine boolean Variable, negiere diese und teste das Ergebnis")
    public void solution1() {
        // given
        boolean isFalse = false;
        boolean isTrue; // initialer Wert?

        // when
        isTrue = !isFalse;

        // then
        assertTrue(isTrue);
    }

}
