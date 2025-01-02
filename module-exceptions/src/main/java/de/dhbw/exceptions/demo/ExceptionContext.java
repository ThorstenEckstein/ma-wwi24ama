package de.dhbw.exceptions.demo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * This class is a container around arbitrary exception information. A context can be build using floating
 * programming style. Basically, a context contains the following information:
 * <ul>
 *     <li>A unique ID (UUID), useful when tracing an error through multiple components such as interfaces,
 *     i.e. <code>0157b880-db74-42db-b15f-2b100c5d063d</code></li>
 *     <li>A timestamp when this context was build, which should be the moment an exception is raised, i.e.
 *     '07.05.2015 16:45:32:428' (Note: timestamp output format has to/can be specified by clients using the
 *     <code>ExceptionContext.DetailLevel</code> enumeration which is provided here!)</li>
 *     <li>A code representing the error, can also be used for warnings, traces etc.</li>
 *     <li>A basic classification of the exceptions' severity (see also class 'Severity')</li>
 *     <li>A basic message (formattable)</li>
 *     <li>One or more optional 'information items' specified by key and value (see below)</li>
 * </ul>
 *
 * Optional information items:
 * <pre>
 * +---------------------+---------------------------------------------+
 * | ITEM                | EXAMPLE/VALUE                               |
 * +---------------------+---------------------------------------------+
 * | Thread-ID           | some 'technical ID' (i.e. component ID)     |
 * +---------------------+---------------------------------------------+
 * | Name of diagnosis   | i.e. 'buhu-task-service'                    |
 * | point according to  |                                             |
 * | some name convention|                                             |
 * +---------------------+---------------------------------------------+
 * | Calling/Request     | System name Consumer : 'FZI'                |
 * | context             | System name Provider : 'FZI'                |
 * |                     | User                 : 'thorsteneckstein'   |
 * |                     | Tenant               : 'FZI'                |
 * |                     | Module/UseCase       : 'importProduct'      |
 * |                     | Http-Request         : 'http://...'         |
 * |                     | Method-Call          : 'service.insert(...)'|
 * |                     | Call-Payload         :  Method arguments,   |
 * |                     |                         return values etc.  |
 * |                     | Stacktrace           : 'Exc. in thread... ' |
 * |                     | Measures             : 'process duration    |
 * |                     |                         in ms/ns'           |
 * +---------------------+---------------------------------------------+
 * </pre>
 *
 * Basically, there are three ways to create a new exception context:
 * <ol type="a">
 * 	   <li>Creating an exception context manually via floating API</li>
 * 	   <li>Creating an exception context via ExceptionContextBuilder helper class</li>
 * 	   <li>Creating an exception context via ExceptionContextBuilder build() method</li>
 * </ol>
 *
 * <pre>
 *     a)
 *     ExceptionContext ctx = new ExceptionContext();
 * 	   ctx.uuid(UUID.randomUUID())
 * 		  .code(ErrorCodes.CONFLICT)
 * 		  .severity(Severity.ERROR)
 * 		  .message("error message")
 * 		  .item("k1", "v1")
 * 		  .item("k2", "v2")
 * 		  .now();
 * 	ApplicationException exc = new ValidationException(ctx);
 * </pre>
 *  <pre>
 *     b)
 *     ExceptionContext ctx = ExceptionContextBuilder.error("Access denied for user '%s'", "johnny.walker");
 *     ApplicationException exc = new AccessDeniedException(ctx);
 * </pre>
 *  <pre>
 *     c)
 *     ExceptionContext ctx = ExceptionContextBuilder.build(Severity.WARN, 200, "warning #%d", 2345);
 *     ApplicationException exc = new UnknownAccessAttemptWarning(ctx);
 * </pre>
 */
public class ExceptionContext implements Serializable {

	private UUID uuid;
	private LocalDateTime timestamp = LocalDateTime.now();
	private int code;
	private Severity severity;
	private String message;
	private Map<String, Object> items = new HashMap<>();

	/**
	 * Main c'tor. Creates internally a random UUID (no instance shall exist without any UUID) and the default
	 * SerializationStrategy (simple 'formatted string' as return value of toString() method).
	 */
	public ExceptionContext() {
		this.uuid = UUID.randomUUID();
	}

	/**
	 * The unique ID. If any UUID was already set (i.e. internally when creating new ExceptionContext instances),
	 * it will be overridden by calling this method.
	 * @param uuid the (new) unique ID
	 * @return the current instance of ExceptionContext
	 */
	public ExceptionContext uuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	/**
	 * Specifies a specific timestamp for this exception context. Preliminary used to indicate the moment when an
	 * exception was raised.
	 * @param timestamp the timestamp to set
	 * @return the current instance of ExceptionContext
	 */
	public ExceptionContext timestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	/**
	 * Sets the context timestamp to 'now' (calls LocalDateTime.now()).
	 * @return the current instance of ExceptionContext
	 */
	public ExceptionContext now() {
		return timestamp(LocalDateTime.now());
	}

	/**
	 * Specifies an commonly known but application specific (error) code as integer. For web environments it is
	 * recommended not to use http error codes for application events (and/or re-use http error codes), instead extend
	 * these code ranges, i.e. beginning with number ranges greater than '1000'.
	 * @param code the (error) code to specify
	 * @return the current instance of ExceptionContext
	 */
	public ExceptionContext code(int code) {
		this.code = code;
		return this;
	}

	public ExceptionContext severity(Severity severity) {
		this.severity = severity;
		return this;
	}

	public ExceptionContext message(String message) {
		this.message = message;
		return this;
	}

	public ExceptionContext message(String format, Object... args) {
		this.message = String.format(format, args);
		return this;
	}

	public ExceptionContext item(String key, Object value) {
		this.items.put(key, value);
		return this;
	}

	public boolean hasItems(){
		return !this.items.isEmpty();
	}

	public UUID getUuid() {
		return uuid;
	}

	public int getCode() {
		return code;
	}

	public Severity getSeverity() {
		return severity;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getItems() {
		return this.items;
	}

	public Object getItem(String key) {
		return this.items.get(key);
	}

	public LocalDateTime getTimestamp() { return timestamp; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExceptionContext other = (ExceptionContext) obj;
		if (uuid == null) {
			if (other.getUuid() != null)
				return false;
		} else if (!uuid.equals(other.getUuid()))
			return false;
		return true;
	}

}