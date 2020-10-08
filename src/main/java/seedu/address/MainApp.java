package seedu.address;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import seedu.address.commons.core.Config;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.Version;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.util.ConfigUtil;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.Logic;
import seedu.address.logic.LogicManager;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.model.application.ApplicationItem;
import seedu.address.model.company.CompanyItem;
import seedu.address.model.internship.InternshipItem;
import seedu.address.model.internship.exceptions.InconsistentInternshipException;
import seedu.address.model.item.Item;
import seedu.address.model.item.ItemList;
import seedu.address.model.item.ReadOnlyItemList;
import seedu.address.model.person.Person;
import seedu.address.model.profile.ProfileItem;
import seedu.address.storage.JsonItemListStorage;
import seedu.address.storage.JsonUserPrefsStorage;
import seedu.address.storage.ListStorage;
import seedu.address.storage.Storage;
import seedu.address.storage.StorageManager;
import seedu.address.storage.UserPrefsStorage;
import seedu.address.storage.application.JsonAdaptedApplicationItem;
import seedu.address.storage.company.JsonAdaptedCompanyItem;
import seedu.address.storage.item.JsonAdaptedItem;
import seedu.address.storage.person.JsonAdaptedPerson;
import seedu.address.storage.profile.JsonAdaptedProfileItem;
import seedu.address.ui.Ui;
import seedu.address.ui.UiManager;

/**
 * Runs the application.
 */
public class MainApp extends Application {

    public static final Version VERSION = new Version(0, 6, 0, true);

    private static final Logger logger = LogsCenter.getLogger(MainApp.class);

    protected Ui ui;
    protected Logic logic;
    protected Storage storage;
    protected Model model;
    protected Config config;

    @Override
    public void init() throws Exception {
        logger.info("=============================[ Initializing InternHunter ]===========================");
        super.init();

        AppParameters appParameters = AppParameters.parse(getParameters());
        config = initConfig(appParameters.getConfigPath());

        UserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(config.getUserPrefsFilePath());
        UserPrefs userPrefs = initPrefs(userPrefsStorage);
        ListStorage<Person, JsonAdaptedPerson> addressBookStorage = new JsonItemListStorage<>(
                userPrefs.getAddressBookFilePath(), Person.class, JsonAdaptedPerson.class);
        ListStorage<ApplicationItem, JsonAdaptedApplicationItem> applicationItemListStorage = new JsonItemListStorage<>(
                userPrefs.getApplicationItemListFilePath(), ApplicationItem.class, JsonAdaptedApplicationItem.class);
        ListStorage<CompanyItem, JsonAdaptedCompanyItem> companyItemListStorage = new JsonItemListStorage<>(
                userPrefs.getCompanyItemListFilePath(), CompanyItem.class, JsonAdaptedCompanyItem.class);
        ListStorage<ProfileItem, JsonAdaptedProfileItem> profileItemListStorage = new JsonItemListStorage<>(
                userPrefs.getProfileItemListFilePath(), ProfileItem.class, JsonAdaptedProfileItem.class);

        storage = new StorageManager(addressBookStorage, applicationItemListStorage,
                companyItemListStorage, profileItemListStorage, userPrefsStorage);

        initLogging(config);

        model = initModelManager(storage, userPrefs);

        logic = new LogicManager(model, storage);

        ui = new UiManager(logic);
    }

    /**
     * Gets the initial item list.
     *
     * @param itemListStorage storage of the item list.
     * @param <T>             type of the item.
     * @param <U>             type of the json adapted item.
     * @return initial item list.
     */
    private <T extends Item, U extends JsonAdaptedItem> ReadOnlyItemList<T> initItemList(
            ListStorage<T, U> itemListStorage) {
        Optional<ReadOnlyItemList<T>> itemListOptional;
        ReadOnlyItemList<T> initialItemListData;
        try {
            itemListOptional = itemListStorage.readItemList();
            if (itemListOptional.isEmpty()) {
                //to do more specific logging
                logger.info("Data file not found. Will be starting with a sample item list");
            }
            //to do sample data
            initialItemListData = itemListOptional.orElse(new ItemList<>());
        } catch (DataConversionException e) {
            logger.warning("Data file not in the correct format. Will be starting with an empty item list");
            initialItemListData = new ItemList<>();
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty item list");
            initialItemListData = new ItemList<>();
        }

        return initialItemListData;
    }

    /**
     * Matches internships in the application list with the ones in the company list.
     *
     * @param applicationItemList list of application items.
     * @param companyItemList     list of company items.
     * @throws InconsistentInternshipException an application has an internship
     *                                         that does not exist in any company's list of internships.
     */
    private void matchInternships(ReadOnlyItemList<ApplicationItem> applicationItemList,
            ReadOnlyItemList<CompanyItem> companyItemList) throws InconsistentInternshipException {
        for (ApplicationItem applicationItem : applicationItemList.getItemList()) {
            InternshipItem applicationInternshipItem = applicationItem.getInternshipItem();
            boolean isFound = false;
            for (CompanyItem companyItem : companyItemList.getItemList()) {
                for (InternshipItem companyInternshipItem : companyItem.getInternships()) {
                    if (applicationInternshipItem.equals(companyInternshipItem)) {
                        applicationInternshipItem = companyInternshipItem;
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    break;
                }
            }

            if (!isFound) {
                throw new InconsistentInternshipException();
            }

            //Changes the current application item with the one with the correct internship object.
            applicationItemList.getItemList().remove(applicationItem);
            applicationItemList.getItemList().add(new ApplicationItem(applicationInternshipItem,
                    applicationItem.getStatus(), applicationItem.getStatusDate()));
        }
    }

    /**
     * Returns a {@code ModelManager} with the data from {@code storage}'s address book and {@code userPrefs}. <br>
     * The data from the sample address book will be used instead if {@code storage}'s address book is not found,
     * or an empty address book will be used instead if errors occur when reading {@code storage}'s address book.
     */
    private Model initModelManager(Storage storage, ReadOnlyUserPrefs userPrefs) {

        ReadOnlyItemList<Person> addressBook = initItemList(storage.getAddressBookStorage());
        ReadOnlyItemList<CompanyItem> companyItemList = initItemList(storage.getCompanyItemListStorage());
        ReadOnlyItemList<ApplicationItem> applicationItemList =
                initItemList(storage.getApplicationItemListStorage());
        ReadOnlyItemList<ProfileItem> profileItemList = initItemList(storage.getProfileItemListStorage());

        try {
            matchInternships(applicationItemList, companyItemList);
        } catch (InconsistentInternshipException e) {
            logger.warning("Applications' internships are not matched with the ones in the companies' lists.");
        }

        return new ModelManager(addressBook, companyItemList, applicationItemList, profileItemList, userPrefs);
    }

    private void initLogging(Config config) {
        LogsCenter.init(config);
    }

    /**
     * Returns a {@code Config} using the file at {@code configFilePath}. <br>
     * The default file path {@code Config#DEFAULT_CONFIG_FILE} will be used instead
     * if {@code configFilePath} is null.
     */
    protected Config initConfig(Path configFilePath) {
        Config initializedConfig;
        Path configFilePathUsed;

        configFilePathUsed = Config.DEFAULT_CONFIG_FILE;

        if (configFilePath != null) {
            logger.info("Custom Config file specified " + configFilePath);
            configFilePathUsed = configFilePath;
        }

        logger.info("Using config file : " + configFilePathUsed);

        try {
            Optional<Config> configOptional = ConfigUtil.readConfig(configFilePathUsed);
            initializedConfig = configOptional.orElse(new Config());
        } catch (DataConversionException e) {
            logger.warning("Config file at " + configFilePathUsed + " is not in the correct format. "
                    + "Using default config properties");
            initializedConfig = new Config();
        }

        //Update config file in case it was missing to begin with or there are new/unused fields
        try {
            ConfigUtil.saveConfig(initializedConfig, configFilePathUsed);
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
        }
        return initializedConfig;
    }

    /**
     * Returns a {@code UserPrefs} using the file at {@code storage}'s user prefs file path,
     * or a new {@code UserPrefs} with default configuration if errors occur when
     * reading from the file.
     */
    protected UserPrefs initPrefs(UserPrefsStorage storage) {
        Path prefsFilePath = storage.getUserPrefsFilePath();
        logger.info("Using prefs file : " + prefsFilePath);

        UserPrefs initializedPrefs;
        try {
            Optional<UserPrefs> prefsOptional = storage.readUserPrefs();
            initializedPrefs = prefsOptional.orElse(new UserPrefs());
        } catch (DataConversionException e) {
            logger.warning("UserPrefs file at " + prefsFilePath + " is not in the correct format. "
                    + "Using default user prefs");
            initializedPrefs = new UserPrefs();
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty AddressBook");
            initializedPrefs = new UserPrefs();
        }

        //Update prefs file in case it was missing to begin with or there are new/unused fields
        try {
            storage.saveUserPrefs(initializedPrefs);
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
        }

        return initializedPrefs;
    }

    @Override
    public void start(Stage primaryStage) {
        logger.info("Starting InternHunter " + MainApp.VERSION);
        ui.start(primaryStage);
    }

    @Override
    public void stop() {
        logger.info("============================ [ Stopping InternHunter ] =============================");
        try {
            storage.saveUserPrefs(model.getUserPrefs());
        } catch (IOException e) {
            logger.severe("Failed to save preferences " + StringUtil.getDetails(e));
        }
    }
}
