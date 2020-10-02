package seedu.address.logic.commands;

import javafx.stage.Stage;
import seedu.address.model.Model;
import seedu.address.ui.MainWindow;
import seedu.address.ui.UiManager;
import seedu.address.ui.tabs.TabName;
import seedu.address.ui.tabs.Tabs;

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
        MainWindow mainWindow = UiManager.getMainWindow();
        Tabs tabs = mainWindow.getTabs();
        Stage stage = mainWindow.getPrimaryStage();
        TabName currentTab = tabs.getCurrentTabName();
        String resultMessage;

        if (tabName.equals(currentTab)) {
            resultMessage = sameScreenText;
        } else {
            switch (tabName) {
            case COMPANY:
                tabs.selectCompany(stage);
                break;
            case INTERNSHIP:
                tabs.selectInternship(stage);
                break;
            case USER:
                tabs.selectUser(stage);
                break;
            default:
                assert false;
            }
            resultMessage = switchedScreenText;
            tabs.setTabName(tabName);
        }
        return new CommandResult(resultMessage);
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
