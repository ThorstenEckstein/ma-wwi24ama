package de.dhbw.demo.associations.n;

public class Person {

    private String name;

    private Passport passport;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public void deletePassport() {
        setPassport(null);
    }
}
