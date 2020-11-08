package seedu.internhunter.model.application;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ApplicationNameContainsKeyWordsPredicateTest {

    ApplicationNameContainsKeyWordsPredicate applicationNameContainsKeyWordsPredicate =
        new ApplicationNameContainsKeyWordsPredicate(List.of("test"));

    @Test
    public void equals() {

        // same object -> return true
        assertTrue(applicationNameContainsKeyWordsPredicate.equals(applicationNameContainsKeyWordsPredicate));

        // same value -> return true
        assertTrue(applicationNameContainsKeyWordsPredicate.equals(
            new ApplicationNameContainsKeyWordsPredicate(List.of("test"))));

        // null -> return false
        assertFalse(applicationNameContainsKeyWordsPredicate.equals(null));

        // different types -> return false
        assertFalse(applicationNameContainsKeyWordsPredicate.equals(0.5f));

        // different value -> return false
        assertFalse(applicationNameContainsKeyWordsPredicate.equals(
            new ApplicationNameContainsKeyWordsPredicate(List.of("test2"))));
    }
}
