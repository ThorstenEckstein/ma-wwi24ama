package de.dhbw.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperatorSolutionTests {

    @Test
    @DisplayName("""
        Übung 1: Werte den folgenden Ausdruck aus
        
          boolean result = one && two | three;
        
        a) Ermittle das Ergebnis mit "System.out.println(...)" oder "assertEquals(...)"
        b) Erläutere die logischen Operatoren
        
        """)
    @SuppressWarnings("ConstantValue")
    public void solution1() {
        // given
        boolean one   = true;
        boolean two   = false;
        boolean three = true;

        // when
        boolean result = one && two | three;

        // Zerlegung zum besseren Verständnis (oder Nutzung von Klammern)!
        boolean result1 = one && two;
        System.out.println("one      &&   two    = " + result1 + " (result1)");

        boolean result2 = result1 | three;
        System.out.println("result1  |    three  = " + result2 + "  (result2)");

        // then
        System.out.println("\none && two | three   = " + result);
    }

    @Test
    @DisplayName("Übung 2: Erstelle eine boolean Variable, negiere diese und teste das Ergebnis")
    public void solution2() {
        // given
        boolean isFalse = false;
        boolean isTrue; // initialer Wert?

        // when
        isTrue = !isFalse;

        // then
        assertTrue(isTrue);
    }

}
