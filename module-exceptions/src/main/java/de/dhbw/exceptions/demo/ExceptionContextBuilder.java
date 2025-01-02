package de.dhbw.exceptions.demo;

import java.util.UUID;

/**
 * This class acts like a helper class for building an exception context using predefined or convenience methods.
 * All severity levels are expressed as methods: fatal, error, warn, info, debug and trace, each for plain messages
 * or message formats with arguments to be injected into these messages (see also String.format(...) contract).
 * Additionally, clients can use the generic build() methods, with the above-mentioned methods being just prefilled
 * ones that delegate internally to these build() methods.
 */
public class ExceptionContextBuilder {

    // ------------------------------------------------------- fatal, error, warn, info, debug, trace

    /**
     * Returns an exception context for some arbitrary fatal 'error':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : FATAL</li>
     * <li>code      : INTERNAL_SERVER_ERROR (500)</li>
     * <li>message   : the plain fatal error message</li>
     * </ul>
     *
     * @param message the plain message text
     * @return a new instance of exception context
     */
    public static ExceptionContext fatal(String message) {
        return fatal(message, (Object) null);
    }

    /**
     * Returns an exception context for some arbitrary fatal 'error':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : FATAL</li>
     * <li>code      : INTERNAL_SERVER_ERROR (500)</li>
     * <li>message   : the (formatted) specified fatal error message</li>
     * </ul>
     *
     * @param format the message format (according to String.format() conventions)
     * @param args   the message arguments
     * @return a new instance of exception context
     */
    public static ExceptionContext fatal(String format, Object... args) {
        return build(Severity.FATAL, 500, format, args);
    }

    /**
     * Returns an exception context for some arbitrary 'error':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : ERROR</li>
     * <li>code      : INTERNAL_SERVER_ERROR (500)</li>
     * <li>message   : the plain error message</li>
     * </ul>
     *
     * @param message the plain message text
     * @return a new instance of exception context
     */
    public static ExceptionContext error(String message) {
        return error(message, (Object) null);
    }

    /**
     * Returns an exception context for some arbitrary 'error':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : ERROR</li>
     * <li>code      : INTERNAL_SERVER_ERROR (500)</li>
     * <li>message   : the (formatted) specified error message</li>
     * </ul>
     *
     * @param format the message format (according to String.format() conventions)
     * @param args   the message arguments
     * @return a new instance of exception context
     */
    public static ExceptionContext error(String format, Object... args) {
        return build(Severity.ERROR, 500, format, args);
    }

    /**
     * Returns an exception context for some arbitrary 'warning':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : WARN</li>
     * <li>code      : ACCEPTED (202)</li>
     * <li>message   : the plain warning message</li>
     * </ul>
     *
     * @param message the plain warning message text
     * @return a new instance of exception context
     */
    public static ExceptionContext warn(String message) {
        return info(message, (Object) null);
    }

    /**
     * Returns an exception context for some arbitrary 'warning':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : WARN</li>
     * <li>code      : ACCEPTED (202)</li>
     * <li>message   : the (formatted) specified warning message</li>
     * </ul>
     *
     * @param format the message format (according to String.format() conventions)
     * @param args   the message arguments
     * @return a new instance of exception context
     */
    public static ExceptionContext warn(String format, Object... args) {
        return build(Severity.INFO, 202, format, args);
    }

    /**
     * Returns an exception context for some arbitrary 'info':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : INFO</li>
     * <li>code      : OK (200)</li>
     * <li>message   : the plain info message</li>
     * </ul>
     *
     * @param message the plain message text
     * @return a new instance of exception context
     */
    public static ExceptionContext info(String message) {
        return info(message, (Object) null);
    }

    /**
     * Returns an exception context for some arbitrary 'info':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : INFO</li>
     * <li>code      : OK (200)</li>
     * <li>message   : the (formatted) specified info message</li>
     * </ul>
     *
     * @param format the message format (according to String.format() conventions)
     * @param args   the message arguments
     * @return a new instance of exception context
     */
    public static ExceptionContext info(String format, Object... args) {
        return build(Severity.INFO, 200, format, args);
    }

    /**
     * Returns an exception context for some arbitrary 'debug':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : DEBUG</li>
     * <li>code      : OK (200)</li>
     * <li>message   : the plain debug message</li>
     * </ul>
     *
     * @param message the plain message text
     * @return a new instance of exception context
     */
    public static ExceptionContext debug(String message) {
        return debug(message, (Object) null);
    }

    /**
     * Returns an exception context for some arbitrary 'debug':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : DEBUG</li>
     * <li>code      : OK (200)</li>
     * <li>message   : the (formatted) specified debug message</li>
     * </ul>
     *
     * @param format the message format (according to String.format conventions)
     * @param args   the message arguments
     * @return a new instance of exception context
     */
    public static ExceptionContext debug(String format, Object... args) {
        return build(Severity.DEBUG, 200, format, args);
    }

    /**
     * Returns an exception context for some arbitrary 'tracing':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : TRACE</li>
     * <li>code      : OK (200)</li>
     * <li>message   : the plain trace message</li>
     * </ul>
     *
     * @param message the plain message text
     * @return a new instance of exception context
     */
    public static ExceptionContext trace(String message) {
        return trace(message, (Object) null);
    }

    /**
     * Returns an exception context for some arbitrary 'tracing':
     * <ul>
     * <li>uuid      : randomly generated</li>
     * <li>timestamp : LocalDateTime.now()</li>
     * <li>severity  : TRACE</li>
     * <li>code      : OK (200)</li>
     * <li>message   : the (formatted) specified trace message</li>
     * </ul>
     *
     * @param format the message format (according to String.format conventions)
     * @param args   the message arguments
     * @return a new instance of exception context
     */
    public static ExceptionContext trace(String format, Object... args) {
        return build(Severity.TRACE, 200, format, args);
    }

    public static ExceptionContext build(Severity severity, int code, String message) {
        return build(severity, code, message, (Object) null);
    }

    /**
     * Builds a new instance of an exception context using the specified parameter.
     *
     * @param severity the severity
     * @param code     the (error) code
     * @param format   the message format according to the String.format(...) contract
     * @param args     arguments to be use within the message format
     * @return a new instance of exception context
     */
    public static ExceptionContext build(Severity severity, int code, String format, Object... args) {
        ExceptionContext context = new ExceptionContext();
        context
                .uuid(UUID.randomUUID())
                .code(code)
                .severity(severity)
                .message(format, args)
                .now()
        ;
        return context;
    }

}