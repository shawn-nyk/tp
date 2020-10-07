package seedu.address.logic.parser.util;

import static seedu.address.model.util.ItemUtil.COMPANY_NAME;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_NAME;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.company.CompanyItem;
import seedu.address.model.internship.InternshipItem;

/**
 * Gets the internship from a company, checking the indexes validity while doing so.
 */
public class InternshipUtil {

    public static InternshipItem getInternship(Model model, Index companyIndex, Index internshipIndex)
            throws CommandException {
        List<CompanyItem> lastShownCompanyList = model.getCompanyList().getFilteredItemList();

        if (companyIndex.getZeroBased() >= lastShownCompanyList.size()) {
            throw new CommandException(String.format(Messages.MESSAGE_INVALID_ITEM_DISPLAYED_INDEX, COMPANY_NAME));
        }

        CompanyItem companyItem = lastShownCompanyList.get(companyIndex.getZeroBased());
        List<InternshipItem> internshipItemList = companyItem.getInternships();

        if (internshipIndex.getZeroBased() >= internshipItemList.size()) {
            throw new CommandException(String.format(Messages.MESSAGE_INVALID_ITEM_DISPLAYED_INDEX, INTERNSHIP_NAME));
        }

        return internshipItemList.get(internshipIndex.getZeroBased());
    }

}
