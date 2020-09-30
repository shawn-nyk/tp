package seedu.address.model.internship;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents a Status in the InternshipItem. Each status is tagged to a date of creation.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Status {

    // Identity field
    private final JobStatus jobStatus;

    // Data fields
    private final Date date;

    /**
     * Constructs a {@code Status} object.
     *
     * @param jobStatus A valid job status.
     * @param date Date and time of status.
     */
    public Status(JobStatus jobStatus, Date date) {
        requireAllNonNull(jobStatus, date);
        this.jobStatus = jobStatus;
        this.date = date;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Returns true if both statuses have the same job status.
     * This defines a weaker notion of equality between two statuses.
     */
    public boolean isSameStatus(Status otherStatus) {
        if (otherStatus == this) {
            return true;
        }

        return otherStatus != null
                && otherStatus.getJobStatus().equals(getJobStatus());
    }

    /**
     * Returns true if both statuses have the same job status and date.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Status)) {
            return false;
        }

        Status otherStatus = (Status) other;
        return otherStatus.getJobStatus().equals(getJobStatus())
                && otherStatus.getDate().equals(getDate());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(jobStatus, date);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getJobStatus())
                .append(" Date ")
                .append(getDate());
        return builder.toString();
    }

}
