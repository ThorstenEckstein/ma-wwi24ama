package de.dhbw.generics.demo;

public class Printer {

    /**
     * Unbounded generic method: Accepts any type (that extend class Object, except for primitives)
     */
    //tag::generic-method[]
    public <T> String print(T data)
    //end::generic-method[]
    {
        return String.format("%s", data);
    }

    /**
     * Bounded generic method: Just accepts specific types that extends class Person
     */
    public <T extends Person> String format(T data) {
        return String.format("%s", data);
    }
}
