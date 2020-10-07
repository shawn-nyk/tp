package seedu.address.logic.parser.add;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.add.AddUtil.arePrefixesPresent;
import static seedu.address.logic.parser.clisyntax.ApplicationCliSyntax.PREFIX_STATUS;
import static seedu.address.logic.parser.clisyntax.ApplicationCliSyntax.PREFIX_STATUS_DATE;
import static seedu.address.logic.parser.clisyntax.ItemCliSyntax.PREFIX_INDEX;

import java.time.LocalDateTime;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.add.AddApplicationCommand;
import seedu.address.logic.parser.ApplicationParserUtil;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.application.Status;
import seedu.address.model.application.StatusDate;

public class AddApplicationCommandParser implements Parser<AddApplicationCommand> {

    private static final int INDEX_FIRST = 0;
    private static final int INDEX_SECOND = 1;
    private static final int NUMBER_OF_ARGUMENTS_TYPES = 2;

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddApplicationCommand parse(String args) throws ParseException {

        String[] argumentArr = args.strip().split(" ", NUMBER_OF_ARGUMENTS_TYPES);
        Index companyIndex = ParserUtil.parseIndex(argumentArr[INDEX_FIRST]);
        String remainingTokens = argumentArr[INDEX_SECOND];

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(remainingTokens, PREFIX_INDEX, PREFIX_STATUS, PREFIX_STATUS_DATE);

        if (!arePrefixesPresent(argMultimap, PREFIX_INDEX) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddApplicationCommand.MESSAGE_USAGE));
        }

        Index internshipIndex = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_INDEX).get());
        Status status;
        StatusDate statusDate;

        if (argMultimap.getValue(PREFIX_STATUS).isPresent()) {
            status = ApplicationParserUtil.parseStatus(argMultimap.getValue(PREFIX_STATUS).get());
        } else {
            status = Status.APPLIED;
        }

        if (argMultimap.getValue(PREFIX_STATUS_DATE).isPresent()) {
            statusDate = ApplicationParserUtil.parseStatusDate(argMultimap.getValue(PREFIX_STATUS_DATE).get());
        } else {
            statusDate = new StatusDate(LocalDateTime.now());
        }

        return new AddApplicationCommand(companyIndex, internshipIndex, status, statusDate);
    }

}
