package de.dhbw.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorExerciseTests {

    @Test
    @DisplayName("""
        Übung 1: Werte den folgenden Ausdruck aus
        
          boolean result = one && two | three;
        
        a) Prüfe das Ergebnis mit "System.out.println(...)" oder "assertEquals(...)"
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

        // then
        //  ... Prüfung ...
    }

    @Test
    @DisplayName("Übung 2: Erstelle eine boolean Variable, negiere diese und teste das Ergebnis")
    public void exercise2() {
        // given

        // when

        // then
    }

}
