package seedu.address.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserDisplay extends VBox {

    //FXML
    private static final String FXML = "/view/User.fxml";

    //FXML properties
    private static final int USER_HEIGHT_SHRINK = 155;

    @FXML
    private VBox user;

    /**
     * Constructs a {@code UserDisplay} in the given {@code primaryStage}.
     */
    private UserDisplay(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource(FXML));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
            setUserProperties(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the {@code userDisplay} information in the {@code primaryStage}.
     */
    public static UserDisplay getUserDisplay(Stage primaryStage) {
        return new UserDisplay(primaryStage);
    }

    /**
     * Set the {@code userDisplay} styling in the {@code primaryStage}.
     */
    private void setUserProperties(Stage primaryStage) {
        user.prefHeightProperty().bind(primaryStage.heightProperty().subtract(USER_HEIGHT_SHRINK));
    }
}
