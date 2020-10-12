package seedu.address.logic.commands.view;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_ITEM_DISPLAYED_INDEX;
import static seedu.address.commons.core.Messages.MESSAGE_VIEW_SUCCESS;
import static seedu.address.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.address.model.util.ItemUtil.APPLICATION_NAME;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.application.ApplicationItem;
import seedu.address.ui.tabs.TabName;

public class ViewApplicationCommand extends ViewCommand {

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + " " + APPLICATION_ALIAS + ": Views an " + APPLICATION_NAME + " in "
            + "InternHunter.\nParameters: "
            + "INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " "
            + APPLICATION_ALIAS
            + " 2";

    private final String messageViewSuccess;
    private final String messageAlreadyViewing;
    private final Index targetIndex;

    /** todo javadocs */
    public ViewApplicationCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
        this.messageViewSuccess = String.format(MESSAGE_VIEW_SUCCESS, APPLICATION_NAME, targetIndex);
        this.messageAlreadyViewing = String.format(MESSAGE_ALREADY_VIEWING, APPLICATION_NAME, targetIndex);
    }

    /**
     * Executes the view application command and returns the result message.
     * This command also auto-switches the user to the application tab.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<ApplicationItem> lastShownList = model.getApplicationList().getFilteredItemList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(String.format(MESSAGE_INVALID_ITEM_DISPLAYED_INDEX, APPLICATION_NAME));
        }

        String resultMessage = messageViewSuccess;
        boolean shouldSwitchTab = false;
        boolean shouldSwitchDisplay = true;
        if (model.getTabName() != TabName.APPLICATION) {
            model.setTabName(TabName.APPLICATION);
            shouldSwitchTab = true;
        } else if (model.getViewIndex().equals(targetIndex)) {
            resultMessage = messageAlreadyViewing;
            shouldSwitchDisplay = false;
        }

        if (shouldSwitchDisplay) {
            model.setViewIndex(targetIndex);
        }
        return new CommandResult(resultMessage, false, false , shouldSwitchTab, shouldSwitchDisplay);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ViewApplicationCommand // instanceof handles nulls
                && targetIndex.equals(((ViewApplicationCommand) other).targetIndex)); // state check
    }

}
