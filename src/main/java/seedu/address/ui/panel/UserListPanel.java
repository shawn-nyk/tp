package seedu.address.ui.panel;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import seedu.address.model.person.Person;
import seedu.address.ui.cards.UserCard;

/**
 * todo Javadocs
 */
public class UserListPanel extends ListPanel {

    /**
     * todo Javadocs
     */
    public UserListPanel(ObservableList<Person> personList) {
        super(personList);
        personListView.setCellFactory(listView -> new UserListViewCell());
    }

    /**
     * todo Javadocs
     */
    class UserListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new UserCard(person, getIndex() + 1).getRoot());
            }
        }
    }
}
