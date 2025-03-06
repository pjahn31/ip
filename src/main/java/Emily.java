import java.util.Scanner;
import java.util.ArrayList;

public class Emily {
    public static final ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        greetUser();

        while(true) {
            String input = sc.nextLine();

            String[] parts = input.split(" ",2);
            String command = parts[0].toLowerCase();
            String arguments = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "bye":
                    exitProgram();
                    return;

                case "list":
                    printTasks();
                    break;

                case "mark":
                    try {
                        markTask(Integer.parseInt(arguments));
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("Error. Invalid task number.");
                    }
                    break;

                case "unmark":
                    try {
                        unmarkTask(Integer.parseInt(arguments));
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("Error. Invalid task number.");
                    }
                    break;

                case "todo":
                    addTodo(arguments);
                    break;

                case "deadline":
                    addDeadline(arguments);
                    break;

                case "event":
                    addEvent(arguments);
                    break;

                default:
                    System.out.println("Sorry, I am not sure what that means. Try again!");
                    break;
            }
        }
    }

    public static void greetUser() {
        System.out.println("Hello! I'm Emily.");
        System.out.println("What can I do for you?");
    }

    public static void exitProgram() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void addTask(Task task) {
        tasks.add(task);
        System.out.println("Got it! I've added this task.");
        System.out.println(" " + task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public static void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your tasks list is empty!");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + "." + tasks.get(i));
            }
        }
    }

    public static void markTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.markAsDone();
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println(" " + task);
        } else {
            System.out.println("This task does not exist! Enter a valid task number.");
        }
    }

    public static void unmarkTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.unmarkAsDone();
            System.out.println("Ok, I've unmarked this task as not done yet:");
            System.out.println(" " + task);
        } else {
            System.out.println("This task does not exist! Enter a valid task number.");
        }
    }

    public static void addTodo(String todo) {
        if (todo.isBlank()) {
            System.out.println("Error! Todo description cannot be empty!");
            return;
        } else {
            addTask(new Todo(todo));
        }
    }

    public static void addDeadline(String deadline) {
        String[] parts = deadline.split(" by ", 2);
        if (parts.length < 2 || parts[0].isBlank() || parts[1].isBlank()) {
            System.out.println("Invalid deadline format. Use: deadline <task> by <time>");
        } else {
            addTask(new Deadline(parts[0], parts[1]));
        }
    }

    public static void addEvent(String event) {
        String[] parts = event.split(" from | to ", 3);
        if (parts.length < 3 || parts[0].isBlank() || parts[1].isBlank() || parts[2].isBlank()) {
            System.out.println("Invalid event format. Use: event <task> from <time> to <time>");
        } else {
            addTask(new Event(parts[0], parts[1], parts[2]));
        }
    }
}
