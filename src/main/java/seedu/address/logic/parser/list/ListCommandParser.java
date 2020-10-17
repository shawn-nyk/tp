package seedu.address.logic.parser.list;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_ITEM_TYPE;
import static seedu.address.logic.parser.util.GeneralParserUtil.getItemType;
import static seedu.address.logic.parser.util.GeneralParserUtil.isValidItemType;
import static seedu.address.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.address.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.address.model.util.ItemUtil.PROFILE_ALIAS;

import seedu.address.logic.commands.list.ListCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

public class ListCommandParser implements Parser<ListCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ListCommand
     * and returns a ListCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListCommand parse(String args) throws ParseException {

        String itemType = getItemType(args, ListCommand.MESSAGE_USAGE);
        isValidItemType(itemType);

        switch (itemType) {
        case COMPANY_ALIAS:
            // todo shawn
            //return new ListCompanyCommand();
            return null;
        case APPLICATION_ALIAS:
            // todo sean
            //return new ListApplicationCommand();
            return null;
        case PROFILE_ALIAS:
            // todo isaac
            //return new ListProfileCommand();
            return null;
        default:
            // Invalid item type
            throw new ParseException(MESSAGE_INVALID_ITEM_TYPE);
        }
    }

}
