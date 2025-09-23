package de.dhbw.solution;

import de.dhbw.solution.visibility.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisibilitySolutionTest {

    @Test
    @DisplayName("""
        Übung 1:
        a) Implementiere eine Klasse 'Person' mit den Attributen
        - Name
        - Alter
        b) Entscheide selbst über die Datentypen der Attribute, aber mache sie nicht öffentlich.
        c) Erstelle dazu einen Konstruktor für die Initialisierung aller Attribute.
        d) Erstelle zudem Methoden für das Auslesen und Setzen der Attributwerte ("getter & setter").
        
        Schreibe hier einen einfachen Test zur Überprüfung eines der Felder
        """)
    public void solution1() {
        // given
        Person person = new Person("Johnny Walker", 25);

        // when
        int age = person.getAge();

        // then
        assertEquals(25, age);
    }
}