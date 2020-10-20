package seedu.address.logic.commands.util.internship;

import static seedu.address.commons.util.GeneralStringUtil.SPACE;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_JOB_TITLE;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_PERIOD;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_REQUIREMENT;
import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_WAGE;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_ALIAS;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.INVALID_JOB_TITLE_DASH;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.INVALID_PERIOD_EMPTY;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.INVALID_REQUIREMENT_EMPTY;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.INVALID_WAGE_ZERO;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_JOB_TITLE_FE;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_JOB_TITLE_SWE;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_PERIOD_THREE_MONTHS;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_PERIOD_TWO_MONTHS;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_REQUIREMENT_R;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_REQUIREMENT_VUE;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_WAGE_2000;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_WAGE_3000;

public class InternshipCommandTestUtil {

    public static final String INTERNSHIP_ALIAS_DESC = SPACE + INTERNSHIP_ALIAS;

    // Valid job titles
    public static final String JOB_TITLE_DESC_SWE = SPACE + PREFIX_JOB_TITLE + VALID_JOB_TITLE_SWE;
    public static final String JOB_TITLE_DESC_FE = SPACE + PREFIX_JOB_TITLE + VALID_JOB_TITLE_FE;

    // Invalid job title
    public static final String INVALID_JOB_TITLE_DESC = SPACE + PREFIX_JOB_TITLE + INVALID_JOB_TITLE_DASH;

    // Valid wages
    public static final String WAGE_DESC_SWE = SPACE + PREFIX_WAGE + VALID_WAGE_2000;
    public static final String WAGE_DESC_FE = SPACE + PREFIX_WAGE + VALID_WAGE_3000;

    // Invalid wage
    public static final String INVALID_WAGE_DESC = SPACE + PREFIX_WAGE + INVALID_WAGE_ZERO;

    // Valid periods
    public static final String PERIOD_DESC_TWO_MONTHS = SPACE + PREFIX_PERIOD + VALID_PERIOD_TWO_MONTHS;
    public static final String PERIOD_DESC_THREE_MONTHS = SPACE + PREFIX_PERIOD + VALID_PERIOD_THREE_MONTHS;

    // Invalid period
    public static final String INVALID_PERIOD_DESC = SPACE + PREFIX_PERIOD + INVALID_PERIOD_EMPTY;

    // Valid requirements
    public static final String REQUIREMENT_DESC_VUE = SPACE + PREFIX_REQUIREMENT + VALID_REQUIREMENT_VUE;
    public static final String REQUIREMENT_DESC_R = SPACE + PREFIX_REQUIREMENT + VALID_REQUIREMENT_R;

    // Invalid requirement
    public static final String INVALID_REQUIREMENT_DESC = SPACE + PREFIX_REQUIREMENT + INVALID_REQUIREMENT_EMPTY;

}
