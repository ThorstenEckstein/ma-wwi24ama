package de.dhbw.demo.factory;

public class FreightTrain extends AbstractTrain {

    public void build(Engine engine) {
        System.out.println("Building " + this.getClass().getSimpleName() + " with engine '" + engine + "' ...");
    }

}