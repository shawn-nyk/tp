package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.internship.InternshipItem;
import seedu.address.model.item.ItemList;

/**
 * A utility class containing a list of {@code InternshipItem} objects to be used in tests.
 */
public abstract class SampleInternshipItems {

    public static final InternshipItem SHOPEE_SWE = new InternshipItemBuilder()
            .withCompanyName("Shopee")
            .withJobTitle("Software Engineer")
            .withPeriod("May - July")
            .withWage("3000")
            .withRequirements("React Native")
            .build();
    public static final InternshipItem LAZADA_DS = new InternshipItemBuilder()
            .withCompanyName("Lazada")
            .withJobTitle("Data Scientist intern")
            .withPeriod("Summer break")
            .withWage("3500")
            .withRequirements("Python", "TensorFlow")
            .build();
    public static final InternshipItem FACEBOOK_FE = new InternshipItemBuilder()
            .withCompanyName("Facebook")
            .withJobTitle("Front End Engineer")
            .withWage("4000")
            .withPeriod("December")
            .build();
    public static final InternshipItem AUTODESK_BE = new InternshipItemBuilder()
            .withCompanyName("Autodesk")
            .withJobTitle("Back End Engineer")
            .withWage("2000")
            .withPeriod("6 months")
            .withRequirements("SQL")
            .build();
    public static final InternshipItem NUS_FS = new InternshipItemBuilder()
            .withCompanyName("NUS")
            .withJobTitle("Full Stack developer intern")
            .withWage("1800")
            .withPeriod("3 months")
            .build();
    public static final InternshipItem LINKEDIN_APP = new InternshipItemBuilder()
            .withCompanyName("LinkedIn")
            .withJobTitle("Data Engineer")
            .withWage("3000")
            .withPeriod("6 months")
            .build();
    public static final InternshipItem TWITTER_SWD = new InternshipItemBuilder()
            .withCompanyName("Twitter")
            .withJobTitle("Software developer")
            .withWage("3200")
            .withPeriod("July")
            .build();

    // Manually added
    public static final InternshipItem GOLDMAN_DA = new InternshipItemBuilder()
            .withCompanyName("Goldman Sachs")
            .withJobTitle("Data Analyst")
            .withWage("2800")
            .withPeriod("3 months")
            .build();
    public static final InternshipItem IMDA_WD = new InternshipItemBuilder()
            .withCompanyName("IMDA")
            .withJobTitle("Web developer intern")
            .withWage("3000")
            .withPeriod("1 month")
            .build();

    /**
     * Returns an {@code AddressBook} with all the sample internship items.
     */
    public static ItemList<InternshipItem> getSampleInternshipList() {
        ItemList<InternshipItem> internshipItemList = new ItemList<>();
        for (InternshipItem internshipItem : getInternshipItems()) {
            internshipItemList.addItem(internshipItem);
        }
        return internshipItemList;
    }

    private static List<InternshipItem> getInternshipItems() {
        return new ArrayList<>(Arrays.asList(SHOPEE_SWE, LAZADA_DS, FACEBOOK_FE, AUTODESK_BE, NUS_FS, LINKEDIN_APP,
                TWITTER_SWD, GOLDMAN_DA, IMDA_WD));
    }
}
