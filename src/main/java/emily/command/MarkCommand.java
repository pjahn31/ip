package emily.command;

import emily.Storage;
import emily.TaskList;
import emily.exception.EmilyException;
import emily.Ui;

public class MarkCommand extends Command {

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

