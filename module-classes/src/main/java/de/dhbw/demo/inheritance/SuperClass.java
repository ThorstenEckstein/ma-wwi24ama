package de.dhbw.demo.inheritance;

public class SuperClass {

    public String id = "1";

    public String getId() {
        return this.id;
    }

    public String whoAmI() {
        String className = SuperClass.class.getSimpleName();
        return className;
    }

}
