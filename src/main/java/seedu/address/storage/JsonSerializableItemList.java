package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.item.Item;
import seedu.address.model.item.ItemList;
import seedu.address.model.item.ReadOnlyItemList;
import seedu.address.storage.item.JsonAdaptedItem;

/**
 * An Immutable Item List that is serializable to JSON format.
 */
public class JsonSerializableItemList<T extends Item> {

    public static final String MESSAGE_DUPLICATE_ITEM = "Item list contains duplicate item(s).";

    private final List<JsonAdaptedItem<T>> items = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableItemList} with the given items.
     */
    @JsonCreator
    public JsonSerializableItemList(@JsonProperty("items") List<JsonAdaptedItem<T>> items) {
        this.items.addAll(items);
    }

    /**
     * Converts a given {@code ReadOnlyItemList} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableItemList}.
     */
    public JsonSerializableItemList(ReadOnlyItemList<T> source) {
        items.addAll(source.getItemList().stream().map(t -> (JsonAdaptedItem<T>) t.getJsonAdaptedItem()).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code ItemList<T>} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public ItemList<T> toModelType() throws IllegalValueException {
        ItemList<T> addressBook = new ItemList<>();
        for (JsonAdaptedItem<T> jsonAdaptedItem : items) {
            T item = jsonAdaptedItem.toModelType();
            if (addressBook.hasItem(item)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_ITEM);
            }
            addressBook.addItem(item);
        }
        return addressBook;
    }

}
