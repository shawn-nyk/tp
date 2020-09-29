package seedu.address.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class InternshipInformationDisplay extends HBox {

    //FXML
    private static final String FXML = "/view/InternshipInformationDisplay.fxml";

    //FXML properties
    private static final String DISPLAY_FONT = "Nunito";
    private static final int DISPLAY_SIZE = 12;
    private static final String TITLE_COLOR = "#363F80";
    private static final String DESCRIPTION_COLOR = "#8E8FB5";

    @FXML
    private TextFlow title;
    @FXML
    private TextFlow description;

    private InternshipInformationDisplay(String title, String description) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource(FXML));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        createInternshipDisplayInformation(title, description);
    }

    public static InternshipInformationDisplay setInternshipDisplayInformation(String title, String description) {
        return new InternshipInformationDisplay(title, description);
    }

    private void createInternshipDisplayInformation(String inputTitle, String inputDescription) {
        Text styledTitle = new Text(inputTitle);
        Text styledDescription = new Text(inputDescription);
        styledTitle.setFont(Font.font(DISPLAY_FONT, FontWeight.BOLD, DISPLAY_SIZE));
        styledTitle.setFill(Color.web(TITLE_COLOR));
        styledDescription.setFont(Font.font(DISPLAY_FONT, FontWeight.BOLD, DISPLAY_SIZE));
        styledDescription.setFill(Color.web(DESCRIPTION_COLOR));
        title.getChildren().addAll(styledTitle);
        description.getChildren().addAll(styledDescription);
    }
}
