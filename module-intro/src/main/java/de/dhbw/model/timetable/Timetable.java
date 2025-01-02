package de.dhbw.model.timetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Timetable {

    // "Winterfahrplan 22/23"
    private final String title;

    private List<Journey> journeys;

    public Timetable(String title) {
        this.title = title;
        this.journeys = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }

    public void addJourney(Journey journey) {
        this.journeys.add(journey);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return title.equals(timetable.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "title='" + title + '\'' +
                ", journeys=" + journeys +
                '}';
    }
}
