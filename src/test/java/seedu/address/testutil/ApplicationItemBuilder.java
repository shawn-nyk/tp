package seedu.address.testutil;

import seedu.address.model.application.ApplicationItem;
import seedu.address.model.application.Status;
import seedu.address.model.application.StatusDate;
import seedu.address.model.internship.InternshipItem;
import seedu.address.model.util.DateUtil;

/**
 * A utility class to help with building ApplicationItem objects.
 */
public class ApplicationItemBuilder {
    public static final String DEFAULT_STATUS = "APPLIED";
    public static final String DEFAULT_STATUS_DATE = "5-12-19";

    private Status status;
    private StatusDate statusDate;
    private InternshipItem internshipItem;

    /**
     * Creates a {@code ApplicationItemBuilder} with the default details.
     */
    public ApplicationItemBuilder() {
        status = Status.valueOf(DEFAULT_STATUS);
        statusDate = new StatusDate(DateUtil.convertToDateTime(DEFAULT_STATUS_DATE));
        internshipItem = SampleInternshipItems.NUS_FS;
    }

    /**
     * Initializes the ApplicationItemBuilder with the data of {@code applicationToCopy}.
     */
    public ApplicationItemBuilder(ApplicationItem applicationToCopy) {
        status = applicationToCopy.getStatus();
        statusDate = applicationToCopy.getStatusDate();
        internshipItem = applicationToCopy.getInternshipItem();
    }

    /**
     * Sets the {@code Status} of the {@code ApplicationItem} that we are building.
     */
    public seedu.address.testutil.ApplicationItemBuilder withStatus(String status) {
        this.status = Status.valueOf(status);
        return this;
    }

    /**
     * Sets the {@code StatusDate} of the {@code ApplicationItem} that we are building.
     */
    public seedu.address.testutil.ApplicationItemBuilder withStatusDate(String statusDate) {
        this.statusDate = new StatusDate(DateUtil.convertToDateTime(statusDate));
        return this;
    }

    /**
     * Sets the {@code InternshipItem} of the {@code ApplicationItem} that we are building.
     */
    public seedu.address.testutil.ApplicationItemBuilder withInternshipItem(InternshipItem internshipItem) {
        this.internshipItem = internshipItem;
        return this;
    }

    public ApplicationItem build() {
        return new ApplicationItem(internshipItem, status, statusDate);
    }

}
