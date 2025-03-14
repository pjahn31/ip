package emily.command;

import emily.TaskList;
import emily.exception.EmilyException;

/**
 * Represents an abstract command that can be executed on a TaskList
 * This class serves as a base class for certain subclasses that need to implement the setCommand method
 */
public abstract class Command {

    /**
     * Executes the command using the provided task list and input string
     *
     * @param taskList The list of tasks to be modified or looked at
     * @param input The user input string containing the commands
     * @throws EmilyException If an error occurs while executing the command
     */
    public abstract void setCommand(TaskList taskList, String input) throws EmilyException;
}
