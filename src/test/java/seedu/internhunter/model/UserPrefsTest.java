package seedu.internhunter.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.internhunter.testutil.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserPrefsTest {

    private UserPrefs userPrefs;

    @BeforeEach
    public void setUp() {
        userPrefs = new UserPrefs();
    }

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> userPrefs.setGuiSettings(null));
    }

    @Test
    public void setApplicationItemListFilePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> userPrefs.setApplicationItemListFilePath(null));
    }

    @Test
    public void setCompanyItemListFilePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> userPrefs.setCompanyItemListFilePath(null));
    }

    @Test
    public void setProfileItemListFilePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> userPrefs.setProfileItemListFilePath(null));
    }

    @Test
    public void hashCode_equals() {
        assertEquals(userPrefs.hashCode(), userPrefs.hashCode());
    }

    @Test
    public void equals() {
        // same object -> return true
        assertTrue(userPrefs.equals(userPrefs));

        // null -> return false
        assertFalse(userPrefs.equals(null));

        // different Types -> return false
        assertFalse(userPrefs.equals(0.5f));
    }

}
