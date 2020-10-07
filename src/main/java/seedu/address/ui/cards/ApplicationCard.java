package seedu.address.ui.cards;

import static seedu.address.commons.util.StringUtil.toTitleCase;
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
        // to be edited in the future!
        setId(displayedIndex);
        setName();
        setTags();
        setStatus();
        initializeBody();
        initializeDate();
    }
    
    @Override
    protected void setName() {
        Object companyName = mapping.get("Header");
        name.setText(companyName.toString());
    }

    @Override
    protected void setTags() {
        Object requirements = mapping.get("Requirements");
        String[] tagList = generateTags(requirements.toString());
        setAllTags(tagList);
    }

    private String[] generateTags(String requirements) {
        int length = requirements.length();
        return requirements.substring(1, length - 1).split(",");
    }
    
    private void setAllTags(String ... tagList) {
        for (String tag : tagList) {
            tags.getChildren().add(new Label(tag));
        }
    }
    
    private void setStatus() {
        Object status = mapping.get("Status");
        getStatusStyle(status.toString());
    }
    
    private void getStatusStyle(String statusType) {
        System.out.println(statusType); // this in titleCase
        switch (statusType) {
        case (APPLIED_KEYWORD):
            status.setText(toTitleCase(APPLIED_KEYWORD));
            statusBox.setStyle("-fx-background-color: #3ADB9D");
            break;
        case (INTERVIEW_KEYWORD):
            status.setText(toTitleCase(INTERVIEW_KEYWORD));
            statusBox.setStyle("-fx-background-color: #F02E62");
            break;
        case (WAITING_KEYWORD):
            status.setText(toTitleCase(WAITING_KEYWORD));
            statusBox.setStyle("-fx-background-color: #F4D014");
            break;
        case (REJECTED_KEYWORD):
            status.setText(toTitleCase(REJECTED_KEYWORD));
            statusBox.setStyle("-fx-background-color: #3A65DB");
            break;
        case (OFFERED_KEYWORD):
            status.setText(toTitleCase(OFFERED_KEYWORD));
            statusBox.setStyle("-fx-background-color: #3A65DB");
            break;
        case (ACCEPTED_KEYWORD):
            status.setText(toTitleCase(ACCEPTED_KEYWORD));
            statusBox.setStyle("-fx-background-color: #3A65DB");
            break;
        default:
            break;    
        }
    }


    /**
     * todo Javadocs
     */
    private void initializeDate() {
        Image calendarIcon = new Image(this.getClass().getResourceAsStream(CALENDAR_IMAGE_LINK));
        calendar.setImage(calendarIcon);
        date.setText("21/07/2020"); // to be changed later!
    }

}
