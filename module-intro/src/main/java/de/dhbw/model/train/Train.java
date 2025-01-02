package de.dhbw.model.train;

import java.util.List;

public interface Train {

    String getNumber();
    void setNumber(String number);
    Locomotive getLocomotive();
    void setLocomotive(Locomotive locomotive);
    List<Wagon> getWagons();
    void setWagons(List<Wagon> wagons);
}
