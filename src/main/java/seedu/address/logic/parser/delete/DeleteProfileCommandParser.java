package seedu.address.logic.parser.delete;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.util.GeneralParserUtil.argumentsAreValid;
import static seedu.address.logic.parser.util.GeneralParserUtil.getIndexInPreamble;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.delete.DeleteProfileCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and creates a new DeleteProfileCommand object.
 */
public class DeleteProfileCommandParser implements Parser<DeleteProfileCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteProfileItemCommand
     * and returns a DeleteProfileItemCommand object for execution.
     *
     * @param args Arguments to be parsed.
     * @return DeleteProfileCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public DeleteProfileCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);

        if (!argumentsAreValid(true, argMultimap)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DeleteProfileCommand.MESSAGE_USAGE));
        }

        Index index = getIndexInPreamble(argMultimap);
        return new DeleteProfileCommand(index);
    }
}
