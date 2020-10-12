package seedu.address.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.commons.util.StringUtil;

public class StatusTest {

    static final String BLANK_STATUS = "";
    static final String VALID_STATUS = "APPLIED";
    static final String INVALID_STATUS = "DEAD";

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Status.valueOf(null));
    }

    @Test
    public void constructor_invalidStatus_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Status.valueOf(BLANK_STATUS));
        assertThrows(IllegalArgumentException.class, () -> Status.valueOf(INVALID_STATUS));
    }

    @Test
    public void toString_validFormats_success() {
        Status status1 = Status.valueOf(VALID_STATUS);
        assertEquals(StringUtil.toTitleCase(VALID_STATUS), status1.toString());
    }

    @Test
    public void equals_equalityTest_success() {
        Status status1 = Status.valueOf(VALID_STATUS);
        Status status2 = Status.valueOf(VALID_STATUS);
        assertEquals(status1, status2);
    }

    @Test
    public void hashCode_equalityTest_success() {
        Status status1 = Status.valueOf(VALID_STATUS);
        Status status2 = Status.valueOf(VALID_STATUS);
        assertEquals(status1.hashCode(), status2.hashCode());
    }
    
}
