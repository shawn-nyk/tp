package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.internship.InternshipItem;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyUserInternship {

    /**
     * Returns an unmodifiable view of the InternshipItems list.
     * This list will not contain any duplicate InternshipItems.
     */
    ObservableList<InternshipItem> getUserInternshipList();

}
