package seedu.address.model.profile;

import seedu.address.model.wrapper.AlphaNumericWord;

public class Title extends AlphaNumericWord {

    public static final String MESSAGE_CONSTRAINTS =
            "Profile Item Titles should only contain alphanumeric characters and spaces, and it should not be blank";

    /**
     * Constructs a {@code Title} for the {@code ProfileItem}
     *
     * @param title A valid title for the profile item.
     */
    public Title(String title) {
        super(title, MESSAGE_CONSTRAINTS);
    }

}
