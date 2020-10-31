package seedu.internhunter.model.internship;

import static java.util.Objects.requireNonNull;
import static seedu.internhunter.commons.util.AppUtil.checkArgument;

/**
 * Represents an InternshipItem's wage. TODO: Javadocs
 * Guarantees: immutable; is valid as declared in {@link #isValidOutputWage(String)}
 */
public class Wage {

    public static final String WAGE_SYMBOL = "$";
    public static final String MESSAGE_CONSTRAINTS = "Wage should only contain a positive number and no leading zeroes";
    public static final String VALIDATION_REGEX = "^[1-9]\\d*";

    private static final String DEFAULT_WAGE = "";

    private final String value;

    /**
     * Constructs a {@code Wage}.
     *
     * @param wage A valid wage.
     */
    public Wage(String wage) {
        requireNonNull(wage);
        checkArgument(isValidOutputWage(wage), MESSAGE_CONSTRAINTS);
        value = wage;
    }

    /**
     * Returns true if the given string matches the default wage or the regex.
     *
     * @param test String to test.
     * @return True if the given string is a valid wage, false otherwise.
     */
    public static boolean isValidOutputWage(String test) {
        return test.equals(DEFAULT_WAGE) || test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is a valid wage.
     *
     * @param test String to test.
     * @return True if the given string is a valid wage, false otherwise.
     */
    public static boolean isValidWage(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getValue() {
        return value;
    }

    /**
     * Returns the string representation of this wage object.
     *
     * @return String representation of this wage object.
     */
    @Override
    public String toString() {
        return value.equals(DEFAULT_WAGE) ? DEFAULT_WAGE : WAGE_SYMBOL + value;
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
