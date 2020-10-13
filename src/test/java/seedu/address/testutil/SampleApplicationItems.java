package seedu.address.testutil;

import static seedu.address.testutil.SampleInternshipItems.FACEBOOK_FE;
import static seedu.address.testutil.SampleInternshipItems.LAZADA_DS;
import static seedu.address.testutil.SampleInternshipItems.SHOPEE_SWE;

import seedu.address.model.application.ApplicationItem;

public abstract class SampleApplicationItems {
    public static final String STATUS_REJECTED = "REJECTED";
    public static final String STATUS_OFFERED = "OFFERED";

    public static final String STATUS_DATE_MAY = "23-05-18";
    public static final String STATUS_DATE_JUNE = "12-06-21";

    public static final ApplicationItem SHOPEE_OFFERED = new ApplicationItemBuilder()
            .withInternshipItem(SHOPEE_SWE)
            .withStatus(STATUS_OFFERED)
            .withStatusDate(STATUS_DATE_JUNE)
            .build();
    public static final ApplicationItem LAZADA_REJECTED = new ApplicationItemBuilder()
            .withInternshipItem(LAZADA_DS)
            .withStatus(STATUS_REJECTED)
            .withStatusDate(STATUS_DATE_JUNE)
            .build();
    public static final ApplicationItem FACEBOOK_ACCEPTED = new ApplicationItemBuilder()
            .withInternshipItem(FACEBOOK_FE)
            .withStatus(STATUS_REJECTED)
            .withStatusDate(STATUS_DATE_MAY)
            .build();

}
