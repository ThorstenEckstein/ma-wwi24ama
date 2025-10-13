package de.dhbw.demo.inheritance;

@SuppressWarnings("all")
public class LongDistanceTrain extends Train {

    /*
    @Override
    public String getId() {
        return super.id;
    }
    */

    @Override
    public String whoAmI() {
        String className = LongDistanceTrain.class.getSimpleName();
        return className;
    }

}