package seedu.address.model.profile;

import seedu.address.model.wrapper.AlphaNumericWord;

/**
 * Represents a title fields in a Profile.
 * Guarantees: immutable; is valid as declared in {@link #isValidAlphaNumericWord(String)}
 */
public class Title extends AlphaNumericWord {

    public static final String MESSAGE_CONSTRAINTS =
            "Titles should only contain alphanumeric characters and spaces, and it should not be blank";

    /**
     * Constructs a {@code Title}.
     *
     * @param title A valid title.
     */
    public Title(String title) {
        super(title, MESSAGE_CONSTRAINTS);
    }
}
