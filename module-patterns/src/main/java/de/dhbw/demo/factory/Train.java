package de.dhbw.demo.factory;

public interface Train {

    void build(Engine engine);

    Engine getEngine();

    void setEngine(Engine engine);
}
