package de.dhbw.demo.composition;

import de.dhbw.demo.associations.n.Passport;

public class Life {

    public static Person birth(String name) {
        return new Person(name);
    }

    public static void comingOfAge(Person person, String passport) {
        Passport _passport = new Passport(passport);
        person.setPassport(_passport);
    }

    public static void death(Person p) {
        p.deletePassport();
        p = null;
    }
}
