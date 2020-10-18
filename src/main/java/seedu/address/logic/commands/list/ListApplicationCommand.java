package seedu.address.logic.commands.list;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.commands.util.CommandUtil.getCommandResult;
import static seedu.address.model.FilterableItemList.PREDICATE_SHOW_ALL_ITEMS;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.ui.tabs.TabName;

public class ListApplicationCommand extends ListCommand {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all applications";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.getApplicationList().updateFilteredItemList(PREDICATE_SHOW_ALL_ITEMS);
        model.setApplicationViewIndex(Index.fromOneBased(1)); // reset to zero for consistency
        return getCommandResult(model, MESSAGE_SUCCESS, TabName.APPLICATION);
    }
}
