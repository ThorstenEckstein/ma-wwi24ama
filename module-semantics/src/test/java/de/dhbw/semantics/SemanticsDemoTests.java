package de.dhbw.semantics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("all")
public class SemanticsDemoTests {

    private static class Person {
        public String name;
    }

    // ------------------------------------------------------------- Wertsemantik

    @SuppressWarnings("ReassignedVariable")
    private static void square(int number) {
        number *= number;
    }

    @Test
    @DisplayName(
            """
            Wertsemantik mit Primitiven:
            Pass by Value: In the pass by value concept, the method is called by passing a value. The argument
            is a copy of the original one. This is called 'pass by value'. It does not affect the original parameter.
            """)
    //tag::ref-semantics-prim[]
    public void demo1() {
        // given - a primitive value
        int number = 10;

        // when
        System.out.println("Before square : " + number);
        square(number);
        System.out.println("After square  : " + number);

        // then
        assertEquals(10, number);
    }
    //end::ref-semantics-prim[]


    // ------------------------------------------------------------- Referenzsemantik (1 von 2)

    private static void renameForDemo2(Person person, String name) {
        person.name = name;
    }

    @Test
    @DisplayName(
            """
            Referenzsemantik mit Objekten:
            Although the argument variable is copied, just the reference is copied. The object that is referenced
            is still the same and thus changed here!
            """
    )
    //tag::ref-semantics-obj[]
    public void demo2() {
        // given - an object reference
        Person person = new Person();
        person.name = "Johnny Walker";

        // when
        System.out.println("Before renaming : " + person.name);
        renameForDemo2(person, "Jenny Tonic");
        System.out.println("After renaming : " + person.name);

        // then
        assertEquals("Jenny Tonic", person.name);
    }
    //end::ref-semantics-obj[]

    // ------------------------------------------------------------- Referenzsemantik (2 von 2)

    private static Person renameForDemo3(Person person, String name) {
        person.name = name;
        return person;
    }

    @Test
    public void demo3() {
        // given - an object reference
        Person person = new Person();
        person.name = "Johnny Walker";

        // when
        System.out.println("Before renaming : " + person.name);
        person = renameForDemo3(person, "Jenny Tonic");
        System.out.println("After renaming : " + person.name);

        // then
        assertEquals("Jenny Tonic", person.name);
    }

}