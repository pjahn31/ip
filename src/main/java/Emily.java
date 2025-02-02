import java.util.Scanner;

public class Emily {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Emily.");
        System.out.println("What can I do for you?");
        while(true) {
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("bye")) {
                break;
            }
            System.out.println(input); //Echo back user input
        }
        sc.close();
        System.out.println("Bye. Hope to see you again soon!");
    }
}
