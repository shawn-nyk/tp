package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
    
    @Test
    public void getTitle_true_success() {
        assertTrue(TitleDescription.createTitleDescription("Hello", "World").getTitle().getText().equals("Hello"));
        assertTrue(TitleDescription.createTitleDescription("Title", "World").getTitle().getText().equals("Title"));
    }

    @Test
    public void getTitle_false_success() {
        assertFalse(TitleDescription.createTitleDescription("Hello", "World").getTitle().getText().equals("Title"));
        assertFalse(TitleDescription.createTitleDescription("Title", "World").getTitle().getText().equals("Hello"));
    }

    @Test
    public void getDescription_true_success() {
        assertTrue(TitleDescription.createTitleDescription("Hello", "World").getDescription().getText().equals("World"));
        assertTrue(TitleDescription.createTitleDescription("Hello", "Description").getDescription().getText().equals("Description"));
    }

    @Test
    public void getDescription_false_success() {
        assertFalse(TitleDescription.createTitleDescription("Hello", "Description").getDescription().getText().equals("World"));
        assertFalse(TitleDescription.createTitleDescription("Hello", "World").getDescription().getText().equals("Description"));
    }
}
