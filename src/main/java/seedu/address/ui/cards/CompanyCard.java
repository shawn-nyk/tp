package seedu.address.ui.cards;

import seedu.address.model.person.Person;

/**
 * todo Javadocs
 */
public class CompanyCard extends Card {

    /**
     * todo Javadocs
     */
    public CompanyCard(Person person, int displayedIndex) {
        super(person, displayedIndex);
        initializeCompanyCardGui();
    }

    /**
     * todo Javadocs
     */
    private void initializeCompanyCardGui() {
        // to be edited in the future!
        initializeHeader(displayedIndex);
        initializeBody();
        initializeTags();
    }
}
