package emily;

import emily.exception.EmilyException;

/**
 * The main class for the Emily task management application
 * It initialises the task list, loads stored tasks and handles user input
 */
public class Emily {
    private final static TaskList tasks = new TaskList();

    /**
     * The entry point of the application
     * Initialises Ui and Storage, loads task and enters the main loop to process user commands
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Ui ui = new Ui();

        Storage storage = new Storage();
        tasks.addAll(Storage.loadTasksFromStorage());

        ui.printTasksLoadedMessage(tasks.getSize());
        ui.printGreeting();

        boolean isLooping = true;
        while (isLooping) {
            try {
                String input = ui.readCommand();
                isLooping = Parser.handleInput(tasks, input);
            } catch (EmilyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}