package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.util.DateUtil.isDateFormat;
import static seedu.address.model.util.DateUtil.isDateTimeFormat;

import org.junit.jupiter.api.Test;

public class DateUtilTest {

    /**
     * DATE_TIME FORMATS
     */
    private static final String VALID_DATE_TIME_ONE = "18-9-20 2240";
    private static final String VALID_DATE_TIME_TWO = "9-09-20 0000";
    private static final String INVALID_DATE_TIME_ONE = "18-9-20   2240";
    private static final String INVALID_DATE_TIME_TWO = "9-09-20 00 00";

    /**
     * DATE FORMATS
     */
    private static final String VALID_DATE_ONE = "18-9-20";
    private static final String VALID_DATE_TWO = "9-09-20";
    private static final String INVALID_DATE_ONE = "20-09-20 ";
    private static final String INVALID_DATE_TWO = " 9-09-20";

    @Test
    public void isDateTimeFormat_validFormats_success() {
        assertTrue(isDateTimeFormat(VALID_DATE_TIME_ONE));
        assertTrue(isDateTimeFormat(VALID_DATE_TIME_TWO));
    }

    @Test
    public void isDateTimeFormat_invalidFormats_success() {
        assertFalse(isDateTimeFormat(INVALID_DATE_TIME_ONE));
        assertFalse(isDateTimeFormat(INVALID_DATE_TIME_TWO));
        assertFalse(isDateTimeFormat(VALID_DATE_ONE));
        assertFalse(isDateTimeFormat(VALID_DATE_TWO));
    }

    @Test
    public void isDateFormat_validFormats_success() {
        assertTrue(isDateFormat(VALID_DATE_ONE));
        assertTrue(isDateFormat(VALID_DATE_TWO));
    }

    @Test
    public void isDateFormat_invalidFormats_success() {
        assertFalse(isDateFormat(INVALID_DATE_ONE));
        assertFalse(isDateFormat(INVALID_DATE_TWO));
        assertFalse(isDateFormat(VALID_DATE_TIME_ONE));
        assertFalse(isDateFormat(VALID_DATE_TIME_TWO));
    }


    @Test
    public void convertToDateTime() {

    }

    @Test
    public void convertOutputFormat() {
    }

    @Test
    public void isValidOutputDate() {
    }

    @Test
    public void formatterDateTime() {
    }

    @Test
    public void extractDayAndMonth() {
    }

}
