package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.logging.Logger;

import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.application.ApplicationItem;
import seedu.address.model.company.CompanyItem;
import seedu.address.model.internship.InternshipItem;
import seedu.address.model.item.ItemList;
import seedu.address.model.item.ReadOnlyItemList;
import seedu.address.model.person.Person;
import seedu.address.model.profile.ProfileItem;
import seedu.address.ui.tabs.TabName;

/**
 * Represents the in-memory model of the InternHunter app data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final FilterableItemList<Person> addressBook;
    private final FilterableItemList<CompanyItem> companyList;
    private final FilterableItemList<InternshipItem> internshipList;
    private final FilterableItemList<ApplicationItem> internshipApplicationList;
    private final FilterableItemList<ProfileItem> profileList;
    private final UserPrefs userPrefs;
    private final Tab tabControl;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(
            ReadOnlyItemList<Person> addressBook,
            ReadOnlyItemList<CompanyItem> companyList,
            ReadOnlyItemList<InternshipItem> internshipList,
            ReadOnlyItemList<ApplicationItem> internshipApplicationList,
            ReadOnlyItemList<ProfileItem> profileList,
            ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(addressBook, companyList, internshipList, internshipApplicationList, profileList, userPrefs);

        logger.fine("Initializing with address book: " + addressBook
                + " and company list " + companyList
                + " and internship list " + internshipList
                + " and internship application list " + internshipApplicationList
                + " and profile list " + profileList
                + " and user prefs " + userPrefs);

        this.addressBook = new ItemListManager<>(new ItemList<>(addressBook));
        this.companyList = new ItemListManager<>(new ItemList<>(companyList));
        this.internshipList = new ItemListManager<>(new ItemList<>(internshipList));
        this.internshipApplicationList = new ItemListManager<>(new ItemList<>(internshipApplicationList));
        this.profileList = new ItemListManager<>(new ItemList<>(profileList));
        this.userPrefs = new UserPrefs(userPrefs);
        this.tabControl = new TabManager();
    }

    public ModelManager() {
        this(new ItemList<>(), new ItemList<>(), new ItemList<>(), new ItemList<>(), new ItemList<>(), new UserPrefs());
    }

    //=========== Models Getters =============================================================================

    @Override
    public FilterableItemList<Person> getAddressBook() {
        return addressBook;
    }

    @Override
    public FilterableItemList<CompanyItem> getCompanyList() {
        return companyList;
    }

    @Override
    public FilterableItemList<InternshipItem> getInternshipList() {
        return internshipList;
    }

    @Override
    public FilterableItemList<ApplicationItem> getInternshipApplicationList() {
        return internshipApplicationList;
    }

    @Override
    public FilterableItemList<ProfileItem> getProfileList() {
        return profileList;
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getInternHunterFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setInternHunterFilePath(Path internHunterFilePath) {
        requireNonNull(internHunterFilePath);
        userPrefs.setAddressBookFilePath(internHunterFilePath);
    }


    //=========== Tab Control Accessors =============================================================

    /**
     * Retrieves the current tab name.
     */
    public TabName getTabName() {
        return tabControl.getTabName();
    }

    /**
     * Sets the current tab name with {@code tabName}.
     */
    public void setTabName(TabName tabName) {
        tabControl.setTabName(tabName);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return addressBook.equals(other.addressBook)
                && companyList.equals(other.companyList)
                && internshipList.equals(other.internshipList)
                && internshipApplicationList.equals(other.internshipApplicationList)
                && profileList.equals(other.profileList)
                && userPrefs.equals(other.userPrefs);
    }
}
