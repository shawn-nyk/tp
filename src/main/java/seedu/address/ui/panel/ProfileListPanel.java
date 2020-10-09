package seedu.address.ui.panel;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import seedu.address.model.person.Person;
import seedu.address.ui.cards.ProfileCard;

/**
 * todo Javadocs
 */
public class ProfileListPanel extends ListPanel {

    /**
     * todo Javadocs
     */
    public ProfileListPanel(ObservableList<Person> personList) {
        super(personList);
        personListView.setCellFactory(listView -> new ProfileListViewCell());
    }

    /**
     * todo Javadocs
     */
    class ProfileListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ProfileCard(person, getIndex() + 1).getRoot());
            }
        }
    }
}
