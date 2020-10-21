package seedu.address.ui;

import static seedu.address.ui.util.UiUtil.addCloseWindowOnEsc;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for the InternshipsWindow page.
 */
public class InternshipsWindow extends UiPart<Stage> {

    private static final Logger logger = LogsCenter.getLogger(InternshipsWindow.class);
    private static final String FXML = "InternshipsWindow.fxml";

    @FXML
    private TextArea matchingInternships;

    /**
     * Creates a new InternshipsWindow.
     *
     * @param root Stage to use as the root of the InternshipsWindow.
     */
    public InternshipsWindow(Stage root) {
        super(FXML, root);
        addCloseWindowOnEsc(root);
    }

    /**
     * Creates a new InternshipsWindow.
     */
    public InternshipsWindow() {
        this(new Stage());
    }

    /**
     * Shows the matching internships window.
     *
     * @throws IllegalStateException <ul>
     * <li>
     * if this method is called on a thread other than the JavaFX Application Thread.
     * </li>
     * <li>
     * if this method is called during animation or layout processing.
     * </li>
     * <li>
     * if this method is called on the primary stage.
     * </li>
     * <li>
     * if {@code dialogStage} is already showing.
     * </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing list of matching internships.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    public void setTextDisplay(String internshipList) {
        matchingInternships.setText(internshipList);
    }

    /**
     * Returns true if the Internships window is currently being shown.
     *
     * @return A boolean value representing whether a Internships window is being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the Internships window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the Internships window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

}
