package seedu.internhunter.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.internhunter.testutil.application.SampleApplicationItems.getSampleApplicationItemList;
import static seedu.internhunter.testutil.company.SampleCompanyItems.getSampleCompanyList;
import static seedu.internhunter.testutil.profile.SampleProfileItems.getSampleProfileItemList;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.internhunter.commons.core.GuiSettings;
import seedu.internhunter.model.UserPrefs;
import seedu.internhunter.model.application.ApplicationItem;
import seedu.internhunter.model.company.CompanyItem;
import seedu.internhunter.model.item.ItemList;
import seedu.internhunter.model.item.ReadOnlyItemList;
import seedu.internhunter.model.profile.ProfileItem;
import seedu.internhunter.storage.application.JsonAdaptedApplicationItem;
import seedu.internhunter.storage.company.JsonAdaptedCompanyItem;
import seedu.internhunter.storage.profile.JsonAdaptedProfileItem;

public class StorageManagerTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src",
            "test", "data", "StorageManagerTest");
    private static final Path APPLICATION_ITEMS_FILE = TEST_DATA_FOLDER.resolve(
            "applicationItemList.json");
    private static final Path COMPANY_ITEMS_FILE = TEST_DATA_FOLDER.resolve(
            "companyItemList.json");
    private static final Path PROFILE_ITEMS_FILE = TEST_DATA_FOLDER.resolve(
            "profileItemList.json");

    @TempDir
    public Path testFolder;

    private StorageManager storageManager;

    @BeforeEach
    public void setUp() {
        JsonItemListStorage<ApplicationItem, JsonAdaptedApplicationItem> applicationItemListStorage =
                new JsonItemListStorage<>(getTempFilePath("app"), ApplicationItem.class,
                        JsonAdaptedApplicationItem.class);
        JsonItemListStorage<CompanyItem, JsonAdaptedCompanyItem> companyItemListStorage =
                new JsonItemListStorage<>(getTempFilePath("app"), CompanyItem.class,
                        JsonAdaptedCompanyItem.class);
        JsonItemListStorage<ProfileItem, JsonAdaptedProfileItem> profileItemListStorage =
                new JsonItemListStorage<>(getTempFilePath("app"), ProfileItem.class,
                        JsonAdaptedProfileItem.class);

        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(getTempFilePath("prefs"));
        storageManager = new StorageManager(applicationItemListStorage, companyItemListStorage, profileItemListStorage,
                userPrefsStorage);
    }

    private Path getTempFilePath(String fileName) {
        return testFolder.resolve(fileName);
    }

    @Test
    public void prefsReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonUserPrefsStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonUserPrefsStorageTest} class.
         */
        UserPrefs original = new UserPrefs();
        original.setGuiSettings(new GuiSettings(300, 600, 4, 6));
        storageManager.saveUserPrefs(original);
        UserPrefs retrieved = storageManager.readUserPrefs().get();
        assertEquals(original, retrieved);
    }

    @Test
    public void applicationItemListReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonItemListStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonAddressBoolStorageTest} class.
         */
        ItemList<ApplicationItem> original = getSampleApplicationItemList();
        storageManager.saveApplicationItemList(original, storageManager.getApplicationItemListFilePath());
        ReadOnlyItemList<ApplicationItem> retrieved = storageManager.readApplicationItemList().get();
        assertEquals(original, new ItemList<>(retrieved));
    }

    @Test
    public void applicationItemListReadSaveFilePath() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonItemListStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonAddressBoolStorageTest} class.
         */
        ItemList<ApplicationItem> original = getSampleApplicationItemList();
        storageManager.saveApplicationItemList(original, APPLICATION_ITEMS_FILE);
        ReadOnlyItemList<ApplicationItem> retrieved = storageManager
                .readApplicationItemList(APPLICATION_ITEMS_FILE).get();
        assertEquals(original, new ItemList<>(retrieved));
    }

    @Test
    public void getApplicationItemListFilePath() {
        assertNotNull(storageManager.getApplicationItemListFilePath());
    }

    @Test
    public void companyItemListReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonItemListStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonAddressBoolStorageTest} class.
         */
        ItemList<CompanyItem> original = getSampleCompanyList();
        storageManager.saveCompanyItemList(original);
        ReadOnlyItemList<CompanyItem> retrieved = storageManager.readCompanyItemList().get();
        assertEquals(original, new ItemList<>(retrieved));
    }

    @Test
    public void companyItemListReadSaveFilePath() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonItemListStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonAddressBoolStorageTest} class.
         */
        ItemList<CompanyItem> original = getSampleCompanyList();
        storageManager.saveCompanyItemList(original, COMPANY_ITEMS_FILE);
        ReadOnlyItemList<CompanyItem> retrieved = storageManager.readCompanyItemList(COMPANY_ITEMS_FILE).get();
        assertEquals(original, new ItemList<>(retrieved));
    }

    @Test
    public void getCompanyItemListFilePath() {
        assertNotNull(storageManager.getCompanyItemListFilePath());
    }

    @Test
    public void profileItemListReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonItemListStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonAddressBoolStorageTest} class.
         */
        ItemList<ProfileItem> original = getSampleProfileItemList();
        storageManager.saveProfileItemList(original);
        ReadOnlyItemList<ProfileItem> retrieved = storageManager.readProfileItemList().get();
        assertEquals(original, new ItemList<>(retrieved));
    }

    @Test
    public void profileItemListReadSaveFilePath() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonItemListStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonAddressBoolStorageTest} class.
         */
        ItemList<ProfileItem> original = getSampleProfileItemList();
        storageManager.saveProfileItemList(original, PROFILE_ITEMS_FILE);
        ReadOnlyItemList<ProfileItem> retrieved = storageManager.readProfileItemList(PROFILE_ITEMS_FILE).get();
        assertEquals(original, new ItemList<>(retrieved));
    }

    @Test
    public void getProfileItemListFilePath() {
        assertNotNull(storageManager.getProfileItemListFilePath());
    }

}
