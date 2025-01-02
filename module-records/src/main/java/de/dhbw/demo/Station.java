package de.dhbw.demo;

public record Station(String address, String capacity) {

    public static final Station FRANKFURT_MAIN_STATION =
            new Station(
                    "Im Hauptbahnhof, 60329 Frankfurt am Main",
                    "1.000.000");

}
