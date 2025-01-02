package de.dhbw.demo.abstracts;

public abstract class NaturalPerson implements Identifiable {

    private String id;

    @Override
    public String getId() {
        return this.id;
    }

    public abstract String getPhysicalAddress();
}