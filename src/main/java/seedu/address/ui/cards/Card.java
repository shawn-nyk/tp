package seedu.address.ui.cards;

import static seedu.address.ui.textstyle.TitleDescription.createTitleDescription;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
 * A UI component that displays information of a {@code Person}.
 */
public abstract class Card extends UiPart<Region> {

    //FXML
    private static final String FXML = "Card.fxml";

    //Person's Attribute
    private static final String ATTRIBUTE_PHONE = "Phone";
    private static final String ATTRIBUTE_ADDRESS = "Address";
    private static final String ATTRIBUTE_EMAIL = "Email";

    public final Person person;
    protected int displayedIndex;

    @FXML
    protected VBox statusBox;
    @FXML
    protected Label status;
    @FXML
    protected ImageView calendar;
    @FXML
    protected Label date;
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

    /**
     * todo Javadocs
     */
    public Card(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        this.displayedIndex = displayedIndex;
        //initializePersonCard(displayedIndex);
    }

    /**
     * todo Javadocs
     */
    protected void initializeHeader(int displayedIndex) {
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
    }

    /**
     * todo Javadocs
     */
    protected void initializeBody() {
        setStyling(ATTRIBUTE_PHONE, person.getPhone().value);
        setStyling(ATTRIBUTE_ADDRESS, person.getAddress().value);
        setStyling(ATTRIBUTE_EMAIL, person.getEmail().value);
    }

    /**
     * todo Javadocs
     */
    protected void initializeTags() {
        person.getTags().stream()
            .sorted(Comparator.comparing(tag -> tag.tagName))
            .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }


    /**
     * todo Javadocs
     */
    private void setStyling(String type, String description) {
        TitleDescription titleDescription = createTitleDescription(type + ": ", description);
        Text styledTitle = titleDescription.getTitle();
        Text styledDescription = titleDescription.getDescription();
        switch (type) {
        case ATTRIBUTE_PHONE:
            phone.getChildren().addAll(styledTitle, styledDescription);
            break;
        case ATTRIBUTE_ADDRESS:
            address.getChildren().addAll(styledTitle, styledDescription);
            break;
        case ATTRIBUTE_EMAIL:
            email.getChildren().addAll(styledTitle, styledDescription);
            break;
        default:
            assert false;
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
        if (!(other instanceof Card)) {
            return false;
        }

        // state check
        Card card = (Card) other;
        return id.getText().equals(card.id.getText())
            && person.equals(card.person);
    }
}
