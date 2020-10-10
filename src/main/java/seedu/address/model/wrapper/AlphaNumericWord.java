package seedu.address.model.wrapper;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a alphanumeric word object.
 * Guarantees: immutable; is valid as declared in {@link #isValidAlphaNumericWord(String)}
 */
public class AlphaNumericWord {

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String value;

    /**
     * Constructs a {@code AlNumWord}.
     *
     * @param alphaNumericWord A valid word consisting of only alphanumeric characters.
     */
    public AlphaNumericWord(String alphaNumericWord, String messageConstraints) {
        requireNonNull(alphaNumericWord);
        checkArgument(isValidAlphaNumericWord(alphaNumericWord), messageConstraints);
        value = alphaNumericWord;
    }

    /**
     * Returns true if a given string only consists of alphanumeric characters.
     */
    public static boolean isValidAlphaNumericWord(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AlphaNumericWord // instanceof handles nulls
                && value.equals(((AlphaNumericWord) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
