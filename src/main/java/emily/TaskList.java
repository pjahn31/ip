package emily;

import emily.task.Task;
import java.util.ArrayList;

public class TaskList {

    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public Task getTasks(int index) {
        return tasks.get(index);
    }

    public int getSize() {
        return tasks.size();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int index) {
        tasks.remove(index - 1);
    }

    public void markTask(int index) {
        tasks.get(index - 1).markAsDone();
    }

    public void unmarkTask(int index) {
        tasks.get(index - 1).unmarkAsDone();
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public void addAll(ArrayList<Task> tasks) {
        this.tasks.addAll(tasks);
    }

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