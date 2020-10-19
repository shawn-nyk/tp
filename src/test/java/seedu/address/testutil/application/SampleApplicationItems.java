package seedu.address.testutil.application;

import static seedu.address.model.util.StatusUtil.ACCEPTED_KEYWORD;
import static seedu.address.model.util.StatusUtil.OFFERED_KEYWORD;
import static seedu.address.model.util.StatusUtil.REJECTED_KEYWORD;
import static seedu.address.testutil.application.ApplicationItemFieldsUtil.STATUS_DATE_JUNE_2021;
import static seedu.address.testutil.application.ApplicationItemFieldsUtil.STATUS_DATE_JUNE_2022;
import static seedu.address.testutil.internship.SampleInternshipItems.FACEBOOK_FE;
import static seedu.address.testutil.internship.SampleInternshipItems.LAZADA_DS;
import static seedu.address.testutil.internship.SampleInternshipItems.SHOPEE_SWE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.application.ApplicationItem;
import seedu.address.model.item.ItemList;

public abstract class SampleApplicationItems {

    public static final ApplicationItem SHOPEE_OFFERED = new ApplicationItemBuilder()
            .withInternshipItem(SHOPEE_SWE)
            .withStatus(OFFERED_KEYWORD)
            .withStatusDate(STATUS_DATE_JUNE_2021)
            .build();
    public static final ApplicationItem LAZADA_REJECTED = new ApplicationItemBuilder()
            .withInternshipItem(LAZADA_DS)
            .withStatus(REJECTED_KEYWORD)
            .withStatusDate(STATUS_DATE_JUNE_2021)
            .build();
    public static final ApplicationItem FACEBOOK_ACCEPTED = new ApplicationItemBuilder()
            .withInternshipItem(FACEBOOK_FE)
            .withStatus(ACCEPTED_KEYWORD)
            .withStatusDate(STATUS_DATE_JUNE_2022)
            .build();

    public static ItemList<ApplicationItem> getSampleApplicationItemList() {
        ItemList<ApplicationItem> applicationItemItemList = new ItemList<>();
        for (ApplicationItem applicationItem : getApplicationItems()) {
            applicationItemItemList.addItem(applicationItem);
        }
        return applicationItemItemList;
    }

    private static List<ApplicationItem> getApplicationItems() {
        return new ArrayList<>(Arrays.asList(SHOPEE_OFFERED, LAZADA_REJECTED, FACEBOOK_ACCEPTED));
    }
}
