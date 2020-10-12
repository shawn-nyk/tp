package seedu.address.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.SampleApplicationItems.LAZADA_REJECTED;
import static seedu.address.testutil.SampleApplicationItems.SHOPEE_OFFERED;
import static seedu.address.testutil.SampleApplicationItems.STATUS_DATE_MAY;
import static seedu.address.testutil.SampleApplicationItems.STATUS_REJECTED;
import static seedu.address.testutil.SampleInternshipItems.GOLDMAN_DA;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ApplicationItemBuilder;

public class ApplicationItemTest {

    @Test
    public void isSameItem_true_success() {
        // same object -> returns true
        assertTrue(SHOPEE_OFFERED.isSameItem(SHOPEE_OFFERED));

        ApplicationItem editedShopeeOffered;

        // different object, same values -> returns true
        editedShopeeOffered = new ApplicationItemBuilder(SHOPEE_OFFERED).build();
        assertTrue(SHOPEE_OFFERED.isSameItem(editedShopeeOffered));

        // different status, everything else the same -> returns true
        editedShopeeOffered = new ApplicationItemBuilder(SHOPEE_OFFERED).withStatus(STATUS_REJECTED).build();
        assertTrue(SHOPEE_OFFERED.isSameItem(editedShopeeOffered));

        // different status date, everything else the same -> returns true
        editedShopeeOffered = new ApplicationItemBuilder(SHOPEE_OFFERED).withStatusDate(STATUS_DATE_MAY).build();
        assertTrue(SHOPEE_OFFERED.isSameItem(editedShopeeOffered));

    }

    @Test
    public void isSameItem_false_success() {
        // null -> returns false
        assertFalse(SHOPEE_OFFERED.isSameItem(null));

        // Two different applications -> returns false
        assertFalse(SHOPEE_OFFERED.isSameItem(LAZADA_REJECTED));

        // TODO: Two different items -> return false

        // different internship -> returns false
        ApplicationItem editedShopeeOffered = new ApplicationItemBuilder(SHOPEE_OFFERED)
                .withInternshipItem(GOLDMAN_DA).build();
        assertFalse(SHOPEE_OFFERED.isSameItem(editedShopeeOffered));

    }

    @Test
    public void equals_true_success() {
        // same object -> returns true
        assertEquals(SHOPEE_OFFERED, SHOPEE_OFFERED);

        // different object, same values -> returns true
        ApplicationItem shopeeOfferedCopy = new ApplicationItemBuilder(SHOPEE_OFFERED).build();
        assertEquals(shopeeOfferedCopy, SHOPEE_OFFERED);
    }

    @Test
    public void equals_false_success() {
        // null -> returns false
        assertNotEquals(SHOPEE_OFFERED, null);

        // different type -> returns false
        assertNotEquals(SHOPEE_OFFERED, 5);

        // different applicationItem -> returns false
        assertNotEquals(LAZADA_REJECTED, SHOPEE_OFFERED);

        // different internshipItem -> returns false
        ApplicationItem editedShopeeOffered = new ApplicationItemBuilder(SHOPEE_OFFERED)
                .withInternshipItem(GOLDMAN_DA).build();
        assertNotEquals(editedShopeeOffered, SHOPEE_OFFERED);

        // different status -> returns false
        editedShopeeOffered = new ApplicationItemBuilder(SHOPEE_OFFERED).withStatus(STATUS_REJECTED).build();
        assertNotEquals(editedShopeeOffered, SHOPEE_OFFERED);

        // different status date -> returns false
        editedShopeeOffered = new ApplicationItemBuilder(SHOPEE_OFFERED).withStatusDate(STATUS_DATE_MAY).build();
        assertNotEquals(editedShopeeOffered, SHOPEE_OFFERED);

    }

}
