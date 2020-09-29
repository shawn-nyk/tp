package seedu.address.model.profile;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Profile Item in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class ProfileItem {

    // Identity fields
    private final String title;
    private final String type;
    
    // Data fields
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public ProfileItem(String title,  String type, Set<Tag> tags) {
        requireAllNonNull(type, title, tags);
        this.type = type;
        this.title = title;
        this.tags.addAll(tags);
    }


    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both profiles of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSameProfileItem(seedu.address.model.profile.ProfileItem otherProfileItem) {
        if (otherProfileItem == this) {
            return true;
        }

        return otherProfileItem != null
                && otherProfileItem.getType().equals(getType())
                && (otherProfileItem.getTitle().equals(getTitle()));
    }

    /**
     * Returns true if both profile item have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof seedu.address.model.profile.ProfileItem)) {
            return false;
        }
        seedu.address.model.profile.ProfileItem otherProfileItem = (seedu.address.model.profile.ProfileItem) other;
        return otherProfileItem != null
                && otherProfileItem.getType().equals(getType())
                && (otherProfileItem.getTitle().equals(getTitle()));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, type, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(" Type: ")
                .append(getType())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}

