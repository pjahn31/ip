import java.util.Scanner;
import java.util.ArrayList;

public class Emily {
    public static ArrayList<Task> tasks = new ArrayList<>();

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
                markTaskAsDone(Integer.parseInt(input.substring(5)));
            } else if (input.startsWith("unmark ")) {
                unmarkTask(Integer.parseInt(input.substring(7)));
            } else {
                addTask(input);
            }
        }
    }

    public static void addTask(String input) {
        Task task = new Task(input);
        tasks.add(task);
        System.out.println("added: " + input);
    }

    public static void printTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ".[" + task.getStatusIcon() + "] " + task.description);
        }
    }

    public static void markTaskAsDone(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.markAsDone();
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println("  [X] " + task.description);
        }
    }

    public static void unmarkTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.unmarkAsDone();
            System.out.println("Ok, I've unmarked this task as not done yet:");
            System.out.println("  [ ] " + task.description);
        }
    }
}
