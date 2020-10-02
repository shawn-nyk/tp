package seedu.address.model.application;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.util.DateUtil.DATE_TIME_LONG_FORMAT;
import static seedu.address.model.util.DateUtil.DATE_TIME_SHORT_FORMAT;
import static seedu.address.model.util.DateUtil.formatterDateTime;
import static seedu.address.model.util.DateUtil.isDateFormat;
import static seedu.address.model.util.DateUtil.isDateTimeFormat;

import java.time.LocalDateTime;

/**
 * Represents the date of the Internship status update.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class StatusDate {

    public static final String MESSAGE_CONSTRAINTS = "Status date should be in the format of d-M-yy or d-M-yy HHmm";

    private final LocalDateTime date;

    /**
     * Constructs an {@code Date}.
     *
     * @param date A valid date.
     */
    public StatusDate(LocalDateTime date) {
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

    /**
     * Returns true if the given date is valid.
     *
     * @param date Input date.
     * @return True if date has a valid input format, false otherwise.
     */
    public boolean isValidDate(String date) {
        return isDateFormat(date) || isDateTimeFormat(date);
    }

    /**
     * Returns the short date format for main screen view.
     *
     * @return Short date format.
     */
    public String getShortDate() {
        return date.format(formatterDateTime(DATE_TIME_SHORT_FORMAT));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StatusDate // instanceof handles nulls
                && sameDate(((StatusDate) other).date)); // state check
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

    /**
     * Returns the long date format for right pane view.
     *
     * @return Long date format.
     */
    @Override
    public String toString() {
        return date.format(formatterDateTime(DATE_TIME_LONG_FORMAT));
    }

}
