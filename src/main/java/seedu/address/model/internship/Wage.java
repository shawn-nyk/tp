package seedu.address.model.internship;

import seedu.address.model.wrapper.PositiveNumber;

/**
 * Represents a Internship's wage.
 * Guarantees: immutable; is valid as declared in {@link #isValidPositiveNumber(String)}
 */
public class Wage extends PositiveNumber {

    public static final String MESSAGE_CONSTRAINTS = "Wage should only contain a positive number";

    /**
     * Constructs a {@code Wage}.
     *
     * @param wage A valid wage number.
     */
    public Wage(String wage) {
        super(wage, MESSAGE_CONSTRAINTS);
    }

    @Override
    public String toString() {
        return String.format("$%s", value);
    }

}
