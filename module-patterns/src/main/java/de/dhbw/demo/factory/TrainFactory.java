package de.dhbw.demo.factory;

public abstract class TrainFactory {

    public Train create(Engine engine) {
        Train train = createTrain(engine);
        train.build(engine);
        return train;
    }

    protected abstract Train createTrain(Engine engine);

}
