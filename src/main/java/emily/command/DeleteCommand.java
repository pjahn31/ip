package emily.command;

import emily.Storage;
import emily.TaskList;
import emily.exception.EmilyException;
import emily.Ui;

/**
 * Represents a command to delete a task from the task list.
 * This command validates the input format, ensures the task number is valid, and removes the specified task from the task list and storage.
 */
public class DeleteCommand extends Command {

    /**
     * Executes the command to delete a task from the task list.
     * The task number is extracted from the input, validated, and used to remove the task.
     * The updated task list is then saved to storage.
     *
     * @param tasks The task list from which the task will be deleted.
     * @param input The user input containing the task number to delete.
     * @throws EmilyException If the input format is invalid, the task number is out of range or the task number is not a valid integer.
     */
    @Override
    public void setCommand(TaskList tasks, String input) throws EmilyException {
        String[] parts = input.split(" ");
        Ui ui = new Ui();

        if (parts.length != 2) {
            throw new EmilyException("Invalid delete command format. Use: delete <task number>");
        }

        try {
            int index = Integer.parseInt(parts[1]);

            if (index < 1 || index > tasks.getSize()) {
                throw new EmilyException("This task does not exist! Enter a valid task number.");
            }

            ui.printMessage("Noted! I've deleted this task.");
            ui.printMessage(" " + tasks.getTasks(index - 1));

            tasks.deleteTask(index);
            Storage.writeToFile(tasks);

            ui.printMessage("Now you have " + tasks.getSize() + " tasks in the list. To check your updated list, type <list> next.");
        } catch (NumberFormatException e) {
            throw new EmilyException("Invalid task number. Please enter a valid number.");
        }
    }
}
