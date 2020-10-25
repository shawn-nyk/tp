package seedu.address.ui.popupwindow;

import static seedu.address.commons.util.CollectionUtil.getNumberedList;

import java.util.List;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.internship.InternshipItem;

/**
 * Controller for the InternshipsWindow page.
 */
public class InternshipsWindow extends PopupWindow {

    private static final Logger logger = LogsCenter.getLogger(InternshipsWindow.class);
    private static final String FXML = "InternshipsWindow.fxml";

    @FXML
    private TextArea matchingInternships;

    /**
     * Creates a new InternshipsWindow.
     */
    public InternshipsWindow() {
        super(FXML, new Stage());
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
        super.show();
    }

    /**
     * Sets the internship list for display.
     *
     * @param internshipList List of internships.
     */
    public void setInternshipList(List<InternshipItem> internshipList) {
        String displayText = getNumberedList(internshipList);
        matchingInternships.setText(displayText);
    }

}
