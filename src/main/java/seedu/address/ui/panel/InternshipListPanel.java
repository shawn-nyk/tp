package seedu.address.ui.panel;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import seedu.address.model.person.Person;
import seedu.address.ui.cards.InternshipCard;

/**
 * todo Javadocs
 */
public class InternshipListPanel extends ListPanel {

    /**
     * todo Javadocs
     */
    public InternshipListPanel(ObservableList<Person> personList) {
        super(personList);
        personListView.setCellFactory(listView -> new InternshipListViewCell());
    }

    /**
     * todo Javadocs
     */
    class InternshipListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new InternshipCard(person, getIndex() + 1).getRoot());
            }
        }
    }
}
