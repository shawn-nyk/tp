package seedu.internhunter.logic.commands.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.internhunter.logic.commands.util.CommandUtil.getApplication;
import static seedu.internhunter.logic.commands.util.CommandUtil.getCommandResult;
import static seedu.internhunter.logic.commands.util.CommandUtil.getCompany;
import static seedu.internhunter.logic.commands.util.CommandUtil.getProfileItem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.internhunter.commons.core.index.Index;
import seedu.internhunter.logic.commands.CommandResult;
import seedu.internhunter.logic.commands.exceptions.CommandException;
import seedu.internhunter.model.Model;
import seedu.internhunter.model.ModelManager;
import seedu.internhunter.model.UserPrefs;
import seedu.internhunter.model.application.ApplicationItem;
import seedu.internhunter.model.company.CompanyItem;
import seedu.internhunter.model.item.ItemList;
import seedu.internhunter.model.profile.ProfileItem;
import seedu.internhunter.testutil.application.ApplicationItemBuilder;
import seedu.internhunter.testutil.company.CompanyItemBuilder;
import seedu.internhunter.testutil.profile.ProfileItemBuilder;
import seedu.internhunter.ui.tabs.TabName;

public class CommandUtilTest {

    private static final String FEEDBACK = "feedback";

    private Model model;
    private Model modelWithData;
    private ApplicationItemBuilder applicationItemBuilder;
    private ProfileItemBuilder profileItemBuilder;
    private CompanyItemBuilder companyItemBuilder;

    @BeforeEach
    public void setUp() {
        model = new ModelManager();
        applicationItemBuilder = new ApplicationItemBuilder();
        profileItemBuilder = new ProfileItemBuilder();
        companyItemBuilder = new CompanyItemBuilder();
        initializeData();
    }

    private void initializeData() {
        ItemList<ApplicationItem> applicationItems = new ItemList<>();
        applicationItems.addItem(applicationItemBuilder.build());
        ItemList<ProfileItem> profileItemItems = new ItemList<>();
        profileItemItems.addItem(profileItemBuilder.build());
        ItemList<CompanyItem> companyItems = new ItemList<>();
        companyItems.addItem(companyItemBuilder.build());
        modelWithData = new ModelManager(companyItems, applicationItems, profileItemItems, new UserPrefs());
    }

    @Test
    public void getCommandResult4Parameters_dontSwitchTab_success() {
        CommandResult expected = new CommandResult(FEEDBACK);
        CommandResult result = getCommandResult(model, FEEDBACK, TabName.COMPANY, TabName.COMPANY,
            Index.fromOneBased(1));
        assertEquals(expected, result);
    }

    @Test
    public void getCommandResult4Parameters_switchTabCompanyToProfile_success() {
        CommandResult expected = new CommandResult(FEEDBACK, false, false, true, true);
        CommandResult result = getCommandResult(model, FEEDBACK, TabName.COMPANY, TabName.PROFILE,
            Index.fromOneBased(1));
        assertEquals(expected, result);
    }

    @Test
    public void getCommandResult4Parameters_switchTabCompanyToApplication_success() {
        CommandResult expected = new CommandResult(FEEDBACK, false, false, true, true);
        CommandResult result = getCommandResult(model, FEEDBACK, TabName.COMPANY, TabName.APPLICATION,
            Index.fromOneBased(1));
        assertEquals(expected, result);
    }

    @Test
    public void getCommandResult4Parameters_switchDisplay_success() {
        CommandResult expected = new CommandResult(FEEDBACK);
        model.setCompanyViewIndex(Index.fromOneBased(3));
        CommandResult result = getCommandResult(model, FEEDBACK, TabName.COMPANY, TabName.COMPANY,
            Index.fromOneBased(3));
        assertEquals(expected, result);
    }

    @Test
    public void getCompany_equals_true() throws CommandException {
        CompanyItem companyItem = companyItemBuilder.build();
        assertTrue(getCompany(modelWithData, Index.fromOneBased(1)).equals(companyItem));
    }

    @Test
    public void getCompany_equals_false() throws CommandException {
        CompanyItem companyItem = companyItemBuilder.withPhone("91919191").build();
        assertFalse(getCompany(modelWithData, Index.fromOneBased(1)).equals(companyItem));
    }

    @Test
    public void getCompany_invalidIndex_throwCommandException() {
        assertThrows(CommandException.class, () -> getCompany(modelWithData, Index.fromOneBased(10)));
        assertThrows(CommandException.class, () -> getCompany(modelWithData, Index.fromZeroBased(1)));
    }

    @Test
    public void getCompany_validIndex_noExceptionThrown() {
        assertDoesNotThrow(() -> getCompany(modelWithData, Index.fromZeroBased(0)));
        assertDoesNotThrow(() -> getCompany(modelWithData, Index.fromOneBased(1)));
    }

    @Test
    public void getApplication_equals_true() throws CommandException {
        ApplicationItem applicationItem = applicationItemBuilder.build();
        assertTrue(getApplication(modelWithData, Index.fromOneBased(1)).equals(applicationItem));
    }

    @Test
    public void getApplication_equals_false() throws CommandException {
        ApplicationItem applicationItem = applicationItemBuilder.withStatus("accepted").build();
        assertFalse(getApplication(modelWithData, Index.fromOneBased(1)).equals(applicationItem));
    }

    @Test
    public void getApplication_invalidIndex_throwCommandException() {
        assertThrows(CommandException.class, () -> getApplication(modelWithData, Index.fromOneBased(10)));
        assertThrows(CommandException.class, () -> getApplication(modelWithData, Index.fromZeroBased(1)));
    }

    @Test
    public void getApplication_validIndex_noExceptionThrown() {
        assertDoesNotThrow(() -> getApplication(modelWithData, Index.fromZeroBased(0)));
        assertDoesNotThrow(() -> getApplication(modelWithData, Index.fromOneBased(1)));
    }

    @Test
    public void getProfile_equals_true() throws CommandException {
        ProfileItem profileItem = profileItemBuilder.build();
        assertTrue(getProfileItem(modelWithData, Index.fromOneBased(1)).equals(profileItem));
    }

    @Test
    public void getProfile_equals_false() throws CommandException {
        ProfileItem profileItem = profileItemBuilder.withDescriptors("HELLO WORLD").build();
        assertFalse(getProfileItem(modelWithData, Index.fromOneBased(1)).equals(profileItem));
    }

    @Test
    public void getProfile_invalidIndex_throwCommandException() {
        assertThrows(CommandException.class, () -> getProfileItem(modelWithData, Index.fromOneBased(10)));
        assertThrows(CommandException.class, () -> getProfileItem(modelWithData, Index.fromZeroBased(1)));
    }

    @Test
    public void getProfile_validIndex_noExceptionThrown() {
        assertDoesNotThrow(() -> getProfileItem(modelWithData, Index.fromOneBased(1)));
        assertDoesNotThrow(() -> getProfileItem(modelWithData, Index.fromZeroBased(0)));
    }
}
