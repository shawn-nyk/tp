package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RequirementTest {

    private static final String VALID_REQUIREMENT = "React Native";
    private static final String INVALID_REQUIREMENT_EMPTY = "";
    private static final String INVALID_REQUIREMENT_SPACES = "   ";

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Requirement(null));
    }

    @Test
    public void constructor_invalidRequirement_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Requirement(INVALID_REQUIREMENT_EMPTY));
        assertThrows(IllegalArgumentException.class, () -> new Requirement(INVALID_REQUIREMENT_SPACES));
    }

    @Test
    public void toString_validFormats_success() {
        Requirement period1 = new Requirement(VALID_REQUIREMENT);
        assertEquals(VALID_REQUIREMENT, period1.toString());
    }

    @Test
    public void equals_equalityTest_success() {
        Requirement period1 = new Requirement(VALID_REQUIREMENT);
        Requirement period2 = new Requirement(VALID_REQUIREMENT);
        assertEquals(period1, period2);
    }

    @Test
    public void hashCode_equalityTest_success() {
        Requirement period1 = new Requirement(VALID_REQUIREMENT);
        Requirement period2 = new Requirement(VALID_REQUIREMENT);
        assertEquals(period1.hashCode(), period2.hashCode());
    }

}
