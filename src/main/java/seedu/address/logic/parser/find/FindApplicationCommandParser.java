package seedu.address.logic.parser.find;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.util.GeneralParserUtil.checkCommandDetailsIsNotBlank;

import java.util.Arrays;

import seedu.address.logic.commands.find.FindApplicationCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.application.ApplicationNameContainsKeyWordsPredicate;

public class FindApplicationCommandParser implements Parser<FindApplicationCommand> {

    @Override
    public FindApplicationCommand parse(String args) throws ParseException {
        requireNonNull(args);
        checkCommandDetailsIsNotBlank(args, FindApplicationCommand.MESSAGE_USAGE);
        String trimmedArgs = args.trim();
        String[] nameKeywords = trimmedArgs.split("\\s+");
        return new FindApplicationCommand(new ApplicationNameContainsKeyWordsPredicate(Arrays.asList(nameKeywords)));
    }
}
