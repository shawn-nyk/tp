package seedu.address.model.internship;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Requirement is an optional field in an InternshipItem.
 * Guarantees: immutable; is valid as declared in {@link #isValidRequirement(String)}
 */
public class Requirement {


    public static final String MESSAGE_CONSTRAINTS = "Requirement have a maximum of 2 words and not be blank";

    private static final int MAX_NUMBER_OF_WORDS = 2;
    private final String value;

    /**
     * Constructs a {@code AlNumWord}.
     *
     * @param requirement A valid word that has at least one non-space character.
     */
    public Requirement(String requirement) {
        requireNonNull(requirement);
        checkArgument(isValidRequirement(requirement), MESSAGE_CONSTRAINTS);
        value = requirement;
    }

    /**
     * Retrieves the Requirement string value.
     *
     * @return String value in Requirement.
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns true if a given string contains 2 or less words.
     *
     * @param test String to test.
     * @return True if the given string is not empty, false otherwise.
     */
    public static boolean isValidRequirement(String test) {
        if (test.isBlank()) {
            return false;
        }
        return test.strip().replaceAll("\\s{2,}", " ").split(" ").length <= MAX_NUMBER_OF_WORDS;
    }

    /**
     * Returns the string representation of this Requirement object.
     *
     * @return String representation of this Requirement object.
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Returns true if the other Requirement object have the same value.
     *
     * @param other Object object to compare to.
     * @return True if the other Requirement object has the same value as this object.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Requirement // instanceof handles nulls
                && value.equals(((Requirement) other).value)); // state check
    }

    /**
     * Returns the hashcode of this Requirement object, which is the hashcode of the value.
     *
     * @return Hashcode of this Requirement object.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
