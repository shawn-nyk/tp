package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class WageTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Wage(null));
    }

    @Test
    public void constructor_invalidWage_throwsIllegalArgumentException() {
        String invalidWage = "3555.4";
        assertThrows(IllegalArgumentException.class, () -> new Wage(invalidWage));
        String invalidWage2 = "-5";
        assertThrows(IllegalArgumentException.class, () -> new Wage(invalidWage2));
    }

    @Test
    public void toString_validFormats_success() {
        Wage wage1 = new Wage("1000");
        assertEquals("$1000", wage1.toString());
    }

    @Test
    public void equals_equalityTest_success() {
        Wage wage1 = new Wage("2500");
        Wage wage2 = new Wage("2500");
        assertEquals(wage1, wage2);
    }

    @Test
    public void hashCode_equalityTest_success() {
        Wage wage1 = new Wage("2500");
        Wage wage2 = new Wage("2500");
        assertEquals(wage1.hashCode(), wage2.hashCode());
    }

}
