package seedu.address.logic.parser.edit;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.clisyntax.ApplicationCliSyntax.PREFIX_STATUS;
import static seedu.address.logic.parser.clisyntax.ApplicationCliSyntax.PREFIX_STATUS_DATE;
import static seedu.address.logic.parser.util.ApplicationParserUtil.parseStatus;
import static seedu.address.logic.parser.util.ApplicationParserUtil.parseStatusDate;
import static seedu.address.logic.parser.util.GeneralParserUtil.getIndexInPreamble;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.edit.EditApplicationCommand;
import seedu.address.logic.commands.edit.EditApplicationCommand.EditApplicationDescriptor;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.application.Status;
import seedu.address.model.application.StatusDate;

/**
 * Parses input arguments and creates a new EditApplicationCommand object.
 */
public class EditApplicationCommandParser implements Parser<EditApplicationCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditApplicationCommand
     * and returns an EditApplicationCommand object for execution.
     *
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public EditApplicationCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_STATUS, PREFIX_STATUS_DATE);

        Index index = getIndexInPreamble(argMultimap, EditApplicationCommand.MESSAGE_USAGE);
        EditApplicationDescriptor editApplicationDescriptor = new EditApplicationDescriptor();

        if (argMultimap.getValue(PREFIX_STATUS).isPresent()) {
            String inputStatus = argMultimap.getValue(PREFIX_STATUS).get();
            Status editedStatus = parseStatus(inputStatus);
            editApplicationDescriptor.setStatus(editedStatus);
        }
        if (argMultimap.getValue(PREFIX_STATUS_DATE).isPresent()) {
            String inputStatusDate = argMultimap.getValue(PREFIX_STATUS_DATE).get();
            StatusDate editedStatusDate = parseStatusDate(inputStatusDate);
            editApplicationDescriptor.setStatusDate(editedStatusDate);
        }

        if (!editApplicationDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditApplicationCommand.MESSAGE_USAGE);
        }
        return new EditApplicationCommand(index, editApplicationDescriptor);
    }

}
