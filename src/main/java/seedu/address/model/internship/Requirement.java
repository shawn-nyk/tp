package seedu.address.model.internship;

import seedu.address.model.wrapper.AlphaNumericWord;

public class Requirement extends AlphaNumericWord {

    public static final String MESSAGE_CONSTRAINTS =
            "Requirements should only contain alphanumeric characters and spaces, and it should not be blank";

    /**
     * Constructs a {@code JobTitle}.
     *
     * @param requirement A valid job title.
     */
    public Requirement(String requirement) {
        super(requirement, MESSAGE_CONSTRAINTS);
    }

}
