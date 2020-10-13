package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class WageTest {

    private static final String INVALID_WAGE_ZERO = "0";
    private static final String INVALID_WAGE_NEGATIVE = "-5";
    private static final String INVALID_WAGE_DECIMAL = "3555.4";
    private static final String VALID_WAGE_THOUSAND = "1000";
    private static final String EXPECTED_WAGE_THOUSAND = "$1000";

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Wage(null));
    }

    @Test
    public void constructor_invalidWage_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Wage(INVALID_WAGE_ZERO));
        assertThrows(IllegalArgumentException.class, () -> new Wage(INVALID_WAGE_NEGATIVE));
        assertThrows(IllegalArgumentException.class, () -> new Wage(INVALID_WAGE_DECIMAL));
    }

    @Test
    public void toString_validFormats_success() {
        Wage wage1 = new Wage(VALID_WAGE_THOUSAND);
        assertEquals(EXPECTED_WAGE_THOUSAND, wage1.toString());
    }

    @Test
    public void equals_equalityTest_success() {
        Wage wage1 = new Wage(VALID_WAGE_THOUSAND);
        Wage wage2 = new Wage(VALID_WAGE_THOUSAND);
        assertEquals(wage1, wage2);
    }

    @Test
    public void hashCode_equalityTest_success() {
        Wage wage1 = new Wage(VALID_WAGE_THOUSAND);
        Wage wage2 = new Wage(VALID_WAGE_THOUSAND);
        assertEquals(wage1.hashCode(), wage2.hashCode());
    }

}
