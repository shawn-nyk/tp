package seedu.address.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CompanyDisplay extends VBox {

    //FXML
    private static final String FXML = "/view/Company.fxml";

    //FXML properties
    private static final int COMPANY_HEIGHT_SHRINK = 155;

    @FXML
    private VBox company;

    /**
     * Constructs a {@code CompanyDisplay} in the given {@code primaryStage}.
     */
    private CompanyDisplay(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource(FXML));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
            setCompanyProperties(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the {@code CompanyDisplay} information in the {@code primaryStage}.
     */
    public static CompanyDisplay getCompanyDisplay(Stage primaryStage) {
        return new CompanyDisplay(primaryStage);
    }

    /**
     * Set the {@code companyDisplay} styling in the {@code primaryStage}.
     */
    private void setCompanyProperties(Stage primaryStage) {
        company.prefHeightProperty().bind(primaryStage.heightProperty().subtract(COMPANY_HEIGHT_SHRINK));
    }
}
