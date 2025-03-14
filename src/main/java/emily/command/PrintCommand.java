package emily.command;

import emily.TaskList;
import emily.Ui;

public class PrintCommand extends Command {

    @Override
    public void setCommand(TaskList tasks, String input) {
        Ui ui = new Ui();
        ui.printTaskList(tasks);
    }
}
