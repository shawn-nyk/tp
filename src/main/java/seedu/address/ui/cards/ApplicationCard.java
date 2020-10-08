package seedu.address.ui.cards;

import static seedu.address.model.util.DateUtil.extractDayAndMonth;
import static seedu.address.model.util.StatusUtil.ACCEPTED_KEYWORD;
import static seedu.address.model.util.StatusUtil.APPLIED_KEYWORD;
import static seedu.address.model.util.StatusUtil.INTERVIEW_KEYWORD;
import static seedu.address.model.util.StatusUtil.OFFERED_KEYWORD;
import static seedu.address.model.util.StatusUtil.REJECTED_KEYWORD;
import static seedu.address.model.util.StatusUtil.WAITING_KEYWORD;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import seedu.address.model.application.ApplicationItem;

/**
 * todo Javadocs
 */
public class ApplicationCard extends Card<ApplicationItem> {

    //Image Link
    private static final String CALENDAR_IMAGE_LINK = "/images/calendar.png";

    /**
     * todo Javadocs
     */
    public ApplicationCard(ApplicationItem applicationItem, int displayedIndex) {
        super(applicationItem, displayedIndex);
        initializeInternshipCardGui();
    }

    /**
     * todo Javadocs
     */
    private void initializeInternshipCardGui() {
        setId(displayedIndex);
        setName();
        setTags();
        setStatus();
        setInformation();
        setDate();
    }

    @Override
    protected void setName() {
        Object jobTitle = mapping.get("Job title");
        name.setText(jobTitle.toString());
    }

    @Override
    protected void setTags() {
        Object requirements = mapping.get("Requirements");
        String[] tagList = generateTags(requirements.toString());
        setAllTags(tagList);
    }

    /**
     * todo Javadocs
     */
    private String[] generateTags(String requirements) {
        int length = requirements.length();
        return requirements.substring(1, length - 1).split(",");
    }

    /**
     * todo Javadocs
     */
    private void setAllTags(String ... tagList) {
        for (String tag : tagList) {
            tags.getChildren().add(new Label(tag));
        }
    }

    /**
     * todo Javadocs
     */
    private void setStatus() {
        Object status = mapping.get("Status");
        getStatusStyle(status.toString());
    }

    /**
     * todo Javadocs
     */
    private void getStatusStyle(String statusType) {
        switch (statusType) {
        case (APPLIED_KEYWORD):
            status.setText(APPLIED_KEYWORD);
            statusBox.setStyle("-fx-background-color: #3ADB9D");
            break;
        case (INTERVIEW_KEYWORD):
            status.setText(INTERVIEW_KEYWORD);
            statusBox.setStyle("-fx-background-color: #F02E62");
            break;
        case (WAITING_KEYWORD):
            status.setText(WAITING_KEYWORD);
            statusBox.setStyle("-fx-background-color: #F4D014");
            break;
        case (REJECTED_KEYWORD):
            status.setText(REJECTED_KEYWORD);
            statusBox.setStyle("-fx-background-color: #3A65DB");
            break;
        case (OFFERED_KEYWORD):
            status.setText(OFFERED_KEYWORD);
            statusBox.setStyle("-fx-background-color: #3A65DB");
            break;
        case (ACCEPTED_KEYWORD):
            status.setText(ACCEPTED_KEYWORD);
            statusBox.setStyle("-fx-background-color: #3A65DB");
            break;
        default:
            break;    
        }
    }

    /**
     * todo Javadocs
     */
    private void setInformation() {
        Object companyName = mapping.get("Header");
        Object wage = mapping.get("Wage");
        Object period = mapping.get("Period");
        setTextAt("Company: ", companyName.toString(), LineNumber.L1);
        setTextAt("Wage: ", wage.toString(), LineNumber.L2);
        setTextAt("Period: ", period.toString(), LineNumber.L3);
    }

    /**
     * todo Javadocs
     */
    private void setDate() {
        Image calendarIcon = new Image(this.getClass().getResourceAsStream(CALENDAR_IMAGE_LINK));
        calendar.setImage(calendarIcon);
        
        Object dateInformation = mapping.get("Date");
        String[] dateInformationArray = dateInformation.toString().split(" ");
        date.setText(extractDayAndMonth(dateInformationArray));
    }

}
