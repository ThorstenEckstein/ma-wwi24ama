package de.dhbw.generics;

import de.dhbw.commons.Logger;
import de.dhbw.generics.demo.Joiner;
import de.dhbw.generics.demo.NaturalPerson;
import de.dhbw.generics.demo.Person;
import de.dhbw.generics.demo.Printer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class GenericsDemoTests {

    private final Logger logger = new Logger(GenericsDemoTests.class);

    @Test
    @DisplayName("Demo 1: Joiner mit Strings")
    public void demo1() {
        // given
        Joiner<String> joiner = new Joiner<>();

        Collection<String> strings = new TreeSet<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");

        // when
        String joined = joiner.join(strings);

        // then
        assertEquals("[A, B, C]", joined);
    }

    @Test
    @DisplayName("Demo 2: Joiner mit Booleans")
    public void demo2() {
        // given
        Joiner<Boolean> joiner = new Joiner<>();

        Collection<Boolean> booleans = new Vector<>();
        booleans.add(Boolean.TRUE);
        booleans.add(Boolean.FALSE);
        booleans.add(Boolean.TRUE);

        // when
        String joined = joiner.join(booleans);

        // then
        assertEquals("[true, false, true]", joined);
    }

    @Test
    @DisplayName("Demo 3: Joiner mit Objects")
    public void demo3() {
        // given
        Joiner<Person> joiner = new Joiner<>();

        Collection<Person> people = new ArrayList<>();
        people.add(new Person("Blake"));
        people.add(new Person("Eric"));
        people.add(new Person("Anna"));

        // when
        String joined = joiner.join(people);

        // then
        assertEquals("[Blake, Eric, Anna]", joined);
    }

    @Test
    @DisplayName("Demo 4: Printer Methode (unbounded)")
    public void demo4() {
        // given
        Printer printer = new Printer();

        // when
        String output1 = printer.print("String");
        String output2 = printer.print(1827.08);
        String output3 = printer.print(new Person("Ronaldo"));

        // then
        assertEquals("String", output1);
        assertEquals("1827.08", output2);
        assertEquals("Ronaldo", output3);
    }

    @Test
    @DisplayName("Demo 5: Printer Methode (bounded)")
    public void demo5() {
        // given
        Printer printer = new Printer();

        Person person1 = new Person("Messi");
        Person person2 = new NaturalPerson("Ronaldo");
        String person3 = "Neymar";

        // when
        String output1 = printer.format(person1);
        String output2 = printer.format(person2);
        //String output3 = printer.format(person3);

        // then
        assertEquals("Messi", output1);
        assertEquals("NaturalPerson: Ronaldo", output2);
    }

}