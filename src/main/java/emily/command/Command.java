package emily.command;

import emily.TaskList;
import emily.exception.EmilyException;

public abstract class Command {

    public abstract void setCommand(TaskList taskList, String input) throws EmilyException;
}
