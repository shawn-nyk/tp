package seedu.address.model;

/**
 * Signals that the operation is unable to find the specified item.
 */
public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Item item) {
        super(String.format("Not able to find this %s item", item.getItemName()));
    }
}
