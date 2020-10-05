package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.model.item.ReadOnlyItemList;
import seedu.address.model.person.Person;

/**
 * API of the Storage component
 */
public interface Storage extends ListStorage<Person>, UserPrefsStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getItemListFilePath();

    @Override
    Optional<ReadOnlyItemList<Person>> readItemList() throws DataConversionException, IOException;

    @Override
    void saveItemList(ReadOnlyItemList<Person> addressBook) throws IOException;

}
