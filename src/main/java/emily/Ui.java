package emily;

import java.util.Scanner;

/**
 * Handles all user interface interactions, including displaying messages and reading user input.
 */
public class Ui {
    private final Scanner scanner;

    /**
     * Constructs a new Ui object and initializes the scanner to read user input.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Prints a message if there are any tasks saved in storage from the previous program run.
     *
     * @param taskCount Indicates how many tasks are saved in storage
     */
    public void printTasksLoadedMessage(int taskCount) {
        if (taskCount > 0) {
            System.out.println("[Your list has been updated with " + taskCount + " tasks from your storage!]");
            System.out.println(" ");
        }
    }

    /**
     * Prints out greeting message to the user when the program starts
     */
    public void printGreeting() {
        System.out.println("Hello! I'm Emily.");
        System.out.println("What can I do for you?");
    }

    /**
     * Reads a command entered by the user.
     *
     * @return The user's input as a String.
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }

    /**
     * Checks the list in storage and prints it out accordingly.
     *
     * @param tasks if empty, print a message that list is empty
     *              if not empty, print the list of tasks
     */
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

    /**
     * Prints out a general message.
     *
     * @param message The input that is to be printed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints a goodbye message to the user when the program ends.
     *
     * @return Always returns false to indicate the program should exit
     */
    public static boolean printGoodbye() {
        System.out.println("Goodbye! Hope to see you again soon!");
        return false;
    }
}