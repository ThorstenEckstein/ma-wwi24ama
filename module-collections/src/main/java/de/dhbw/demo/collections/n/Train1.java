package de.dhbw.demo.collections.n;

import java.util.ArrayList;
import java.util.List;

public class Train1 {

    public int id;

    public List<Wagon1> wagons = new ArrayList<>();

    public void addWagon(Wagon1 wagon1) {
        this.wagons.add(wagon1);
    }
}
