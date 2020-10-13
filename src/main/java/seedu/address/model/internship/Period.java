package seedu.address.model.internship;

import seedu.address.model.wrapper.NonEmptyString;

public class Period extends NonEmptyString {

    public static final String MESSAGE_CONSTRAINTS = "Periods should not be blank";

    /**
     * Constructs a {@code Period}.
     *
     * @param period A valid period.
     */
    public Period(String period) {
        super(period, MESSAGE_CONSTRAINTS);
    }

}
