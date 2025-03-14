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

public class Storage {

    private static final String FILE_PATH = "./Emily-storage.txt";
    private static File storageFile;

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

    public static boolean isFileExists() {
        return storageFile.exists();
    }

    public String getAbsolutePath() {
        return storageFile.getAbsolutePath();
    }

    public static void writeToFile(TaskList tasks) {
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            for (int i = 0; i < tasks.getSize(); i++) {
                fw.write(tasks.getTasks(i).toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void appendToFile(String data) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true)) { // true enables appending
            fw.write(data + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

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

    public static ArrayList<Task> loadTasksFromStorage() {
        ArrayList<Task> tasks = new ArrayList<>();
        for (String line : readFromFile()) {
            tasks.add(parseTaskFromStorage(line));
        }
        return tasks;
    }
}