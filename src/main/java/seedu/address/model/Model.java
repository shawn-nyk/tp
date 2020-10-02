package seedu.address.model;

import java.nio.file.Path;

import seedu.address.commons.core.GuiSettings;
import seedu.address.model.application.InternshipApplicationItem;
import seedu.address.model.internship.InternshipItem;
import seedu.address.model.person.Person;
import seedu.address.model.profile.ProfileItem;

/**
 * The API of the Model component.
 */
public interface Model {

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getInternHunterFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setInternHunterFilePath(Path internHunterFilePath);

    /**
     * Get person list manager.
     */
    FilterableItemList<Person> getAddressBook();

    /**
     * Get internship list manager.
     */
    FilterableItemList<InternshipItem> getInternshipList();

    /**
     * Get internship application list manager.
     */
    FilterableItemList<InternshipApplicationItem> getInternshipApplicationList();

    /**
     * Get profile list manager.
     */
    FilterableItemList<ProfileItem> getProfileList();
}
