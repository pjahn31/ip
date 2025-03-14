package emily.command;

import emily.TaskList;
import emily.exception.EmilyException;
import emily.task.Task;
import emily.task.Todo;
import emily.task.Deadline;
import emily.task.Event;
import emily.Storage;
import emily.Ui;

public class AddTaskCommand extends Command {

    Ui ui= new Ui();
    @Override
    public void setCommand(TaskList tasks, String input) throws EmilyException {
        String[] parts = input.trim().split(" ");
        Task newTask;

        switch (parts[0]) {
        case "todo":
            if (parts.length < 2) {
                throw new EmilyException("Error! Todo description cannot be empty! An example 'todo homework'.");
            }

            newTask = new Todo(input.substring(5));
            break;

        case "deadline":
            if (!input.contains(" by ")) {
                throw new EmilyException("Error! Invalid deadline format. Use: deadline <task> by <time>");
            }

            String[] deadline = input.substring(9).split(" by ", 2);
            if (deadline[0].isBlank() || deadline[1].isBlank()) {
                throw new EmilyException("Error! Deadline description cannot be empty! An example 'deadline homework by Thursday'.");
            }

            newTask = new Deadline(deadline[0], deadline[1]);
            break;

        case "event":
            if (!input.contains(" from ") || !input.contains(" to ")) {
                throw new EmilyException("Error! Invalid event format. Use: event <task> from <time> to <time>");
            }

            String[] event = input.substring(6).split(" from | to ", 3);
            if (event[0].isBlank() || event[1].isBlank() || event[2].isBlank()) {
                throw new EmilyException("Error! Event description cannot be empty! An example 'event party from 4pm to 6pm'.");
            }

            newTask = new Event(event[0], event[1], event[2]);
            break;

        default:
            throw new EmilyException("Sorry, need to type <todo>, <deadline> or <event> to add a task. Try again!");
        }

        tasks.addTask(newTask);
        Storage.appendToFile(newTask.toString());

        ui.printMessage("Got it! I've added this task.");
        ui.printMessage(" " + newTask);
        ui.printMessage("Now you have " + tasks.getSize() + " tasks in the list.");
    }
}
