package seedu.internhunter.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.internhunter.logic.commands.MatchCommand.NO_MATCHING_INTERNSHIPS_MESSAGE;
import static seedu.internhunter.logic.commands.MatchCommand.SHOWING_MATCH_COMMAND_MESSAGE;
import static seedu.internhunter.testutil.company.SampleCompanyItems.getSampleCompanyList;
import static seedu.internhunter.testutil.internship.SampleInternshipItems.FACEBOOK_SWE;
import static seedu.internhunter.testutil.internship.SampleInternshipItems.GOLDMAN_BA;
import static seedu.internhunter.testutil.profile.ProfileItemFieldsUtil.VALID_CATEGORY_ACHIEVEMENT;
import static seedu.internhunter.testutil.profile.ProfileItemFieldsUtil.VALID_CATEGORY_EXPERIENCE;
import static seedu.internhunter.testutil.profile.SampleProfileItems.HTML_SKILL;
import static seedu.internhunter.testutil.profile.SampleProfileItems.R_SKILL;
import static seedu.internhunter.testutil.profile.SampleProfileItems.getSampleProfileItemList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import seedu.internhunter.model.Model;
import seedu.internhunter.model.ModelManager;
import seedu.internhunter.model.UserPrefs;
import seedu.internhunter.model.item.ItemList;
import seedu.internhunter.model.profile.ProfileItem;
import seedu.internhunter.testutil.profile.ProfileItemBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for {@code MatchCommand}. Testing is done
 * through both command result since there is no changes to the model.
 */
public class MatchCommandTest {

    private Model model;
    private MatchCommand matchCommand;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getSampleCompanyList(), new ItemList<>(), getSampleProfileItemList(),
                new UserPrefs());
        matchCommand = new MatchCommand();
    }

    @Test
    public void execute_noChangesToModel_success() {
        Model expectedModel = new ModelManager(getSampleCompanyList(), new ItemList<>(), getSampleProfileItemList(),
                new UserPrefs());
        matchCommand.execute(model);
        assertEquals(model, expectedModel);
    }

    @Test
    public void execute_onlyOneCompanyMatched_success() {
        CommandResult actualCommandResult = matchCommand.execute(model);
        CommandResult expectedCommandResult = new CommandResult(SHOWING_MATCH_COMMAND_MESSAGE);
        expectedCommandResult.setMatchingInternships(FXCollections.observableArrayList(FACEBOOK_SWE));
        assertMatchCommandSuccess(actualCommandResult, expectedCommandResult, 1);
    }

    @Test
    public void execute_multipleCompaniesInternships_success() {
        model.addProfileItem(R_SKILL);
        CommandResult actualCommandResult = matchCommand.execute(model);
        CommandResult expectedCommandResult = new CommandResult(SHOWING_MATCH_COMMAND_MESSAGE);
        expectedCommandResult.setMatchingInternships(
                FXCollections.observableArrayList(GOLDMAN_BA, FACEBOOK_SWE));
        assertMatchCommandSuccess(actualCommandResult, expectedCommandResult, 2);
    }

    @Test
    public void execute_emptyCompanyList_noMatchingInternships() {
        model = new ModelManager(new ItemList<>(), new ItemList<>(), getSampleProfileItemList(),
                new UserPrefs());
        CommandResult actualCommandResult = matchCommand.execute(model);
        CommandResult expectedCommandResult = new CommandResult(NO_MATCHING_INTERNSHIPS_MESSAGE);
        assertMatchCommandSuccess(actualCommandResult, expectedCommandResult, 0);
    }

    @Test
    public void execute_emptyProfileList_noMatchingInternships() {
        model = new ModelManager(getSampleCompanyList(), new ItemList<>(), new ItemList<>(),
                new UserPrefs());
        CommandResult actualCommandResult = matchCommand.execute(model);
        CommandResult expectedCommandResult = new CommandResult(NO_MATCHING_INTERNSHIPS_MESSAGE);
        assertMatchCommandSuccess(actualCommandResult, expectedCommandResult, 0);
    }

    @Test
    public void execute_differentCategoryNonMatch_success() {
        // Checks for achievement category
        model = new ModelManager(getSampleCompanyList(), new ItemList<>(), new ItemList<>(), new UserPrefs());
        ProfileItem profileItemToAdd =
                new ProfileItemBuilder(HTML_SKILL).withCategory(VALID_CATEGORY_ACHIEVEMENT).build();
        model.addProfileItem(profileItemToAdd);
        CommandResult actualCommandResult = matchCommand.execute(model);
        CommandResult expectedCommandResult = new CommandResult(NO_MATCHING_INTERNSHIPS_MESSAGE);
        assertMatchCommandSuccess(actualCommandResult, expectedCommandResult, 0);

        // Checks for experience category
        model = new ModelManager(getSampleCompanyList(), new ItemList<>(), new ItemList<>(), new UserPrefs());
        profileItemToAdd = new ProfileItemBuilder(HTML_SKILL).withCategory(VALID_CATEGORY_EXPERIENCE).build();
        model.addProfileItem(profileItemToAdd);
        actualCommandResult = matchCommand.execute(model);
        expectedCommandResult = new CommandResult(NO_MATCHING_INTERNSHIPS_MESSAGE);
        assertMatchCommandSuccess(actualCommandResult, expectedCommandResult, 0);
    }

    /**
     * Checks if the given command result is the same as the expected one. Also checks if the size of matching
     * internships in the actualCommandResult is equal to the matchingInternshipsSize.
     *
     * @param expectedCommandResult Expected CommandResult.
     * @param actualCommandResult Actual CommandResult.
     * @param matchingInternshipsSize Expected size of matching internships.
     */
    private void assertMatchCommandSuccess(CommandResult expectedCommandResult, CommandResult actualCommandResult,
            int matchingInternshipsSize) {
        assertEquals(expectedCommandResult, actualCommandResult);
        assertEquals(matchingInternshipsSize, actualCommandResult.getMatchingInternships().size());
    }

}
