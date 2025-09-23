package de.dhbw.exceptions;

import de.dhbw.exceptions.solution.CheckedException;
import de.dhbw.exceptions.solution.Executable;
import de.dhbw.exceptions.solution.InterruptedException;
import de.dhbw.exceptions.solution.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SuppressWarnings({"CallToPrintStackTrace", "Convert2MethodRef"})
public class ExceptionsSolutionTests {

    @Test
    @DisplayName("""
        Übung 1: Exception werfen und fangen
        1. Implementiere das Interface Executable mit einer Methode void execute(), dazu eine Klasse Task, die das
           Interface implementiert
        2. Implementiere dazu auch eine neue konkrete, eigene 'CheckedException', die von Exception abgeleitet werden
           soll und von execute() geworfen werden kann.
        3. Wirf diese neue Exception einfach mittels throws in der konkreten Methode execute() deiner konkreten Klasse.
        4. Nutze diesen Unit-Test, erzeuge einen Task, rufe die Methode execute() auf und fange die geworfene Exception
    """)
    public void solution1_1() {
        // given
        Executable task = new Task();

        // when
        try {
            task.execute();
        } catch (CheckedException e) {
            e.printStackTrace();
        }

        // then
    }

    @Test
    @DisplayName("Solution 1: Exception werfen und fangen (Volle Implementierung")
    public void solution1_2() {
        // given
        Executable task = new Task();

        // when
        CheckedException thrown = assertThrows(InterruptedException.class, () -> {
            task.execute();
        });

        // then
        assertEquals(InterruptedException.class, thrown.getClass());
    }

}
