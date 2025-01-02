package de.dhbw.demo.inheritance;

@SuppressWarnings("all")
public class SubClass2 extends SuperClass {

    public SubClass2() {
        super.id = "2";
    }

    @Override
    public String whoAmI() {
        String className = this.getClass().getSimpleName();
        return className;
    }

}
