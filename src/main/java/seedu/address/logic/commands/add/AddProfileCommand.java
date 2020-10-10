package seedu.address.logic.commands.add;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_DUPLICATE_ITEM;
import static seedu.address.logic.commands.util.CommandUtil.getCommandResult;
import static seedu.address.logic.parser.clisyntax.ProfileCliSyntax.PREFIX_CATEGORY;
import static seedu.address.logic.parser.clisyntax.ProfileCliSyntax.PREFIX_DESCRIPTORS;
import static seedu.address.logic.parser.clisyntax.ProfileCliSyntax.PREFIX_TITLE;
import static seedu.address.model.util.ItemUtil.PROFILE_ALIAS;
import static seedu.address.model.util.ItemUtil.PROFILE_NAME;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.profile.ProfileItem;
import seedu.address.ui.tabs.TabName;

/**
 * Adds a Profile Item to the Model's Profile list. todo javadocs (shawn)
 */
public class AddProfileCommand extends AddCommandAbstract {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " " + PROFILE_ALIAS
            + ": Adds a profile item to "
            + "InternHunter.\nParameters: "
            + "Parameters: "
            + PREFIX_TITLE + "TITLE "
            + PREFIX_CATEGORY + "CATEGORY "
            + "[" + PREFIX_DESCRIPTORS + "DESCRIPTOR]...\n"
            + "Example: " + COMMAND_WORD + " " + PROFILE_ALIAS + " "
            + PREFIX_TITLE + "Learn HTML "
            + PREFIX_CATEGORY + "Skill "
            + PREFIX_DESCRIPTORS + "Learn how to use div and classes. "
            + PREFIX_DESCRIPTORS + "Learn how to inject javascript. ";

    public static final String MESSAGE_SUCCESS = "New profileItem added: %1$s";

    private final ProfileItem toAdd;

    /**
     * Creates an AddCommand to add the specified {@code ProfileItem}.
     */
    public AddProfileCommand(ProfileItem profileItem) {
        requireNonNull(profileItem);
        toAdd = profileItem;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.getProfileList().hasItem(toAdd)) {
            throw new CommandException(String.format(MESSAGE_DUPLICATE_ITEM, PROFILE_NAME));
        }

        model.getProfileList().addItem(toAdd);

        return getCommandResult(model, String.format(MESSAGE_SUCCESS, toAdd), TabName.PROFILE);
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
