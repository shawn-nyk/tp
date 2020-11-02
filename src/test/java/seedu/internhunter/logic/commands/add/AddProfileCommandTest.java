package seedu.internhunter.logic.commands.add;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.internhunter.commons.core.Messages.MESSAGE_ADD_SUCCESS;
import static seedu.internhunter.commons.core.Messages.MESSAGE_DUPLICATE_ITEM;
import static seedu.internhunter.model.util.ItemUtil.PROFILE_ITEM_NAME;
import static seedu.internhunter.model.util.ItemUtil.PROFILE_NAME;
import static seedu.internhunter.testutil.Assert.assertThrows;
import static seedu.internhunter.testutil.profile.ProfileItemFieldsUtil.VALID_TITLE_GOVTECH_INTERNSHIP;
import static seedu.internhunter.testutil.profile.ProfileItemFieldsUtil.VALID_TITLE_HACKATHON;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.internhunter.logic.commands.CommandResult;
import seedu.internhunter.logic.commands.exceptions.CommandException;
import seedu.internhunter.model.profile.ProfileItem;
import seedu.internhunter.testutil.profile.ProfileItemBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for {@code AddProfileCommand}.
 */
public class AddProfileCommandTest {

    @Test
    public void constructor_nullProfileItem_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddProfileCommand(null));
    }

    @Test
    public void execute_profileItemAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingProfileItemAdded modelStub = new ModelStubAcceptingProfileItemAdded();
        ProfileItem validProfileItem = new ProfileItemBuilder().build();

        CommandResult commandResult = new AddProfileCommand(validProfileItem).execute(modelStub);

        assertEquals(String.format(MESSAGE_ADD_SUCCESS, PROFILE_NAME, validProfileItem), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validProfileItem), modelStub.profileItems);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        ProfileItem validProfileItem = new ProfileItemBuilder().build();
        AddProfileCommand addProfileCommand = new AddProfileCommand(validProfileItem);
        ModelStub modelStub = new ModelStubAcceptingProfileItemAdded();

        assertThrows(CommandException.class, String.format(MESSAGE_DUPLICATE_ITEM, PROFILE_ITEM_NAME),
            () -> addProfileCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        ProfileItem internship = new ProfileItemBuilder().withTitle(VALID_TITLE_GOVTECH_INTERNSHIP).build();
        ProfileItem hackathon = new ProfileItemBuilder().withTitle(VALID_TITLE_HACKATHON).build();
        AddProfileCommand addProfileInternshipCommand = new AddProfileCommand(internship);
        AddProfileCommand addProfileHackathonCommand = new AddProfileCommand(hackathon);

        // same object -> returns true
        assertTrue(addProfileInternshipCommand.equals(addProfileInternshipCommand));

        // same values -> returns true
        AddProfileCommand addInternshpCommandCopy = new AddProfileCommand(internship);
        assertTrue(addProfileInternshipCommand.equals(addInternshpCommandCopy));

        // different types -> returns false
        assertFalse(addProfileInternshipCommand.equals(1));

        // null -> returns false
        assertFalse(addProfileInternshipCommand.equals(null));

        // different person -> returns false
        assertFalse(addProfileInternshipCommand.equals(addProfileHackathonCommand));
    }


    /**
     * A Model stub that always accept the profile item being added.
     */
    private class ModelStubAcceptingProfileItemAdded extends ModelStub {
        final ArrayList<ProfileItem> profileItems = new ArrayList<>();

        @Override
        public boolean hasProfileItem(ProfileItem profileItem) {
            requireNonNull(profileItem);
            return profileItems.stream().anyMatch(profileItem::isSameItem);
        }

        @Override
        public void addProfileItem(ProfileItem profileItem) {
            requireNonNull(profileItem);
            profileItems.add(profileItem);
        }
    }
}
