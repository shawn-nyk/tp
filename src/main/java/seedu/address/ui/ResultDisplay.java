package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class ResultDisplay extends UiPart<Region> {

    // FXML
    private static final String FXML = "ResultDisplay.fxml";

    // FXML properties
    private static final String TEXT_COLOR = "#5A4DEB"; // TODO change to red
    private static final String TEXT_FONT = "Nunito";

    @FXML
    private TextFlow resultDisplay;

    /**
     * Construct a display containing the results of the command.
     */
    public ResultDisplay() {
        super(FXML);
    }

    /**
     * Displays the {@code feedbackToUser} in {@code resultDisplay}.
     */
    public void setFeedbackToUser(String feedbackToUser) {
        requireNonNull(feedbackToUser);
        Text text = new Text(feedbackToUser);
        clearHistory();
        setNewText(text);
    }

    /**
     * Sets the color and font of the {@code text}.
     */
    private void setTextStyle(Text text) {
        text.setFill(Color.web(TEXT_COLOR));
        text.setFont(Font.font(TEXT_FONT));
    }

    /**
     * Clears any old text in {@code resultDisplay}.
     */
    private void clearHistory() {
        resultDisplay.getChildren().clear();
    }

    /**
     * Displays the {@code text} in {@code resultDisplay}.
     */
    private void setNewText(Text text) {
        setTextStyle(text);
        resultDisplay.getChildren().add(text);
    }
}
