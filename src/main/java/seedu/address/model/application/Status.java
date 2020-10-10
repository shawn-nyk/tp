package seedu.address.model.application;

import static seedu.address.model.util.StatusUtil.ACCEPTED_KEYWORD;
import static seedu.address.model.util.StatusUtil.APPLIED_KEYWORD;
import static seedu.address.model.util.StatusUtil.INTERVIEW_KEYWORD;
import static seedu.address.model.util.StatusUtil.OFFERED_KEYWORD;
import static seedu.address.model.util.StatusUtil.REJECTED_KEYWORD;
import static seedu.address.model.util.StatusUtil.WAITING_KEYWORD;

import seedu.address.commons.util.StringUtil;

/**
 * Status class which contains the valid statuses for an internship application.
 */
public enum Status {
    APPLIED,
    INTERVIEW,
    WAITING,
    REJECTED,
    OFFERED,
    ACCEPTED;

    public static final String MESSAGE_CONSTRAINTS =
            "Application status can only be applied, interview, waiting, rejected, offered or accepted.";

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
     * Returns a string representation of the {@code Status}.
     *
     * @return String representation of the {@code Status}.
     */
    @Override
    public String toString() {
        return StringUtil.toTitleCase(super.toString());
    }

}
