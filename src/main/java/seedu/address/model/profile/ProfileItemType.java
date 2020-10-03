package seedu.address.model.profile;

import static seedu.address.model.util.ProfileItemTypeUtil.ACHIEVEMENT_KEYWORD;
import static seedu.address.model.util.ProfileItemTypeUtil.EXPERIENCE_KEYWORD;
import static seedu.address.model.util.ProfileItemTypeUtil.SKILL_KEYWORD;

/**
 * UserProfileType class contains the valid types for user profile.
 */
public enum ProfileItemType {
    EXPERIENCE,
    ACHIEVEMENT,
    SKILL;


    public static final String MESSAGE_CONSTRAINTS =
            "ProfileItem can only be experience, achievement or skill.";

    /**
     * Returns true if the profile type is valid.
     *
     * @param profileItemType Input status.
     * @return True if status is valid, false otherwise.
     */
    public static boolean isValidProfileItemType(String profileItemType) {
        return profileItemType.equals(EXPERIENCE_KEYWORD)
                || profileItemType.equals(ACHIEVEMENT_KEYWORD)
                || profileItemType.equals(SKILL_KEYWORD);
    }

    /**
     * Returns a string representation of the {@code ProfileItemType}.
     *
     * @return String representation of the {@code ProfileItemType} in lower case.
     */
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

}
