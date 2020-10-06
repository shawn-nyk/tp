package seedu.address.ui.cards;

import seedu.address.model.profile.ProfileItem;

/**
 * todo Javadocs
 */
public class ProfileCard extends Card<ProfileItem> {

    /**
     * todo Javadocs
     */
    public ProfileCard(ProfileItem profileItem, int displayedIndex) {
        super(profileItem, displayedIndex);
        initializeUserCardGui();
    }

    /**
     * todo Javadocs
     */
    private void initializeUserCardGui() {
        // to be edited in the future!
        initializeBody();
    }

    @Override
    protected void setName() {

    }

    @Override
    protected void setTags() {

    }
}
