package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.internship.InternshipItemUtil.VALID_COMPANY_NAME_SINGTEL;
import static seedu.address.model.internship.InternshipItemUtil.VALID_JOB_TITLE_SINGTEL;
import static seedu.address.model.internship.InternshipItemUtil.VALID_PERIOD_SINGTEL;
import static seedu.address.model.internship.InternshipItemUtil.VALID_REQUIREMENT_R;
import static seedu.address.model.internship.InternshipItemUtil.VALID_REQUIREMENT_VUE;
import static seedu.address.model.internship.InternshipItemUtil.VALID_WAGE_SINGTEL;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.SampleInternshipItems.LAZADA_DS;
import static seedu.address.testutil.SampleInternshipItems.SHOPEE_SWE;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.InternshipItemBuilder;

public class InternshipItemTest {

    @Test
    public void requirements_invalidDataType_throwsUnsupportedOperationException() {
        InternshipItem internshipItem = new InternshipItemBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> internshipItem.getRequirements().remove(0));
    }

    @Test
    public void isSameItem_true_success() {
        // same object -> returns true
        assertTrue(SHOPEE_SWE.isSameItem(SHOPEE_SWE));

        InternshipItem editedShopeeSwe;

        // different object, same values -> returns true
        editedShopeeSwe = new InternshipItemBuilder(SHOPEE_SWE).build();
        assertTrue(SHOPEE_SWE.isSameItem(editedShopeeSwe));

        // different wage, everything else the same -> returns true
        editedShopeeSwe = new InternshipItemBuilder(SHOPEE_SWE).withWage(VALID_WAGE_SINGTEL).build();
        assertTrue(SHOPEE_SWE.isSameItem(editedShopeeSwe));

        // different requirements, everything else the same -> returns true
        editedShopeeSwe = new InternshipItemBuilder(SHOPEE_SWE).withRequirements(VALID_REQUIREMENT_R,
                VALID_REQUIREMENT_VUE).build();
        assertTrue(SHOPEE_SWE.isSameItem(editedShopeeSwe));

    }

    @Test
    public void isSameItem_false_success() {
        // null -> returns false
        assertFalse(SHOPEE_SWE.isSameItem(null));

        // Two different internships -> returns false
        assertFalse(SHOPEE_SWE.isSameItem(LAZADA_DS));

        // TODO: Two different items -> return false

        // different company -> returns false
        InternshipItem editedShopeeSwe = new InternshipItemBuilder(SHOPEE_SWE)
                .withCompanyName(VALID_COMPANY_NAME_SINGTEL).build();
        assertFalse(SHOPEE_SWE.isSameItem(editedShopeeSwe));

        // different job title -> returns false
        editedShopeeSwe = new InternshipItemBuilder(SHOPEE_SWE).withJobTitle(VALID_JOB_TITLE_SINGTEL).build();
        assertFalse(SHOPEE_SWE.isSameItem(editedShopeeSwe));

        // different period -> returns false
        editedShopeeSwe = new InternshipItemBuilder(SHOPEE_SWE).withPeriod(VALID_PERIOD_SINGTEL).build();
        assertFalse(SHOPEE_SWE.isSameItem(editedShopeeSwe));

    }

    public void equals_true_success() {
        // same object -> returns true
        assertEquals(SHOPEE_SWE, SHOPEE_SWE);

        // different object, same values -> returns true
        InternshipItem shopeeSweCopy = new InternshipItemBuilder(SHOPEE_SWE).build();
        assertEquals(shopeeSweCopy, SHOPEE_SWE);
    }

    @Test
    public void equals_false_success() {
        // null -> returns false
        assertNotEquals(SHOPEE_SWE, null);

        // different type -> returns false
        assertNotEquals(SHOPEE_SWE, 5);

        // TODO: Two different items -> return false

        // different internshipItem -> returns false
        assertNotEquals(LAZADA_DS, SHOPEE_SWE);

        // different company name -> returns false
        InternshipItem editedShopeeSwe = new InternshipItemBuilder(SHOPEE_SWE)
                .withCompanyName(VALID_PERIOD_SINGTEL).build();
        assertNotEquals(editedShopeeSwe, SHOPEE_SWE);

        // different job title -> returns false
        editedShopeeSwe = new InternshipItemBuilder(SHOPEE_SWE).withJobTitle(VALID_JOB_TITLE_SINGTEL).build();
        assertNotEquals(editedShopeeSwe, SHOPEE_SWE);

        // different period -> returns false
        editedShopeeSwe = new InternshipItemBuilder(SHOPEE_SWE).withPeriod(VALID_PERIOD_SINGTEL).build();
        assertNotEquals(editedShopeeSwe, SHOPEE_SWE);

        // different wage -> returns false
        editedShopeeSwe = new InternshipItemBuilder(SHOPEE_SWE).withWage(VALID_WAGE_SINGTEL).build();
        assertNotEquals(editedShopeeSwe, SHOPEE_SWE);

        // different requirements -> returns false
        editedShopeeSwe = new InternshipItemBuilder(SHOPEE_SWE).withRequirements(VALID_REQUIREMENT_R).build();
        assertNotEquals(editedShopeeSwe, SHOPEE_SWE);
    }

}
