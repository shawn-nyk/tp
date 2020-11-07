package seedu.internhunter.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.internhunter.testutil.company.CompanyItemFieldsUtil.VALID_INDUSTRY_ARTIFICIAL_INTELLIGENCE;
import static seedu.internhunter.testutil.company.CompanyItemFieldsUtil.VALID_INDUSTRY_CLOUD_COMPUTING;
import static seedu.internhunter.testutil.internship.InternshipItemFieldsUtil.VALID_REQUIREMENT_GRAPHQL;
import static seedu.internhunter.testutil.internship.InternshipItemFieldsUtil.VALID_REQUIREMENT_R;

import org.junit.jupiter.api.Test;

import javafx.application.Platform;
import seedu.internhunter.model.application.ApplicationItem;
import seedu.internhunter.model.company.CompanyItem;
import seedu.internhunter.model.internship.InternshipItem;
import seedu.internhunter.model.profile.ProfileItem;
import seedu.internhunter.testutil.application.ApplicationItemBuilder;
import seedu.internhunter.testutil.company.CompanyItemBuilder;
import seedu.internhunter.testutil.internship.InternshipItemBuilder;
import seedu.internhunter.testutil.profile.ProfileItemBuilder;
import seedu.internhunter.ui.cards.ApplicationCard;
import seedu.internhunter.ui.cards.Card;
import seedu.internhunter.ui.cards.CompanyCard;
import seedu.internhunter.ui.cards.InternshipCard;
import seedu.internhunter.ui.cards.ProfileCard;

/**
 * Test for the Card in Ui. Note that there will be an "application" appearing, however it is just the
 * JavaFX runtime starting to allow the FXML files to load to test the Card Methods.
 */
public class CardTest {

    // ApplicationItemBuilder
    private ApplicationItemBuilder applicationItemBuilderStatusApplied = new ApplicationItemBuilder();
    private ApplicationItemBuilder applicationItemBuilderStatusAccepted = new ApplicationItemBuilder()
        .withStatus("accepted");
    private ApplicationItemBuilder applicationItemBuilderStatusInterview = new ApplicationItemBuilder()
        .withStatus("interview");
    private ApplicationItemBuilder applicationItemBuilderStatusWaiting = new ApplicationItemBuilder()
        .withStatus("waiting");
    private ApplicationItemBuilder applicationItemBuilderStatusRejected = new ApplicationItemBuilder()
        .withStatus("rejected");
    private ApplicationItemBuilder applicationItemBuilderStatusOffered = new ApplicationItemBuilder()
        .withStatus("offered");

    // CompanyItemBuilder
    private CompanyItemBuilder companyItemBuilder = new CompanyItemBuilder();
    private CompanyItemBuilder companyItemBuilderWithIndustries = new CompanyItemBuilder()
        .withIndustries(VALID_INDUSTRY_ARTIFICIAL_INTELLIGENCE, VALID_INDUSTRY_CLOUD_COMPUTING);

    // ProfileItemBuilder
    private ProfileItemBuilder profileItemBuilderWithSkill = new ProfileItemBuilder();
    private ProfileItemBuilder profileItemBuilderWithExperience = new ProfileItemBuilder().withTitle("Experience")
        .withCategory("EXPERIENCE");
    private ProfileItemBuilder profileItemBuilderWithAchievement = new ProfileItemBuilder().withTitle("Achievement")
        .withCategory("ACHIEVEMENT");

    // InternshipItemBuilder
    private InternshipItemBuilder internshipItemBuilder = new InternshipItemBuilder();
    private InternshipItemBuilder internshipItemBuilderWithRequirements = new InternshipItemBuilder()
        .withRequirements(VALID_REQUIREMENT_GRAPHQL, VALID_REQUIREMENT_R);

    @Test
    public void testCardMethod() throws InterruptedException {
        // creates a single JavaFX runtime to test all the method in card.
        // Unable to create multiple platform startup. As such all the methods will be tested inside one platform.

        Thread thread = new Thread(() -> {
            Platform.startup(() -> {});

            // set up Application item card
            Card<ApplicationItem> applicationCardWithStatusApplied =
                new ApplicationCard(applicationItemBuilderStatusApplied.build(), 1);
            Card<ApplicationItem> applicationCardWithStatusAccepted =
                new ApplicationCard(applicationItemBuilderStatusAccepted.build(), 2);
            Card<ApplicationItem> applicationCardWithStatusInterview =
                new ApplicationCard(applicationItemBuilderStatusInterview.build(), 3);
            Card<ApplicationItem> applicationCardWithStatusWaiting =
                new ApplicationCard(applicationItemBuilderStatusWaiting.build(), 4);
            Card<ApplicationItem> applicationCardWithStatusRejected =
                new ApplicationCard(applicationItemBuilderStatusRejected.build(), 5);
            Card<ApplicationItem> applicationCardWithStatusOffered =
                new ApplicationCard(applicationItemBuilderStatusOffered.build(), 6);

            // set up company item card
            Card<CompanyItem> companyCard = new CompanyCard(companyItemBuilder.build(), 1);
            Card<CompanyItem> companyCardWithIndustries = new CompanyCard(companyItemBuilderWithIndustries.build(), 2);

            // set up profile item card
            Card<ProfileItem> profileItemCardWithSkill = new ProfileCard(profileItemBuilderWithSkill.build(), 1);
            Card<ProfileItem> profileItemCardWithExperience = new ProfileCard(
                profileItemBuilderWithExperience.build(), 2);
            Card<ProfileItem> profileItemCardWithAchievement = new ProfileCard(
                profileItemBuilderWithAchievement.build(), 3);

            // set up Internship item card
            Card<InternshipItem> internshipItemCard = new InternshipCard(internshipItemBuilder.build(), 1);
            Card<InternshipItem> internshipItemCardWithRequirements = new InternshipCard(
                internshipItemBuilderWithRequirements.build(), 2);

            /* Test for application card. The 3 methods that are being tested are getItem, getDisplayedIndex
             * and the equals method */

            // test for getItem for application card
            assertEquals(applicationItemBuilderStatusApplied.build(), applicationCardWithStatusApplied.getItem());
            assertEquals(applicationItemBuilderStatusAccepted.build(), applicationCardWithStatusAccepted.getItem());
            assertEquals(applicationItemBuilderStatusInterview.build(), applicationCardWithStatusInterview.getItem());
            assertEquals(applicationItemBuilderStatusWaiting.build(), applicationCardWithStatusWaiting.getItem());
            assertEquals(applicationItemBuilderStatusRejected.build(), applicationCardWithStatusRejected.getItem());
            assertEquals(applicationItemBuilderStatusOffered.build(), applicationCardWithStatusOffered.getItem());

            // test for getDisplayedIndex for application card
            assertEquals(1, applicationCardWithStatusApplied.getDisplayedIndex());
            assertEquals(2, applicationCardWithStatusAccepted.getDisplayedIndex());
            assertEquals(3, applicationCardWithStatusInterview.getDisplayedIndex());
            assertEquals(4, applicationCardWithStatusWaiting.getDisplayedIndex());
            assertEquals(5, applicationCardWithStatusRejected.getDisplayedIndex());
            assertEquals(6, applicationCardWithStatusOffered.getDisplayedIndex());

            // test equals for application card

            // same value -> return true
            assertTrue(applicationCardWithStatusApplied.equals(
                new ApplicationCard(applicationItemBuilderStatusApplied.build(), 1)));
            assertTrue(applicationCardWithStatusAccepted.equals(
                new ApplicationCard(applicationItemBuilderStatusAccepted.build(), 2)));
            assertTrue(applicationCardWithStatusInterview.equals(
                new ApplicationCard(applicationItemBuilderStatusInterview.build(), 3)));
            assertTrue(applicationCardWithStatusWaiting.equals(
                new ApplicationCard(applicationItemBuilderStatusWaiting.build(), 4)));
            assertTrue(applicationCardWithStatusRejected.equals(
                new ApplicationCard(applicationItemBuilderStatusRejected.build(), 5)));
            assertTrue(applicationCardWithStatusOffered.equals(
                new ApplicationCard(applicationItemBuilderStatusOffered.build(), 6)));

            // same object -> return true
            assertTrue(applicationCardWithStatusApplied.equals(applicationCardWithStatusApplied));
            assertTrue(applicationCardWithStatusAccepted.equals(applicationCardWithStatusAccepted));
            assertTrue(applicationCardWithStatusInterview.equals(applicationCardWithStatusInterview));
            assertTrue(applicationCardWithStatusWaiting.equals(applicationCardWithStatusWaiting));
            assertTrue(applicationCardWithStatusRejected.equals(applicationCardWithStatusRejected));
            assertTrue(applicationCardWithStatusOffered.equals(applicationCardWithStatusOffered));

            // null -> return false
            assertFalse(applicationCardWithStatusApplied.equals(null));
            assertFalse(applicationCardWithStatusAccepted.equals(null));
            assertFalse(applicationCardWithStatusInterview.equals(null));
            assertFalse(applicationCardWithStatusWaiting.equals(null));
            assertFalse(applicationCardWithStatusRejected.equals(null));
            assertFalse(applicationCardWithStatusOffered.equals(null));

            // different type -> return false
            assertFalse(applicationCardWithStatusApplied.equals(0.5f));
            assertFalse(applicationCardWithStatusAccepted.equals(0.5f));
            assertFalse(applicationCardWithStatusInterview.equals(0.5f));
            assertFalse(applicationCardWithStatusWaiting.equals(0.5f));
            assertFalse(applicationCardWithStatusRejected.equals(0.5f));
            assertFalse(applicationCardWithStatusOffered.equals(0.5f));

            /* Test for company card. The 3 methods that are being tested are getItem, getDisplayedIndex
             * and the equals method */

            // test for getItem for company card
            assertEquals(companyItemBuilder.build(), companyCard.getItem());
            assertEquals(companyItemBuilderWithIndustries.build(), companyCardWithIndustries.getItem());

            // test for getDisplayedIndex for company card
            assertEquals(1, companyCard.getDisplayedIndex());
            assertEquals(2, companyCardWithIndustries.getDisplayedIndex());

            // test equals for company card

            // same value -> return true
            assertTrue(companyCard.equals(new CompanyCard(companyItemBuilder.build(), 1)));
            assertTrue(companyCardWithIndustries.equals(new CompanyCard(companyItemBuilderWithIndustries.build(), 2)));

            // same object -> return true
            assertTrue(companyCard.equals(companyCard));
            assertTrue(companyCardWithIndustries.equals(companyCardWithIndustries));

            // null -> return false
            assertFalse(companyCard.equals(null));
            assertFalse(companyCardWithIndustries.equals(null));

            // different type -> return false
            assertFalse(companyCard.equals(0.5f));
            assertFalse(companyCardWithIndustries.equals(0.5f));

            /* Test for profile card. The 3 methods that are being tested are getItem, getDisplayedIndex
             * and the equals method */

            // test for getItem for profile card
            assertEquals(profileItemBuilderWithSkill.build(), profileItemCardWithSkill.getItem());
            assertEquals(profileItemBuilderWithExperience.build(), profileItemCardWithExperience.getItem());
            assertEquals(profileItemBuilderWithAchievement.build(), profileItemCardWithAchievement.getItem());

            // test for getDisplayedIndex for profile card
            assertEquals(1, profileItemCardWithSkill.getDisplayedIndex());
            assertEquals(2, profileItemCardWithExperience.getDisplayedIndex());
            assertEquals(3, profileItemCardWithAchievement.getDisplayedIndex());

            // test equals for profile card

            // same value -> return true
            assertTrue(profileItemCardWithSkill.equals(new ProfileCard(profileItemBuilderWithSkill.build(), 1)));
            assertTrue(profileItemCardWithExperience.equals(new ProfileCard(profileItemBuilderWithExperience.build(),
                2)));
            assertTrue(profileItemCardWithAchievement.equals(new ProfileCard(profileItemBuilderWithAchievement.build(),
                3)));

            // same object -> return true
            assertTrue(profileItemCardWithSkill.equals(profileItemCardWithSkill));
            assertTrue(profileItemCardWithExperience.equals(profileItemCardWithExperience));
            assertTrue(profileItemCardWithAchievement.equals(profileItemCardWithAchievement));

            // null -> false
            assertFalse(profileItemCardWithSkill.equals(null));
            assertFalse(profileItemCardWithExperience.equals(null));
            assertFalse(profileItemCardWithAchievement.equals(null));

            // different type -> false
            assertFalse(profileItemCardWithSkill.equals(0.5f));
            assertFalse(profileItemCardWithExperience.equals(0.5f));
            assertFalse(profileItemCardWithAchievement.equals(0.5f));

            /* Test for internship card. The 3 methods that are being tested are getItem, getDisplayedIndex
             * and the equals method */

            // test for getItem for internship card
            assertEquals(internshipItemBuilder.build(), internshipItemCard.getItem());
            assertEquals(internshipItemBuilderWithRequirements.build(), internshipItemCardWithRequirements.getItem());

            // test for getDisplayedIndex for internship card
            assertEquals(1, internshipItemCard.getDisplayedIndex());
            assertEquals(2, internshipItemCardWithRequirements.getDisplayedIndex());

            // test for equals for internship card

            // same value -> return true
            assertTrue(internshipItemCard.equals(new InternshipCard(internshipItemBuilder.build(), 1)));
            assertTrue(internshipItemCardWithRequirements.equals(
                new InternshipCard(internshipItemBuilderWithRequirements.build(), 2)));

            // same object -> return true
            assertTrue(internshipItemCard.equals(internshipItemCard));
            assertTrue(internshipItemCardWithRequirements.equals(internshipItemCardWithRequirements));

            // null -> false
            assertFalse(internshipItemCard.equals(null));
            assertFalse(internshipItemCardWithRequirements.equals(null));

            // different type -> false
            assertFalse(internshipItemCard.equals(0.5f));
            assertFalse(internshipItemCardWithRequirements.equals(0.5f));

            Platform.exit();
        });

        thread.start();
    }
}
