package emily.command;

import emily.TaskList;
import emily.Ui;

/**
 * Represents a command to print all tasks in the task list.
 * This command displays the current tasks in the task list to the user.
 */
public class PrintCommand extends Command {

    /**
     * Executes the command to print all tasks in the task list.
     * The task list is displayed to the user in a formatted manner.
     *
     * @param tasks The task list to be printed.
     * @param input The user input (not used in this command).
     */
    @Override
    public void setCommand(TaskList tasks, String input) {
        Ui ui = new Ui();
        ui.printTaskList(tasks);
    }
}
