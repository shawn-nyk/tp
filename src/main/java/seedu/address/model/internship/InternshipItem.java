package seedu.address.model.internship;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.job.Job;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Represents an InternshipItem in the InternHunter application.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class InternshipItem {

    // Identity fields
    private final Job job;
    private final Name period;

    // Data fields
    private final Phone wage;
    private final Status status;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public InternshipItem(Job job, Name period, Phone wage, Status status, Set<Tag> tags) {
        requireAllNonNull(job, period, wage, status, tags);
        this.job = job;
        this.period = period;
        this.wage = wage;
        this.status = status;
        this.tags.addAll(tags);
    }

    public Job getJob() {
        return job;
    }

    public Name getPeriod() {
        return period;
    }

    public Phone getWage() {
        return wage;
    }

    public Status getStatus() {
        return status;
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
     */
    public boolean isSameInternshipItem(InternshipItem otherInternshipItem) {
        if (otherInternshipItem == this) {
            return true;
        }

        return otherInternshipItem != null
                && otherInternshipItem.getJob().equals(getJob())
                && otherInternshipItem.getPeriod().equals(getPeriod());
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
                && otherInternshipItem.getStatus().equals(getStatus())
                && otherInternshipItem.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(job, period, wage, status, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getJob())
                .append(" Period: ")
                .append(getPeriod())
                .append(" Wage: ")
                .append(getWage())
                .append(" Status: ")
                .append(getStatus())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
