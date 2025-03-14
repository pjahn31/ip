package emily.command;

import emily.Storage;
import emily.TaskList;
import emily.exception.EmilyException;
import emily.Ui;

/**
 * Represents a command to mark or unmark a task as done in the task list.
 * This command validates the input format, ensures the task number is valid, and updates the task's status in the task list and storage.
 */
public class MarkCommand extends Command {

    /**
     * Executes the command to mark or unmark a task as done.
     * The task number is extracted from the input, validated, and used to update the task's status.
     * The updated task list is then saved to storage.
     *
     * @param tasks The task list containing the task to be marked or unmarked.
     * @param input The user input containing the command and task number.
     * @throws EmilyException If the task number is invalid, out of range, or the input format is incorrect.
     */
    @Override
    public void setCommand(TaskList tasks, String input) throws EmilyException {
        String[] parts = input.trim().split(" ");
        Ui ui = new Ui();

        int index = Integer.parseInt(parts[1]);
        if (index < 1 || index > tasks.getSize()) {
            throw new EmilyException("This task does not exist! Enter a valid task number.");
        }

        if (parts[0].equals("mark")) {
            ui.printMessage("Nice! I've marked this task as done: ");
            tasks.markTask(index);
        } else {
            ui.printMessage("Ok, I've unmarked this task as not done yet: ");
            tasks.unmarkTask(index);
        }

        Storage.writeToFile(tasks);
        ui.printMessage(" " + tasks.getTasks(index - 1));
    }
}