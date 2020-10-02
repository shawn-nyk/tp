package seedu.address.model.application;

import static seedu.address.model.util.StatusUtil.ACCEPTED_KEYWORD;
import static seedu.address.model.util.StatusUtil.APPLIED_KEYWORD;
import static seedu.address.model.util.StatusUtil.INTERVIEW_KEYWORD;
import static seedu.address.model.util.StatusUtil.OFFERED_KEYWORD;
import static seedu.address.model.util.StatusUtil.REJECTED_KEYWORD;
import static seedu.address.model.util.StatusUtil.WAITING_KEYWORD;

/**
 * InternshipStatus class which contains the valid statuses for an internship application.
 */
public enum InternshipStatus {
    APPLIED,
    INTERVIEW,
    WAITING,
    REJECTED,
    OFFERED,
    ACCEPTED;

    public static final String MESSAGE_CONSTRAINTS =
            "Job status can only be applied, interview, waiting, rejected, offered or accepted.";

    /**
     * Returns true if the given status is valid.
     *
     * @param status Input status.
     * @return True if status is valid, false otherwise.
     */
    public static boolean isValidStatus(String status) {
        return status.equals(APPLIED_KEYWORD)
                || status.equals(INTERVIEW_KEYWORD)
                || status.equals(WAITING_KEYWORD)
                || status.equals(OFFERED_KEYWORD)
                || status.equals(ACCEPTED_KEYWORD)
                || status.equals(REJECTED_KEYWORD);
    }

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
