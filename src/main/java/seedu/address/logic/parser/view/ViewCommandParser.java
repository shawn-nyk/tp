package seedu.address.logic.parser.view;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_ITEM_TYPE;
import static seedu.address.logic.parser.util.GeneralParserUtil.getCommandDetails;
import static seedu.address.logic.parser.util.GeneralParserUtil.getItemType;
import static seedu.address.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.address.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_ALIAS;
import static seedu.address.model.util.ItemUtil.PROFILE_ALIAS;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.view.ViewApplicationCommand;
import seedu.address.logic.commands.view.ViewCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.util.GeneralParserUtil;

/**
 * Parses input arguments and creates a new ViewCommand object
 */
public class ViewCommandParser implements Parser<ViewCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewCommand
     * and returns a ViewCommand object for execution.
     *
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public ViewCommand parse(String args) throws ParseException {

        String itemType = getItemType(args, ViewCommand.MESSAGE_USAGE);
        String commandDetails = getCommandDetails(args);

        // Internship has a different parse requirement
        if (itemType.equals(INTERNSHIP_ALIAS)) {
            // todo: return view internship command
            return null;
        }

        Index index = GeneralParserUtil.parseIndex(commandDetails);

        switch (itemType) {
        case COMPANY_ALIAS:
            //todo: return own delete command
            return null;

        case APPLICATION_ALIAS:
            return new ViewApplicationCommand(index);

        case PROFILE_ALIAS:
            //todo: return own delete command
            return null;

        default:
            // Invalid item type
            throw new ParseException(MESSAGE_INVALID_ITEM_TYPE);
        }
    }

}
