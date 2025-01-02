package de.dhbw.demo.factory;

public class FreightTrainFactory extends TrainFactory {

    public Train createTrain(Engine engine) {
        Train train = new FreightTrain();
        train.setEngine(engine);

        // do a lot of work here ...

        return train;
    }

}
