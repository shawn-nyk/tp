package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_ITEM_TYPE;
import static seedu.address.commons.util.GeneralStringUtil.BLANK;
import static seedu.address.commons.util.GeneralStringUtil.SPACE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.address.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.address.model.util.ItemUtil.PROFILE_ALIAS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.SwitchCommand;
import seedu.address.logic.parser.switchparser.SwitchCommandParser;
import seedu.address.ui.tabs.TabName;

public class SwitchCommandParserTest {

    private static final String EXPECTED_MESSAGE = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
        SwitchCommand.MESSAGE_USAGE);

    private SwitchCommandParser switchCommandParser;

    @BeforeEach
    public void setUp() {
        switchCommandParser = new SwitchCommandParser();
    }

    @Test
    public void parse_missingTabNames_failure() {
        // no tab name input
        assertParseFailure(switchCommandParser, BLANK, EXPECTED_MESSAGE);

        // space
        assertParseFailure(switchCommandParser, SPACE, EXPECTED_MESSAGE);

    }

    @Test
    public void parse_invalidTabNames_failure() {
        // invalid tab name(words)
        assertParseFailure(switchCommandParser, "hello", MESSAGE_INVALID_ITEM_TYPE);

        // invalid tab name(numbers)
        assertParseFailure(switchCommandParser, "1", MESSAGE_INVALID_ITEM_TYPE);

        // almost correct tab name
        assertParseFailure(switchCommandParser, "com1", MESSAGE_INVALID_ITEM_TYPE);

        // adopting a strict case sensitive for parsers
        assertParseFailure(switchCommandParser, "Com", MESSAGE_INVALID_ITEM_TYPE);

        // adopting a strict case sensitive for parsers
        assertParseFailure(switchCommandParser, "App", MESSAGE_INVALID_ITEM_TYPE);

        // adopting a strict case sensitive for parsers
        assertParseFailure(switchCommandParser, "Me", MESSAGE_INVALID_ITEM_TYPE);
    }

    @Test
    public void parse_validTabNames_success() {
        // Valid tab name - com
        assertParseSuccess(switchCommandParser, COMPANY_ALIAS, new SwitchCommand(TabName.COMPANY));

        // valid tab name - app
        assertParseSuccess(switchCommandParser, APPLICATION_ALIAS, new SwitchCommand(TabName.APPLICATION));

        // valid tab name - me
        assertParseSuccess(switchCommandParser, PROFILE_ALIAS, new SwitchCommand(TabName.PROFILE));
    }
}
