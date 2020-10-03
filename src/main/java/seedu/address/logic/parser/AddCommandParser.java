package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.clisyntax.CliSyntax.ITEM_PREFIX_APPLICATION;
import static seedu.address.logic.parser.clisyntax.CliSyntax.ITEM_PREFIX_COMPANY;
import static seedu.address.logic.parser.clisyntax.CliSyntax.ITEM_PREFIX_INTERNSHIP;
import static seedu.address.logic.parser.clisyntax.CliSyntax.ITEM_PREFIX_USER_PROFILE;
import static seedu.address.logic.parser.clisyntax.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.clisyntax.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.clisyntax.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.clisyntax.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.clisyntax.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.clisyntax.internship.InternshipCliSyntax.PREFIX_JOB_TITLE;
import static seedu.address.logic.parser.clisyntax.internship.InternshipCliSyntax.PREFIX_PERIOD;
import static seedu.address.logic.parser.clisyntax.internship.InternshipCliSyntax.PREFIX_REQUIREMENT;
import static seedu.address.logic.parser.clisyntax.internship.InternshipCliSyntax.PREFIX_WAGE;

import java.util.Set;
import java.util.stream.Stream;

import seedu.address.logic.commands.add.AddCommand;
import seedu.address.logic.commands.add.AddCommandAbstract;
import seedu.address.logic.commands.add.AddInternshipCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommandAbstract> {

    private static final int ITEM_TYPE_INDEX = 0;
    private static final int ITEM_PREFIX_INDEX = 1;
    private static final int NUMBER_OF_ARGUMENTS_TYPES = 2;

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommandAbstract parse(String args) throws ParseException {

        String[] argumentTypes = args.strip().split(" ", NUMBER_OF_ARGUMENTS_TYPES);
        String itemType = argumentTypes[ITEM_TYPE_INDEX];

        // comment out these 2 lines to access og addresss book
        checkArgumentTypeSufficiency(argumentTypes);
        String itemPrefixes = argumentTypes[ITEM_PREFIX_INDEX];
        switch (itemType) {
        case ITEM_PREFIX_COMPANY:
            return null;

        case ITEM_PREFIX_INTERNSHIP:
            // todo: replace args with itemPrefixes
            ArgumentMultimap internshipMultimap =
                    ArgumentTokenizer.tokenize(itemPrefixes,
                        PREFIX_JOB_TITLE, PREFIX_PERIOD, PREFIX_WAGE, PREFIX_REQUIREMENT);

            // Todo: Only includes compulsory fields
            //            if (!arePrefixesPresent(internshipMultimap, PREFIX_JOB_TITLE, PREFIX_PERIOD,
            //                PREFIX_WAGE, PREFIX_REQUIREMENT)
            //                    || !internshipMultimap.getPreamble().isEmpty()) {
            //                throw new ParseException(String.format(
            //                            MESSAGE_INVALID_COMMAND_FORMAT, AddInternshipCommand.MESSAGE_USAGE));
            //            }
            // Todo: Add parser utilities for Internship
            // eg: Parse field e.g. Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
            // Todo: Create Internship object based on abstracted fields.
            return new AddInternshipCommand("Not an internship added");
        case ITEM_PREFIX_APPLICATION:
            return null;

        case ITEM_PREFIX_USER_PROFILE:
            return null;

        default:
            //todo: delete below and throw new parse exception for unrecognizable item type

            ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(
                        args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_TAG);

            if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE, PREFIX_EMAIL)
                    || !argMultimap.getPreamble().isEmpty()) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
            }

            Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
            Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
            Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());
            Address address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get());
            Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));

            Person person = new Person(name, phone, email, address, tagList);

            return new AddCommand(person);
        }

    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    /**
     * Checks if number of argument types are sufficient.
     *
     * @return true if there are 2 types of argument: item type and prefixes.
     */
    private void checkArgumentTypeSufficiency(String[] argumentTypes) throws ParseException {
        if (argumentTypes.length < NUMBER_OF_ARGUMENTS_TYPES) {
            throw new ParseException(String.format(
                    MESSAGE_INVALID_COMMAND_FORMAT, AddCommandAbstract.MESSAGE_USAGE));
        }
    }
}
