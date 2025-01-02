package de.dhbw.exam;

import java.util.LinkedList;
import java.util.List;

public class Kunde {

    private List<Account> accounts = new LinkedList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int berechneGesamtVerbrauch() {

        int gesamtStromVerbrauch = 0; // algorithmus

        return 2400;
    }
}
