package seedu.address.logic.commands.add;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_WRONG_TAB;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.clisyntax.ApplicationCliSyntax.PREFIX_STATUS;
import static seedu.address.logic.parser.clisyntax.ApplicationCliSyntax.PREFIX_STATUS_DATE;
import static seedu.address.logic.parser.clisyntax.ItemCliSyntax.PREFIX_INDEX;
import static seedu.address.model.util.ItemUtil.APPLICATION_NAME;
import static seedu.address.model.util.ItemUtil.COMPANY_NAME;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_NAME;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.FilterableItemList;
import seedu.address.model.Model;
import seedu.address.model.application.ApplicationItem;
import seedu.address.model.application.Status;
import seedu.address.model.application.StatusDate;
import seedu.address.model.company.CompanyItem;
import seedu.address.model.internship.InternshipItem;
import seedu.address.ui.tabs.TabName;

public class AddApplicationCommand extends AddCommandAbstract {

    public static final String MESSAGE_DUPLICATE_APPLICATION = "This application already exists in Internhunter";
    public static final String MESSAGE_SUCCESS = "New application added: %s\n"
            + "Type in 'switch app' to see the newly added application!";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an application to Internhunter. "
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_INDEX + "INDEX "
            + "[" + PREFIX_STATUS + "STATUS]"
            + "[" + PREFIX_STATUS_DATE + "STATUS_DATE]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_INDEX + "2"
            + PREFIX_STATUS + "waiting"
            + PREFIX_STATUS_DATE + "23-12-20";

    private final Index companyIndex;
    private final Index internshipIndex;
    private final Status status;
    private final StatusDate statusDate;

    /**
     * Creates an AddApplicationCommand to add the specified {@code ApplicationItem}.
     */
    public AddApplicationCommand(Index companyIndex, Index internshipIndex, Status status, StatusDate statusDate) {
        requireAllNonNull(companyIndex, internshipIndex, status, statusDate);
        this.companyIndex = companyIndex;
        this.internshipIndex = internshipIndex;
        this.status = status;
        this.statusDate = statusDate;
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

        if (!model.getTabName().equals(TabName.APPLICATION)) {
            throw new CommandException(String.format(MESSAGE_WRONG_TAB, APPLICATION_NAME));
        }

        List<CompanyItem> lastShownCompanyList = model.getCompanyList().getFilteredItemList();

        if (companyIndex.getZeroBased() >= lastShownCompanyList.size()) {
            throw new CommandException(String.format(Messages.MESSAGE_INVALID_ITEM_DISPLAYED_INDEX, COMPANY_NAME));
        }

        CompanyItem companyItem = lastShownCompanyList.get(companyIndex.getZeroBased());
        List<InternshipItem> internshipItemList = companyItem.getInternships();

        if (internshipIndex.getZeroBased() >= internshipItemList.size()) {
            throw new CommandException(String.format(Messages.MESSAGE_INVALID_ITEM_DISPLAYED_INDEX, INTERNSHIP_NAME));
        }

        InternshipItem internshipItem = internshipItemList.get(internshipIndex.getZeroBased());
        ApplicationItem applicationItem = new ApplicationItem(internshipItem, status, statusDate);

        FilterableItemList<ApplicationItem> applicationList = model.getApplicationList();

        if (applicationList.hasItem(applicationItem)) {
            throw new CommandException(MESSAGE_DUPLICATE_APPLICATION);
        }
        applicationList.addItem(applicationItem);
        return new CommandResult(String.format(MESSAGE_SUCCESS, applicationItem));
    }

    @Override
    public String getItemType() {
        return APPLICATION_NAME;
    }

    @Override
    public boolean equals(Object otherCommand) {
        // short circuit if same object
        if (otherCommand == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(otherCommand instanceof AddApplicationCommand)) {
            return false;
        }

        AddApplicationCommand otherAddApplicationCommand = (AddApplicationCommand) otherCommand;
        return companyIndex.equals(otherAddApplicationCommand.companyIndex)
                && internshipIndex.equals(otherAddApplicationCommand.internshipIndex)
                && status.equals(otherAddApplicationCommand.status)
                && statusDate.equals(otherAddApplicationCommand.statusDate);
    }

}
