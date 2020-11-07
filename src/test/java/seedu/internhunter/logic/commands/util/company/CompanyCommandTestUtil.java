package seedu.internhunter.logic.commands.util.company;

import static seedu.internhunter.commons.core.Messages.MESSAGE_INVALID_ITEM_DISPLAYED_INDEX;
import static seedu.internhunter.logic.parser.clisyntax.CompanyCliSyntax.PREFIX_ADDRESS;
import static seedu.internhunter.logic.parser.clisyntax.CompanyCliSyntax.PREFIX_COMPANY_NAME;
import static seedu.internhunter.logic.parser.clisyntax.CompanyCliSyntax.PREFIX_EMAIL;
import static seedu.internhunter.logic.parser.clisyntax.CompanyCliSyntax.PREFIX_PHONE;
import static seedu.internhunter.model.util.ItemUtil.COMPANY_NAME;
import static seedu.internhunter.testutil.company.CompanyItemFieldsUtil.VALID_ADDRESS_FACEBOOK;
import static seedu.internhunter.testutil.company.CompanyItemFieldsUtil.VALID_COMPANY_NAME_FACEBOOK;
import static seedu.internhunter.testutil.company.CompanyItemFieldsUtil.VALID_EMAIL_FACEBOOK;
import static seedu.internhunter.testutil.company.CompanyItemFieldsUtil.VALID_PHONE_FACEBOOK;

public class CompanyCommandTestUtil {

    // Invalid company index
    public static final String INVALID_COMPANY_INDEX_MESSAGE =
            String.format(MESSAGE_INVALID_ITEM_DISPLAYED_INDEX, COMPANY_NAME);

    // Valid Name
    public static final String NAME_DESC_FACEBOOK = " " + PREFIX_COMPANY_NAME + VALID_COMPANY_NAME_FACEBOOK;

    // Valid Address
    public static final String ADDRESS_DESC_FACEBOOK = " " + PREFIX_ADDRESS + VALID_ADDRESS_FACEBOOK;

    // Valid Phone
    public static final String PHONE_DESC_FACEBOOK = " " + PREFIX_PHONE + VALID_PHONE_FACEBOOK;

    // Valid Email
    public static final String EMAIL_DESC_FACEBOOK = " " + PREFIX_EMAIL + VALID_EMAIL_FACEBOOK;

}
