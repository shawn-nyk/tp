package seedu.address.logic.commands.add;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.commands.util.CommandUtil.getCommandResult;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_JOB_TITLE;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_PERIOD;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_REQUIREMENT;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_WAGE;
import static seedu.address.model.util.ItemUtil.COMPANY_NAME;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_ALIAS;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_NAME;

import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.company.CompanyItem;
import seedu.address.model.internship.InternshipItem;
import seedu.address.model.internship.jobTitle;
import seedu.address.model.internship.Period;
import seedu.address.model.internship.Requirement;
import seedu.address.model.internship.Wage;
import seedu.address.ui.tabs.TabName;

public class AddInternshipCommand extends AddCommandAbstract {

    public static final String MESSAGE_DUPLICATE_ITEM = "This %1$s already exists in %2$s";
    public static final String MESSAGE_SUCCESS = "New internship added: %1$s";
    public static final String MESSAGE_USAGE = COMMAND_WORD + " " + INTERNSHIP_ALIAS + ": Adds an internship to "
            + "InternHunter.\nParameters: "
            + "INDEX "
            + PREFIX_JOB_TITLE + "JOB_TITLE "
            // Todo: Update Wage when its status is resolved.
            + PREFIX_WAGE + "WAGE "
            + "[" + PREFIX_PERIOD + "PERIOD] "
            + "[" + PREFIX_REQUIREMENT + "REQUIREMENT]...\n"
            + "Example: " + COMMAND_WORD + " " + INTERNSHIP_ALIAS
            + " 1 "
            + PREFIX_JOB_TITLE + "Software Engineer "
            + PREFIX_PERIOD + "3 months "
            + PREFIX_WAGE + "3000 "
            + PREFIX_REQUIREMENT + "React "
            + PREFIX_REQUIREMENT + "Vue ";

    private final Index companyIndex;
    private final jobTitle jobTitle;
    private final Period period;
    private final Wage wage;
    private final Set<Requirement> requirements;

    /**
     * Creates an AddCommand to add the specified {@code Internship}.
     */
    public AddInternshipCommand(Index companyIndex, jobTitle jobTitle,
        Period period, Wage wage, Set<Requirement> requirements) {
        requireAllNonNull(companyIndex, jobTitle, period, wage, requirements);
        this.companyIndex = companyIndex;
        this.jobTitle = jobTitle;
        this.period = period;
        this.wage = wage;
        this.requirements = requirements;
    }

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<CompanyItem> lastShownCompanyList = model.getCompanyList().getFilteredItemList();
        if (companyIndex.getZeroBased() >= lastShownCompanyList.size()) {
            throw new CommandException(String.format(Messages.MESSAGE_INVALID_ITEM_DISPLAYED_INDEX, COMPANY_NAME));
        }
        CompanyItem companyItem = lastShownCompanyList.get(companyIndex.getZeroBased());
        InternshipItem internshipItem = new InternshipItem(companyItem.getCompanyName(),
                jobTitle, period, wage, requirements);

        if (companyItem.ifInternshipExists(internshipItem)) {
            throw new CommandException(String.format(MESSAGE_DUPLICATE_ITEM,
                INTERNSHIP_NAME, companyItem.getCompanyName().toString()));
        }

        companyItem.addInternship(internshipItem);
        return getCommandResult(model, String.format(MESSAGE_SUCCESS, internshipItem),
                TabName.COMPANY);
    }

    @Override
    public String getItemType() {
        return INTERNSHIP_NAME;
    }
}
