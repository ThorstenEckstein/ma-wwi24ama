package de.dhbw.demo.overload;

import java.util.List;

public class PlatformDisplay extends Display {

    // multiple methods can be used to
    // update a platforms' display

    public void update(String line) { /* omitted */ }

    public void update(List<String> lines) { /* omitted */ }

}