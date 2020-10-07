package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.util.StatusUtil.ACCEPTED_KEYWORD;
import static seedu.address.model.util.StatusUtil.APPLIED_KEYWORD;
import static seedu.address.model.util.StatusUtil.INTERVIEW_KEYWORD;
import static seedu.address.model.util.StatusUtil.OFFERED_KEYWORD;
import static seedu.address.model.util.StatusUtil.REJECTED_KEYWORD;
import static seedu.address.model.util.StatusUtil.WAITING_KEYWORD;

import java.time.LocalDateTime;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.application.Status;
import seedu.address.model.application.StatusDate;
import seedu.address.model.util.DateUtil;

/**
 * ApplicationParserUtil class which parses all the fields in an ApplicationItem.
 */
public class ApplicationParserUtil {

    private static final String ERROR_MESSAGE = "Checks for status validity failed";

    /**
     * Parses a {@code String status} into a {@code Status}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code status} is invalid.
     */
    public static Status parseStatus(String status) throws ParseException {
        requireNonNull(status);
        String trimmedStatus = status.trim();

        if (!Status.isValidStatus(trimmedStatus)) {
            throw new ParseException(Status.MESSAGE_CONSTRAINTS);
        }

        switch (trimmedStatus) {
        case APPLIED_KEYWORD:
            return Status.APPLIED;
        case INTERVIEW_KEYWORD:
            return Status.INTERVIEW;
        case WAITING_KEYWORD:
            return Status.WAITING;
        case REJECTED_KEYWORD:
            return Status.REJECTED;
        case OFFERED_KEYWORD:
            return Status.OFFERED;
        case ACCEPTED_KEYWORD:
            return Status.ACCEPTED;
        default:
            assert false : ERROR_MESSAGE;
            return null;
        }
    }

    /**
     * Parses a {@code String statusDate} into a {@code StatusDate}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code StatusDate} is invalid.
     */
    public static StatusDate parseStatusDate(String statusDate) throws ParseException {
        requireNonNull(statusDate);
        String trimmedStatusDate = statusDate.trim();

        if (!StatusDate.isValidDate(statusDate)) {
            throw new ParseException(StatusDate.MESSAGE_CONSTRAINTS);
        }

        LocalDateTime localDateTime = DateUtil.convertToDateTime(trimmedStatusDate);
        return new StatusDate(localDateTime);
    }

}
