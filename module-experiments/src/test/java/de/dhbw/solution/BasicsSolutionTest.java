package de.dhbw.solution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SuppressWarnings({"SimplifiableAssertion", "ConstantValue"})
public class BasicsSolutionTest {

    @Test
    @DisplayName(
            """
            Erstelle eine beliebige, fachliche Klasse deiner Wahl im 'Package'
            
              module-experiments/src/main/java/de/dhbw/exercise/???.java
            
            in diesem Modul, instanziiere diese hier im Test und prüfe, ob die Instanz existiert.
            Führe diesen Test durch Klick auf das 'Play' Symbol am linken Rand des Editors aus.
            
            (Zusatzfrage: Wie lautet das package der neuen Klasse?)
            """)
    public void exercise1() {
        // given
        Lunch lunch = new Lunch();

        // when

        // then
        assertFalse(lunch == null);
    }

}