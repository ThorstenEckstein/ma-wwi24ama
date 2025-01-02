package de.dhbw.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
public class Station {

    private List<Train> trains = new ArrayList<>();

    public boolean hasTrain(String key) {
        return trains.stream().anyMatch(p -> p.getKey().equalsIgnoreCase(key));
    }

    public Train getTrain(String key) {
        Optional<Train> optional =
                trains.stream()
                        .filter(p -> p.getKey().equalsIgnoreCase(key))
                        .findFirst();
        return optional.orElse(null);
    }

    public List<Train> getTrains() {
        return trains;
    }

    public Station add(Train train) {
        this.trains.add(train);
        return this;
    }

    public void addTrain(Train train) {
        this.trains.add(train);
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}
