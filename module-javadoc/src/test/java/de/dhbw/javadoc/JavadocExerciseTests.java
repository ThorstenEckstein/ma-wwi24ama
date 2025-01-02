package de.dhbw.javadoc;

import de.dhbw.commons.Logger;
import de.dhbw.javadoc.exercises.DefaultXmlAdapter;
import de.dhbw.javadoc.exercises.XmlAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JavadocExerciseTests {
    @Test
    @DisplayName(
            "Übung 1: Ergänze die *öffentlichen Methoden* der Klasse `XmlAdapter` mit einer `javadoc` Dokumentation")
    public void exercise1() {
        // given - poorly documented interface 'XmlAdapter'
        XmlAdapter adapter = new DefaultXmlAdapter();

        // when - developer has documented its public API

        // then - basic documentation is now far better ;-)
    }

}