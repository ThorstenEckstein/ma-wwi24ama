package de.dhbw.solution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticsSolutionTest {

    @Test
    @DisplayName("""
            Übung 1:
            1. Erstelle eine Klasse Car mit einem Feld 'type' (String) und einem zugehörigen Konstruktor
            2. Erstelle eine Klasse CarFactory mit einer statischen Methode 'createCar' mit dem Parameter 'type',
               die neue Car-Instanzen mit dem jeweils gesetzten 'type' zurückgibt.
            3. Nutze diesen Test hier, in dem die Factory benutzt wird und den/die Car-Type(s) testet
            """)
    public void exercise1() {
        // given

        // when
        Car car1 = CarFactory.createCar("Mercedes");
        Car car2 = CarFactory.createCar("BMW");
        Car car3 = CarFactory.createCar("VW Golf");

        // then
        assertEquals("Mercedes", car1.getType());
        assertEquals("BMW",      car2.getType());
        assertEquals("VW Golf",  car3.getType());
    }

}
