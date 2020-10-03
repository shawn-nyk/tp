package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.ui.tabs.TabName;

public class SwitchCommandTest {

    // Default screen is Internship.
    public static final String SAME_SCREEN_TEXT = "Already in Internship tab";
    public static final String SWITCHED_SCREEN_TEXT_USER = "Switching to User tab";
    public static final String SWITCHED_SCREEN_TEXT_COMPANY = "Switching to Company tab";

    private final Model model = new ModelManager();
    private final Model expectedModel = new ModelManager();

    @Test
    public void execute_switchToUserTab_success() {
        CommandResult expectedCommandResult = new CommandResult(SWITCHED_SCREEN_TEXT_USER, false, false,
            true);
        assertCommandSuccess(new SwitchCommand(TabName.USER), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_switchToCompanyTab_success() {
        CommandResult expectedCommandResult = new CommandResult(SWITCHED_SCREEN_TEXT_COMPANY, false,
            false, true);
        assertCommandSuccess(new SwitchCommand(TabName.COMPANY), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_switchToInternshipTab_success() {
        CommandResult expectedCommandResult = new CommandResult(SAME_SCREEN_TEXT, false, false,
            true);
        assertCommandSuccess(new SwitchCommand(TabName.INTERNSHIP), model, expectedCommandResult, expectedModel);
    }
}
