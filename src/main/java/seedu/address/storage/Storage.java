package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.model.company.CompanyItem;
import seedu.address.model.item.ReadOnlyItemList;
import seedu.address.model.person.Person;

/**
 * API of the Storage component
 */
public interface Storage extends UserPrefsStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    Path getAddressBookFilePath();

    Optional<ReadOnlyItemList<Person>> readAddressBook() throws DataConversionException, IOException;

    void saveAddressBook(ReadOnlyItemList<Person> addressBook) throws IOException;

    Path getCompanyItemListFilePath();

    Optional<ReadOnlyItemList<CompanyItem>> readCompanyItemList() throws DataConversionException, IOException;

    void saveCompanyItemList(ReadOnlyItemList<CompanyItem> companyList) throws IOException;
}
