package seedu.internhunter.logic.commands;


import org.junit.jupiter.api.Test;

import seedu.internhunter.model.Model;
import seedu.internhunter.model.ModelManager;
import seedu.internhunter.model.UserPrefs;
import seedu.internhunter.model.item.ItemList;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code DeleteCommand}.
 * // TODO REMOVE CLASS
 */
public class DeleteCommandTest {

    private Model model = new ModelManager(new ItemList<>(), new ItemList<>(), new ItemList<>(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        // Person personToDelete = model.getAddressBook().getFilteredItemList().get(INDEX_FIRST.getZeroBased());
        // DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST);

        // String expectedMessage = String.format(DeleteCommand.MESSAGE_DELETE_PERSON_SUCCESS, personToDelete);

        // ModelManager expectedModel = new ModelManager(model.getAddressBook().getUnfilteredItemList(),
        // new ItemList<>(), new ItemList<>(), new ItemList<>(), new UserPrefs());
        // expectedModel.getAddressBook().deleteItem(personToDelete);

        // assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        // Index outOfBoundIndex = Index.fromOneBased(model.getAddressBook().getFilteredItemList().size() + 1);
        // DeleteCommand deleteCommand = new DeleteCommand(outOfBoundIndex);

        // assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        // showPersonAtIndex(model, INDEX_FIRST);
        // Person personToDelete = model.getAddressBook().getFilteredItemList().get(INDEX_FIRST.getZeroBased());
        // DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST);

        // String expectedMessage = String.format(DeleteCommand.MESSAGE_DELETE_PERSON_SUCCESS, personToDelete);

        // Model expectedModel = new ModelManager(model.getAddressBook().getUnfilteredItemList(), new ItemList<>(),
        //         new ItemList<>(), new ItemList<>(), new UserPrefs());
        // expectedModel.getAddressBook().deleteItem(personToDelete);
        // showNoPerson(expectedModel);

        // assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        // showPersonAtIndex(model, INDEX_FIRST);
        // Index outOfBoundIndex = INDEX_SECOND;
        // ensures that outOfBoundIndex is still in bounds of address book list
        // assertTrue(outOfBoundIndex.getZeroBased()
        //        < model.getAddressBook().getUnfilteredItemList().getItemList().size());

        // DeleteCommand deleteCommand = new DeleteCommand(outOfBoundIndex);

        // assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        // DeleteCommand deleteFirstCommand = new DeleteCommand(INDEX_FIRST);
        // DeleteCommand deleteSecondCommand = new DeleteCommand(INDEX_SECOND);

        // same object -> returns true
        // assertEquals(deleteFirstCommand, deleteFirstCommand);

        // same values -> returns true
        // DeleteCommand deleteFirstCommandCopy = new DeleteCommand(INDEX_FIRST);
        // assertEquals(deleteFirstCommandCopy, deleteFirstCommand);

        // different types -> returns false
        // assertNotEquals(deleteFirstCommand, 1);

        // null -> returns false
        // assertNotEquals(deleteFirstCommand, null);

        // different person -> returns false
        // assertNotEquals(deleteSecondCommand, deleteFirstCommand);
    }

    /**
     * Updates {@code model}'s filtered list to show no one.
     */
    private void showNoPerson(Model model) {
        // model.getAddressBook().updateFilteredItemList(p -> false);

        // assertTrue(model.getAddressBook().getFilteredItemList().isEmpty());
    }
}
