package emily.task;

/**
 * Represents an Event task in the Emily application.
 * An Event task has a description, a start time (`from`), and an end time (`to`).
 * It inherits from the Task class and includes additional details for the event's time frame.
 */
public class Event extends Task {

    protected String from;
    protected String to;

    /**
     * Constructs a new Event task with the given description, start time, and end time.
     *
     * @param description The description of the Event task.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description,String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a string representation of the Event task.
     * The representation includes a prefix "[E]" to indicate that it is an Event task,
     * followed by the description, status, and the event's time frame (e.g., "[E][X] Team meeting (from: 2pm to: 4pm)").
     *
     * @return A formatted string representation of the Event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
