package seedu.address.ui.display;

import static seedu.address.ui.display.TitleDescriptionDisplay.addTitleDescriptionDisplay;

import javafx.stage.Stage;
import seedu.address.ui.tabs.TabName;

/**
 * A display containing information about the chosen internship.
 */
public class InternshipDisplay extends InformationDisplay {

    /**
     * Constructs a {@code InternshipDisplay} in the given {@code primaryStage}.
     */
    private InternshipDisplay(Stage primaryStage) {
        super(primaryStage);
        setInformationTitle("Software Engineering");
        // todo change when internship class is ready.

        String[] titleArr = {"Company", "Industry", "Email", "Address", "Skills", "Wage", "Status", "Date"};
        String[] descriptionArr = {"Shopee", "Software", "support@shopee.sg", "abc location",
            "Java, JavaScript, ReactJS, React Native, C++, C#, Rust, Objective-C, HTML, CSS, Python", "$3000",
            "Accepted", "25 March 2020"
        };
        for (int i = 0; i < titleArr.length; i++) {
            TitleDescriptionDisplay internshipInformation = addTitleDescriptionDisplay(titleArr[i], descriptionArr[i],
                TabName.INTERNSHIP);
            addInformation(internshipInformation);
        }
    }

    /**
     * Creates the {@code InternshipDisplay} information in the {@code primaryStage}.
     */
    public static InternshipDisplay getInternshipDisplay(Stage primaryStage) {
        return new InternshipDisplay(primaryStage);
    }
}
