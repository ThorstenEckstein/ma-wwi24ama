package de.dhbw.exceptions.demo;

public class TrainObservationMonitor {

    public void observeOperatingTrain(String train) throws TrainTooLateException {

        // code that can throw an exception ...
        throw new TrainTooLateException(train + " is more than 6 minutes delayed!");
    }

    public void observeOperatingTrainWithContext(String train) throws PassengerLimitPerWagonExceededException {

        // Code that can throw an exception. For each wagon applies: 4 seats, 20 rows = 80 seats in total
        // Rule 1: 80 < passengers <= 85  -->  WARNING
        // Rule 2: 85 < passengers <= 90  -->  ERROR
        int nPassengersOnBoard = 81;

        if (validatePassengerLimit(nPassengersOnBoard, 80, 85)) {

            // create context for this remarkable situation
            ExceptionContext context = new ExceptionContext();
            context.severity(Severity.WARN)
                    .message("Number of passengers exceeds limit! WARN: %s < %s <= %s", 80, nPassengersOnBoard, 85)
                    .code(7_01)
                    .item("train", train)
                    .item("wagon", 7)
                    .item("passengers", 81); // wagon: 4 seats, 20 rows = 80

            throw new PassengerLimitPerWagonExceededException(context);
        }
    }

    private boolean validatePassengerLimit(int passengersCount, int lowerLimit, int upperLimit) {
        return passengersCount > lowerLimit && passengersCount <= upperLimit;
    }
}
