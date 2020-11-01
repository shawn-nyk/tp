package seedu.internhunter.logic.parser.view;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.internhunter.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.internhunter.commons.core.Messages.MESSAGE_INVALID_ITEM_TYPE_ABRIDGED;
import static seedu.internhunter.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.internhunter.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.internhunter.model.util.ItemUtil.PROFILE_ALIAS;
import static seedu.internhunter.testutil.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.internhunter.logic.commands.view.ViewApplicationCommand;
import seedu.internhunter.logic.commands.view.ViewCommand;
import seedu.internhunter.logic.commands.view.ViewCompanyCommand;
import seedu.internhunter.logic.commands.view.ViewProfileCommand;
import seedu.internhunter.logic.parser.exceptions.ParseException;

/**
 * Tests the view command parser for the view commands.
 */
public class ViewCommandParserTest {

    private ViewCommandParser viewCommandParser;

    @BeforeEach
    public void setUp() {
        viewCommandParser = new ViewCommandParser();
    }

    @Test
    public void parse_blankItemType_throwsParseException() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE);
        assertThrows(ParseException.class, expectedMessage, () -> viewCommandParser.parse("  "));
    }

    @Test
    public void parse_invalidTypes_throwsParseException() {
        // invalid item type
        assertThrows(ParseException.class, MESSAGE_INVALID_ITEM_TYPE_ABRIDGED, () -> viewCommandParser.parse("int 2"));
        assertThrows(ParseException.class, MESSAGE_INVALID_ITEM_TYPE_ABRIDGED, () -> viewCommandParser.parse("null 1"));
    }

    @Test
    public void parse_correctFormat_success() throws ParseException {
        // item type app, index present
        assertTrue(viewCommandParser.parse(COMPANY_ALIAS + " 3") instanceof ViewCompanyCommand);
        assertTrue(viewCommandParser.parse(APPLICATION_ALIAS + " 2") instanceof ViewApplicationCommand);
        assertTrue(viewCommandParser.parse(PROFILE_ALIAS + " 4") instanceof ViewProfileCommand);
    }

}
