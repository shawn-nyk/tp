package seedu.address.model.internship;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;

/**
 * A list of internshipItems that enforces uniqueness between its elements and does not allow nulls.
 * A internshipItem is considered unique by comparing using {@code InternshipItem#isSameInternshipItem(InternshipItem)}.
 * As such, adding and updating of internshipItems uses InternshipItem#isSameInternshipItem(InternshipItem) for
 * equality so as to ensure that the internshipItem being added or updated is unique in terms of identity in the
 * UniqueInternshipItemList. However, the removal of a internshipItem uses InternshipItem#equals(Object) so
 * as to ensure that the internshipItem with exactly the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see InternshipItem#isSameInternshipItem(InternshipItem)
 */
public class UniqueInternshipItemList implements Iterable<InternshipItem> {

    private final ObservableList<InternshipItem> internalList = FXCollections.observableArrayList();
    private final ObservableList<InternshipItem> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent internshipItem as the given argument.
     */
    public boolean contains(InternshipItem toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameInternshipItem);
    }

    /**
     * Adds a internshipItem to the list.
     * The internshipItem must not already exist in the list.
     */
    public void add(InternshipItem toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicatePersonException();
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the internshipItem {@code target} in the list with {@code editedInternshipItem}.
     * {@code target} must exist in the list.
     * The internshipItem identity of {@code editedInternshipItem} must not be the same as another existing
     * internshipItem in the list.
     */
    public void setInternshipItem(InternshipItem target, InternshipItem editedInternshipItem) {
        requireAllNonNull(target, editedInternshipItem);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new PersonNotFoundException();
        }

        if (!target.isSameInternshipItem(editedInternshipItem) && contains(editedInternshipItem)) {
            throw new DuplicatePersonException();
        }

        internalList.set(index, editedInternshipItem);
    }

    /**
     * Removes the equivalent internshipItem from the list.
     * The internshipItem must exist in the list.
     */
    public void remove(InternshipItem toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new PersonNotFoundException();
        }
    }

    public void setInternshipItems(UniqueInternshipItemList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code internshipItems}.
     * {@code internshipItems} must not contain duplicate internshipItems.
     */
    public void setInternshipItems(List<InternshipItem> internshipItems) {
        requireAllNonNull(internshipItems);
        if (!internshipItemsAreUnique(internshipItems)) {
            throw new DuplicatePersonException();
        }

        internalList.setAll(internshipItems);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<InternshipItem> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<InternshipItem> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueInternshipItemList // instanceof handles nulls
                && internalList.equals(((UniqueInternshipItemList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    /**
     * Returns true if {@code internshipItems} contains only unique internshipItems.
     */
    private boolean internshipItemsAreUnique(List<InternshipItem> internshipItems) {
        for (int i = 0; i < internshipItems.size() - 1; i++) {
            for (int j = i + 1; j < internshipItems.size(); j++) {
                if (internshipItems.get(i).isSameInternshipItem(internshipItems.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
