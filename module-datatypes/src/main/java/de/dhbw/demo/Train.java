package de.dhbw.demo;

public class Train {

    private String number;

    public Train() {
    }

    public Train(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Train{" +
                "number='" + number + '\'' +
                '}';
    }
}
