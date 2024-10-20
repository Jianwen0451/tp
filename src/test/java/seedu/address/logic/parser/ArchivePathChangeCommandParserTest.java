package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_INVALID_PATH;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ArchiveCommand;
import seedu.address.logic.commands.ArchivePathChangeCommand;

public class ArchivePathChangeCommandParserTest {
    private ArchivePathChangeCommandParser parser = new ArchivePathChangeCommandParser();
    private String invalidPath = " pa/aaa";
    private String validPath = " pa/myfile.json";
    private Path path = Paths.get("myfile.json");

    @Test
    public void missing_path() {
        assertParseFailure(parser, ArchiveCommand.COMMAND_WORD, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ArchivePathChangeCommand.MESSAGE_USAGE));
    }

    @Test
    public void invalid_path() {
        assertParseFailure(parser, ArchivePathChangeCommand.COMMAND_WORD + invalidPath, MESSAGE_INVALID_PATH);
    }

    @Test
    public void valid_path() {
        assertParseSuccess(parser, ArchivePathChangeCommand.COMMAND_WORD + validPath,
                new ArchivePathChangeCommand(path));
    }

}
