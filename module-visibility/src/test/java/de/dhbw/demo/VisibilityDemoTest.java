package de.dhbw.demo;

import de.dhbw.demo.visibility.VisibilityExampleClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VisibilityDemoTest {

    //tag::visibility[]
    @Test
    @DisplayName("Demo 3: Sichtbarkeiten von Feldern")
    public void canCheckVisibilityOfFields() {
        // given
        VisibilityExampleClass someClass = new VisibilityExampleClass();

        // What is the reason for fields A, C and D being not accessible?

        //someClass.fieldA
        someClass.fieldB = "some value for field B";
        //someClass.fieldC
        //someClass.fieldD

        // when
        String fieldBValue = someClass.fieldB;

        // then
        assertNotNull(fieldBValue);
    }
    //end::visibility[]

    @Test
    @DisplayName("Demo 3: Sichtbarkeiten von Konstruktoren und Methoden")
    public void canCheckVisibilityOfConstructorsAndMethods() {
        // given
        VisibilityExampleClass someClass = new VisibilityExampleClass();

        // when :: change visibility of method in class for demonstration
        String fieldA = someClass.getFieldA();
        someClass.setFieldA("Triple-X");

        // then :: Ist folgende Assertion korrekt sein?
        //assertEquals("Triple-X", fieldA);
    }

}
