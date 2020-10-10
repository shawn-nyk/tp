package seedu.address.model.wrapper;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a non empty string object.
 * Guarantees: immutable; is valid as declared in {@link #isValidNonEmptyString(String)}
 */
public class NonEmptyString {

    /*
     * Represents a string that contains at least one non-space character.
     */
    public static final String VALIDATION_REGEX = "^(?!\\s*$).+";

    public final String value;

    /**
     * Constructs a {@code AlNumWord}.
     *
     * @param nonEmptyString A valid word that has at least one non-space character.
     */
    public NonEmptyString(String nonEmptyString, String messageConstraints) {
        requireNonNull(nonEmptyString);
        checkArgument(isValidNonEmptyString(nonEmptyString), messageConstraints);
        value = nonEmptyString;
    }

    /**
     * Returns true if a given string is a not empty.
     */
    public static boolean isValidNonEmptyString(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NonEmptyString // instanceof handles nulls
                && value.equals(((NonEmptyString) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
