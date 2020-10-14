package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class JobTitleTest {

    private static final String INVALID_JOB_TITLE_ONE = "Software - Engineer";
    private static final String INVALID_JOB_TITLE_TWO = " ";
    private static final String VALID_JOB_TITLE = "Software Engineer";


    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new JobTitle(null));
    }

    @Test
    public void constructor_invalidJobTitle_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new JobTitle(INVALID_JOB_TITLE_ONE));
        assertThrows(IllegalArgumentException.class, () -> new JobTitle(INVALID_JOB_TITLE_TWO));
    }

    @Test
    public void toString_validFormats_success() {
        JobTitle jobTitle1 = new JobTitle(VALID_JOB_TITLE);
        assertEquals(VALID_JOB_TITLE, jobTitle1.toString());
    }

    @Test
    public void equals_equalityTest_success() {
        JobTitle jobTitle1 = new JobTitle(VALID_JOB_TITLE);
        JobTitle jobTitle2 = new JobTitle(VALID_JOB_TITLE);
        assertEquals(jobTitle1, jobTitle2);
    }

    @Test
    public void hashCode_equalityTest_success() {
        JobTitle jobTitle1 = new JobTitle(VALID_JOB_TITLE);
        JobTitle jobTitle2 = new JobTitle(VALID_JOB_TITLE);
        assertEquals(jobTitle1.hashCode(), jobTitle2.hashCode());
    }

}
