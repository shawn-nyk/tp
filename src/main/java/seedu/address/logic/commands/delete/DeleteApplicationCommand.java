package seedu.address.logic.commands.delete;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.util.ItemUtil.APPLICATION_NAME;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.application.ApplicationItem;
import seedu.address.ui.tabs.TabName;

/**
 * Deletes the application from the Application list.
 */
public class DeleteApplicationCommand extends DeleteCommandAbstract {

    private final Index targetIndex;

    public DeleteApplicationCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<ApplicationItem> lastShownList = model.getApplicationList().getFilteredItemList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(String.format(Messages.MESSAGE_INVALID_ITEM_DISPLAYED_INDEX, APPLICATION_NAME));
        }

        ApplicationItem applicationToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.getApplicationList().deleteItem(applicationToDelete);
        model.setTabName(TabName.APPLICATION);

        return new CommandResult(String.format(Messages.MESSAGE_DELETED_ITEM, APPLICATION_NAME, applicationToDelete));
    }

    @Override
    public String getItemType() {
        return APPLICATION_NAME;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteApplicationCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteApplicationCommand) other).targetIndex)); // state check
    }

}
