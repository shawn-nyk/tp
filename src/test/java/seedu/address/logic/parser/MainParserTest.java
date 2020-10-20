package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.commons.util.GeneralStringUtil.SPACE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INDEX_ONE;
import static seedu.address.logic.commands.util.application.ApplicationCommandTestUtil.APPLICATION_ALIAS_DESC;
import static seedu.address.logic.commands.util.application.ApplicationCommandTestUtil.STATUS_DESC_ACCEPTED;
import static seedu.address.logic.commands.util.internship.InternshipCommandTestUtil.INTERNSHIP_ALIAS_DESC;
import static seedu.address.logic.commands.util.internship.InternshipCommandTestUtil.JOB_TITLE_DESC_SWE;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.SwitchCommand;
import seedu.address.logic.commands.edit.EditCommandAbstract;
import seedu.address.logic.commands.view.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class MainParserTest {

    private final MainParser parser = new MainParser();

    @Test
    public void parseCommand_add() throws Exception {
        Person person = new PersonBuilder().build();
        // Todo: Update test cases after add commands are added.
        //        AddCommand command = (AddCommand) parser.parseCommand(PersonUtil.getAddCommand(person));
        //        AddCommand command = (AddCommand) parser.parseCommand(PersonUtil.getAddCommand()
        //        assertEquals(new AddCommand(person), command);
    }

    // todo: add delete test (Issac)
    // @Test
    // public void parseCommand_delete() throws Exception {
    //     DeleteCommand command = (DeleteCommand) parser.parseCommand(
    //             DeleteCommand.COMMAND_WORD + " " + INDEX_FIRST.getOneBased());
    //     assertEquals(new DeleteCommand(INDEX_FIRST), command);
    // }

    // todo: When com, profile has their prefixes and syntax ready
    @Test
    public void parseCommand_edit() throws Exception {
        // assertTrue(parser.parseCommand(EditCommandAbstract.COMMAND_WORD + INTERNSHIP_ALIAS_DESC + SPACE
        //         + INDEX_FIRST.getOneBased() + JOB_TITLE_DESC_SWE) instanceof EditCommandAbstract);
        assertTrue(parser.parseCommand(EditCommandAbstract.COMMAND_WORD + INTERNSHIP_ALIAS_DESC + SPACE
                + INDEX_FIRST.getOneBased() + VALID_INDEX_ONE + JOB_TITLE_DESC_SWE) instanceof EditCommandAbstract);
        assertTrue(parser.parseCommand(EditCommandAbstract.COMMAND_WORD + APPLICATION_ALIAS_DESC + SPACE
                + INDEX_FIRST.getOneBased() + STATUS_DESC_ACCEPTED) instanceof EditCommandAbstract);
        // assertTrue(parser.parseCommand(EditCommandAbstract.COMMAND_WORD + INTERNSHIP_ALIAS_DESC + SPACE
        //         + INDEX_FIRST.getOneBased() + JOB_TITLE_DESC_SWE) instanceof EditCommandAbstract);
    }

    // todo: When com, profile has their prefixes and syntax ready
    @Test
    public void parseCommand_view_success() throws Exception {
        // assertTrue(parser.parseCommand(ViewCommand.COMMAND_WORD +  + SPACE
        //         + INDEX_FIRST.getOneBased()) instanceof ViewCommand);
        assertTrue(parser.parseCommand(ViewCommand.COMMAND_WORD + APPLICATION_ALIAS_DESC + SPACE
                + INDEX_FIRST.getOneBased()) instanceof ViewCommand);
        // assertTrue(parser.parseCommand(ViewCommand.COMMAND_WORD + SPACE + PROFILE_ALIAS + SPACE
        //         + INDEX_FIRST.getOneBased()) instanceof ViewCommand);
    }

    @Test
    public void parseCommand_clear() throws Exception {
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD) instanceof ClearCommand);
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD + " 3") instanceof ClearCommand);
    }

    // @Test
    // public void parseCommand_find() throws Exception {
    //     List<String> keywords = Arrays.asList("foo", "bar", "baz");
    //     FindCommand command = (FindCommand) parser.parseCommand(
    //             FindCommand.COMMAND_WORD + " " + keywords.stream().collect(Collectors.joining(" ")));
    //     assertEquals(new FindCommand(new NameContainsKeywordsPredicate(keywords)), command);
    // }

    // @Test
    // public void parseCommand_list() throws Exception {
    //     assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD) instanceof ListCommand);
    //     assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD + " 3") instanceof ListCommand);
    // }

    @Test
    public void parseCommand_exit() throws Exception {
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD) instanceof ExitCommand);
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD + " 3") instanceof ExitCommand);
    }

    @Test
    public void parseCommand_help() throws Exception {
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    }

    @Test
    public void parseCommand_switch_returnsTrue() throws Exception {
        assertTrue(parser.parseCommand(SwitchCommand.COMMAND_WORD + " me") instanceof SwitchCommand);
        assertTrue(parser.parseCommand(SwitchCommand.COMMAND_WORD + " com") instanceof SwitchCommand);
        assertTrue(parser.parseCommand(SwitchCommand.COMMAND_WORD + " app") instanceof SwitchCommand);
    }

    @Test
    public void parseCommand_switch_throwsParseException() {
        String invalidMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, SwitchCommand.MESSAGE_USAGE);
        assertThrows(ParseException.class, invalidMessage, () -> parser.parseCommand("switch"));
        assertThrows(ParseException.class, invalidMessage, () -> parser.parseCommand("switch hello"));
        assertThrows(ParseException.class, invalidMessage, () -> parser.parseCommand("switch 1"));
        assertThrows(ParseException.class, invalidMessage, () -> parser.parseCommand("switch "));
    }

    @Test
    public void parseCommand_unrecognisedInput_throwsParseException() {
        String errorMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE);
        assertThrows(ParseException.class, errorMessage, () -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
    }

}
