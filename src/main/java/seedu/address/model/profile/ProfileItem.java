package seedu.address.model.profile;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.util.ItemUtil.PROFILE_NAME;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.item.Item;
import seedu.address.storage.item.JsonAdaptedItem;
import seedu.address.storage.person.JsonAdaptedPerson;

/**
 * Represents a Profile Item in the UserProfile.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class ProfileItem extends Item {

    // Identity fields
    private final Title title;
    private final ProfileItemType type;

    // Data fields
    private final Set<Descriptor> descriptors = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public ProfileItem(Title title, ProfileItemType type, Set<Descriptor> descriptors) {
        requireAllNonNull(type, title, descriptors);
        this.type = type;
        this.title = title;
        this.descriptors.addAll(descriptors);
    }


    public Title getTitle() {
        return title;
    }

    public ProfileItemType getType() {
        return type;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Descriptor> getDescriptors() {
        return Collections.unmodifiableSet(descriptors);
    }

    /**
     * Returns true if both items are the have the same name and type.
     * This defines a weaker notion of equality between two ProfileItemObjects.
     *
     * @param otherItem item to compare to.
     * @return True if and only if the 2 items have the same identity fields.
     */
    @Override
    public boolean isSameItem(Item otherItem) {
        if (otherItem == this) {
            return true;
        }

        if (!(otherItem instanceof ProfileItem)) {
            return false;
        }

        ProfileItem otherProfileItem = (ProfileItem) otherItem;

        return otherItem != null
                && otherProfileItem.getType().equals(getType())
                && (otherProfileItem.getTitle().equals(getTitle()));
    }

    /**
     * Returns true if both profile item have the same data fields and descriptors.
     * This defines a stronger notion of equality between two ProfileItem objects.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ProfileItem)) {
            return false;
        }
        ProfileItem otherProfileItem = (ProfileItem) other;
        return otherProfileItem != null
                && otherProfileItem.getType().equals(getType())
                && (otherProfileItem.getTitle().equals(getTitle()))
                && (otherProfileItem.getDescriptors().equals(getDescriptors()));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, type, descriptors);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(" Type: ")
                .append(getType())
                .append(" Descriptors: ");
        getDescriptors().forEach(builder::append);
        return builder.toString();
    }


    /**
     * Obtains the name of the item.
     *
     * @return Item name.
     */
    @Override
    public String getItemName() {
        return PROFILE_NAME;
    }

    /**
     * Obtains the mapping of all field names to their corresponding fields.
     *
     * @return Mapping of field names to fields for the ProfileItem.
     */
    @Override
    public LinkedHashMap<String, Object> getMapping() {
        LinkedHashMap<String, Object> mapping = new LinkedHashMap<>();
        mapping.put("Title", title);
        mapping.put("Type", type);
        mapping.put("Descriptors", descriptors);
        return mapping;
    }

    @Override
    public JsonAdaptedItem getJsonAdaptedItem() {
        return null;
    }
}

