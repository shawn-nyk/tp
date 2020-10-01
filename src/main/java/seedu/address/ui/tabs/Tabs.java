package seedu.address.ui.tabs;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import seedu.address.ui.MainWindow;

/**
 * Tabs which allow switching of screens for different information.
 */
public class Tabs extends VBox {

    //FXML
    private static final String FXML = "/view/Tabs.fxml";

    //FXML properties
    private static final String TRANSPARENT = "-fx-background-color: transparent;";
    private static final String TAB_COLOR = "-fx-background-color: #BED0F7;";
    private static final String INTERNSHIP_Y_TRANSLATE = "-fx-translate-y: 0";
    private static final String COMPANY_Y_TRANSLATE = "-fx-translate-y: -13.5";
    private static final String USER_Y_TRANSLATE = "-fx-translate-y: -27";

    // Image links
    private static final String INTERNSHIP_IMAGE_LINK = "/images/internship.png";
    private static final String COMPANY_IMAGE_LINK = "/images/company.png";
    private static final String USER_IMAGE_LINK = "/images/user.png";

    @FXML
    private Button internshipButton;
    @FXML
    private Button companyButton;
    @FXML
    private Button userButton;
    @FXML
    private VBox internship;
    @FXML
    private VBox company;
    @FXML
    private VBox user;
    @FXML
    private ImageView internshipIcon;
    @FXML
    private ImageView companyIcon;
    @FXML
    private ImageView userIcon;

    private Stage stage;
    private MainWindow mainWindow;
    private TabName tabName;

    /**
     * Constructs the {@code Tabs} in the given {@code primaryStage} of the {@code mainWindow}.
     */
    private Tabs(MainWindow mainWindow, Stage primaryStage) {
        try {
            stage = primaryStage;
            this.mainWindow = mainWindow;
            tabName = TabName.INTERNSHIP; // preload the screen name

            // Loading the information of the GUI
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource(FXML));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
            internship.setStyle(TAB_COLOR);

            // initialize the GUI of the tabs.
            setTabIcons();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the {@code Tabs} information in the {@code primaryStage} of the {@code mainWindow}.
     */
    public static Tabs getTabs(MainWindow mainWindow, Stage primaryStage) {
        return new Tabs(mainWindow, primaryStage);
    }

    /**
     * Handles the click {@code event} on the tabs.
     */
    @FXML
    public void handleClick(ActionEvent event) {
        if (event.getSource() == internshipButton) {
            selectInternship(stage);
            tabName = TabName.INTERNSHIP;
        } else if (event.getSource() == companyButton) {
            selectCompany(stage);
            tabName = TabName.COMPANY;
        } else if (event.getSource() == userButton) {
            selectUser(stage);
            tabName = TabName.USER;
        } else {
            assert false : "Invalid button";
        }
    }

    /**
     * todo Javadocs
     */
    public TabName getCurrentTabName() {
        return tabName;
    }

    /**
     * todo Javadocs
     */
    public void setTabName(TabName tabName) {
        this.tabName = tabName;
    }

    /**
     * Set up the tab icons in GUI of {@code MainWindow}.
     */
    private void setTabIcons() {
        Image internshipPicture = new Image(getClass().getResourceAsStream(INTERNSHIP_IMAGE_LINK));
        internshipIcon.setImage(internshipPicture);

        Image companyPicture = new Image(getClass().getResourceAsStream(COMPANY_IMAGE_LINK));
        companyIcon.setImage(companyPicture);

        Image userPicture = new Image(getClass().getResourceAsStream(USER_IMAGE_LINK));
        userIcon.setImage(userPicture);
    }

    /**
     * Set the display and tab to be of {@code internship} in the {@code stage}
     * Currently it only switches the information display.
     */
    public void selectInternship(Stage stage) {
        // adjust tab bar position
        setColor(internship, INTERNSHIP_Y_TRANSLATE);
        setTransparent(company, COMPANY_Y_TRANSLATE);
        setTransparent(user, USER_Y_TRANSLATE);

        // adjust the display of the gui
        mainWindow.changeDisplay(TabName.INTERNSHIP, stage);
    }

    /**
     * Set the display and tab to be of {@code company} in the {@code stage}
     * Currently it only switches the information display.
     */
    public void selectCompany(Stage stage) {
        // adjust tab bar position
        setTransparent(internship, INTERNSHIP_Y_TRANSLATE);
        setColor(company, COMPANY_Y_TRANSLATE);
        setTransparent(user, USER_Y_TRANSLATE);

        // adjust the display of the gui
        mainWindow.changeDisplay(TabName.COMPANY, stage);
    }

    /**
     * Set the display and tab to be of {@code user} in the {@code stage}
     * Currently it only switches the information display.
     */
    public void selectUser(Stage stage) {
        // adjust tab bar position
        setTransparent(internship, INTERNSHIP_Y_TRANSLATE);
        setTransparent(company, COMPANY_Y_TRANSLATE);
        setColor(user, USER_Y_TRANSLATE);

        // adjust the display of the gui
        mainWindow.changeDisplay(TabName.USER, stage);
    }

    /**
     * Set the color of the {@code scene} to be transparent.
     */
    private <T extends Pane> void setTransparent(T scene, String distance) {
        scene.setStyle(TRANSPARENT + distance);
    }

    /**
     * Set the color of the {@code scene} to be {@code TAB_COLOR}.
     */
    private <T extends Pane> void setColor(T scene, String distance) {
        scene.setStyle(TAB_COLOR + distance);
    }
}
