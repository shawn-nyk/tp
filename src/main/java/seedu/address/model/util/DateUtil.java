package seedu.address.model.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * DateUtil class which provides the input and output formats for all dates, as well as methods for date format
 * matching.
 */
public class DateUtil {

    // Output date formats
    public static final String DATE_TIME_LONG_FORMAT = "d MMM yyyy @ h.mm a";
    public static final String DATE_TIME_SHORT_FORMAT = "d MMM";

    // Input date formats
    public static final String DATE_INPUT_FORMAT = "d-M-yy";
    public static final String DATE_TIME_INPUT_FORMAT = "d-M-yy HHmm";

    // MISC
    private static final String DEFAULT_TIME = "23:59";

    /**
     * Checks if the input given matches the d-M-yy HHmm format.
     *
     * @param input User input.
     * @return True if input has the date and time format, false otherwise.
     */
    public static boolean isDateTimeFormat(String input) {
        try {
            LocalDateTime.parse(input, formatterDateTime(DATE_TIME_INPUT_FORMAT));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the input given matches the d-M-yy format.
     *
     * @param input User input.
     * @return True if input has the date format, false otherwise.
     */
    public static boolean isDateFormat(String input) {
        try {
            LocalDate.parse(input, formatterDateTime(DATE_INPUT_FORMAT));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Creates a LocalDateTime object with d MMM yyyy @ h.mm a format.
     *
     * @param date Input date from user.
     * @return A LocalDate object.
     */
    public static LocalDateTime formatDate(String date) {
        LocalDate localDate = LocalDate.parse(date, formatterDateTime(DATE_INPUT_FORMAT));
        LocalTime currentTime = LocalTime.parse(DEFAULT_TIME);
        return LocalDateTime.of(localDate, currentTime);
    }

    /**
     * Creates a LocalDateTime object with d MMM yyyy @ h.mm a format.
     *
     * @param dateAndTime Input date and time from user.
     * @return Formatted date and time.
     */
    public static LocalDateTime formatDateTime(String dateAndTime) {
        return LocalDateTime.parse(dateAndTime, formatterDateTime(DATE_TIME_INPUT_FORMAT));
    }

    /**
     * Creates a DateTimeFormatter using the input pattern.
     *
     * @param pattern String pattern.
     * @return The DateTimeFormatter based the pattern.
     */
    public static DateTimeFormatter formatterDateTime(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }

}
