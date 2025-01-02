package de.dhbw.exceptions;

import de.dhbw.commons.Colourizer;
import de.dhbw.exceptions.demo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"ConstantValue", "CallToPrintStackTrace"})
public class ExceptionsDemoTests {

    @Test()
    @DisplayName("Demo 1: Do not print stack trace without any exception handle!")
    public void demo1() {
        // given
        boolean exceptionCondition = true;

        // when
        try {
            if (exceptionCondition) {
                throw new Exception("Something weird happened!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // then
    }


    @Test()
    @DisplayName("Demo 2: How to test an expected exception")
    public void demo2() {
        // given
        TrainObservationMonitor model = new TrainObservationMonitor();

        // when
        TrainTooLateException thrown = assertThrows(TrainTooLateException.class, () -> {
            // Code under test that can throw an exception
            model.observeOperatingTrain("RB-21");
        });

        // then
        assertTrue(thrown.getMessage().contains("is more than 6 minutes delayed!"));
    }

    @Test()
    @DisplayName("Demo 3: How to test an expected exception with details/context")
    public void demo3() {
        // given
        TrainObservationMonitor monitor = new TrainObservationMonitor();

        // when
        PassengerLimitPerWagonExceededException thrown = assertThrows(
                PassengerLimitPerWagonExceededException.class, () -> {
                    // Code under test that can throw an exception
                    monitor.observeOperatingTrainWithContext("RB-21");
                });
        Object passengersCount = thrown.getContext().getItem("passengers");

        // then
        assertEquals(Severity.WARN, thrown.getContext().getSeverity());
        assertTrue((int)passengersCount > 80);

        System.out.println(Colourizer.red(thrown.getContext().getMessage()));
    }

    @Test()
    @DisplayName("Demo 4: How to handle an exception simple")
    public void demo4() {
        // given
        DataLoader loader = new DataLoader();

        // when
        Product product = loader.tryLoadWithResources("/resources/macbook-pro.csv");

        // then
        assertNull(product);
    }

    @Test()
    @DisplayName("Demo 5: How to handle an exception in a more appropriate way")
    public void demo5() {
        // given
        DataLoader loader = new DataLoader();

        // when
        Product product = loader.tryLoad("/resources/macbook-pro.csv");

        // then
        assertNull(product);
    }

}