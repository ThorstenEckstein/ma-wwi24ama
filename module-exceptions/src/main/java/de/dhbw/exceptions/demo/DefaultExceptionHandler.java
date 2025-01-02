package de.dhbw.exceptions.demo;

public class DefaultExceptionHandler implements ExceptionHandler {

	@Override
	public void handle(Exception e) {
		System.err.printf("\nException occurred '%s'!", e.getMessage());
		System.err.println("\n  (1) Handle: Writing stack trace to error log ...");
		System.err.println("  (2) Handle: Sending email to 'admin@company.com' ...");
	}
}
