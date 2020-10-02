package seedu.address.ui.display;

import static seedu.address.ui.display.TitleDescriptionDisplay.addTitleDescriptionDisplay;

import javafx.stage.Stage;
import seedu.address.ui.tabs.TabName;

/**
 * A display containing information about the chosen company.
 */
public class CompanyDisplay extends InformationDisplay {

    /**
     * Constructs a {@code CompanyDisplay} in the given {@code primaryStage}.
     */
    private CompanyDisplay(Stage primaryStage) {
        super(primaryStage);
        setInformationTitle("Google");
        // todo change when Company class is ready.
        String[] titleArr = {"Industry", "Jobs"};
        String[] descriptionArr = {"Internet, Cloud Computing",
            "Artificial Intelligence, Software Engineering, Cloud Architect"};
        for (int i = 0; i < titleArr.length; i++) {
            TitleDescriptionDisplay companyInformation = addTitleDescriptionDisplay(titleArr[i], descriptionArr[i],
                TabName.COMPANY);
            addInformation(companyInformation);
        }
    }

    /**
     * Creates the {@code CompanyDisplay} information in the {@code primaryStage}.
     */
    public static CompanyDisplay getCompanyDisplay(Stage primaryStage) {
        return new CompanyDisplay(primaryStage);
    }
}
