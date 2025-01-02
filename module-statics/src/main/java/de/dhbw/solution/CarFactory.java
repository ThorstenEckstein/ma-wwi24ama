package de.dhbw.solution;

public class CarFactory {

    public static Car createCar(String type) {
        return new Car(type);
    }
}
