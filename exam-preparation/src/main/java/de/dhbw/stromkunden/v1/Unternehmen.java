package de.dhbw.stromkunden.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Unternehmen {

    private String name;
    private List<Kunde> kunden = new ArrayList<>();

    public Unternehmen(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addKunde(Kunde kunde1) {
        kunden.add(kunde1);
    }

    public Double berechneJahresStromverbrauch(Kunde kunde) {
        Map<Integer, Double> verbrauch = kunde.getVerbrauch();
        double jahresStromVerbrauch = verbrauch.values().stream().mapToDouble(Double::doubleValue).sum();

        return jahresStromVerbrauch;
    }

    public Kunde getKunde(String kundenname) {
        for (Kunde kunde : kunden) {
            if (kunde.getName().equals(kundenname)) {
                return kunde;
            }
        }
        return null;
    }
}