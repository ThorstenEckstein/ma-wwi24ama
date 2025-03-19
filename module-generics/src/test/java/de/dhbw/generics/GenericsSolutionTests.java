package de.dhbw.generics;

import de.dhbw.generics.solution.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GenericsSolutionTests {

    @Test
    @DisplayName("""
        Übung 1: Taschenrechner mit 4 Grundrechenarten
        
        Erstelle ein generisches Interface für einen Taschenrechner, der die 4 Grundrechenarten in Form von Methoden
        zur Verfügung stellt, also für
        
        - addieren,
        - subtrahieren,
        - multiplizieren und
        - dividieren.
        
        Der Taschenrechner sollte mit einem beliebigen Zahlen-Datentyp umgehen können. Zahlentypen in Java haben 
        eine gemeinsame Superklasse: java.lang.Number.
        """)
    public void solution1() {
        // given - mandatory part
        Calculator<Integer> calculator = new IntegerCalculator();
        //Calculator<Double> calculator = new DoubleCalculator();

        // when
        Number number = calculator.add(2, 7);
        //Number number = calculator.add(1.9, 7.1);

        // then
        assertEquals(9, number);
        //assertEquals(9.0, number);
    }

    @Test
    @DisplayName("""
        Übung 2: Taschenrechner mit 4 Grundrechenarten
        
         Realisiere einen generischen, konkreten Taschenrechner für die 4 Grundrechenarten, der alle Zahlen-Datentypen
        verarbeiten kann. Schreibe dazu hier einen kleinen Test, der die Funktionsfähigkeit mindestens einer der
        Rechenarten mit Beispielwerten testet, aber mit unterschiedlichen Zahlen-Datentypen.
        """)
    public void solution2() {
        // given
        NumberCalculator<Double> calculator1 = new NumberCalculator<>();
        NumberCalculator<Integer> calculator2 = new NumberCalculator<>();
        NumberCalculator<BigDecimal> calculator3 = new NumberCalculator<>();

        // when
        double result1 = calculator1.add(2.0, 7.0);
        double result2 = calculator2.add(2, 7);
        double result3 = calculator3.add(new BigDecimal("2.0"),  new BigDecimal("7.0"));

        // then
        assertEquals(9.0, result1);
        assertEquals(9.0, result2);
        assertEquals(9.0, result3);
    }

    @Test
    @DisplayName("Übung 3: Workflow")
    public void solution3() {
        // given
        Step step1 = new Start();
        Step step2 = new Choice();
        Step step3 = new SendEmail();

        // when
        Workflow.execute(step1);
        Workflow.execute(step2);
        Workflow.execute(step3);

        // then
    }

}
