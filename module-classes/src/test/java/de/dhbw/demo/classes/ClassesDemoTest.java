package de.dhbw.demo.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClassesDemoTest {

    @Test
    @DisplayName("Demo 1: Klasse instanziieren")
    public void canInstantiateClass() {
        // given
        ASimpleClass aClass;

        // when (Initialisierung)
        aClass = new ASimpleClass();

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
        String returnValue = aClass.aMethod("Eingabe-Wert");

        // then
        assertEquals("Eingabe-Wert", returnValue);
    }

}
