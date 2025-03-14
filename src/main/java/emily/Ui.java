package emily;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void printGreeting() {
        System.out.println("Hello! I'm Emily.");
        System.out.println("What can I do for you?");
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void printTaskList(TaskList tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Your tasks list is empty!");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.getSize(); i++) {
                System.out.println((i + 1) + ". " + tasks.getTasks(i));
            }
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public static boolean printGoodbye() {
        System.out.println("Goodbye! Hope to see you again soon!");
        return false;
    }

    public void printTasksLoadedMessage(int taskCount) {
        if (taskCount > 0) {
            System.out.println("[Your list has been updated with " + taskCount + " tasks from your storage!]");
            System.out.println(" ");
        }
    }
}