package emily;

import emily.task.Task;
import emily.task.Todo;
import emily.task.Deadline;
import emily.task.Event;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles reading from and writing to the storage file.
 * This class is responsible for loading tasks from the file when the program starts
 * and saving tasks to the file when the program ends or tasks are modified.
 */
public class Storage {

    private static final String FILE_PATH = "./Emily-storage.txt";
    private static File storageFile;

    /**
     * Constructs a Storage object and initializes the storage file.
     * If the file does not exist, it creates a new file.
     */
    public Storage() {
        storageFile = new File(FILE_PATH);
        if (!storageFile.exists()) {
            try {
                storageFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating storage file: " + e.getMessage());
            }
        }
    }

    /**
     * Checks if the storage file exists.
     *
     * @return True if the file exists, false otherwise.
     */
    public static boolean isFileExists() {
        return storageFile.exists();
    }

    /**
     * Returns the absolute path of the storage file.
     *
     * @return The absolute path of the file as a String.
     */
    public String getAbsolutePath() {
        return storageFile.getAbsolutePath();
    }

    /**
     * Writes all tasks from the TaskList to the storage file.
     *
     * @param tasks The TaskList containing the tasks to be written to the file.
     */
    public static void writeToFile(TaskList tasks) {
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            for (int i = 0; i < tasks.getSize(); i++) {
                fw.write(tasks.getTasks(i).toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Appends a single line of data to the storage file.
     *
     * @param data The data to be appended to the file.
     */
    public static void appendToFile(String data) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true)) { // true enables appending
            fw.write(data + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

    /**
     * Reads all lines from the storage file and returns them as an array of strings.
     *
     * @return An array of strings, where each string represents a line from the file.
     */
    public static String[] readFromFile() {
        ArrayList<String> output = new ArrayList<>();
        try (Scanner sc = new Scanner(storageFile)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    output.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return output.toArray(new String[0]);
    }

    /**
     * Parses a line from the storage file into a Task object.
     *
     * @param line The line from the storage file to be parsed.
     * @return The Task object created from the line.
     */
    public static Task parseTaskFromStorage(String line) {
        char taskType = line.charAt(1);
        boolean isDone = (line.charAt(4) == 'X');
        String content = line.substring(7);

        Task task;
        switch (taskType) {
        case 'T':
            task = new Todo(content);
            break;
        case 'D':
            int byIndex = content.lastIndexOf("(by: ");
            if (byIndex != -1) {
                String description = content.substring(0, byIndex).trim();
                String by = content.substring(byIndex + 5, content.length() - 1).trim();
                task = new Deadline(description, by);
            } else {
                return new Task(content);
            }
            break;
        case 'E':
            int fromIndex = content.lastIndexOf("(from: ");
            int toIndex = content.lastIndexOf(" to: ");
            if (fromIndex != -1 && toIndex != -1) {
                String description = content.substring(0, fromIndex).trim();
                String from = content.substring(fromIndex + 7, toIndex).trim();
                String to = content.substring(toIndex + 4, content.length() - 1).trim();
                task = new Event(description, from, to);
            } else {
                return new Task(content);
            }
            break;
        default:
            return new Task(content);
        }

        if (isDone) task.markAsDone();
        return task;
    }

    /**
     * Loads all tasks from the storage file into an ArrayList.
     *
     * @return An ArrayList containing all tasks loaded from the file.
     */
    public static ArrayList<Task> loadTasksFromStorage() {
        ArrayList<Task> tasks = new ArrayList<>();
        for (String line : readFromFile()) {
            tasks.add(parseTaskFromStorage(line));
        }
        return tasks;
    }
}