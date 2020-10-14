package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.ui.textstyle.TitleDescription;

public class TitleDescriptionTest {

    @Test
    public void equals() {
        TitleDescription titleDescription = TitleDescription.createTitleDescription("Title", "Description");

        // same values -> returns true
        assertTrue(titleDescription.equals(TitleDescription.createTitleDescription("Title", "Description")));

        // same object -> returns true
        assertTrue(titleDescription.equals(titleDescription));

        // null -> returns false
        assertFalse(titleDescription.equals(null));

        // different types -> returns false
        assertFalse(titleDescription.equals(0.5f));

        // different title -> returns false
        assertFalse(titleDescription.equals(TitleDescription.createTitleDescription("T", "Description")));

        // different description -> returns false
        assertFalse(titleDescription.equals(TitleDescription.createTitleDescription("Title", "D")));

        // different title and description -> returns false
        assertFalse(titleDescription.equals(TitleDescription.createTitleDescription("HELLO", "WORLD")));
    }
}
