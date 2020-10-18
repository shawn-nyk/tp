package seedu.address.logic.commands.list;

import static seedu.address.commons.util.GeneralStringUtil.DOT;
import static seedu.address.commons.util.GeneralStringUtil.NEW_LINE;
import static seedu.address.commons.util.GeneralStringUtil.SPACE;
import static seedu.address.model.util.ItemUtil.APPLICATION_NAME;
import static seedu.address.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.address.model.util.ItemUtil.COMPANY_NAME;
import static seedu.address.model.util.ItemUtil.PROFILE_NAME;

import seedu.address.logic.commands.Command;

/**
 * todo javadocs
 */
public abstract class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": List out all the items in either "
        + COMPANY_NAME + " or "
        + APPLICATION_NAME + " or "
        + PROFILE_NAME + DOT + NEW_LINE
        + "Parameters: list ITEM_TYPE" + NEW_LINE
        + "Example: " + COMMAND_WORD + SPACE + COMPANY_ALIAS + NEW_LINE;

    public static final String EXCESS_MESSAGE = "Note that that should not be anything inputs after the ITEM_TYPE";
}
