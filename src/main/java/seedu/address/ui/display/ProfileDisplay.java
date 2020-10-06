package seedu.address.ui.display;

import static seedu.address.ui.display.TitleDescriptionDisplay.addTitleDescriptionDisplay;

import javafx.stage.Stage;
import seedu.address.ui.tabs.TabName;

/**
 * A display containing information about the chosen profile's item.
 */
public class ProfileDisplay extends InformationDisplay {

    /**
     * Constructs a {@code ProfileDisplay} in the given {@code primaryStage}.
     */
    private ProfileDisplay(Stage primaryStage) {
        super(primaryStage);
        setInformationTitle("Shoppee");
        // todo change when internship class is ready.

        String[] titleArr = {"Experience", "Achievement", "Skills"};
        String[] descriptionArr = {"Internship at Govtech, Internship at Google, Internship at Facebook",
            "Special recognition in Hack n Roll, Leetcode weekly champion, Google code jam champion",
            "HTML, CSS, JavaScript, Java, Python, React, React Native, Vue, Angular, C, C++, C#, PHP, Rust"
        };
        for (int i = 0; i < titleArr.length; i++) {
            TitleDescriptionDisplay profileInformation = addTitleDescriptionDisplay(titleArr[i], descriptionArr[i],
                TabName.PROFILE);
            addInformation(profileInformation);
        }
    }

    /**
     * Creates the {@code ProfileDisplay} information in the {@code primaryStage}.
     */
    public static ProfileDisplay getProfileDisplay(Stage primaryStage) {
        return new ProfileDisplay(primaryStage);
    }
}
