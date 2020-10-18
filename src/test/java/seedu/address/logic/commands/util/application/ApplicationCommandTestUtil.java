package seedu.address.logic.commands.util.application;

import static seedu.address.commons.util.GeneralStringUtil.SPACE;
import static seedu.address.logic.parser.clisyntax.ApplicationCliSyntax.PREFIX_STATUS;
import static seedu.address.logic.parser.clisyntax.ApplicationCliSyntax.PREFIX_STATUS_DATE;
import static seedu.address.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.address.model.util.StatusUtil.ACCEPTED_KEYWORD;
import static seedu.address.model.util.StatusUtil.REJECTED_KEYWORD;
import static seedu.address.testutil.application.ApplicationItemFieldsUtil.INVALID_STATUS;
import static seedu.address.testutil.application.ApplicationItemFieldsUtil.INVALID_STATUS_DATE;
import static seedu.address.testutil.application.ApplicationItemFieldsUtil.STATUS_DATE_JUNE_2021;
import static seedu.address.testutil.application.ApplicationItemFieldsUtil.STATUS_DATE_JUNE_2022;

public class ApplicationCommandTestUtil {

    public static final String APPLICATION_ALIAS_DESC = SPACE + APPLICATION_ALIAS;

    // Valid Statuses
    public static final String STATUS_DESC_ACCEPTED = SPACE + PREFIX_STATUS + ACCEPTED_KEYWORD;
    public static final String STATUS_DESC_REJECTED = SPACE + PREFIX_STATUS + REJECTED_KEYWORD;

    // Invalid status
    public static final String INVALID_STATUS_DESC = SPACE + PREFIX_STATUS + INVALID_STATUS;

    // Valid Status dates
    public static final String STATUS_DATE_DESC_JUNE_2021 = SPACE + PREFIX_STATUS_DATE + STATUS_DATE_JUNE_2021;
    public static final String STATUS_DATE_DESC_JUNE_2022 = SPACE + PREFIX_STATUS_DATE + STATUS_DATE_JUNE_2022;

    // Invalid status dates
    public static final String INVALID_STATUS_DATE_DESC = SPACE + PREFIX_STATUS_DATE + INVALID_STATUS_DATE;

}
