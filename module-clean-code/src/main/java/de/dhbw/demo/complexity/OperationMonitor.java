package de.dhbw.demo.complexity;

import java.util.List;

public class OperationMonitor {

    private boolean monitoringIsEnabled = true;

    private enum MonitoringSubject {
        Speed,
        Delay;
    }

    //tag::cyclo-complex[]
    // Summe aller "Bedingungen" = 6
    // +1
    public boolean monitor(Train train, MonitoringSubject subject) {

        // +1
        if (monitoringIsEnabled) {

            String number = train.number();
            // +2
            if (isTrainObservable(number) && butIgnoreIf(train)) {

                switch(subject) {
                    // +1
                    case Speed -> {
                        observeSpeed(train);
                        return true;
                    }
                    // +1
                    case Delay -> {
                        observeDelay(train);
                        return true;
                    }
                    default ->
                            throw new IllegalArgumentException(
                                    "Invalid enum value: " + subject);
                }

            } else {
                return false;
            }
        }
        return false;
    }
    //end::cyclo-complex[]

    private void observeDelay(Train train) {
        // code to observe current trains' delay
        System.out.println("Comparing trains' delay ...");
    }

    private void observeSpeed(Train train) {
        // code to observe trains' speed
        System.out.println("Checking trains' speed ...");
    }

    private boolean isTrainObservable(String number) {
        return number != null;
    }

    private boolean butIgnoreIf(Train train) {
        List<String> numbers = List.of("RB-21", "RB-23");
        for (String number : numbers) {
            if (numbers.contains(train.number())) {
                return true;
            }
        }
        return false;
    }
}
