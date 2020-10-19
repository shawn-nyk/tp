package seedu.address.logic.commands.list;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_LIST_SUCCESS;
import static seedu.address.logic.commands.util.CommandUtil.getCommandResult;
import static seedu.address.model.FilterableItemList.PREDICATE_SHOW_ALL_ITEMS;
import static seedu.address.model.util.ItemUtil.APPLICATION_NAME;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.ui.tabs.TabName;

/**
 * todo javadocs
 */
public class ListApplicationCommand extends ListCommand {

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.getApplicationList().updateFilteredItemList(PREDICATE_SHOW_ALL_ITEMS);
        model.setApplicationViewIndex(Index.fromOneBased(1)); // reset to zero for consistency
        String messageSuccess = String.format(MESSAGE_LIST_SUCCESS, APPLICATION_NAME);
        return getCommandResult(model, messageSuccess, TabName.APPLICATION);
    }
}
