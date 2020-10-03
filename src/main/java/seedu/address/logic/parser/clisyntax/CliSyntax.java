package seedu.address.logic.parser.clisyntax;

import seedu.address.logic.parser.Prefix;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    /* Item Prefix definitions */
    public static final String ITEM_PREFIX_COMPANY = "com";
    public static final String ITEM_PREFIX_INTERNSHIP = "int";
    public static final String ITEM_PREFIX_APPLICATION = "app";
    public static final String ITEM_PREFIX_USER_PROFILE = "me";
}
