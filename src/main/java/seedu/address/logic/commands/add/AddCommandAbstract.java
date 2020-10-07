package seedu.address.logic.commands.add;

import seedu.address.logic.commands.Command;

/**
 * Represents an Add Command for Items.
 */
public abstract class AddCommandAbstract extends Command {

    public static final String COMMAND_WORD = "add";
    //todo Update Message Usage to standardised format
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a company or internship or application to Internhunter. "
            + "Parameters: "
            + "ITEM TYPE (must be 'com' or 'int' or 'app' or 'me')\n"
            + "Example: " + COMMAND_WORD + " "
            + "int "
            + "PREFIX ARGUMENTS";

    /**
     * Obtains the name of item associated with Add Command.
     *
     * @return Item name.
     */
    public abstract String getItemType();
}
