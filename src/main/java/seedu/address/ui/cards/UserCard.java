package seedu.address.ui.cards;

import seedu.address.model.person.Person;
/**
 * todo Javadocs
 */
public class UserCard extends Card {

    /**
     * todo Javadocs
     */
    public UserCard(Person person, int displayedIndex) {
        super(person, displayedIndex);
        initializeUserCardGui();
    }

    /**
     * todo Javadocs
     */
    private void initializeUserCardGui() {
        // to be edited in the future!
        initializeHeader(displayedIndex);
        initializeBody();
        initializeTags();
    }
}
