package seedu.address.ui.cards;

import static seedu.address.ui.textstyle.TitleDescription.createTitleDescription;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import seedu.address.model.person.Person;
import seedu.address.ui.UiPart;
import seedu.address.ui.textstyle.TitleDescription;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    //FXML
    private static final String FXML = "PersonListCard.fxml";

    //Image Link
    private static final String CALENDAR_IMAGE_LINK = "/images/calendar.png";

    //Person's Attribute
    private static final String ATTRIBUTE_PHONE = "Phone";
    private static final String ATTRIBUTE_ADDRESS = "Address";
    private static final String ATTRIBUTE_EMAIL = "Email";

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private TextFlow phone;
    @FXML
    private TextFlow address;
    @FXML
    private TextFlow email;
    @FXML
    private FlowPane tags;
    @FXML
    private VBox statusBox;
    @FXML
    private Label status;
    @FXML
    private ImageView calendar;
    @FXML
    private Label date;

    /**
     * Creates a {@code PersonCard} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        initializePersonCard(displayedIndex);
    }

    /**
     * Sets up the styling of the {@code PersonCard} with {@code displayedIndex}.
     */
    private void initializePersonCard(int displayedIndex) {
        initializeHeader(displayedIndex);
        initializeBody();
        initializeTags();
        initializeStatus();
        initializeDate();
    }

    /**
     * Sets up the header of the {@code PersonCard} with {@code displayedIndex}.
     */
    private void initializeHeader(int displayedIndex) {
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
    }

    /**
     * Sets up the content of the {@code PersonCard}.
     */
    private void initializeBody() {
        setStyling(ATTRIBUTE_PHONE, person.getPhone().value);
        setStyling(ATTRIBUTE_ADDRESS, person.getAddress().value);
        setStyling(ATTRIBUTE_EMAIL, person.getEmail().value);
    }

    /**
     * Sets up the tags of the {@code PersonCard}.
     */
    private void initializeTags() {
        person.getTags().stream()
            .sorted(Comparator.comparing(tag -> tag.tagName))
            .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    private void initializeStatus() {
        setRandomStatus(); // to be change in when other classes are ready.
    }

    private void initializeDate() {
        Image calendarIcon = new Image(this.getClass().getResourceAsStream(CALENDAR_IMAGE_LINK));
        calendar.setImage(calendarIcon);
        date.setText("21/07/2020"); // to be changed later!
    }

    /**
     * Initializes the GUI of the properties inside {@code PersonCard}.
     */
    private void setStyling(String type, String description) {
        TitleDescription titleDescription = createTitleDescription(type + ": ", description);
        Text styledTitle = titleDescription.getTitle();
        Text styledDescription = titleDescription.getDescription();
        if (type.equals(ATTRIBUTE_PHONE)) {
            phone.getChildren().addAll(styledTitle, styledDescription);
        } else if (type.equals(ATTRIBUTE_ADDRESS)) {
            address.getChildren().addAll(styledTitle, styledDescription);
        } else if (type.equals(ATTRIBUTE_EMAIL)) {
            email.getChildren().addAll(styledTitle, styledDescription);
        } else {
            assert false;
        }
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

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        PersonCard card = (PersonCard) other;
        return id.getText().equals(card.id.getText())
            && person.equals(card.person);
    }
}
