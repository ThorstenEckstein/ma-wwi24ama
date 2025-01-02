package de.dhbw.generics.demo;

public class NaturalPerson extends Person {

    public NaturalPerson(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "NaturalPerson: " + super.toString();
    }
}
