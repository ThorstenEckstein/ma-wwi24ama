package de.dhbw.demo;

import java.util.Objects;

public class PreJava14ImmutableStation {

    private final String address;
    private final String capacity;

    public PreJava14ImmutableStation(String address, String capacity) {
        this.address = address;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Station{" +
                "address='" + address + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreJava14ImmutableStation station = (PreJava14ImmutableStation) o;
        return Objects.equals(address, station.address) && Objects.equals(capacity, station.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, capacity);
    }
}