package seedu.address.logic.parser.delete;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.clisyntax.ItemCliSyntax.PREFIX_INDEX;
import static seedu.address.logic.parser.util.Util.arePrefixesPresent;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.delete.DeleteInternshipCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteInternshipCommand object.
 */
public class DeleteInternshipCommandParser implements Parser<DeleteInternshipCommand> {

    private static final int INDEX_FIRST = 0;
    private static final int INDEX_SECOND = 1;
    private static final int NUMBER_OF_ARGUMENTS_TYPES = 2;

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteInternshipCommand parse(String args) throws ParseException {

        String[] argumentArr = args.split(" ", NUMBER_OF_ARGUMENTS_TYPES);

        if (argumentArr.length < NUMBER_OF_ARGUMENTS_TYPES) {
            throw new ParseException(String.format(
                    MESSAGE_INVALID_COMMAND_FORMAT, DeleteInternshipCommand.MESSAGE_USAGE));
        }

        Index companyIndex = ParserUtil.parseIndex(argumentArr[INDEX_FIRST]);
        String remainingTokens = " " + argumentArr[INDEX_SECOND];

        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(remainingTokens, PREFIX_INDEX);

        if (!arePrefixesPresent(argMultimap, PREFIX_INDEX) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DeleteInternshipCommand.MESSAGE_USAGE));
        }

        Index internshipIndex = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_INDEX).get());

        return new DeleteInternshipCommand(companyIndex, internshipIndex);
    }

}
