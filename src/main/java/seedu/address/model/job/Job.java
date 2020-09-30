package seedu.address.model.job;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.person.Name;

/**
 * Represents a Job in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Job {

    // Data fields
    private final Name jobTitle;
    private final Name companyName;
    private final Name industry;

    /**
     * Every field must be present and not null.
     */
    public Job(Name jobTitle, Name companyName, Name industry) {
        requireAllNonNull(jobTitle, companyName, industry);
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.industry = industry;
    }


    public Name getJobTitle() {
        return jobTitle;
    }

    public Name getCompanyName() {
        return companyName;
    }

    public Name getIndustry() {
        return industry;
    }

    /**
     * Returns true if both Jobs have the same job title, company name, and industry.
     * This defines a weaker notion of equality between two Jobs.
     */
    public boolean isSameJob(Job otherJob) {
        if (otherJob == this) {
            return true;
        }

        return otherJob != null
                && otherJob.getJobTitle().equals(getJobTitle())
                && otherJob.getCompanyName().equals(getCompanyName())
                && otherJob.getIndustry().equals(getIndustry());
    }

    /**
     * Returns true if both Jobs have the same identity and data fields.
     * This defines a stronger notion of equality between two Jobs.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Job)) {
            return false;
        }

        Job otherJob = (Job) other;
        return otherJob.getJobTitle().equals(getJobTitle())
                && otherJob.getCompanyName().equals(getCompanyName())
                && otherJob.getIndustry().equals(getIndustry());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(jobTitle, companyName, industry);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getJobTitle())
                .append(" Company: ")
                .append(getCompanyName())
                .append(" Industry: ")
                .append(getIndustry());
        return builder.toString();
    }

}
