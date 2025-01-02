package de.dhbw.javadoc.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//tag::javadoc-class[]

/**
 * <p>
 * This class is a utility class that can be used to handle
 * instances of <code>LocalDateTime</code>.
 * </p>
 * <p>
 * Whenever this application uses <code>LocalDateTime</code>
 * instances, this utility helps to deal with conversions from
 * and to <code>String</code>. Therefore, It provides specific
 * <code>DateTimeFormatter</code> and conversion methods like
 * <code>format</code> and <code>parse</code>.
 * </p>
 */
public class DateTimeHelper {
//end::javadoc-class[]

	/**
	 * The default <strong>timestamp format</strong> according to <code>java.time</code> API:
	 * <pre>
	 *  MM.dd.yyyy HH:mm:ss
	 * </pre>
	 *
	 * See also &rarr; {@link  DateTimeHelper#DATE_TIME_FORMATTER  DATE_TIME_FORMATTER}
	 */
	public static final String DEFAULT_TIMESTAMP_FORMAT = "dd.MM.yyyy HH:mm:ss";

	//tag::javadoc-field[]
	/**
	 * <p>
	 * The default <strong>timestamp formatter</strong> according
	 * to <code>java.time</code> API. Uses the
	 * <code>DEFAULT_TIMESTAMP_FORMAT</code> to format instances of
	 * <code>LocalDateTime</code>.
	 * </p>
	 *
	 * See also &rarr;
	 * {@link
	 * DateTimeHelper#DEFAULT_TIMESTAMP_FORMAT
	 * DEFAULT_TIMESTAMP_FORMAT}
	 */
	public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_TIMESTAMP_FORMAT);
    //end::javadoc-field[]

	/**
	 * Returns a <strong>formatted String</strong> which is formatted
	 * using the &rarr; {@link  DateTimeHelper#DATE_TIME_FORMATTER  DATE_TIME_FORMATTER}
	 *
	 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html">DateTimeFormatter</a>
	 *
	 * @param localDateTime
	 *            the instance of LocalDateTime
	 * @return the string formatted with DATE_TIME_FORMATTER
	 */
	public static String format(LocalDateTime localDateTime) {
		return format(localDateTime, null);
	}

	//tag::javadoc-method[]
	/**
	 * Returns a <strong>formatted String</strong> which is formatted
	 * using the specified format pattern.
	 *
	 * <p style="font-style:italic;">
	 * <strong style="color:red;">CAUTION</strong> The given pattern
	 * will be parsed internally and thus have to follow the rules
	 * as prescribed by <code>DateTimeFormatter</code>.
	 * </p>
	 *
	 * In case of invalid pattern, an exception will be thrown, please
	 * visit &rarr;
	 * <a href="https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ofPattern-java.lang.String-">
	 *  <code>DateTimeFormatter.ofPattern(String)</code>
	 * </a>
	 *
	 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html">DateTimeFormatter</a>
	 *
	 * @param localDateTime
	 *            the instance of LocalDateTime
	 * @param pattern
	 *            the pattern to use for formatting
	 * @return the formatted string
	 */
	public static String format(LocalDateTime localDateTime, String pattern) {
	//end::javadoc-method[]
		if (localDateTime == null)
			return null;
		if (pattern != null && !pattern.isEmpty()) {
			DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(pattern);
			return localDateTime.format(customFormatter);
		}
		return localDateTime.format(DATE_TIME_FORMATTER);
	}

	/**
	 * Parses a string representing the local datetime using the default format
	 * pattern as specified in 'DEFAULT_TIMESTAMP_FORMAT'.
	 * 
	 * @param localDateTime
	 *            the String representing the local datetime
	 * @return the parsed instance of LocalDateTime
	 */
	public static LocalDateTime parse(String localDateTime) {
		return parse(localDateTime, null);
	}

	/**
	 * Parses a string representing the local datetime using the specified format pattern.
	 * 
	 * @param localDateTime
	 *            the String representing the local datetime
	 * @param pattern
	 *            the pattern string
	 * @return the parsed instance of LocalDateTime
	 */
	public static LocalDateTime parse(String localDateTime, String pattern) {
		if (localDateTime == null)
			return null;
		if (pattern != null && !pattern.isEmpty()) {
			DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(pattern);
			return LocalDateTime.parse(localDateTime, customFormatter);
		}
		return LocalDateTime.parse(localDateTime, DATE_TIME_FORMATTER);
	}

}