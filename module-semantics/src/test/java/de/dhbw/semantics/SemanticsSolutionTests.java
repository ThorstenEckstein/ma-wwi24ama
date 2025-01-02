package de.dhbw.semantics;

import de.dhbw.semantics.demo.Account;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SemanticsSolutionTests {

    @Test
    @DisplayName("Übung 1: Stelle das ausführliche Beispiel oben (Demo 3) in Form eines Unit-Tests nach")
    @Disabled
    public void demo4() {
        Account a1 = new Account();
        assertEquals(-1, a1.getAmount(), "Welcher Wert wird hier erwartet?");

        Account.process(a1);

        Account a2 = new Account(100);
        assertEquals(-1, a2.getAmount(), "Welcher Wert wird hier erwartet?");

        // folgende Zeile nur damit es kompiliert, mit 'acc' ist eigentlich das Methodenargument gemeint
        Account acc = new Account();
        acc = a2;

        acc.deposit(250);
        assertEquals(-1, acc.getAmount(), "Welcher Wert wird hier erwartet?");
    }

}
