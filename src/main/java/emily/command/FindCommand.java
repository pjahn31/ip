package emily.command;

import emily.TaskList;
import emily.Ui;
import emily.exception.EmilyException;

/**
 * Represents a command to find tasks in the task list that match a given keyword.
 * This command validates the input format, ensures the keyword is provided, and searches for tasks containing the keyword.
 */
public class FindCommand extends Command {

    /**
     * Executes the command to find tasks matching a keyword.
     * The keyword is extracted from the input, validated, and used to search the task list.
     * Matching tasks are displayed to the user.
     *
     * @param tasks The task list to search for matching tasks.
     * @param input The user input containing the keyword to search for.
     * @throws EmilyException If the keyword is missing or the input format is invalid.
     */
    @Override
    public void setCommand(TaskList tasks, String input) throws EmilyException {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2 || parts[1].isBlank()) {
            throw new EmilyException("Error! Please provide a keyword to search for! An example 'find homework'.");
        }

        String keyword = parts[1].trim();
        TaskList matchingTasks = tasks.findTasksByKeyword(keyword);

        Ui ui = new Ui();
        if (matchingTasks.isEmpty()) {
            ui.printMessage("No tasks found with the keyword " + keyword);
        } else {
            ui.printMessage("Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.getSize(); i++) {
                ui.printMessage((i + 1) + "." + matchingTasks.getTasks(i));
            }
        }
    }
}

