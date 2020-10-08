package seedu.address.ui.cards;

import static seedu.address.ui.textstyle.TitleDescription.createTitleDescription;

import java.util.Comparator;
import java.util.LinkedHashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import seedu.address.model.item.Item;
import seedu.address.ui.UiPart;
import seedu.address.ui.textstyle.TitleDescription;

/**
 * A UI component that displays information of a {@code Person}.
 */
public abstract class Card<T extends Item> extends UiPart<Region> {

    //FXML
    private static final String FXML = "Card.fxml";

    //Person's Attribute
    private static final String ATTRIBUTE_PHONE = "Phone";
    private static final String ATTRIBUTE_ADDRESS = "Address";
    private static final String ATTRIBUTE_EMAIL = "Email";

    public final T item;
    protected int displayedIndex;
    public LinkedHashMap<String, Object> mapping;

    @FXML
    protected VBox statusBox;
    @FXML
    protected Label status;
    @FXML
    protected ImageView calendar;
    @FXML
    protected Label date;
    @FXML
    protected Label name;
    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private TextFlow p1;
    @FXML
    private TextFlow p2;
    @FXML
    private TextFlow p3;
    @FXML
    protected FlowPane tags;

    /**
     * todo Javadocs
     */
    public Card(T item, int displayedIndex) {
        super(FXML);
        this.item = item;
        this.displayedIndex = displayedIndex;
        this.mapping = item.getMapping();
    }

    /**
     * todo Javadocs
     */
    protected abstract void setName();

    /**
     * todo Javadocs
     */
    protected abstract void setTags();

    /**
     * todo Javadocs
     */
    protected void setId(int displayedIndex) {
        id.setText(displayedIndex + ". ");
    }
    
    protected void setTextAt(String type, String description, LineNumber lineNumber) {
        TitleDescription titleDescription = createTitleDescription(type + ": ", description);
        Text styledTitle = titleDescription.getTitle();
        Text styledDescription = titleDescription.getDescription();
        switch(lineNumber) {
        case L1:
            setL1(styledTitle, styledDescription);
            break;
        case L2:
            setL2(styledTitle, styledDescription);
            break;
        case L3:
            setL3(styledTitle, styledDescription);
            break;
        default:
            assert false;
            break;
        }
    }

    private void setL1(Text styledTitle, Text styledDescription) {
        p1.getChildren().addAll(styledTitle, styledDescription);
    }

    private void setL2(Text styledTitle, Text styledDescription) {
        p2.getChildren().addAll(styledTitle, styledDescription);
    }

    private void setL3(Text styledTitle, Text styledDescription) {
        p3.getChildren().addAll(styledTitle, styledDescription);
    }

    /**
     * todo Javadocs
     */
    protected void initializeBody() {
        //setStyling(ATTRIBUTE_PHONE, person.getPhone().value);
        //setStyling(ATTRIBUTE_ADDRESS, person.getAddress().value);
        //setStyling(ATTRIBUTE_EMAIL, person.getEmail().value);
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
            && item.equals(card.item);
    }
}
