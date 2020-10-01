package seedu.address.model;

/**
 * Signals that the operation will result in duplicate Persons (Persons are considered duplicates if they have the same
 * identity).
 */
public class DuplicateItemException extends RuntimeException {
    public DuplicateItemException(Item item) {
        super(String.format("Operation would result in duplicate %s items", item));
    }
}
