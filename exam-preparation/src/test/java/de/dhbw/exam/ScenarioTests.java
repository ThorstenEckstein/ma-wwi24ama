package de.dhbw.exam;

import de.dhbw.course.Inhalt;
import de.dhbw.course.Lehrveranstaltung;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScenarioTests {

    @Test
    public void canRealizeScenarioLV() {
        // given
        Lehrveranstaltung prog2 = new Lehrveranstaltung();
        Inhalt grundlagen = new Inhalt();
        Inhalt schnittstellen = new Inhalt();
        Inhalt operatoren = new Inhalt();

        // when
        grundlagen.setName("Java Grundlagen");
        grundlagen.setDauer(45);
        schnittstellen.setName("Java Schnittstellen");
        schnittstellen.setDauer(30);
        operatoren.setName("Java Operatoren");
        operatoren.setDauer(15);

        prog2.setName("Java Programmierung");
        prog2.setBeginn(LocalTime.of(8,0,0));

        List<Inhalt> inhalte = new ArrayList<>();
        inhalte.add(grundlagen);
        inhalte.add(schnittstellen);
        inhalte.add(operatoren);

        prog2.setInhalte(inhalte);
        Integer gesamtDauerProg2 = prog2.getGesamtDauer();

        // then
        assertEquals(3, prog2.getInhalte().size());
        assertEquals(90, gesamtDauerProg2);
    }


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