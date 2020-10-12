package seedu.address.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.model.util.DateUtil.DATE_TIME_LONG_FORMAT;
import static seedu.address.model.util.DateUtil.formatterDateTime;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.util.DateUtil;

public class StatusDateTest {

    static final String BLANK_STATUS_DATE = "";
    static final String VALID_STATUS_DATE = "15-7-20";
    static final String INVALID_STATUS_DATE = "Monday";

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new StatusDate(null));
    }

    @Test
    public void constructor_invalidStatusDate_throwsAssertionError() {
        assertThrows(AssertionError.class,
                () -> new StatusDate(DateUtil.convertToDateTime(BLANK_STATUS_DATE)));
        assertThrows(AssertionError.class,
                () -> new StatusDate(DateUtil.convertToDateTime(INVALID_STATUS_DATE)));
    }

    @Test
    public void toString_validFormats_success() {
        StatusDate statusDate1 = new StatusDate(DateUtil.convertToDateTime(VALID_STATUS_DATE));
        assertNotEquals(null, DateUtil.convertToDateTime(VALID_STATUS_DATE));
        assertEquals(DateUtil.convertToDateTime(VALID_STATUS_DATE).format(formatterDateTime(DATE_TIME_LONG_FORMAT)),
                statusDate1.toString());
    }

    @Test
    public void equals_equalityTest_success() {
        StatusDate statusDate1 = new StatusDate(DateUtil.convertToDateTime(VALID_STATUS_DATE));
        StatusDate statusDate2 = new StatusDate(DateUtil.convertToDateTime(VALID_STATUS_DATE));
        assertEquals(statusDate1, statusDate2);
    }

    @Test
    public void hashCode_equalityTest_success() {
        StatusDate statusDate1 = new StatusDate(DateUtil.convertToDateTime(VALID_STATUS_DATE));
        StatusDate statusDate2 = new StatusDate(DateUtil.convertToDateTime(VALID_STATUS_DATE));
        assertEquals(statusDate1.hashCode(), statusDate2.hashCode());
    }

}
