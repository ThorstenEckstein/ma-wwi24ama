package de.dhbw.demo.override;

import de.dhbw.commons.Logger;

import java.util.ArrayList;
import java.util.List;

public class DefaultDisplay implements Display {

    protected final Logger logger = new Logger(DefaultDisplay.class);

    private List<String> rows = new ArrayList<>();

    @Override
    public void update(int index, String row) {
        this.rows.add(index, row);
        logger.log("row updated: " + row);
    }
}
