package de.dhbw.exceptions.demo;

import java.io.Serial;

public abstract class CheckedException extends RuntimeException implements ContextAware {

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
	public CheckedException(String message) {
		super(message);
	}

	/**
	 * Global application exception <i>with</i> an <b>exception context</b>
	 * specified. Note that every application exception must have a context.
	 *
	 * @param context
	 *            the (exception) context
	 */
	public CheckedException(ExceptionContext context) {
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
	public CheckedException(ExceptionContext context, Throwable cause) {
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