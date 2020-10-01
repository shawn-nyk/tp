package seedu.address.model;

/**
 * Represents an Item in the InternHunter application.
 * There are 3 types of items, InternshipItem, CompanyItem, ProfileItem.
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

}
