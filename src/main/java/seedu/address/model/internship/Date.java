package seedu.address.model.internship;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Status's date.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Date {

    private static final String DATE_TIME_OUTPUT_FORMAT = "d MMM yyyy @ h.mm a";

    private final LocalDateTime date;

    /**
     * Constructs an {@code Date}.
     *
     * @param date A valid date.
     */
    public Date(LocalDateTime date) {
        requireNonNull(date);
        this.date = date;
    }

    /**
     * Checks if the otherDate has the same date as this Date object.
     * Two LocalDateTime objects have ths same date if they have the same year and date.
     *
     * @param otherDate Date of the other task.
     * @return True if the other task has the same date.
     */
    private boolean sameDate(LocalDateTime otherDate) {
        boolean sameYear = date.getYear() == otherDate.getYear();
        boolean sameDay = date.getDayOfYear() == otherDate.getDayOfYear();
        return sameYear && sameDay;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date // instanceof handles nulls
                && sameDate(((Date) other).date)); // state check
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ofPattern(DATE_TIME_OUTPUT_FORMAT));
    }

}
