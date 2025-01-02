package de.dhbw.model.timetable;

import de.dhbw.model.routes.Route;
import de.dhbw.model.personnel.Driver;
import de.dhbw.model.train.Train;

import java.time.ZonedDateTime;

public class Journey {

    /**
     * Journey takes place on which route (from where to where)?
     */
    private Route route;

    /**
     * Journey takes place for what train?
     */
    private Train train;

    /**
     * Journey takes place when, when is the scheduled train departing?
     */
    private ZonedDateTime departure;

    /**
     * Who is driving the train?
     */
    private Driver driver;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public ZonedDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(ZonedDateTime departure) {
        this.departure = departure;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "route=" + route +
                ", train=" + train +
                ", departure=" + departure +
                ", driver=" + driver +
                '}';
    }
}
