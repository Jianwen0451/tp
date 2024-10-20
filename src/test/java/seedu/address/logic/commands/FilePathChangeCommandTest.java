package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class FilePathChangeCommandTest {

    private static final Path filePath = Paths.get("fileTest", "fileTest.json");
    private static final UserPrefs prefs = new UserPrefs();

    @Test
    public void execute_success() {
        Model model = new ModelManager(new AddressBook(), prefs);
        UserPrefs expectedPrefs = new UserPrefs();
        expectedPrefs.setAddressBookFilePath(filePath);
        Model expectedModel = new ModelManager(new AddressBook(), expectedPrefs);

        assertCommandSuccess(new FilePathChangeCommand(filePath), model,
                String.format(FilePathChangeCommand.MESSAGE_SUCCESS, filePath), expectedModel);
    }

    @Test
    public void equals() {
        Path path1 = Paths.get("mybook.json");
        Path path2 = Paths.get("mybook.json");
        Path path3 = Paths.get("yourbook.json");
        FilePathChangeCommand command = new FilePathChangeCommand(path1);

        assertEquals(new FilePathChangeCommand(path1), new FilePathChangeCommand(path2));
        assertTrue(command.equals(command));
        assertFalse(command.equals(1));
        assertNotEquals(new FilePathChangeCommand(path1), new FilePathChangeCommand(path3));
    }

}
