package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    // Person's Attribute
    private static final String ATTRIBUTE_PHONE = "Phone";
    private static final String ATTRIBUTE_ADDRESS = "Address";
    private static final String ATTRIBUTE_EMAIL = "Email";

    // PersonCard styling attribute
    private static final String DISPLAY_FONT = "Nunito";
    private static final int DISPLAY_SIZE = 12;
    private static final String TITLE_COLOR = "#363F80";
    private static final String DESCRIPTION_COLOR = "#8E8FB5";

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

    /**
     * Creates a {@code PersonCard} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        initializePersonCard(displayedIndex);
    }

    /**
     * Set up the styling of the {@code PersonCard} with {@code displayedIndex}.
     */
    private void initializePersonCard(int displayedIndex) {
        initializeHeader(displayedIndex);
        initializeBody();
        initializeTags();
    }

    /**
     * Set up the header of the {@code PersonCard} with {@code displayedIndex}.
     */
    private void initializeHeader(int displayedIndex) {
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
    }

    /**
     * Set up the content of the {@code PersonCard}.
     */
    private void initializeBody() {
        setStyling(ATTRIBUTE_PHONE, person.getPhone().value);
        setStyling(ATTRIBUTE_ADDRESS, person.getAddress().value);
        setStyling(ATTRIBUTE_EMAIL, person.getEmail().value);
    }

    /**
     * Set up the tags of the {@code PersonCard}.
     */
    private void initializeTags() {
        person.getTags().stream()
            .sorted(Comparator.comparing(tag -> tag.tagName))
            .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
        setRandomStatus(); // to be removed in when other classes are ready.
    }

    /**
     * Creates a {@code Text[]} that constitute the {@code title} of a specific color and {@code description}
     * of a specific color.
     */
    private Text[] createText(String title, String description) {
        Text text1 = new Text(title);
        Text text2 = new Text(description);
        setTextStyle(text1, TITLE_COLOR);
        setTextStyle(text2, DESCRIPTION_COLOR);
        return new Text[]{text1, text2};
    }

    /**
     * Set the {@code text}'s color to be {@code color} and set its font to a pre-defined font.
     */
    private void setTextStyle(Text text, String color) {
        text.setFill(Color.web(color));
        text.setFont(Font.font(DISPLAY_FONT, FontWeight.BOLD, DISPLAY_SIZE));
    }

    /**
     * Initialized the GUI of the properties inside {@code PersonCard}.
     */
    private void setStyling(String type, String description) {
        Text[] titleDescription = createText(type + ": ", description);
        if (type.equals(ATTRIBUTE_PHONE)) {
            phone.getChildren().addAll(titleDescription[0], titleDescription[1]);
        } else if (type.equals(ATTRIBUTE_ADDRESS)) {
            address.getChildren().addAll(titleDescription[0], titleDescription[1]);
        } else if (type.equals(ATTRIBUTE_EMAIL)) {
            email.getChildren().addAll(titleDescription[0], titleDescription[1]);
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
