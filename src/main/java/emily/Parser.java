package emily;

import emily.command.PrintCommand;
import emily.command.AddTaskCommand;
import emily.command.MarkCommand;
import emily.command.DeleteCommand;
import emily.command.FindCommand;
import emily.exception.EmilyException;


public class Parser {

    public static boolean handleInput(TaskList tasks, String input) throws EmilyException {
        try {
            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();

            switch (command) {
            case "bye":
                return Ui.printGoodbye();
            case "list":
                new PrintCommand().setCommand(tasks, input);
                return true;
            case "mark":
            case "unmark":
                new MarkCommand().setCommand(tasks, input);
                return true;
            case "todo":
            case "deadline":
            case "event":
                new AddTaskCommand().setCommand(tasks, input);
                return true;
            case "delete":
                new DeleteCommand().setCommand(tasks, input);
                return true;
            case "find":
                new FindCommand().setCommand(tasks, input);
                return true;
            default:
                throw new EmilyException("Sorry, I am not sure what that means. Try again!");
            }
        } catch (EmilyException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}

