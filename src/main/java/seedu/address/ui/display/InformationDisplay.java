package seedu.address.ui.display;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import seedu.address.ui.UiPart;

/**
 * A display that contains information.
 */
public abstract class InformationDisplay extends UiPart<Region> {

    //FXML
    private static final String FXML = "InformationDisplay.fxml";

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
    public InformationDisplay(Stage primaryStage) {
        super(FXML);
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
