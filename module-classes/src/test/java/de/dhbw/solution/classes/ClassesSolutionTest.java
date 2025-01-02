package de.dhbw.solution.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClassesSolutionTest {

    @Test
    @DisplayName(
    """
     Erstelle die folgenden Klassen im Paket "java/de/dhbw/exercise/classes"
     1. Erstelle eine neue Klasse Fernzug mit einem parameterlosen Konstruktor
     2. Erstelle eine neue Klasse Regionalzug mit einem parameterlosen Konstruktor
     Teste, ob die Instanzen korrekt erzeugt wurden!
    """)
    public void solution1() {
        // given
        Fernzug fernzug;
        Regionalzug regionalzug;

        // when
        fernzug = new Fernzug();
        regionalzug = new Regionalzug();

        // then
        assertNotNull(fernzug);
        assertNotNull(regionalzug);
    }

    @Test
    @DisplayName(
    """
    Ergänze die Klasse Fernzug mit einem Feld namens "number". Erzeuge eine Instanz und
    teste für die Instanz, welchen Wert dieses Feld einer Instanz hat!
    """)
    public void solution2() {
        // given
        Fernzug fernzug;

        // when
        fernzug = new Fernzug();

        // then
        assertNull(fernzug.number);
        // oder auch:
        // assertEquals(null, fernzug.number);
    }

    @Test
    @DisplayName(
            """
            Erzeuge eine
              1. konkrete Klasse `Person` mit einem Attribut `name`, erstelle dann
              2. die zum Attribut gehörende `get` und `set` Methode,
              3. erstelle dann die `equals()` und `hashCode()` Methoden durch Code Generierung,
              4. zuletzt leite aus dieser konkreten Klasse ein Interface `Mensch` ab
              
              Ableitung eines Interfaces aus einer Klasse:
              images/extract-interface-from-class.png
              
              Öffnen der Klasse 'Person' (Cursor irgendwo)
              > Menu > Refactor > Extract/Introduce > Interface ...
              > Dialog ausfüllen ... Create
              > Zum Schluss hier in diesem Test das Interface statt der Klasse nutzen
            """)
    public void solution3() {
        // given
        Mensch person = new Person();

        // when
        person.setName("Stephen Hawking");

        // then
        assertTrue(person.getName().contains("Hawking"));
    }

}
