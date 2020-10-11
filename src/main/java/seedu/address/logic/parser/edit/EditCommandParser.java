package seedu.address.logic.parser.edit;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_ITEM_TYPE;
import static seedu.address.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.address.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_ALIAS;
import static seedu.address.model.util.ItemUtil.PROFILE_ALIAS;

import seedu.address.logic.commands.edit.EditCommandAbstract;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new EditCommand object // todo javadocs
 */
public class EditCommandParser implements Parser<EditCommandAbstract> {

    private static final int ITEM_TYPE_INDEX = 0;
    private static final int COMMAND_DETAILS_INDEX = 1;
    private static final int NUMBER_OF_ARGUMENTS_TYPES = 2;

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommandAbstract parse(String args) throws ParseException {
        requireNonNull(args);
        String[] argumentTypes = args.strip().split(" ", NUMBER_OF_ARGUMENTS_TYPES);
        String itemType = argumentTypes[ITEM_TYPE_INDEX];

        checkItemTypePresent(itemType);
        String commandDetails = getCommandDetails(argumentTypes);
        switch (itemType) {
        case COMPANY_ALIAS:
            return new EditCompanyCommandParser().parse(commandDetails);
        case INTERNSHIP_ALIAS:
            // todo return edit internship command
            return null;
        case APPLICATION_ALIAS:
            // todo return edit application command
            return null;
        case PROFILE_ALIAS:
            // todo return edit profile command
            return null;
        default:
            throw new ParseException(MESSAGE_INVALID_ITEM_TYPE);
        }
    }

    private void checkItemTypePresent(String itemType) throws ParseException {
        if (itemType.trim().isEmpty()) {
            throw new ParseException(String.format(
                    MESSAGE_INVALID_COMMAND_FORMAT, EditCommandAbstract.MESSAGE_USAGE));
        }
    }

    private String getCommandDetails(String[] argumentTypes) {
        String dummy = "";
        if (argumentTypes.length < NUMBER_OF_ARGUMENTS_TYPES) {
            return dummy; // if the user only entered the command word and the item type (did not enter details),
            // then provide this dummy string so that the relevant parser will show its error message.
        } else {
            return " " + argumentTypes[COMMAND_DETAILS_INDEX];
        }
    }

}
