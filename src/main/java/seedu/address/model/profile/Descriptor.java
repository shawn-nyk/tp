package seedu.address.model.profile;

import seedu.address.model.wrapper.AlphaNumericWord;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;


/**
 * Represents a descriptor in the profile item.
 * Guarantees: immutable; non-empty; name is valid as declared in {@link #isValidAlphaNumericWord(String)}
 */
public class Descriptor extends AlphaNumericWord {

    public static final String MESSAGE_CONSTRAINTS = "Descriptors should only contain alphanumeric characters and "
            + "spaces, and it should not be blank";

    /**
     * Constructs a {@code Industry}.
     *
     * @param descriptor A valid industry type.
     */
    public Descriptor(String descriptor) {
        super(descriptor, MESSAGE_CONSTRAINTS);
    }
}
