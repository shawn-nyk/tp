package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.model.company.CompanyItem;
import seedu.address.model.item.ReadOnlyItemList;
import seedu.address.model.person.Person;
import seedu.address.storage.company.JsonAdaptedCompanyItem;
import seedu.address.storage.person.JsonAdaptedPerson;

/**
 * Manages storage of ItemList data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private final ListStorage<Person, JsonAdaptedPerson> addressBookStorage;
    private final ListStorage<CompanyItem, JsonAdaptedCompanyItem> companyItemListStorage;
    private final UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code ItemListStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(ListStorage<Person, JsonAdaptedPerson> addressBookStorage,
            ListStorage<CompanyItem, JsonAdaptedCompanyItem> companyItemListStorage,
            UserPrefsStorage userPrefsStorage) {
        super();
        this.addressBookStorage = addressBookStorage;
        this.companyItemListStorage = companyItemListStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }

    // ================ ItemList methods ==============================
    @Override
    public Path getAddressBookFilePath() {
        return addressBookStorage.getItemListFilePath();
    }

    @Override
    public Optional<ReadOnlyItemList<Person>> readAddressBook() throws DataConversionException, IOException {
        logger.fine("Attempting to read address book.");
        return addressBookStorage.readItemList();
    }

    @Override
    public void saveAddressBook(ReadOnlyItemList<Person> addressBook) throws IOException {
        logger.fine("Attempting to save address book.");
        addressBookStorage.saveItemList(addressBook);
    }

    @Override
    public Path getCompanyItemListFilePath() {
        return companyItemListStorage.getItemListFilePath();
    }

    @Override
    public Optional<ReadOnlyItemList<CompanyItem>> readCompanyItemList() throws DataConversionException, IOException {
        logger.fine("Attempting to read company item list.");
        return companyItemListStorage.readItemList();
    }

    @Override
    public void saveCompanyItemList(ReadOnlyItemList<CompanyItem> companyList) throws IOException {
        logger.fine("Attempting to save company item list.");
        companyItemListStorage.saveItemList(companyList);
    }
}
