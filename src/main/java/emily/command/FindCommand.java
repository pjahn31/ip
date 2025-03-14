package emily.command;

import emily.TaskList;
import emily.Ui;
import emily.exception.EmilyException;

public class FindCommand extends Command {

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

