package seedu.address.logic.commands.add;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.clisyntax.ProfileCliSyntax.PREFIX_CATEGORY;
import static seedu.address.logic.parser.clisyntax.ProfileCliSyntax.PREFIX_DESCRIPTORS;
import static seedu.address.logic.parser.clisyntax.ProfileCliSyntax.PREFIX_TITLE;
import static seedu.address.model.util.ItemUtil.PROFILE_NAME;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.profile.ProfileItem;

public class AddProfileCommand extends AddCommandAbstract {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Parameters: "
            + PREFIX_TITLE + "TITLE "
            + PREFIX_CATEGORY + "CATEGORY "
            + "[" + PREFIX_DESCRIPTORS + "DESCRIPTOR]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TITLE + "Learn HTML "
            + PREFIX_CATEGORY + "Skill "
            + "[" + PREFIX_DESCRIPTORS + "DESCRIPTOR]...\n"
            + PREFIX_DESCRIPTORS + "Learn how to use div and classes. "
            + PREFIX_DESCRIPTORS + "Learn how to inject javascript. ";

    public static final String MESSAGE_SUCCESS = "New profileItem added: %1$s";
    public static final String MESSAGE_DUPLICATE_PROFILE_ITEM = "This profile item already exists in InternHunter";

    private final ProfileItem toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddProfileCommand(ProfileItem profileItem) {
        requireNonNull(profileItem);
        toAdd = profileItem;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.getProfileList().hasItem(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PROFILE_ITEM);
        }

        model.getProfileList().addItem(toAdd);
        System.out.println(model.getProfileList().getUnfilteredItemList().toString());
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof AddProfileCommand // instanceof handles nulls
                && toAdd.equals(((AddProfileCommand) other).toAdd));
    }

    @Override
    public String getItemType() {
        return PROFILE_NAME;
    }

}
