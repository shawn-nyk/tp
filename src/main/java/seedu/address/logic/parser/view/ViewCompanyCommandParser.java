package seedu.address.logic.parser.view;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.util.GeneralParserUtil.argumentsAreValid;
import static seedu.address.logic.parser.util.GeneralParserUtil.getIndexInPreamble;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.view.ViewCompanyCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

public class ViewCompanyCommandParser implements Parser<ViewCompanyCommand> {

    public ViewCompanyCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);

        if (!argumentsAreValid(true, argMultimap)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCompanyCommand.MESSAGE_USAGE));
        }

        Index index = getIndexInPreamble(argMultimap);
        return new ViewCompanyCommand(index);
    }
}
