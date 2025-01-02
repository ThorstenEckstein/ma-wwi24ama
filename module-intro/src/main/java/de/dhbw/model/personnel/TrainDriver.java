package de.dhbw.model.personnel;

import java.util.Objects;

public class TrainDriver implements Driver {
    private String name;

    public TrainDriver(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainDriver that = (TrainDriver) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "TrainDriver{" +
                "name='" + name + '\'' +
                '}';
    }
}
