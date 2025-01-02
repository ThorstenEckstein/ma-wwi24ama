package de.dhbw.commons;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private static DateTimeFormatter zonedFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
    private static DateTimeFormatter localFormatter = DateTimeFormatter.ISO_DATE_TIME;

    public static final Boolean SORT_ASCENDING = true;
    public static final Boolean SORT_DESCENDING = false;

    /**
     * Return a zoned date time instance using ISO-like date-time formatter that formats or parses a date-time
     * with the offset and zone if available, such as '2011-12-03T10:15:30', '2011-12-03T10:15:30+01:00' or
     * '2011-12-03T10:15:30+01:00[Europe/Paris]'. If no Zone is provided, the ZoneId.systemDefault() is used.
     *
     * @param dateTime the string representing a date time
     * @return the zones date time
     */
    public static ZonedDateTime of(String dateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, localFormatter);
        return ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
    }

    /**
     *
     * @param dateTime the simple date formatted as: <pre>dd.mm.yyyy</pre>.
     * @return the zoned date time instance
     */
    public static ZonedDateTime from(String dateTime) {
        String[] dateTimeParts = dateTime.split("\\.");
        return ZonedDateTime.of(
                Integer.parseInt(dateTimeParts[2]),
                Integer.parseInt(dateTimeParts[1]),
                Integer.parseInt(dateTimeParts[0]),
                0,
                0,
                0,
                0,
                ZoneId.systemDefault());
    }

    /**
     * Returns the date time as a simplified string: dd/mm/yyyy
     * @param zonedDateTime the date time instance
     * @return the converted & simplified date time instance
     */
    public static String asSimpleStringWithTime(ZonedDateTime zonedDateTime) {
        if (zonedDateTime != null) {
            return String.format(
                    "%02d.%02d.%d %02d:%02d",
                    zonedDateTime.getDayOfMonth(),
                    zonedDateTime.getMonthValue(),
                    zonedDateTime.getYear(),
                    zonedDateTime.getHour(),
                    zonedDateTime.getMinute());
        }
        return "not-set";
    }

    /**
     * Returns the date time as a simplified string: dd/mm/yyyy
     * @param zonedDateTime the date time instance
     * @return the converted & simplified date time instance
     */
    public static String asSimpleString(ZonedDateTime zonedDateTime) {
        if (zonedDateTime != null) {
            return String.format(
                    "%02d.%02d.%d",
                    zonedDateTime.getDayOfMonth(),
                    zonedDateTime.getMonthValue(),
                    zonedDateTime.getYear());
        }
        return "not-set";
    }

    /*
     * Returns a zoned datetime from a string of format: "yyyy-mm-ddTHH:MM:SS"
     * @param dateTime the date time string
     * @return the instance od date time
     */
    /*
    public static ZonedDateTime of(String dateTime) {
        return ZonedDateTime.parse(
                dateTime,
                zonedFormatter);
    }
    */

}
