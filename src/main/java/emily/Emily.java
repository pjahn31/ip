package emily;

import emily.exception.EmilyException;

public class Emily {
    private final static TaskList tasks = new TaskList();

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