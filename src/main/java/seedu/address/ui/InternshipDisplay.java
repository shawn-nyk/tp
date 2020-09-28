package seedu.address.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InternshipDisplay extends VBox {

    //FXML
    private static final String FXML = "/view/Internship.fxml";

    //FXML properties
    private static final int INTERNSHIP_HEIGHT_SHRINK = 155;

    @FXML
    private VBox internship;

    /**
     * Constructs a {@code InternshipDisplay} in the given {@code primaryStage}.
     */
    private InternshipDisplay(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource(FXML));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
            setInternshipProperties(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the {@code internshipDisplay} information in the {@code primaryStage}.
     */
    public static InternshipDisplay getInternshipDisplay(Stage primaryStage) {
        return new InternshipDisplay(primaryStage);
    }

    /**
     * Set the {@code internshipDisplay} styling in the {@code primaryStage}.
     */
    private void setInternshipProperties(Stage primaryStage) {
        internship.prefHeightProperty().bind(primaryStage.heightProperty().subtract(INTERNSHIP_HEIGHT_SHRINK));
    }
}
