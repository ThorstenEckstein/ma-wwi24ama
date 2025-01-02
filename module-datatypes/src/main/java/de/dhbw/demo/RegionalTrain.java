package de.dhbw.demo;

public class RegionalTrain extends Train {

    private String type;

    public RegionalTrain(String number) {
        super(number);
    }

    public RegionalTrain(String number, String type) {
        super(number);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RegionalTrain{" +
                "number='" + super.getNumber() + '\'' +
                "type='" + type + '\'' +
                "} ";
    }
}
