package seedu.address.storage.item;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.item.Item;

/*
    Represents a Jackson-friendly version  of an item.
 */
public interface JsonAdaptedItem<T> {

    /**
     * Converts this Jackson-friendly adapted item object into the model's {@code Item} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted item.
     */
    T toModelType() throws IllegalValueException;
}
