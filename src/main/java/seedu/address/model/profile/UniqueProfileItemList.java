package seedu.address.model.profile;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;

/**
 * A list of profile items that enforces uniqueness between its elements and does not allow nulls.
 * A profile item is considered unique by comparing using {@code Profile#isSameProfileItem(ProfileItem)}. As such,
 * adding and updating of profile items uses ProfileItem#isSameProfileItem(ProfileItem) for equality so as to ensure
 * that the profile item being added or updated is unique in terms of identity in the UniquePersonList.
 * However, the removal of a profile item uses ProfileItem#equals(Object) so as to ensure that the profile item with
 * exactly the same  fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see ProfileItem#isSameProfileItem(ProfileItem)
 */
public class UniqueProfileItemList implements Iterable<ProfileItem> {

    private final ObservableList<ProfileItem> internalList = FXCollections.observableArrayList();
    private final ObservableList<ProfileItem> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent person as the given argument.
     */
    public boolean contains(ProfileItem toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameProfileItem);
    }

    /**
     * Adds a profileItem to the list.
     * The person must not already exist in the list.
     */
    public void add(ProfileItem toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicatePersonException();
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the list.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the list.
     */
    public void setProfileItem(ProfileItem target, ProfileItem editedProfileItem) {
        requireAllNonNull(target, editedProfileItem);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new PersonNotFoundException();
        }

        if (!target.isSameProfileItem(editedProfileItem) && contains(editedProfileItem)) {
            throw new DuplicatePersonException();
        }

        internalList.set(index, editedProfileItem);
    }

    /**
     * Removes the equivalent person from the list.
     * The person must exist in the list.
     */
    public void remove(ProfileItem toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new PersonNotFoundException();
        }
    }

    public void setProfileItems(UniqueProfileItemList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setProfileItems(List<ProfileItem> profileItems) {
        requireAllNonNull(profileItems);
        if (!profileItemsAreUnique(profileItems)) {
            throw new DuplicatePersonException();
        }

        internalList.setAll(profileItems);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<ProfileItem> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<ProfileItem> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueProfileItemList // instanceof handles nulls
                && internalList.equals(((UniqueProfileItemList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    /**
     * Returns true if {@code persons} contains only unique persons.
     */
    private boolean profileItemsAreUnique(List<ProfileItem> profileItems) {
        for (int i = 0; i < profileItems.size() - 1; i++) {
            for (int j = i + 1; j < profileItems.size(); j++) {
                if (profileItems.get(i).isSameProfileItem(profileItems.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
