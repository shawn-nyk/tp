package seedu.address.logic.parser.view;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.util.GeneralParserUtil.argumentsAreValid;
import static seedu.address.logic.parser.util.GeneralParserUtil.getIndexInPreamble;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.view.ViewProfileCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewProfileCommand object.
 */
public class ViewProfileCommandParser implements Parser<ViewProfileCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewProfileCommand
     * and returns a ViewProfileCommand object for execution.
     *
     * @param args Arguments to be parsed.
     * @return ViewProfileCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public ViewProfileCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);

        if (!argumentsAreValid(true, argMultimap)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewProfileCommand.MESSAGE_USAGE));
        }

        Index index = getIndexInPreamble(argMultimap);
        return new ViewProfileCommand(index);
    }
}
