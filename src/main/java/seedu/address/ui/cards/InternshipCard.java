package seedu.address.ui.cards;

import javafx.scene.image.Image;
import seedu.address.model.person.Person;

/**
 * todo Javadocs
 */
public class InternshipCard extends Card {

    //Image Link
    private static final String CALENDAR_IMAGE_LINK = "/images/calendar.png";

    /**
     * todo Javadocs
     */
    public InternshipCard(Person person, int displayedIndex) {
        super(person, displayedIndex);
        initializeInternshipCardGui();
    }

    /**
     * todo Javadocs
     */
    private void initializeInternshipCardGui() {
        // to be edited in the future!
        initializeHeader(displayedIndex);
        initializeBody();
        initializeTags();
        initializeDate();
        initializeStatus();
    }

    /**
     * todo Javadocs
     */
    private void initializeStatus() {
        setRandomStatus(); // to be change in when other classes are ready.
    }

    /**
     * todo Javadocs
     */
    private void initializeDate() {
        Image calendarIcon = new Image(this.getClass().getResourceAsStream(CALENDAR_IMAGE_LINK));
        calendar.setImage(calendarIcon);
        date.setText("21/07/2020"); // to be changed later!
    }

    // TEMPORARY FUNCTION TO ALLOW DISPLAYS
    private void setRandomStatus() {
        int num = (int) (Math.random() * (4));
        switch (num) {
        case (0):
            status.setText("Accepted");
            statusBox.setStyle("-fx-background-color: #3ADB9D");
            break;
        case (1):
            status.setText("Rejected");
            statusBox.setStyle("-fx-background-color: #F02E62");
            break;
        case (2):
            status.setText("Waiting");
            statusBox.setStyle("-fx-background-color: #F4D014");
            break;
        case (3):
            status.setText("Ongoing");
            statusBox.setStyle("-fx-background-color: #3A65DB");
            break;
        default:
            break;
        }
    }
}
