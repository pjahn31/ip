import java.util.Scanner;
import java.util.ArrayList;

public class Emily {
    public static final ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Emily.");
        System.out.println("What can I do for you?");

        while(true) {
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                printTasks();
            } else if (input.startsWith("mark ")) {
                markTask(Integer.parseInt(input.substring(5)));
            } else if (input.startsWith("unmark ")) {
                unmarkTask(Integer.parseInt(input.substring(7)));
            } else if (input.startsWith("todo ")) {
                addTask(new Todo(input.substring(5)));
            } else if (input.startsWith("deadline ")) {
                String[] parts = input.substring(9).split(" by ");
                addTask(new Deadline(parts[0], parts[1]));
            } else if (input.startsWith("event ")) {
                String[] parts = input.substring(6).split(" from | to ");
                addTask(new Event(parts[0], parts[1], parts[2]));
            } else {
                System.out.println("Sorry, I am not sure what that means.");
            }
        }
    }

    public static void addTask(Task task) {
        tasks.add(task);
        System.out.println("Got it! I've added this task.");
        System.out.println(" " + task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public static void printTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
    }

    public static void markTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.markAsDone();
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println(" " + task);
        }
    }

    public static void unmarkTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.unmarkAsDone();
            System.out.println("Ok, I've unmarked this task as not done yet:");
            System.out.println(" " + task);
        }
    }
}
