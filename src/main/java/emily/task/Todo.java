package emily.task;

/**
 * Represents a Todo task in the Emily application.
 * A Todo task is a simple task with a description but no specific deadline or time frame.
 * It inherits from the Task class and adds a specific format for its string representation.
 */
public class Todo extends Task {

    /**
     * Constructs a new Todo task with the given description.
     *
     * @param description The description of the Todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the Todo task.
     * The representation includes a prefix "[T]" to indicate that it is a Todo task,
     * followed by the description and status (e.g., "[T][X] Read a book").
     *
     * @return A formatted string representation of the Todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
