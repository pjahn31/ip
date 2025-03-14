package emily.command;

import emily.Storage;
import emily.TaskList;
import emily.exception.EmilyException;
import emily.Ui;

public class DeleteCommand extends Command {

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

            ui.printMessage("Now you have " + tasks.getSize() + " tasks in the list.");
        } catch (NumberFormatException e) {
            throw new EmilyException("Invalid task number. Please enter a valid number.");
        }
    }
}
