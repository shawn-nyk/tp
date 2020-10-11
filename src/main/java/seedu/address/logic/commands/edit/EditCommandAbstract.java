package seedu.address.logic.commands.edit;

import seedu.address.logic.commands.Command;

public abstract class EditCommandAbstract extends Command {

    public static final String COMMAND_WORD = "edit";

    //todo Update Message Usage to standardised format
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits a company, internship, application or profile item in InternHunter.\n"
            + "Parameters: ITEM_TYPE DETAILS\n"
            + "Note: Valid ITEM_TYPEs are 'com', 'int', 'app' or 'me'. "
            + "Each ITEM_TYPE requires its own set of details."
            + "At least one field has to be provided for edit commands.\n"
            + "Example: " + COMMAND_WORD + " "
            + "int "
            + "DETAILS";

}
