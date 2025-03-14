package emily;

import emily.task.Task;
import java.util.ArrayList;

/**
 * Represents a list of tasks and provides methods to manipulate the list.
 * This class supports adding, deleting, marking, and searching for tasks.
 */
public class TaskList {

    private final ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Returns the task at the specified index.
     *
     * @param index The index of the task to retrieve.
     * @return The task at the specified index.
     */
    public Task getTasks(int index) {
        return tasks.get(index);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The number of tasks as an integer.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Adds a task to the list.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes the task at the specified index.
     *
     * @param index The index of the task to delete.
     */
    public void deleteTask(int index) {
        tasks.remove(index - 1);
    }

    /**
     * Marks the task at the specified index as done.
     *
     * @param index The index of the task to mark as done.
     */
    public void markTask(int index) {
        tasks.get(index - 1).markAsDone();
    }

    /**
     * Marks the task at the specified index as not done.
     *
     * @param index The index of the task to unmark.
     */
    public void unmarkTask(int index) {
        tasks.get(index - 1).unmarkAsDone();
    }

    /**
     * Checks if the task list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Adds all tasks from a given list to this task list.
     *
     * @param tasks The list of tasks to be added.
     */
    public void addAll(ArrayList<Task> tasks) {
        this.tasks.addAll(tasks);
    }

    /**
     * Finds tasks containing the specified keyword in their description.
     *
     * @param keyword The keyword to search for.
     * @return A TaskList containing the matching tasks.
     */
    public TaskList findTasksByKeyword(String keyword) {
        TaskList matchingTasks = new TaskList();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.addTask(task);
            }
        }
        return matchingTasks;
    }
}