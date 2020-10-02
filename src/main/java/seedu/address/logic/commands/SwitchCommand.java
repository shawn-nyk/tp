package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.ui.tabs.TabName;

/**
 * Switch the screen to a a certain tab.
 */
public class SwitchCommand extends Command {

    public static final String COMMAND_WORD = "switch";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Switch to the desired tab.\n"
        + "Parameters: Tab name.\n"
        + "Example: " + COMMAND_WORD + "-com";

    public final String sameScreenText;
    public final String switchedScreenText;

    private final TabName tabName;

    /**
     * Creates an AddCommand to switch {@code tabName}
     */
    public SwitchCommand(TabName tabName) {
        this.tabName = tabName;
        sameScreenText = String.format("Already in %s tab", capitalizeFirstLetterOnly(tabName.toString()));
        switchedScreenText = String.format("Switching to %s tab", capitalizeFirstLetterOnly(tabName.toString()));
    }

    @Override
    public CommandResult execute(Model model) {

        TabName currentTab = model.getTabName();
        String resultMessage;

        if (tabName.equals(currentTab)) {
            resultMessage = sameScreenText;
        } else {
            resultMessage = switchedScreenText;
            model.setTabName(tabName);
        }
        return new CommandResult(resultMessage, false, false, true);
    }

    /**
     * Capitalize only the first letter of {@code string}.
     */
    private String capitalizeFirstLetterOnly(String string) {
        String firstLetter = string.substring(0, 1);
        String rest = string.substring(1);
        return firstLetter + rest.toLowerCase();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof SwitchCommand // instanceof handles nulls
            && tabName.equals(((SwitchCommand) other).tabName)); // state check
    }
}
