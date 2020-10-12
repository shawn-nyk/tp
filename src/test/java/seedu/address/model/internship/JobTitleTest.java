package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class JobTitleTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new JobTitle(null));
    }

    @Test
    public void constructor_invalidJobTitle_throwsIllegalArgumentException() {
        String invalidJobTitle = "Software - Engineer";
        assertThrows(IllegalArgumentException.class, () -> new JobTitle(invalidJobTitle));
        String invalidJobTitle2 = " ";
        assertThrows(IllegalArgumentException.class, () -> new JobTitle(invalidJobTitle2));
    }

    @Test
    public void toString_validFormats_success() {
        JobTitle jobTitle1 = new JobTitle("Software Engineer");
        assertEquals("Software Engineer", jobTitle1.toString());
    }

    @Test
    public void equals_equalityTest_success() {
        JobTitle jobTitle1 = new JobTitle("Software Engineer");
        JobTitle jobTitle2 = new JobTitle("Software Engineer");
        assertEquals(jobTitle1, jobTitle2);
    }

    @Test
    public void hashCode_equalityTest_success() {
        JobTitle jobTitle1 = new JobTitle("Software Engineer");
        JobTitle jobTitle2 = new JobTitle("Software Engineer");
        assertEquals(jobTitle1.hashCode(), jobTitle2.hashCode());
    }

}
