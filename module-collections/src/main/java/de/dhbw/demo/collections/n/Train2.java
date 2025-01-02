package de.dhbw.demo.collections.n;

import java.util.ArrayList;
import java.util.List;

public class Train2 {

    public int id;

    public List<Wagon2> wagons = new ArrayList<>();

    // Alternative Umsetzung
    public List<Integer> wagonIds;

    public void addWagon(Wagon2 wagon2) {
        this.wagons.add(wagon2);
    }

}
