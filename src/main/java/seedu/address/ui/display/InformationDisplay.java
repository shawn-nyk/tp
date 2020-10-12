package seedu.address.ui.display;

import static seedu.address.ui.panel.PanelDisplayKeyword.INTERNSHIPS_DISPLAY_NAME;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import seedu.address.model.item.Item;
import seedu.address.ui.UiPart;
import seedu.address.ui.tabs.TabName;

/**
 * A display that contains information.
 */
public abstract class InformationDisplay<T extends Item> extends UiPart<Region> {

    //FXML
    private static final String FXML = "InformationDisplay.fxml";

    //FXML properties
    private static final int INFORMATION_HEIGHT_SHRINK = 175;
    private static final int INFORMATION_WIDTH_SHRINK = 100;
    protected T item;
    protected LinkedHashMap<String, Object> mapping;

    @FXML
    private ScrollPane scrollableInformationDisplay;
    @FXML
    private HBox nameBar;
    @FXML
    private Label informationTitle;
    @FXML
    private VBox information;
    @FXML
    private VBox informationDisplay;
    @FXML
    private VBox informationDisplayContainer;

    /**
     * Constructs a {@code InformationDisplay} in the given {@code primaryStage}.
     */
    public InformationDisplay(Stage primaryStage, T item) {
        super(FXML);
        initializeInformationDisplay(primaryStage);
        this.item = item;
        this.mapping = item.getMapping();
    }

    /**
     * Sets the size of {@code InformationDisplay} in the given {@code primaryStage}.
     */
    private void initializeInformationDisplay(Stage primaryStage) {
        scrollableInformationDisplay.prefHeightProperty()
            .bind(primaryStage.heightProperty().subtract(INFORMATION_HEIGHT_SHRINK));
        nameBar.maxWidthProperty().bind(informationDisplay.widthProperty().subtract(INFORMATION_WIDTH_SHRINK));
    }

    /**
     * Adds {@code titleDescriptionDisplay} into {@code InformationDisplay}.
     */
    void addInformation(TitleDescriptionDisplay titleDescriptionDisplay) {
        information.getChildren().addAll(titleDescriptionDisplay);
    }

    /**
     * Adds {@code title} into {@code InformationDisplay}.
     */
    protected void setInformationTitle(String title) {
        informationTitle.setText(title);
    }

    /**
     * todo javadocs
     */
    protected void setInformation(Function<String, String> editString, Predicate<String> haveBrackets,
        TabName tabName, String ... displayKeyList) {
        for (String key : displayKeyList) {
            Object object = mapping.get(key);
            String detail = object.toString();
            if (haveBrackets.test(key)) {
                detail = editString.apply(detail);
            }
            if (detail.length() == 0) {
                detail = "-";
            }
            if (key.equals(INTERNSHIPS_DISPLAY_NAME) && detail.length() > 0) {
                detail = formatInternshipDetail(detail);
            }
            addInformation(TitleDescriptionDisplay.addTitleDescriptionDisplay(key, detail, tabName));
        }
    }

    public String formatInternshipDetail(String string) {
        String s =string.substring(0, string.length() - 1);
        s = s.replaceAll("\n, ", "\n");
        StringBuffer buffer = new StringBuffer(s);
        buffer.insert(0, "1. ");
        formatNumbering(buffer, "\n");
        return formatBulletPoints(buffer);
    }
    
    public void formatNumbering(StringBuffer buffer, String target) {
        int index = buffer.indexOf(target);
        int counter = 2;
        while (index != -1) {
            String replacement = target + counter + ". ";
            buffer.replace(index, index + 1, replacement);
            index += replacement.length();
            index = buffer.indexOf(target, index);
            counter++;
        }
    }
    
    public String formatBulletPoints(StringBuffer buffer) {
        String string = buffer.toString();
        string = string.replaceAll(", {2}",  "\n  \u2022 ");
        return string;
    }
}
