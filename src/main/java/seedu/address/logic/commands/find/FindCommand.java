package seedu.address.logic.commands.find;

import static seedu.address.commons.util.GeneralStringUtil.COMMA_WITH_SPACE;
import static seedu.address.commons.util.GeneralStringUtil.DOT;
import static seedu.address.commons.util.GeneralStringUtil.DOT_WITH_SPACE;
import static seedu.address.commons.util.GeneralStringUtil.NEW_LINE;
import static seedu.address.commons.util.GeneralStringUtil.SPACE;
import static seedu.address.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.address.model.util.ItemUtil.APPLICATION_NAME;
import static seedu.address.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.address.model.util.ItemUtil.COMPANY_NAME;
import static seedu.address.model.util.ItemUtil.PROFILE_ALIAS;
import static seedu.address.model.util.ItemUtil.PROFILE_NAME;

import seedu.address.logic.commands.Command;

/**
 * todo javadocs
 */
public abstract class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Find if an item exist in the list of "
        + COMPANY_NAME + " or "
        + APPLICATION_NAME + " or "
        + PROFILE_NAME + DOT + NEW_LINE
        + "Parameters: ITEM_TYPE DESCRIPTION\n" // note that the name description can be change in the future
        + "Note: Valid ITEM_TYPEs are "
        + SPACE + COMPANY_ALIAS + COMMA_WITH_SPACE
        + SPACE + APPLICATION_ALIAS + " or "
        + SPACE + PROFILE_ALIAS + DOT_WITH_SPACE
        + "Example: "
        + COMMAND_WORD + SPACE + COMPANY_ALIAS + SPACE + "Google" + NEW_LINE;
}
