package de.dhbw.exam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScenarioTests {

    @Test
    @DisplayName("Stromkunden-Verwaltung")
    public void canRealizeScenarioModel1() {
        // given
        Kunde kunde = new Kunde();
        Account account = new Account("1");

        kunde.getAccounts().add(account);

        Vertrag vertrag = new Vertrag();
        vertrag.setTarif(Tarif.Student);
        Tarif studentenTarif = vertrag.getTarif();

        // when
        int gesamtStromVerbrauch = kunde.berechneGesamtVerbrauch();

        // then
        assertEquals(2400, gesamtStromVerbrauch);

    }

    @Test
    @DisplayName("World of Codecraft")
    public void canRealizeScenarioModel2() {

        // implement your test code here

    }

}