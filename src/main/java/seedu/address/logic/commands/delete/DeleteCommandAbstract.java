package seedu.address.logic.commands.delete;
import seedu.address.logic.commands.Command;

public abstract class DeleteCommandAbstract extends Command {

    public static final String COMMAND_WORD = "delete";

    //todo Update Message Usage to standardised format
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": deletes an item from Internhunter."
            + "Parameters: "
            + "ITEM TYPE (must be com or int or app or me) "
            + "INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " "
            + "int "
            + "2";

    /**
     * Obtains the name of item associated with Delete Command.
     *
     * @return Item name.
     */
    public abstract String getItemType();
}
