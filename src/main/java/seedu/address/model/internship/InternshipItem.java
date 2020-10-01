package seedu.address.model.internship;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.item.Item;
import seedu.address.model.person.Name;
import seedu.address.model.tag.Tag;

/**
 * Represents an InternshipItem in the InternHunter application.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class InternshipItem implements Item {

    // Identity fields
    private final Name companyName;
    private final Name jobTitle;
    private final String period;

    // Data fields
    private final Wage wage;
    private final Set<Tag> skills = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public InternshipItem(Name companyName, Name jobTitle, String period, Wage wage, Set<Tag> skills) {
        requireAllNonNull(companyName, jobTitle, period, wage, skills);
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.period = period;
        this.wage = wage;
        this.skills.addAll(skills);
    }

    public Name getCompanyName() {
        return jobTitle;
    }

    public Name getJobTitle() {
        return jobTitle;
    }

    public String getPeriod() {
        return period;
    }

    public Wage getWage() {
        return wage;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(skills);
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
     * Obtains the mapping of all field names to their corresponding fields in an InternshipItem object.
     *
     * @return Mapping of field names to fields for the InternshipItem.
     */
    public LinkedHashMap<String, Object> getMapping() {
        LinkedHashMap<String, Object> mapping = new LinkedHashMap<>();
        mapping.put("Header", companyName);
        mapping.put("Job title", jobTitle);
        mapping.put("Period", period);
        mapping.put("Wage", wage);
        mapping.put("Skills", skills);
        return mapping;
    }

    /**
     * Returns true if both InternshipItems have the same jobTitle and period.
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
        return otherInternshipItem.getCompanyName().equals(getCompanyName())
                && otherInternshipItem.getJobTitle().equals(getJobTitle())
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
        return otherInternshipItem.getCompanyName().equals(getCompanyName())
                && otherInternshipItem.getJobTitle().equals(getJobTitle())
                && otherInternshipItem.getPeriod().equals(getPeriod())
                && otherInternshipItem.getWage().equals(getWage())
                && otherInternshipItem.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(companyName, jobTitle, period, wage, skills);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getCompanyName())
                .append(" Job title: ")
                .append(getJobTitle())
                .append(" Period: ")
                .append(getPeriod())
                .append(" Wage: ")
                .append(getWage())
                .append(" Skills: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
