package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PeriodTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Period(null));
    }

    @Test
    public void constructor_invalidPeriod_throwsIllegalArgumentException() {
        String invalidPeriod = "   ";
        assertThrows(IllegalArgumentException.class, () -> new Period(invalidPeriod));
        String invalidPeriod2 = "";
        assertThrows(IllegalArgumentException.class, () -> new Period(invalidPeriod2));
    }

    @Test
    public void toString_validFormats_success() {
        Period period1 = new Period("3 months, summer break");
        assertEquals("3 months, summer break", period1.toString());
    }

    @Test
    public void equals_equalityTest_success() {
        Period period1 = new Period("Sunday");
        Period period2 = new Period("Sunday");
        assertEquals(period1, period2);
    }

    @Test
    public void hashCode_equalityTest_success() {
        Period period1 = new Period("Sunday");
        Period period2 = new Period("Sunday");
        assertEquals(period1.hashCode(), period2.hashCode());
    }

}
