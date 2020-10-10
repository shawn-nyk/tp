package seedu.address.logic.parser.add;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_JOB_TITLE;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_PERIOD;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_REQUIREMENT;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_WAGE;
import static seedu.address.logic.parser.util.Util.arePrefixesPresent;

import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.add.AddApplicationCommand;
import seedu.address.logic.commands.add.AddInternshipCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.util.InternshipParserUtil;
import seedu.address.model.internship.InternshipItem;
import seedu.address.model.internship.InternshipTitle;
import seedu.address.model.internship.Period;
import seedu.address.model.internship.Requirement;
import seedu.address.model.internship.Wage;

/**
 * Parses input arguments and creates a new AddApplicationCommand object.
 */
public class AddInternshipCommandParser implements Parser<AddInternshipCommand> {

    private static final int INDEX_FIRST = 0;
    private static final int INDEX_SECOND = 1;
    private static final int NUMBER_OF_ARGUMENTS_TYPES = 2;

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform to the expected format
     */
    public AddInternshipCommand parse(String args) throws ParseException {

        String[] argumentArr = args.strip().split(" ", NUMBER_OF_ARGUMENTS_TYPES);
        checkArgumentTypeSufficiency(argumentArr);
        Index companyIndex = ParserUtil.parseIndex(argumentArr[INDEX_FIRST]);
        String remainingTokens = " " + argumentArr[INDEX_SECOND];

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(remainingTokens, PREFIX_JOB_TITLE, PREFIX_PERIOD, PREFIX_WAGE, PREFIX_REQUIREMENT);

        if (!arePrefixesPresent(argMultimap, PREFIX_JOB_TITLE) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddInternshipCommand.MESSAGE_USAGE));
        }
        InternshipTitle internshipTitle =  InternshipParserUtil.parseInternshipTitle(argMultimap.getValue(PREFIX_JOB_TITLE).get());
        Period period =  InternshipParserUtil.parsePeriod(argMultimap.getValue(PREFIX_PERIOD).get());
        Wage wage =  InternshipParserUtil.parseWage(argMultimap.getValue(PREFIX_PERIOD).get());
        Set<Requirement> requirements = InternshipParserUtil.parseRequirements(argMultimap.getAllValues(PREFIX_REQUIREMENT));

        InternshipItem internshipItem = new InternshipItem(internshipTitle, period, wage, requirements);

        return new AddInternshipCommand(companyIndex, internshipItem);
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
                    MESSAGE_INVALID_COMMAND_FORMAT, AddApplicationCommand.MESSAGE_USAGE));
        }
    }
}
