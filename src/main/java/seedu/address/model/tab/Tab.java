package seedu.address.model.tab;

import seedu.address.ui.tabs.TabName;

/**
 * The API of the Tab component.
 */
public interface Tab {

    /**
     * Replaces the current tab name with {@code tabName}.
     */
    void setTabName(TabName tabName);

    /**
     * Retrieves the current tab name
     */
    TabName getTabName();

}
