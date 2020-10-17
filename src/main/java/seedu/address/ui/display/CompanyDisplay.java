package seedu.address.ui.display;

import static seedu.address.ui.display.DisplayKeyList.COMPANY_DISPLAY_KEY_LIST;
import static seedu.address.ui.panel.PanelDisplayKeyword.COMPANY_DISPLAY_NAME;
import static seedu.address.ui.panel.PanelDisplayKeyword.INDUSTRIES_DISPLAY_NAME;
import static seedu.address.ui.panel.PanelDisplayKeyword.INTERNSHIPS_DISPLAY_NAME;

import java.util.function.Function;
import java.util.function.Predicate;

import javafx.stage.Stage;
import seedu.address.model.company.CompanyItem;
import seedu.address.ui.tabs.TabName;

/**
 * A display containing information about the chosen company.
 */
public class CompanyDisplay extends InformationDisplay<CompanyItem> {

    /**
     * A Predicate that checks if the current key in the key list is of industries or internships.
     */
    private final Predicate<String> isIndustriesOrInternship = key -> key.equals(INDUSTRIES_DISPLAY_NAME)
        || key.equals(INTERNSHIPS_DISPLAY_NAME);

    /**
     * A function that takes in a string containing information of the internship and formats it with bullet
     * points and new line for each attributes in the internship information.
     */
    private final Function<String, String> formatInternshipDetail = string -> {
        String s = string.substring(0, string.length() - 1);
        s = s.replaceAll(NEW_LINE + COMMA_ONE_SPACE, NEW_LINE);
        StringBuffer buffer = new StringBuffer(s);
        buffer.insert(0, 1 + DOT_SPACE);
        formatNumbering(buffer);
        return formatBulletPoints(buffer);
    };

    /**
     * Creates a {@code CompanyDisplay} in the given {@code primaryStage}.
     *
     * @param primaryStage The main stage of the app.
     * @param companyItem The company item to be displayed.
     */
    private CompanyDisplay(Stage primaryStage, CompanyItem companyItem) {
        super(primaryStage, companyItem);

        initializeCompanyDisplayGui();
    }

    /**
     * Initializes a {@code CompanyDisplay} in the given {@code primaryStage}.
     *
     * @param primaryStage The main stage of the app.
     * @param companyItem The company item to be displayed.
     * @return A company display that contains information of the {@code companyItem} in {@code primaryStage}.
     */
    public static CompanyDisplay getCompanyDisplay(Stage primaryStage, CompanyItem companyItem) {
        return new CompanyDisplay(primaryStage, companyItem);
    }

    /**
     * Set the title and information of the {@code companyItem} for display.
     */
    private void initializeCompanyDisplayGui() {
        setInformationTitle();
        setInformation();
    }

    /**
     * Set the title of the {@code companyItem} for display.
     */
    private void setInformationTitle() {
        Object jobTitle = mapping.get(COMPANY_DISPLAY_NAME);
        setInformationTitle(jobTitle.toString());
    }

    /**
     * Set the information of the {@code companyItem} for display.
     */
    private void setInformation() {
        setInformation(editString, formatInternshipDetail, isIndustriesOrInternship, TabName.COMPANY,
            COMPANY_DISPLAY_KEY_LIST);
    }

    /**
     * Formats the {@code buffer} to number the internships.
     *
     * @param buffer A stringbuffer containing information of the internships.
     */
    private void formatNumbering(StringBuffer buffer) {
        int index = buffer.indexOf(NEW_LINE);
        int counter = 2;
        while (index != -1) {
            String replacement = NEW_LINE + counter + DOT_SPACE;
            buffer.replace(index, index + 1, replacement);
            index += replacement.length();
            index = buffer.indexOf(NEW_LINE, index);
            counter++;
        }
    }

    /**
     * Formats the {@code buffer} to have bullet points for each attributes.
     *
     * @param buffer A stringbuffer containing information of the intnership.
     * @return A string that is formatted with bullet points.
     */
    private String formatBulletPoints(StringBuffer buffer) {
        String string = buffer.toString();
        string = string.replaceAll(COMMA_TWO_SPACE, NEW_LINE + BULLET_WITH_TWO_SPACE_FRONT_ONE_BACK);
        return string;
    }
}
