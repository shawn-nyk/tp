package seedu.address.ui.panel;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.company.CompanyItem;
import seedu.address.model.item.Item;
import seedu.address.ui.UiPart;

/**
 * todo Javadocs
 */
public abstract class ListPanel<T extends Item> extends UiPart<Region> {

    private static final String FXML = "ListPanel.fxml";

    @FXML
    protected ListView<T> itemListView;

    private final Logger logger = LogsCenter.getLogger(ListPanel.class);

    /**
     * todo Javadocs
     */
    public ListPanel(ObservableList<T> itemList) {
        super(FXML);
        T item = itemList.get(0);
        itemListView.setItems(itemList);
    }
}
