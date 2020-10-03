package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.clisyntax.CliSyntax.ITEM_PREFIX_APPLICATION;
import static seedu.address.logic.parser.clisyntax.CliSyntax.ITEM_PREFIX_COMPANY;
import static seedu.address.logic.parser.clisyntax.CliSyntax.ITEM_PREFIX_INTERNSHIP;
import static seedu.address.logic.parser.clisyntax.CliSyntax.ITEM_PREFIX_USER_PROFILE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.delete.DeleteCommand;
import seedu.address.logic.commands.delete.DeleteCommandAbstract;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommandAbstract> {

    private static final int ITEM_TYPE_POS = 0;
    private static final int ITEM_INDEX_POS = 1;
    private static final int NUMBER_OF_ARGUMENTS_TYPES = 2;

    /**
     * todo:Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommandAbstract parse(String args) throws ParseException {

        String[] argumentTypes = args.strip().split(" ", NUMBER_OF_ARGUMENTS_TYPES);
        String itemType = argumentTypes[ITEM_TYPE_POS];
        // Comment these 2 lines to use original addressbook format
        checkArgumentTypeSufficiency(argumentTypes);
        String itemIndex = argumentTypes[ITEM_INDEX_POS];
        try {
            // change itemIndex to args to use addressbook
            Index index = ParserUtil.parseIndex(itemIndex);
            switch (itemType) {
            case ITEM_PREFIX_COMPANY:
                //todo: return own delete command
                return new DeleteCommand(index);

            case ITEM_PREFIX_INTERNSHIP:
                //todo: return own delete command
                return new DeleteCommand(index);

            case ITEM_PREFIX_APPLICATION:
                //todo: return own delete command
                return new DeleteCommand(index);

            case ITEM_PREFIX_USER_PROFILE:
                //todo: return own delete command
                return new DeleteCommand(index);

            default:
                //todo: throw new parse exception for unrecognizable item
                return new DeleteCommand(index);
            }
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommandAbstract.MESSAGE_USAGE), pe);
        }
    }

    /**
     * Checks if number of argument types are sufficient.
     *
     * @return true if there are 2 types of argument: item type and index.
     */
    private void checkArgumentTypeSufficiency(String[] argumentTypes) throws ParseException {
        if (argumentTypes.length < NUMBER_OF_ARGUMENTS_TYPES) {
            throw new ParseException(String.format(
                    MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommandAbstract.MESSAGE_USAGE));
        }
    }
}
