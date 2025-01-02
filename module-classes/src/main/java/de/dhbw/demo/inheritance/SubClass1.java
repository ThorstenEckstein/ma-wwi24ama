package de.dhbw.demo.inheritance;

@SuppressWarnings("all")
public class SubClass1 extends SuperClass {

    @Override
    public String whoAmI() {
        String className = SubClass1.class.getSimpleName();
        return className;
    }

    @Override
    public String getId() {
        return super.id;
    }

}