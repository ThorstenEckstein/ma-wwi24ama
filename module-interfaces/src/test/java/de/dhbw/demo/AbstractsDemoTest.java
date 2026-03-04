package de.dhbw.demo;

import de.dhbw.demo.abstracts.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AbstractsDemoTest {

    @Test
    @DisplayName("Demo 1: Abstrakte Klassen im Allgemeinen")
    public void demoAbstractClass() {
        // given
        AbstractClass abstractClass;

        // when
        abstractClass = new ConcreteClass();
        abstractClass.doSomething();

        // then
        assertNotNull(abstractClass);
    }

    @Test
    @DisplayName("""
      Demo 2: Interface & abstrakte Klasse in Kombination
          +---------------+
          | Identifiable  |
          +---------------+
                 /\
                 . implements
                 .
          +---------------+
          | NaturalPerson |
          +---------------+
                /\
                | extends
                |
          +---------------+
          | Citizen       |
          +---------------+
      """)
    public void demoInterfaceAndAbstractClass() {
        // given

        // when
        Identifiable identifiable = new Citizen("Schlossallee 1, Hamburg");
        NaturalPerson naturalPerson = new Citizen("Badstraße 5, Frankfurt");

        //String id = naturalPerson.getId();
        //String id = identifiable.getId();

        // then
        //assertEquals(0, id);
        assertEquals("Badstraße 5, Frankfurt", naturalPerson.getPhysicalAddress());
    }

}
