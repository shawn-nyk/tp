package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.ui.textstyle.TitleDescription;

public class TitleDescriptionTest {

    private TitleDescription helloDescription;
    private TitleDescription helloWorld;
    private TitleDescription titleWorld;
    //TitleDescription

    @BeforeEach
    public void setUp() {
        helloDescription = TitleDescription.createTitleDescription("Hello", "Description");
        helloWorld = TitleDescription.createTitleDescription("Hello", "World");
        titleWorld = TitleDescription.createTitleDescription("Title", "World");
    }

    @Test
    public void equals() {
        // same values -> returns true
        assertTrue(helloDescription.equals(TitleDescription.createTitleDescription("Hello", "Description")));

        // same object -> returns true
        assertTrue(helloDescription.equals(helloDescription));

        // null -> returns false
        assertFalse(helloDescription.equals(null));

        // different types -> returns false
        assertFalse(helloDescription.equals(0.5f));

        // different title -> returns false
        assertFalse(helloDescription.equals(TitleDescription.createTitleDescription("T", "Description")));

        // different description -> returns false
        assertFalse(helloDescription.equals(TitleDescription.createTitleDescription("Title", "D")));

        // different title and description -> returns false
        assertFalse(helloDescription.equals(TitleDescription.createTitleDescription("HELLO", "WORLD")));
    }

    @Test
    public void getTitle_true_success() {
        assertTrue(helloWorld.getTitle().getText().equals("Hello"));
        assertTrue(titleWorld.getTitle().getText().equals("Title"));
    }

    @Test
    public void getTitle_false_success() {
        assertFalse(helloWorld.getTitle().getText().equals("Title"));
        assertFalse(titleWorld.getTitle().getText().equals("Hello"));
    }

    @Test
    public void getDescription_true_success() {
        assertTrue(helloWorld.getDescription().getText().equals("World"));
        assertTrue(helloDescription.getDescription().getText().equals("Description"));
    }

    @Test
    public void getDescription_false_success() {
        assertFalse(helloDescription.getDescription().getText().equals("World"));
        assertFalse(helloWorld.getDescription().getText().equals("Description"));
    }
}
