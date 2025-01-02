package de.dhbw.solution.realization;

public class Regionalzug implements Zug {

    private String number;

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }
}
