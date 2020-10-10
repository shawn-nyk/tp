package seedu.address.logic.parser.delete;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_ITEM_TYPE;
import static seedu.address.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.address.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_ALIAS;
import static seedu.address.model.util.ItemUtil.PROFILE_ALIAS;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.delete.DeleteApplicationCommand;
import seedu.address.logic.commands.delete.DeleteCommandAbstract;
import seedu.address.logic.commands.delete.DeleteProfileCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommandAbstract> {

    private static final int ITEM_TYPE_INDEX = 0;
    private static final int ITEM_PREFIX_INDEX = 1;
    private static final int NUMBER_OF_ARGUMENTS_TYPES = 2;

    /**
     * todo:Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommandAbstract parse(String args) throws ParseException {

        String[] argumentTypes = args.strip().split(" ", NUMBER_OF_ARGUMENTS_TYPES);
        String itemType = argumentTypes[ITEM_TYPE_INDEX];

        checkArgumentTypeSufficiency(argumentTypes);
        String itemPrefixes = argumentTypes[ITEM_PREFIX_INDEX];

        // Internship has a different parse requirement
        if (itemType.equals(INTERNSHIP_ALIAS)) {
            return new DeleteInternshipCommandParser().parse(itemPrefixes);
        }

        Index index = ParserUtil.parseIndex(itemPrefixes);

        switch (itemType) {
        case COMPANY_ALIAS:
            //todo: return own delete command
            return null;

        case APPLICATION_ALIAS:
            return new DeleteApplicationCommand(index);

        case PROFILE_ALIAS:
            return new DeleteProfileCommand(index);

        default:
            // Invalid item type
            throw new ParseException(MESSAGE_INVALID_ITEM_TYPE);
        }
    }

    /**
     * Checks if number of argument types are sufficient.
     *
     * @param argumentTypes is a list of arguments delimited by the
     * first space in the user argument after stripping wrapping spaces.
     */
    private void checkArgumentTypeSufficiency(String[] argumentTypes) throws ParseException {
        if (argumentTypes.length < NUMBER_OF_ARGUMENTS_TYPES) {
            throw new ParseException(String.format(
                    MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommandAbstract.MESSAGE_USAGE));
        }
    }
}
