package seedu.address.model.company;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Tag in the address book. TODO: Javadocs (Shawn)
 * Guarantees: immutable; name is valid as declared in {@link #isValidIndustryType(String)}
 */
public class Industry {

    public static final String MESSAGE_CONSTRAINTS = "Industry types should only contain alphanumeric characters and "
            + "spaces, and it should not be blank";
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String industryType;

    /**
     * Constructs a {@code Tag}.
     *
     * @param industryType A valid industry type.
     */
    public Industry(String industryType) {
        requireNonNull(industryType);
        checkArgument(isValidIndustryType(industryType), MESSAGE_CONSTRAINTS);
        this.industryType = industryType;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidIndustryType(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Industry // instanceof handles nulls
                && industryType.equals(((Industry) other).industryType)); // state check
    }

    @Override
    public int hashCode() {
        return industryType.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + industryType + ']';
    }

}
