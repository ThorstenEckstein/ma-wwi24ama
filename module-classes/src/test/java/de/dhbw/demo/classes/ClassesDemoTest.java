package de.dhbw.demo.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("GrazieInspection")
public class ClassesDemoTest {

    @Test
    @DisplayName("Demo 1: Klasse instanziieren")
    public void canInstantiateClass() {
        // given
        // Deklaration
        //     |
        ASimpleClass aClass;

        // when
        //       Instanziierung
        //        |   Initialisierung
        //        |   |
        aClass = new ASimpleClass(); // durch Drücken von "Strg (Win)" oder "Command (Mac)" + linke Maus hinein navigieren

        // then
        assertNotNull(aClass);
    }

    @Test
    @DisplayName("Demo 2: Nutzung eines Felds")
    public void canUseField() {
        // given
        AClassWithField aClass = new AClassWithField();

        // when
        String aField = aClass.aField;

        // then
        assertNull(aField);
    }

    @Test
    @DisplayName("Demo 3: Nutzung einer Methode")
    public void canUseMethod() {
        // given
        AComplexClass aClass = new AComplexClass();

        // when
        String fieldValue = aClass.getAField();
        String returnValue = aClass.aMethod("Eingabe-Wert");

        // then
        assertNull(fieldValue);
        assertEquals("Eingabe-Wert", returnValue);
    }

}
