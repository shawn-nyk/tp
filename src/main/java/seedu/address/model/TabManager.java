package seedu.address.model;

import seedu.address.ui.tabs.TabName;

public class TabManager implements Tab {

    private TabName tabName;

    public TabManager() {
        tabName = TabName.INTERNSHIP; // default tab that is displayed to user each time the app is opened.
    }

    public TabName getTabName() {
        return tabName;
    }

    public void setTabName(TabName tabName) {
        this.tabName = tabName;
    }
}
