package seedu.address.model.application;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.util.ItemUtil.APPLICATION_NAME;

import java.util.LinkedHashMap;
import java.util.Objects;

import seedu.address.model.internship.InternshipItem;
import seedu.address.model.item.Item;
import seedu.address.storage.item.JsonAdaptedItem;

/**
 * Represents an ApplicationItem in the InternHunter application.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class ApplicationItem extends Item {

    // Identity fields
    private final InternshipItem internshipItem;

    // Data fields
    private final InternshipStatus internshipStatus;
    private final StatusDate statusDate;

    /**
     * Every field must be present and not null.
     */
    public ApplicationItem(InternshipItem internshipItem, InternshipStatus internshipStatus,
            StatusDate statusDate) {

        requireAllNonNull(internshipItem, internshipStatus, statusDate);
        this.internshipItem = internshipItem;
        this.internshipStatus = internshipStatus;
        this.statusDate = statusDate;
    }

    public InternshipItem getInternshipItem() {
        return internshipItem;
    }

    public InternshipStatus getInternshipStatus() {
        return internshipStatus;
    }

    public StatusDate getStatusDate() {
        return statusDate;
    }

    /**
     * Obtains the name of the item.
     *
     * @return Item name.
     */
    @Override
    public String getItemName() {
        return APPLICATION_NAME;
    }

    /**
     * Obtains the mapping of all field names to their corresponding fields.
     *
     * @return Mapping of field names to fields for the ApplicationItem object.
     */
    public LinkedHashMap<String, Object> getMapping() {
        LinkedHashMap<String, Object> mapping = internshipItem.getMapping();
        mapping.put("Status", internshipStatus);
        mapping.put("Date", statusDate);
        return mapping;
    }

    /**
     * Returns true if both InternshipApplications have the {@code InternshipItem}.
     * This defines a weaker notion of equality between two ApplicationItem objects.
     *
     * @param otherItem Other ApplicationItem to compare to.
     * @return True if and only if the 2 InternshipApplications have the same identity field.
     */
    @Override
    public boolean isSameItem(Item otherItem) {
        if (otherItem == this) {
            return true;
        }

        if (!(otherItem instanceof ApplicationItem)) {
            return false;
        }

        ApplicationItem otherApplication = (ApplicationItem) otherItem;
        return otherApplication.getInternshipItem().equals(getInternshipItem());
    }

    /**
     * Returns true if both InternshipApplications have the same data fields.
     * This defines a stronger notion of equality between two ApplicationItem objects.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ApplicationItem)) {
            return false;
        }

        ApplicationItem otherApplication = (ApplicationItem) other;
        return otherApplication.getInternshipItem().equals(getInternshipItem())
                && otherApplication.getInternshipStatus().equals(getInternshipStatus())
                && otherApplication.getStatusDate().equals(getStatusDate());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(internshipItem, internshipStatus, statusDate);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getInternshipItem())
                .append(" Status: ")
                .append(getInternshipStatus())
                .append(" Date: ")
                .append(getStatusDate());
        return builder.toString();
    }

    @Override
    public JsonAdaptedItem<? extends Item> getJsonAdaptedItem() {
        return null;
    }

}
