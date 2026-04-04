package de.dhbw.stromkunden.v1;

public class Vertrag {

    private final String number;

    private Tarif tarif;

    public Vertrag(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }
    public Tarif getTarif() {
        return tarif;
    }

}