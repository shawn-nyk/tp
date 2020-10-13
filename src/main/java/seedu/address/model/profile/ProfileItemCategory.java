package seedu.address.model.profile;

import static seedu.address.model.util.ProfileItemCategoryUtil.ACHIEVEMENT_KEYWORD;
import static seedu.address.model.util.ProfileItemCategoryUtil.EXPERIENCE_KEYWORD;
import static seedu.address.model.util.ProfileItemCategoryUtil.SKILL_KEYWORD;

/**
 * UserProfileCategory class contains the valid category for user profile.
 */
public enum ProfileItemCategory {
    EXPERIENCE,
    ACHIEVEMENT,
    SKILL;


    public static final String MESSAGE_CONSTRAINTS =
            "ProfileItem category c/ can only be experience, achievement or skill";

    /**
     * Returns true if the profile item category is valid.
     *
     * @param profileItemCategory Input category as lower case.
     * @return True if status is valid, false otherwise.
     */
    public static boolean isValidProfileItemCategory(String profileItemCategory) {
        return profileItemCategory.equals(EXPERIENCE_KEYWORD)
                || profileItemCategory.equals(ACHIEVEMENT_KEYWORD)
                || profileItemCategory.equals(SKILL_KEYWORD);
    }
}
