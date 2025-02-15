package de.dhbw.demo.override;

import java.util.ArrayList;
import java.util.List;

public class DefaultDisplay {

    private List<String> rows = new ArrayList<>();

    public void update(int index, String row) {
        this.rows.add(index, row);
        System.out.println("row updated: " + row);
    }
}
