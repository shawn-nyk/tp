package seedu.address.logic.commands.add;

import seedu.address.logic.commands.Command;

import static seedu.address.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.address.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_ALIAS;
import static seedu.address.model.util.ItemUtil.PROFILE_ALIAS;

/**
 * Represents an Add Command for Items.
 */
public abstract class AddCommandAbstract extends Command {

    public static final String COMMAND_WORD = "add";
    //todo Update Message Usage to standardised format
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a company, internship, application or profile item to InternHunter.\n"
            + "Parameters: ITEM_TYPE DETAILS\n"
            + "Note: Valid ITEM_TYPEs are "
            + "'" + COMPANY_ALIAS + "', "
            + "'" + INTERNSHIP_ALIAS + "', "
            + "'" + APPLICATION_ALIAS + "' or "
            + "'" + PROFILE_ALIAS + "'. "
            + "Each ITEM_TYPE requires its own set of DETAILS.\n"
            + "Example: " + COMMAND_WORD + " " + INTERNSHIP_ALIAS + " DETAILS";

    /**
     * Obtains the name of item associated with Add Command.
     *
     * @return Item name.
     */
    public abstract String getItemType();
}
