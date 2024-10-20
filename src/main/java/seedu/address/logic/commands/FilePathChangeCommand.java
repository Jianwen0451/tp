package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PATH;

import java.nio.file.Path;

import seedu.address.model.Model;

/**
 * Change the archive file path
 */
public class FilePathChangeCommand extends Command {

    public static final String COMMAND_WORD = "filepath";
    public static final String MESSAGE_USAGE = COMMAND_WORD + " "
            + PREFIX_PATH + "Path\n"
            + "Example: " + COMMAND_WORD
            + PREFIX_PATH + "data/filename.json";
    public static final String MESSAGE_SUCCESS = "The file path has been changed to %1$s";

    private Path newFilePath;

    /**
     * Create a new ArchivePathChangeCommand object
     * */
    public FilePathChangeCommand(Path newfilePath) {
        requireNonNull(newfilePath);
        this.newFilePath = newfilePath;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setAddressBookFilePath(newFilePath);
        return new CommandResult(String.format(MESSAGE_SUCCESS, newFilePath.toString()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Command)) {
            return false;
        }

        FilePathChangeCommand otherCommand = (FilePathChangeCommand) other;
        return newFilePath.equals(otherCommand.newFilePath);
    }
}
