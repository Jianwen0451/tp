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

public class ArchivePathChangeCommandTest {

    private static final Path archivePath = Paths.get("archiveTest", "archiveTest.json");
    private static final UserPrefs prefs = new UserPrefs();

    @Test
    public void execute_success() {
        Model model = new ModelManager(new AddressBook(), prefs);
        UserPrefs expectedPrefs = new UserPrefs();
        expectedPrefs.setArchivedAddressBookFilePath(archivePath);
        Model expectedModel = new ModelManager(new AddressBook(), expectedPrefs);

        assertCommandSuccess(new ArchivePathChangeCommand(archivePath), model,
                String.format(ArchivePathChangeCommand.MESSAGE_SUCCESS, archivePath), expectedModel);
    }

    @Test
    public void equals() {
        Path path1 = Paths.get("mybook.json");
        Path path2 = Paths.get("mybook.json");
        Path path3 = Paths.get("yourbook.json");
        ArchivePathChangeCommand command = new ArchivePathChangeCommand(path1);

        assertEquals(new ArchivePathChangeCommand(path1), new ArchivePathChangeCommand(path2));
        assertTrue(command.equals(command));
        assertFalse(command.equals(1));
        assertNotEquals(new ArchivePathChangeCommand(path1), new ArchivePathChangeCommand(path3));
    }

}
