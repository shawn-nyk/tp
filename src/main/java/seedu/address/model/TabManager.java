package seedu.address.model;

import seedu.address.ui.tabs.TabName;

public class TabManager implements Tab {

    private TabName tabName;

    /**
     * Initializes TabManger which controls the current {@code tabName}. By default, it is always Internship tab.
     */
    public TabManager() {
        tabName = TabName.COMPANY; // default tab that is displayed to user each time the app is opened.
    }

    /**
     * Retrieves the current {@code tabName}.
     */
    public TabName getTabName() {
        return tabName;
    }

    /**
     * Replaces {@code this.tabName} with {@code tabName}.
     */
    public void setTabName(TabName tabName) {
        this.tabName = tabName;
    }
}
