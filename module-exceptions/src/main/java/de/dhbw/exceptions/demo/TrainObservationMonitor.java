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
        int seats = 80;
        int maxCapacity = 90;
        int nPassengersOnBoard = 92;

        if (isPassengerCapacityExceeded(nPassengersOnBoard, maxCapacity)) {

            // create context for this remarkable situation
            ExceptionContext context = new ExceptionContext();
            context.severity(Severity.WARN)
                    .message("[WARNING] Number of passengers (%s) exceeds wagon capacity (%s)!", nPassengersOnBoard, maxCapacity)
                    .code(7_01)
                    .item("train", train)
                    .item("wagon", 7)
                    .item("passengers", nPassengersOnBoard);

            throw new PassengerLimitPerWagonExceededException(context);
        }
    }

    private boolean isPassengerCapacityExceeded(int passengersCount, int upperLimit) {
        return passengersCount >= upperLimit;
    }
}
