package seedu.address.model.internship;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Internship's wage.
 * Guarantees: immutable; is valid as declared in {@link #isValidWage(String)}
 */
public class Wage {

    public static final String MESSAGE_CONSTRAINTS =
            "Wage should only contain numbers, and it should be at least 3 digits long";
    public static final String VALIDATION_REGEX = "\\d{3,}";
    public final String value;

    /**
     * Constructs a {@code Wage}.
     *
     * @param wage A valid wage number.
     */
    public Wage(String wage) {
        requireNonNull(wage);
        checkArgument(isValidWage(wage), MESSAGE_CONSTRAINTS);
        value = wage;
    }

    /**
     * Returns true if a given string is a valid wage number.
     */
    public static boolean isValidWage(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format("$%s", value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Wage // instanceof handles nulls
                && value.equals(((Wage) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
