package seedu.address.ui.panel;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import seedu.address.model.person.Person;
import seedu.address.ui.cards.ApplicationCard;

/**
 * todo Javadocs
 */
public class ApplicationListPanel extends ListPanel {

    /**
     * todo Javadocs
     */
    public ApplicationListPanel(ObservableList<Person> personList) {
        super(personList);
        personListView.setCellFactory(listView -> new ApplicationListViewCell());
    }

    /**
     * todo Javadocs
     */
    class ApplicationListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ApplicationCard(person, getIndex() + 1).getRoot());
            }
        }
    }
}
