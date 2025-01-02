package de.dhbw.demo.factory;

public abstract class AbstractTrain implements Train {

    private Engine engine;

    public abstract void build(Engine engine);

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
