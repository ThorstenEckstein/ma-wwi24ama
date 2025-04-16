package de.dhbw.course;

import java.time.LocalTime;
import java.util.List;

public class Lehrveranstaltung {

    // public protected private
    private String name;
    List<Inhalt> inhalte;
    private LocalTime beginn;

    public Integer getGesamtDauer() {
        Integer gesamtDauer = 0;

        for (Inhalt inhalt : inhalte) {
            gesamtDauer += inhalt.getDauer();
        }

        return gesamtDauer;
    }

    public LocalTime getEnde(){
        LocalTime ende = null;
        // beginn + dauer = ende
        return ende;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Inhalt> getInhalte() {
        return inhalte;
    }

    public void setInhalte(List<Inhalt> inhalte) {
        this.inhalte = inhalte;
    }

    public LocalTime getBeginn() {
        return beginn;
    }

    public void setBeginn(LocalTime beginn) {
        this.beginn = beginn;
    }
}