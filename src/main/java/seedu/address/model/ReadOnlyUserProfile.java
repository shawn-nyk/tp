package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.profile.ProfileItem;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyUserProfile {

    /**
     * Returns an unmodifiable view of the Profile list.
     * This list will not contain any duplicate profile items.
     */
    ObservableList<ProfileItem> getUserProfileItemList();

}
