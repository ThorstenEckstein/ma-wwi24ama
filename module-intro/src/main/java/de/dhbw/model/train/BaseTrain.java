package de.dhbw.model.train;

import java.util.List;
import java.util.Objects;

public abstract class BaseTrain implements Train {

    private String number;
    private Locomotive locomotive;
    private List<Wagon> wagons;

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public Locomotive getLocomotive() {
        return locomotive;
    }

    @Override
    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    @Override
    public List<Wagon> getWagons() {
        return wagons;
    }

    @Override
    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseTrain train = (BaseTrain) o;
        return number.equals(train.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "BaseTrain{" +
                "number='" + number + '\'' +
                ", locomotive=" + locomotive +
                ", wagons=" + wagons +
                '}';
    }
}
