package de.dhbw.demo.inheritance;

@SuppressWarnings("all")
public class RegionalTrain extends Train {

    public RegionalTrain() {
        super.id = "2";
    }

    @Override
    public String whoAmI() {
        String className = this.getClass().getSimpleName();
        return className;
    }

}
