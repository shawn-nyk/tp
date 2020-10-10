package seedu.address.logic.commands.add;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_JOB_TITLE;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_PERIOD;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_REQUIREMENT;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_WAGE;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_ALIAS;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_NAME;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class AddInternshipCommand extends AddCommandAbstract {

    // Todo: Fill Message Usage
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds an internship to InternHunter.\n"
            + "Parameters: "
            + PREFIX_JOB_TITLE + "TITLE "
            + "[" + PREFIX_PERIOD + "WAGE]...\n"
            + "[" + PREFIX_WAGE + "WAGE]...\n"
            + "[" + PREFIX_REQUIREMENT + "REQUIREMENT]...\n"
            + "Example: " + COMMAND_WORD + " " + INTERNSHIP_ALIAS + " "
            + PREFIX_JOB_TITLE + "Software Engineer "
            + PREFIX_REQUIREMENT + "React "
            + PREFIX_REQUIREMENT + "Vue";

    public static final String MESSAGE_SUCCESS = "New internship added: %1$s";

    private final String toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Internship}.
     */
    public AddInternshipCommand(String internshipItem) {
        requireNonNull(internshipItem);
        toAdd = internshipItem;
    }

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException { // todo
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public String getItemType() {
        return INTERNSHIP_NAME;
    }
}
