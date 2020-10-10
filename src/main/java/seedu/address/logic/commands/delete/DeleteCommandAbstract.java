package seedu.address.logic.commands.delete;

import static seedu.address.logic.parser.clisyntax.ItemCliSyntax.PREFIX_INDEX;
import static seedu.address.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_ALIAS;

import seedu.address.logic.commands.Command;

public abstract class DeleteCommandAbstract extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes an item from InternHunter.\n"
            + "Parameters (for ITEM_TYPE 'com', 'app', 'me'): "
            + "ITEM_TYPE INDEX\n"
            + "Parameters (for ITEM_TYPE 'int'): "
            + "ITEM_TYPE INDEX " + PREFIX_INDEX + "INDEX\n"
            + "Note: INDEX must be a positive integer.\n"
            + "Examples:\n"
            + COMMAND_WORD + " " + COMPANY_ALIAS + " 2\n"
            + COMMAND_WORD + " " + INTERNSHIP_ALIAS + " 1 " + PREFIX_INDEX + "3";

    /**
     * Obtains the name of item associated with Delete Command.
     *
     * @return Item name.
     */
    public abstract String getItemType();
}
