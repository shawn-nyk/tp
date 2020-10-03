package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.model.item.ReadOnlyItemList;
import seedu.address.model.person.Person;

/**
 * Manages storage of ItemList data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private ListStorage<Person> addressBookStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code ItemListStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(ListStorage<Person> addressBookStorage, UserPrefsStorage userPrefsStorage) {
        super();
        this.addressBookStorage = addressBookStorage;
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
    public Path getItemListFilePath() {
        return addressBookStorage.getItemListFilePath();
    }

    @Override
    public Optional<ReadOnlyItemList<Person>> readItemList() throws DataConversionException, IOException {
        return readItemList(addressBookStorage.getItemListFilePath());
    }

    @Override
    public Optional<ReadOnlyItemList<Person>> readItemList(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return addressBookStorage.readItemList(filePath);
    }

    @Override
    public void saveItemList(ReadOnlyItemList<Person> addressBook) throws IOException {
        saveItemList(addressBook, addressBookStorage.getItemListFilePath());
    }

    @Override
    public void saveItemList(ReadOnlyItemList<Person> addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        addressBookStorage.saveItemList(addressBook, filePath);
    }

}
