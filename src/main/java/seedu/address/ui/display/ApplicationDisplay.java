package seedu.address.ui.display;

import static seedu.address.ui.display.TitleDescriptionDisplay.addTitleDescriptionDisplay;

import javafx.stage.Stage;
import seedu.address.ui.tabs.TabName;

/**
 * A display containing information about the chosen application.
 */
public class ApplicationDisplay extends InformationDisplay {

    /**
     * Constructs a {@code ApplicationDisplay} in the given {@code primaryStage}.
     */
    private ApplicationDisplay(Stage primaryStage) {
        super(primaryStage);
        setInformationTitle("Software Engineering");
        // todo change when internship class is ready.

        String[] titleArr = {"Company", "Industry", "Email", "Address", "Skills", "Wage", "Status", "Date"};
        String[] descriptionArr = {"Shopee", "Software", "support@shopee.sg", "abc location",
            "Java, JavaScript, ReactJS, React Native, C++, C#, Rust, Objective-C, HTML, CSS, Python", "$3000",
            "Accepted", "25 March 2020"
        };
        for (int i = 0; i < titleArr.length; i++) {
            TitleDescriptionDisplay applicationInformation = addTitleDescriptionDisplay(titleArr[i], descriptionArr[i],
                TabName.APPLICATION);
            addInformation(applicationInformation);
        }
    }

    /**
     * Creates the {@code ApplicationDisplay} information in the {@code primaryStage}.
     */
    public static ApplicationDisplay getApplicationDisplay(Stage primaryStage) {
        return new ApplicationDisplay(primaryStage);
    }
}
