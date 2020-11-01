package seedu.internhunter.logic.commands.add;

import static seedu.internhunter.testutil.Assert.assertThrows;
import static seedu.internhunter.testutil.profile.SampleProfileItems.getSampleProfileItemList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.internhunter.model.Model;
import seedu.internhunter.model.ModelManager;
import seedu.internhunter.model.UserPrefs;
import seedu.internhunter.model.item.ItemList;

public class AddProfileCommandTest {
    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(new ItemList<>(), new ItemList<>(), getSampleProfileItemList(),
                new UserPrefs());
        expectedModel = new ModelManager(new ItemList<>(), new ItemList<>(),
                model.getUnfilteredProfileList(), new UserPrefs());
    }
    @Test
    public void constructor_nullProfileItem_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddProfileCommand(null));
    }

//    @Test
//    public void execute_profileItemAcceptedByModel_addSuccessful() throws Exception {
//        ProfileItem profileItem = new ProfileItemBuilder().build();
//
//        CommandResult commandResult = new AddProfileCommand(profileItem).execute(model);
//
//        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, profileItem), commandResult.getFeedbackToUser());
//        assertEquals(Arrays.asList(profileItem), modelStub.personsAdded);
//    }
//
//    @Test
//    public void execute_duplicatePerson_throwsCommandException() {
//        Person validPerson = new PersonBuilder().build();
//        AddCommand addCommand = new AddCommand(validPerson);
//        ModelStub modelStub = new ModelStubWithPerson(validPerson);
//
//        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PERSON, () -> addCommand.execute(modelStub));
//    }
//
//    @Test
//    public void equals() {
//        Person alice = new PersonBuilder().withName("Alice").build();
//        Person bob = new PersonBuilder().withName("Bob").build();
//        AddCommand addAliceCommand = new AddCommand(alice);
//        AddCommand addBobCommand = new AddCommand(bob);
//
//        // same object -> returns true
//        assertTrue(addAliceCommand.equals(addAliceCommand));
//
//        // same values -> returns true
//        AddCommand addAliceCommandCopy = new AddCommand(alice);
//        assertTrue(addAliceCommand.equals(addAliceCommandCopy));
//
//        // different types -> returns false
//        assertFalse(addAliceCommand.equals(1));
//
//        // null -> returns false
//        assertFalse(addAliceCommand.equals(null));
//
//        // different person -> returns false
//        assertFalse(addAliceCommand.equals(addBobCommand));
//    }
//
//
//    /**
//     * A Model stub that always accept the profile item being added.
//     */
//    private class ModelStubAcceptingProfileItemAdded extends ModelStub {
//        final ArrayList<ProfileItem> profileItems = new ArrayList<>();
//
//        @Override
//        public boolean hasProfileItem(ProfileItem profileItem) {
//            requireNonNull(profileItem);
//            return profileItems.stream().anyMatch(profileItem::isSameItem);
//        }
//
//        @Override
//        public void addProfileItem(ProfileItem profileItem) {
//            requireNonNull(profileItem);
//            profileItems.add(profileItem);
//        }
//
//        @Override
//        public ItemList getProfileItemList() {
//            return new ItemList<ProfileItem>();
//        }
//    }
}
