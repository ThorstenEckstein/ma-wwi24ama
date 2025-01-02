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
    @DisplayName("Solution 1: Exception werfen und fangen (Basis-Implementierung)")
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
