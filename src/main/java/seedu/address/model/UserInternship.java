package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.internship.InternshipItem;
import seedu.address.model.internship.UniqueInternshipItemList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameInternshipItem comparison)
 */
public class UserInternship implements ReadOnlyUserInternship {

    private final UniqueInternshipItemList internshipItems;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        internshipItems = new UniqueInternshipItemList();
    }

    public UserInternship() {
    }

    /**
     * Creates an UserInternship using the InternshipItems in the {@code toBeCopied}
     */
    public UserInternship(ReadOnlyUserInternship toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code internshipItems}.
     * {@code internshipItems} must not contain duplicate internshipItems.
     */
    public void setInternshipItems(List<InternshipItem> internshipItems) {
        this.internshipItems.setInternshipItems(internshipItems);
    }

    /**
     * Resets the existing data of this {@code UserInternship} with {@code newData}.
     */
    public void resetData(ReadOnlyUserInternship newData) {
        requireNonNull(newData);

        setInternshipItems(newData.getUserInternshipList());
    }

    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasInternshipItem(InternshipItem person) {
        requireNonNull(person);
        return internshipItems.contains(person);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addInternshipItem(InternshipItem p) {
        internshipItems.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedInternshipItem}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedInternshipItem} must not be the same as another existing person in the
     * address book.
     */
    public void setInternshipItem(InternshipItem target, InternshipItem editedInternshipItem) {
        requireNonNull(editedInternshipItem);

        internshipItems.setInternshipItem(target, editedInternshipItem);
    }

    /**
     * Removes {@code key} from this {@code UserInternship}.
     * {@code key} must exist in the address book.
     */
    public void removeInternshipItem(InternshipItem key) {
        internshipItems.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return internshipItems.asUnmodifiableObservableList().size() + " internshipItems";
        // TODO: refine later
    }

    @Override
    public ObservableList<InternshipItem> getUserInternshipList() {
        return internshipItems.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UserInternship // instanceof handles nulls
                && internshipItems.equals(((UserInternship) other).internshipItems));
    }

    @Override
    public int hashCode() {
        return internshipItems.hashCode();
    }
}
