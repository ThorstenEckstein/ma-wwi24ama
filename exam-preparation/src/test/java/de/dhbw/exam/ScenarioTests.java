package de.dhbw.exam;

import de.dhbw.stromkunden.v1.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScenarioTests {

    // -----------------------------------------------------------------------------

    @Test
    @DisplayName("Semester-Planung")
    public void canRealizeScenario1() {
        // given

        // when

        // then
    }

    // -----------------------------------------------------------------------------

    @Test
    @DisplayName("Stromkunden-Verwaltung")
    public void canRealizeScenario2() {
        // given

        // when

        // then
    }















    @Test
    @DisplayName("Stromkunden-Verwaltung :: Tarif")
    public void canRealizeScenario2_Tarif() {
        // given
        Unternehmen dbEnergie   = new Unternehmen("DB Energie");
        Kunde walker            = new Kunde("Johnny Walker");
        Kundenkonto walkerKonto = new Kundenkonto();
        Vertrag v2026001        = new Vertrag("2026001");
        Tarif xl                = new Tarif("XL");

        // when
        v2026001.setTarif(xl);
        walkerKonto.setVertrag(v2026001);
        walker.addKundenkonto(walkerKonto);
        dbEnergie.addKunde(walker);

        // then
        assertEquals("XL",
            dbEnergie
                .getKunde("Johnny Walker")
                .getVertrag("2026001")
                .getTarif()
                .getGroup()
        );
    }

    @Test
    @DisplayName("Stromkunden-Verwaltung :: Jahres-Stromverbrauch")
    public void canRealizeScenario2_JahresStromverbrauch() {
        // given
        Unternehmen dbEnergie = new Unternehmen("DB Energie");
        Kunde walker = new Kunde("Johnny Walker");
        walker.setVerbrauch(1, 127.8);
        walker.setVerbrauch(2, 127.8);
        walker.setVerbrauch(3, 127.8);
        walker.setVerbrauch(4, 127.8);
        walker.setVerbrauch(5, 127.8);
        walker.setVerbrauch(6, 127.8);
        walker.setVerbrauch(7, 127.8);
        walker.setVerbrauch(8, 127.8);
        walker.setVerbrauch(9, 127.8);
        walker.setVerbrauch(10, 127.8);
        walker.setVerbrauch(11, 127.8);
        walker.setVerbrauch(12, 127.8);
        dbEnergie.addKunde(walker);

        // when
        double verbrauch = dbEnergie.berechneJahresStromverbrauch(walker);

        // then :: 12 * 127.8 = 1533.6
        assertEquals(1533.6, verbrauch);
    }

    // -----------------------------------------------------------------------------

    @Test
    @DisplayName("World of CodeCraft")
    public void canRealizeScenario3() {
        // given

        // when

        // then
    }

}