package seedu.address.model.internship;

public enum JobStatus {
    APPLIED,
    INTERVIEW,
    WAITING,
    REJECTED,
    OFFERED,
    ACCEPTED;

    public static final String MESSAGE_CONSTRAINTS =
            "Job status can only be applied, interview, waiting, rejected, offered or accepted.";

    /**
     * Converts the job status to title case.
     *
     * @return {@code JobStatus} in title case.
     */
    public String toTitleCase() {
        String current = toString();
        char firstLetter = current.charAt(0);
        String remaining = toString().substring(1, current.length());
        return Character.toUpperCase(firstLetter) + remaining;
    }

    /**
     * Returns a string representation of the {@code JobStatus}.
     *
     * @return String representation of the {@code JobStatus}.
     */
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

}
