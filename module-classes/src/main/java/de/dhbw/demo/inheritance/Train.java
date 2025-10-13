package de.dhbw.demo.inheritance;

public class Train {

    public String id = "1";

    public String getId() {
        return this.id;
    }

    public String whoAmI() {
        return Train.class.getSimpleName();
    }

}
