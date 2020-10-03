package seedu.address.ui.panel;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import seedu.address.model.person.Person;
import seedu.address.ui.cards.CompanyCard;

/**
 * todo Javadocs
 */
public class CompanyListPanel extends ListPanel {

    /**
     * todo Javadocs
     */
    public CompanyListPanel(ObservableList<Person> personList) {
        super(personList);
        personListView.setCellFactory(listView -> new CompanyListViewCell());
    }

    /**
     * todo Javadocs
     */
    class CompanyListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new CompanyCard(person, getIndex() + 1).getRoot());
            }
        }
    }
}
