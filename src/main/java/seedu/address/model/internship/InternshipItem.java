package seedu.address.model.internship;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.Item;
import seedu.address.model.person.Name;
import seedu.address.model.tag.Tag;

/**
 * Represents an InternshipItem in the InternHunter application.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class InternshipItem implements Item {

    // Identity fields
    private final Name job;
    private final String period;

    // Data fields
    private final Wage wage;
    private final InternshipStatus internshipStatus;
    private final StatusDate statusDate;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public InternshipItem(Name job, String period, Wage wage, InternshipStatus internshipStatus, StatusDate statusDate,
            Set<Tag> tags) {
        requireAllNonNull(job, period, wage, internshipStatus, tags);
        this.job = job;
        this.period = period;
        this.wage = wage;
        this.internshipStatus = internshipStatus;
        this.statusDate = statusDate;
        this.tags.addAll(tags);
    }

    public Name getJob() {
        return job;
    }

    public String getPeriod() {
        return period;
    }

    public Wage getWage() {
        return wage;
    }

    public InternshipStatus getInternshipStatus() {
        return internshipStatus;
    }

    public StatusDate getStatusDate() {
        return statusDate;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both InternshipItems have the same job and period.
     * This defines a weaker notion of equality between two InternshipItems.
     *
     * @param otherItem Other InternShipItem to compare to.
     * @return True if and only if the 2 InternshipItems have the same identity fields.
     */
    @Override
    public boolean isSameItem(Item otherItem) {
        if (otherItem == this) {
            return true;
        }

        if (!(otherItem instanceof InternshipItem)) {
            return false;
        }

        InternshipItem otherInternshipItem = (InternshipItem) otherItem;
        return otherInternshipItem.getJob().equals(getJob())
                && otherInternshipItem.getPeriod().equals(getPeriod());
    }

    /**
     * Obtains the name of the item.
     *
     * @return Item name.
     */
    @Override
    public String getItemName() {
        return "internship";
    }

    /**
     * Returns true if both InternshipItems have the same identity and data fields.
     * This defines a stronger notion of equality between two InternshipItems.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof InternshipItem)) {
            return false;
        }

        InternshipItem otherInternshipItem = (InternshipItem) other;
        return otherInternshipItem.getJob().equals(getJob())
                && otherInternshipItem.getPeriod().equals(getPeriod())
                && otherInternshipItem.getWage().equals(getWage())
                && otherInternshipItem.getInternshipStatus().equals(getInternshipStatus())
                && otherInternshipItem.getStatusDate().equals(getStatusDate())
                && otherInternshipItem.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(job, period, wage, internshipStatus, statusDate, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getJob())
                .append(" Period: ")
                .append(getPeriod())
                .append(" Wage: ")
                .append(getWage())
                .append(" Internship status: ")
                .append(getInternshipStatus())
                .append(" Date: ")
                .append(getStatusDate())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
