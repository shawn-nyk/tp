package seedu.address.model.internship;

import seedu.address.model.wrapper.NonEmptyString;

public class Requirement extends NonEmptyString {

    public static final String MESSAGE_CONSTRAINTS = "Requirements should not be blank";

    /**
     * Constructs a {@code JobTitle}.
     *
     * @param requirement A valid job title.
     */
    public Requirement(String requirement) {
        super(requirement, MESSAGE_CONSTRAINTS);
    }

}
