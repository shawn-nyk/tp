package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PeriodTest {

    private static final String INVALID_PERIOD_EMPTY = "";
    private static final String INVALID_PERIOD_SPACES = "   ";
    private static final String VALID_PERIOD = "3 months, summer break";

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Period(null));
    }

    @Test
    public void constructor_invalidPeriod_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Period(INVALID_PERIOD_EMPTY));
        assertThrows(IllegalArgumentException.class, () -> new Period(INVALID_PERIOD_SPACES));
    }

    @Test
    public void toString_validFormats_success() {
        Period period1 = new Period(VALID_PERIOD);
        assertEquals(VALID_PERIOD, period1.toString());
    }

    @Test
    public void equals_equalityTest_success() {
        Period period1 = new Period(VALID_PERIOD);
        Period period2 = new Period(VALID_PERIOD);
        assertEquals(period1, period2);
    }

    @Test
    public void hashCode_equalityTest_success() {
        Period period1 = new Period(VALID_PERIOD);
        Period period2 = new Period(VALID_PERIOD);
        assertEquals(period1.hashCode(), period2.hashCode());
    }

}
