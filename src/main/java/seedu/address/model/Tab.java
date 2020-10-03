package seedu.address.model;

import seedu.address.ui.tabs.TabName;

public interface Tab {

    void setTabName(TabName tabName);

    TabName getTabName();
}
