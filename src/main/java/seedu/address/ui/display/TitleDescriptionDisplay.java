package seedu.address.ui.display;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import seedu.address.ui.MainWindow;
import seedu.address.ui.tabs.TabName;

/**
 * A display containing a title and a description.
 */
public class TitleDescriptionDisplay extends HBox {

    //FXML
    private static final String FXML = "/view/TitleDescriptionDisplay.fxml";

    //FXML properties
    private static final String DISPLAY_FONT = "Nunito";
    private static final int DISPLAY_SIZE = 12;
    private static final String TITLE_COLOR = "#363F80";
    private static final String DESCRIPTION_COLOR = "#8E8FB5";
    private static final String USER_INFORMATION_WIDTH = "-fx-min-width: 95";
    private static final String COMPANY_INTERNSHIP_INFORMATION_WIDTH = "-fx-min-width: 75";

    @FXML
    private TextFlow title;
    @FXML
    private TextFlow description;
    @FXML
    private VBox titleInformation;
    @FXML
    private VBox descriptionInformation;

    /**
     * Constructs a {@code TitleDescriptionDisplay} with {@code displayTitle}, {@code displayDescription} for
     * {@code tab} display.
     */
    private TitleDescriptionDisplay(String displayTitle, String displayDescription, TabName tab) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource(FXML));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addDisplayInformation(displayTitle, displayDescription);
        setWidth(tab);
    }

    /**
     * Accessor to add a {@code TitleDescriptionDisplay} with {@code displayTitle}, {@code displayDescription} for
     * {@code tab} display.
     */
    public static TitleDescriptionDisplay addTitleDescriptionDisplay(String displayTitle, String displayDescription,
        TabName tab) {

        return new TitleDescriptionDisplay(displayTitle, displayDescription, tab);
    }

    /**
     * Adds a title and description into the {@code TitleDescriptionDisplay}.
     */
    private void addDisplayInformation(String displayTitle, String displayDescription) {
        DisplayInformation displayInformation = createDisplayInformation(displayTitle, displayDescription);
        title.getChildren().addAll(displayInformation.title);
        description.getChildren().addAll(displayInformation.description);
    }

    /**
     * Constructs a {@code DisplayInformation} that contains both the styled title and the styled description.
     */
    private DisplayInformation createDisplayInformation(String displayTitle, String displayDescription) {
        Text styledTitle = new Text(displayTitle);
        Text styledDescription = new Text(displayDescription);
        setTextStyle(styledTitle, Color.web(TITLE_COLOR));
        setTextStyle(styledDescription, Color.web(DESCRIPTION_COLOR));
        return new DisplayInformation(styledTitle, styledDescription);
    }

    /**
     * Set a text with a pre-defined font and its {@code color}.
     */
    private void setTextStyle(Text text, Color color) {
        text.setFont(Font.font(DISPLAY_FONT, FontWeight.BOLD, DISPLAY_SIZE));
        text.setFill(color);
    }

    /**
     * Adjust the width of the title based on which {@code tab} display.
     */
    private void setWidth(TabName tab) {
        switch (tab) {
        case COMPANY:
            //Fallthrough
        case INTERNSHIP:
            titleInformation.setStyle(COMPANY_INTERNSHIP_INFORMATION_WIDTH);
            break;
        case USER:
            titleInformation.setStyle(USER_INFORMATION_WIDTH);
            break;
        default:
            assert false;
        }
    }

    /**
     * Class that holds a title and a description.
     */
    private static class DisplayInformation {
        private Text title;
        private Text description;

        /**
         * Constructs a {@code DisplayInformation} containing a title and a description.
         */
        private DisplayInformation(Text title, Text description) {
            this.title = title;
            this.description = description;
        }
    }
}
