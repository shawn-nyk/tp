package seedu.address.ui.cards;

import seedu.address.model.person.Person;
/**
 * todo Javadocs
 */
public class ProfileCard extends Card {

    /**
     * todo Javadocs
     */
    public ProfileCard(Person person, int displayedIndex) {
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
