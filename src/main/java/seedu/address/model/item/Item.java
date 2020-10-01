package seedu.address.model.item;

import java.util.LinkedHashMap;

/**
 * Represents an Item in the InternHunter application.
 * There are 4 types of items, InternshipItem, InternshipApplication, CompanyItem, ProfileItem.
 */
public interface Item {

    /**
     * Returns true if both items are the have the same identity fields.
     * This defines a weaker notion of equality between two {@code Items}.
     *
     * @param otherItem Other item to compare to.
     * @return True if and only if the 2 items have the same identity fields.
     */
    boolean isSameItem(Item otherItem);

    /**
     * Obtains the name of the item.
     *
     * @return Item name.
     */
    String getItemName();

    /**
     * Obtains the mapping of all field names to their corresponding fields.
     *
     * @return Mapping of field names to fields for the item.
     */
    LinkedHashMap<String, Object> getMapping();

}
