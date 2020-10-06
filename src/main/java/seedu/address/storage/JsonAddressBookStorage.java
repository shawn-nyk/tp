package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.item.Item;
import seedu.address.model.item.ReadOnlyItemList;

/**
 * A class to access AddressBook data stored as a json file on the hard disk.
 */
public class JsonAddressBookStorage<T extends Item> implements ListStorage<T> {

    private static final Logger logger = LogsCenter.getLogger(JsonAddressBookStorage.class);

    private final Path filePath;

    private final Class<T> contentClass;

    public JsonAddressBookStorage(Path filePath, Class<T> contentClass) {
        this.filePath = filePath;
        this.contentClass = contentClass;
    }

    @Override
    public Path getItemListFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyItemList<T>> readItemList() throws DataConversionException {
        return readItemList(filePath);
    }

    /**
     * Similar to {@link #readItemList()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyItemList<T>> readItemList(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableItemList<T>> jsonAddressBook = JsonUtil.readJsonFileSerializableItemList(
                filePath, contentClass);
        if (jsonAddressBook.isEmpty()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonAddressBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveItemList(ReadOnlyItemList<T> itemList) throws IOException {
        saveItemList(itemList, filePath);
    }

    /**
     * Similar to {@link #saveItemList(ReadOnlyItemList)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveItemList(ReadOnlyItemList<T> itemList, Path filePath) throws IOException {
        requireNonNull(itemList);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableItemList<>(itemList), filePath);
    }

}
