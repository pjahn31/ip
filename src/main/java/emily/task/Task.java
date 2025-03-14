package emily.task;

/**
 * Represents a task with a description and a completion status.
 * This class serves as the base class for specific task types like Todo, Deadline, and Event.
 */
public class Task {

    protected String description;
    protected boolean isDone;

    /**
     * Constructs a new Task with the given description.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the description of the task.
     *
     * @return The description of the task as a String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the status icon of the task, indicating whether it is done.
     *
     * @return "X" if the task is done, " " (space) otherwise.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Marks the task as done by setting the isDone field to true.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done by setting the isDone field to false.
     */
    public void unmarkAsDone() {
        this.isDone = false;
    }

    /**
     * Returns a string representation of the task, including its status and description.
     *
     * @return The string representation of the task.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
