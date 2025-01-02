package de.dhbw.demo.abstracts;

public class Citizen extends NaturalPerson {

    private String physicalAddress;

    public Citizen(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    @Override
    public String getPhysicalAddress() {
        return this.physicalAddress;
    }

}
