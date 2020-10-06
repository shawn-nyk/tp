package seedu.address.commons.util;

import static seedu.address.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.address.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.address.model.util.ItemUtil.PROFILE_ALIAS;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.ui.tabs.TabName;

public class TabUtil {

    private static final String MESSAGE_INVALID_TAB = "Tab name should be either com, app or me";

    /**
     * Takes in a {@code tab} and converts the {@code tab} into it's {@code TabName}.
     */
    public static TabName getSwitchTabName(String tab) throws ParseException {
        TabName tabName;
        switch (tab) {
        case COMPANY_ALIAS:
            tabName = TabName.COMPANY;
            break;
        case APPLICATION_ALIAS:
            tabName = TabName.APPLICATION;
            break;
        case PROFILE_ALIAS:
            tabName = TabName.PROFILE;
            break;
        default:
            throw new ParseException(MESSAGE_INVALID_TAB);
        }
        return tabName;
    }

    /**
     * Takes in a {@code tab} and checks if there is a tab.
     */
    public static boolean isEmptyTab(String tab) {
        return tab.length() <= 0;
    }
}
