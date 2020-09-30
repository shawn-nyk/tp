package seedu.address.ui.display;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import seedu.address.ui.MainWindow;

/**
 * A display that contains information.
 */
public class InformationDisplay extends VBox {

    //FXML
    private static final String FXML = "/view/InformationDisplay.fxml";

    //FXML properties
    private static final int INFORMATION_HEIGHT_SHRINK = 155;

    @FXML
    private VBox informationDisplay;
    @FXML
    private HBox nameBar;
    @FXML
    private Label informationTitle;
    @FXML
    private VBox information;

    /**
     * Constructs a {@code InformationDisplay} in the given {@code primaryStage}.
     */
    InformationDisplay(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource(FXML));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initializeInformationDisplay(primaryStage);
    }

    /**
     * Set the size of {@code InformationDisplay} in the given {@code primaryStage}.
     */
    private void initializeInformationDisplay(Stage primaryStage) {
        informationDisplay.prefHeightProperty().bind(primaryStage.heightProperty().subtract(INFORMATION_HEIGHT_SHRINK));
        nameBar.maxWidthProperty().bind(informationDisplay.widthProperty().subtract(100));
    }

    /**
     * Adds {@code titleDescriptionDisplay} into {@code InformationDisplay}.
     */
    void addInformation(TitleDescriptionDisplay titleDescriptionDisplay) {
        information.getChildren().addAll(titleDescriptionDisplay);
    }

    /**
     * Sets the title of the {@code InformationDisplay}.
     */
    void setInformationTitle(String title) {
        informationTitle.setText(title);
    }
}
