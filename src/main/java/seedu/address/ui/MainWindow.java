package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.ui.display.ApplicationDisplay;
import seedu.address.ui.display.CompanyDisplay;
import seedu.address.ui.display.InformationDisplay;
import seedu.address.ui.display.ProfileDisplay;
import seedu.address.ui.panel.CompanyListPanel;
import seedu.address.ui.panel.ApplicationListPanel;
import seedu.address.ui.panel.ListPanel;
import seedu.address.ui.panel.ProfileListPanel;
import seedu.address.ui.tabs.TabName;
import seedu.address.ui.tabs.Tabs;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class MainWindow extends UiPart<Stage> {

    //FXML
    private static final String FXML = "MainWindow.fxml";

    //FXML properties
    private static final int PERSON_LIST_HEIGHT_SHRINK = 255;
    private static final int RESULT_HEIGHT_SHRINK = 350;

    private final Logger logger = LogsCenter.getLogger(getClass());

    private Stage primaryStage;
    private Logic logic;

    // Independent Ui parts residing in this Ui container
    private ListPanel listPanel;
    private InformationDisplay informationDisplay;
    private ResultDisplay resultDisplay;
    private HelpWindow helpWindow;
    private Tabs tabs;

    @FXML
    private VBox cardList;
    @FXML
    private StackPane ListPanelPlaceholder;
    @FXML
    private VBox display;
    @FXML
    private ScrollPane resultDisplayPlaceholder;
    @FXML
    private VBox commandBoxPlaceholder;
    @FXML
    private VBox tabsContainer;

    /**
     * Creates a {@code MainWindow} with the given {@code Stage} and {@code Logic}.
     */
    public MainWindow(Stage primaryStage, Logic logic) {
        super(FXML, primaryStage);

        // Set dependencies
        this.primaryStage = primaryStage;
        this.logic = logic;
        // Configure the UI
        initializeUi(primaryStage, logic);
    }

    /**
     * todo Javadocs
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Sets up the GUI properties in the {@code primaryStage} using the stored user settings in {@code logic}.
     */
    private void initializeUi(Stage primaryStage, Logic logic) {
        setWindowDefaultSize(logic.getGuiSettings());
        bindHeights(primaryStage);
        helpWindow = new HelpWindow();

        primaryStage.setOnCloseRequest(event -> {
            GuiSettings guiSettings = new GuiSettings(primaryStage.getWidth(), primaryStage.getHeight(),
                    (int) primaryStage.getX(), (int) primaryStage.getY());
            logic.setGuiSettings(guiSettings);

            ExitDialog exitDialog = new ExitDialog(event, helpWindow);
            exitDialog.show();
        });
    }

    /**
     * Binds the height of {@code personList} and {@code resultDisplayPlaceHolder} in the {@code primaryStage}
     */
    private void bindHeights(Stage primaryStage) {
        cardList.prefWidthProperty().bind(primaryStage.widthProperty().subtract(PERSON_LIST_HEIGHT_SHRINK));
        resultDisplayPlaceholder.prefWidthProperty().bind(primaryStage.widthProperty().subtract(RESULT_HEIGHT_SHRINK));
    }

    /**
     * Sets the default size based on {@code guiSettings}.
     */
    private void setWindowDefaultSize(GuiSettings guiSettings) {
        primaryStage.setHeight(guiSettings.getWindowHeight());
        primaryStage.setWidth(guiSettings.getWindowWidth());
        if (guiSettings.getWindowCoordinates() != null) {
            primaryStage.setX(guiSettings.getWindowCoordinates().getX());
            primaryStage.setY(guiSettings.getWindowCoordinates().getY());
        }
    }

    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts() {
        listPanel = new CompanyListPanel(logic.getFilteredPersonList());
        ListPanelPlaceholder.getChildren().add(listPanel.getRoot());

        resultDisplay = new ResultDisplay();
        resultDisplayPlaceholder.setContent(resultDisplay.getRoot());

        display.getChildren().clear();
        informationDisplay = CompanyDisplay.getCompanyDisplay(primaryStage);
        display.getChildren().add(informationDisplay.getRoot());

        CommandBox commandBox = new CommandBox(this::executeCommand);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());

        tabs = Tabs.getTabs(this, primaryStage, logic);
        tabsContainer.getChildren().add(tabs);
    }

    /**
     * Opens the help window or focuses on it if it's already opened.
     */
    @FXML
    public void handleHelp() {
        if (!helpWindow.isShowing()) {
            helpWindow.show();
        } else {
            helpWindow.focus();
        }
    }

    /**
     * Displays the GUI.
     */
    void show() {
        primaryStage.show();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public ListPanel getListPanel() {
        return listPanel;
    }

    /**
     * Switch the tabs of the application.
     */
    private void switchTab() {
        tabs.switchTab();
    }

    /**
     * Executes the command and returns the result.
     *
     * @see seedu.address.logic.Logic#execute(String)
     */
    private CommandResult executeCommand(String commandText) throws CommandException, ParseException {
        try {
            CommandResult commandResult = logic.execute(commandText);
            logger.info("Result: " + commandResult.getFeedbackToUser());
            resultDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());

            if (commandResult.isSwitchTab()) {
                switchTab();
            }

            if (commandResult.isShowHelp()) {
                handleHelp();
            }

            if (commandResult.isExit()) {
                handleExit();
            }

            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            resultDisplay.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }

    /**
     * Changes the display of screen, depending on {@code input}, in the {@code primaryStage}.
     */
    public void changeDisplay(TabName input, Stage primaryStage) {
        assert (input.equals(TabName.APPLICATION) || input.equals(TabName.COMPANY) || input.equals(TabName.PROFILE));
        display.getChildren().clear();
        ListPanelPlaceholder.getChildren().clear();
        switch (input) {
        case COMPANY:
            informationDisplay = CompanyDisplay.getCompanyDisplay(primaryStage);
            listPanel = new CompanyListPanel(logic.getFilteredPersonList());
            break;
        case APPLICATION:
            informationDisplay = ApplicationDisplay.getApplicationDisplay(primaryStage);
            listPanel = new ApplicationListPanel(logic.getFilteredPersonList());
            break;
        case PROFILE:
            informationDisplay = ProfileDisplay.getProfileDisplay(primaryStage);
            listPanel = new ProfileListPanel(logic.getFilteredPersonList());
            break;
        default:
            assert false;
            break;
        }
        display.getChildren().add(informationDisplay.getRoot());
        ListPanelPlaceholder.getChildren().add(listPanel.getRoot());
    }
}
