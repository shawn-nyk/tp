package seedu.address.model.internship;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a Status in the InternshipItem.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Status {

    // Identity field
    private final JobStatus jobStatus;

    // Data fields
    private final LocalDateTime dateTime;

    /**
     * Constructs a {@code Status} object.
     *
     * @param jobStatus A valid job status.
     * @param dateTime Date and time of status.
     */
    public Status(JobStatus jobStatus, LocalDateTime dateTime) {
        requireAllNonNull(jobStatus, dateTime);
        this.jobStatus = jobStatus;
        this.dateTime = dateTime;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Returns true if both statuses of the same name have at least one other identity field that is the same.
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
     * Returns true if both statuses have the same data fields.
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
                && otherStatus.getDateTime().equals(getDateTime());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(jobStatus, dateTime);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getJobStatus())
                .append(" Date ")
                .append(getDateTime());
        return builder.toString();
    }

}
