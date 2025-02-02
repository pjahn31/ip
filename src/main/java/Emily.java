import java.util.Scanner;
import java.util.ArrayList;

public class Emily {
    public static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Emily.");
        System.out.println("What can I do for you?");

        while(true) {
            String task = sc.nextLine().trim();

            if(task.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (task.equalsIgnoreCase("list")) {
                listTasks();
            } else if (task.startsWith("add ")) {
                addTask(task.substring(4));
            } else {
                System.out.println("Sorry I do not know what you are saying. Please type again!");
            }
        }
        sc.close();
    }

    public static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void addTask(String task) {
        tasks.add(task);
        System.out.println("added: " + task);
    }
}
