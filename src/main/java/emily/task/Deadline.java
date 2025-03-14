package emily.task;

/**
 * Represents a Deadline task in the Emily application.
 * A Deadline task has a description and a due date/time (`by`).
 * It inherits from the Task class and includes additional details for the deadline.
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Constructs a new Deadline task with the given description and due date/time.
     *
     * @param description The description of the Deadline task.
     * @param by The due date/time of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns a string representation of the Deadline task.
     * The representation includes a prefix "[D]" to indicate that it is a Deadline task,
     * followed by the description, status, and the due date/time (e.g., "[D][X] Submit report (by: 2023-10-31)").
     *
     * @return A formatted string representation of the Deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
