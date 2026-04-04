package de.dhbw.stromkunden.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kunde {

    private String name;

    private List<Kundenkonto> kundenkonten = new ArrayList<>();
    // Map<Monat 1-12, Verbrauch in kwh>
    private Map<Integer, Double> verbrauch = new HashMap<>();

    public Kunde(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addKundenkonto(Kundenkonto konto1) {
        kundenkonten.add(konto1);
    }

    public void setVerbrauch(Integer monat, Double verbrauch) {
        this.verbrauch.put(monat, verbrauch);
    }

    public Map<Integer, Double> getVerbrauch() {
        return verbrauch;
    }

    public Vertrag getVertrag(String number) {
        for (Kundenkonto konto : kundenkonten) {
            if (konto.getVertrag().getNumber().equals(number)) {
                return konto.getVertrag();
            }
        }
        return null;
    }
}