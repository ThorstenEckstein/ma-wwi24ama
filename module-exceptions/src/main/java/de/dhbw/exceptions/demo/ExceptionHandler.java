package de.dhbw.exceptions.demo;

public interface ExceptionHandler {

	/**
	 * Handles the specified exception.
	 * 
	 * @param exception The application specific ApplicationException to throw
	 */
	void handle(Exception exception);

}