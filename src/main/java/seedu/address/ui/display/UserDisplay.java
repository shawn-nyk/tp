package seedu.address.ui.display;

import static seedu.address.ui.display.TitleDescriptionDisplay.addTitleDescriptionDisplay;

import javafx.stage.Stage;
import seedu.address.ui.tabs.TabName;

/**
 * A display containing information about the chosen user's category.
 */
public class UserDisplay extends InformationDisplay {

    /**
     * Constructs a {@code UserDisplay} in the given {@code primaryStage}.
     */
    private UserDisplay(Stage primaryStage) {
        super(primaryStage);
        setInformationTitle("Shoppee");
        // todo change when internship class is ready.

        String[] titleArr = {"Experience", "Achievement", "Skills"};
        String[] descriptionArr = {"Internship at Govtech, Internship at Google, Internship at Facebook",
            "Special recognition in Hack n Roll, Leetcode weekly champion, Google code jam champion",
            "HTML, CSS, JavaScript, Java, Python, React, React Native, Vue, Angular, C, C++, C#, PHP, Rust"
        };
        for (int i = 0; i < titleArr.length; i++) {
            TitleDescriptionDisplay userInformation = addTitleDescriptionDisplay(titleArr[i], descriptionArr[i],
                TabName.USER);
            addInformation(userInformation);
        }
    }

    /**
     * Creates the {@code UserDisplay} information in the {@code primaryStage}.
     */
    public static UserDisplay getUserDisplay(Stage primaryStage) {
        return new UserDisplay(primaryStage);
    }
}
