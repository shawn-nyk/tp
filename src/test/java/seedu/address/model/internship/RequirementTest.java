package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RequirementTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Requirement(null));
    }

    @Test
    public void constructor_invalidRequirement_throwsIllegalArgumentException() {
        String invalidName = "   ";
        assertThrows(IllegalArgumentException.class, () -> new Requirement(invalidName));
        String invalidName2 = "";
        assertThrows(IllegalArgumentException.class, () -> new Requirement(invalidName2));
    }

    @Test
    public void toString_validFormats_success() {
        Requirement period1 = new Requirement("React Native");
        assertEquals("React Native", period1.toString());
    }

    @Test
    public void equals_equalityTest_success() {
        Requirement period1 = new Requirement("React Native");
        Requirement period2 = new Requirement("React Native");
        assertEquals(period1, period2);
    }

    @Test
    public void hashCode_equalityTest_success() {
        Requirement period1 = new Requirement("React Native");
        Requirement period2 = new Requirement("React Native");
        assertEquals(period1.hashCode(), period2.hashCode());
    }

}
