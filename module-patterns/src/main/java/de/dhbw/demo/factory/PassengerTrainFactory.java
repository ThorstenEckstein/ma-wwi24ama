package de.dhbw.demo.factory;

public class PassengerTrainFactory extends TrainFactory {

    public Train createTrain(Engine engine) {
        Train train = new PassengerTrain();
        train.setEngine(engine);

        // do a lot of work here ...

        return train;
    }

}
