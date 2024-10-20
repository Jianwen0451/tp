package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PATH;

import java.nio.file.Path;

import seedu.address.model.Model;

/**
 * Change the archive file path
 */
public class ArchivePathChangeCommand extends Command {

    public static final String COMMAND_WORD = "archivepath";
    public static final String MESSAGE_USAGE = COMMAND_WORD + " "
            + PREFIX_PATH + "Path\n"
            + "Example: " + COMMAND_WORD
            + PREFIX_PATH + "archive/archived.json";
    public static final String MESSAGE_SUCCESS = "The archive path has been changed to %1$s";

    private Path newArchivePath;

    /**
     * Create a new ArchivePathChangeCommand object
     * */
    public ArchivePathChangeCommand(Path newArchivePath) {
        requireNonNull(newArchivePath);
        this.newArchivePath = newArchivePath;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setArchivedAddressBookFilePath(newArchivePath);
        return new CommandResult(String.format(MESSAGE_SUCCESS, newArchivePath.toString()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ArchivePathChangeCommand)) {
            return false;
        }

        ArchivePathChangeCommand otherCommand = (ArchivePathChangeCommand) other;
        return newArchivePath.equals(otherCommand.newArchivePath);
    }
}
