package de.dhbw.exceptions.demo;

public class PassengerLimitPerWagonExceededException extends ApplicationRuntimeException {
    public PassengerLimitPerWagonExceededException(String message) {
        super(message);
    }

    public PassengerLimitPerWagonExceededException(ExceptionContext context) {
        super(context);
    }

    public PassengerLimitPerWagonExceededException(ExceptionContext context, Throwable cause) {
        super(context, cause);
    }
}
