package de.dhbw.exceptions.demo;

import java.io.Serial;

/**
 * A Note about RuntimeException: RuntimeException is the superclass of those
 * exceptions that can be thrown during the normal operation of the Java Virtual
 * Machine. RuntimeException and its subclasses are unchecked exceptions.
 * Unchecked exceptions do not need to be declared in a method or constructor's
 * throws clause if they can be thrown by the execution of the method or
 * constructor and propagate outside the method or constructor boundary.
 */
public abstract class ApplicationRuntimeException extends RuntimeException implements ContextAware {

	@Serial
	private static final long serialVersionUID = 0;

    private ExceptionContext context;

    // overridden super c'tors

	/**
	 * Global application exception just <i>with</i> a <b>message</b>.
	 * <p>
	 * <span style="color:red">WARNING</span>: This exception has NO exception context and is not meant to be used excessively!
	 * </p>
	 * @param message
	 *            the (exception) message
	 */
	public ApplicationRuntimeException(String message) {
		super(message);
	}

	/**
	 * Global application exception <i>with</i> an <b>exception context</b>
	 * specified. Note that every application exception must have a context.
	 *
	 * @param context
	 *            the (exception) context
	 */
	public ApplicationRuntimeException(ExceptionContext context) {
		super(context.getMessage());
		this.setContext(context);
	}

	/**
	 * Global application exception <i>with</i> a context and the
	 * exception cause.
	 *
	 * @param context
	 *            the exception context
	 * @param cause
	 *            the exception cause
	 */
	public ApplicationRuntimeException(ExceptionContext context, Throwable cause) {
		super(cause);
		this.setContext(context);
	}

	public ExceptionContext getContext() {
		return context;
	}

	public void setContext(ExceptionContext context) {
		this.context = context;
	}

}