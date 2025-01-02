package de.dhbw.funcprog.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Timetable {

    // "Winterfahrplan 22/23"
    private final String title;

    private List<Schedule> schedules;

    public Timetable(String title) {
        this.title = title;
        this.schedules = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    public void addSchedules(Schedule... schedules) {
        for (Schedule schedule : schedules) {
           addSchedule(schedule);
        }
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
                ", schedules=" + schedules +
                '}';
    }
}
