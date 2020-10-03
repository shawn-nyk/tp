package seedu.address.ui.panel;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;
import seedu.address.ui.UiPart;

/**
 * todo Javadocs
 */
public abstract class ListPanel extends UiPart<Region> {

    private static final String FXML = "ListPanel.fxml";

    @FXML
    protected ListView<Person> personListView;

    private final Logger logger = LogsCenter.getLogger(ListPanel.class);

    /**
     * todo Javadocs
     */
    public ListPanel(ObservableList<Person> personList) {
        super(FXML);
        personListView.setItems(personList);
    }
}
