package de.dhbw.solution;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjectContractSolutionsTest {

    @Test
    @DisplayName("""
        - Erzeuge eine Klasse 'Banknote' mit einem Feld 'betrag' (double) ab
        - Erzeuge auch einen Konstruktor für dieses Feld
        - Erzeuge im nachstehenden Test zwei Instanzen mit demselben Betrag
        - Teste, ob die Geldschein-Instanzen gleich sind
        """)
    public void exercise1() {
        // given
        Banknote note1 = new Banknote(100.0);
        Banknote note2 = new Banknote(100.0);

        // when
        boolean areEqual = note1.equals(note2);

        // then
        assertFalse(areEqual);
    }

    @Test
    @DisplayName("""
        - Nutze die Klasse 'Banknote' von exercise1()
        - Erzeuge in dieser Klasse die Objektvertrags-Methoden equals() und hashCode()
          und nutze für deren Implementierung das Feld 'betrag'
        - Erzeuge im nachstehenden Test zwei Instanzen, wieder mit demselben Betrag
        - Teste, ob die Geldschein-Instanzen gleich sind
        
        !!! FÜR DIE TEST-AUSFÜHRUNG EQUALS UND HASHCODE EINKOMMENTIEREN! !!!
        
        """)
    @Disabled
    public void exercise2() {
        // given
        Banknote note1 = new Banknote(100.0);
        Banknote note2 = new Banknote(100.0);

        // when
        boolean areEqual = note1.equals(note2);

        // then
        assertTrue(areEqual);
    }

}