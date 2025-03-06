import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    private static File storageFile;
    private static final String filePath = "./Emily-storage.txt";

    public Storage() {
        storageFile = new File(filePath);
    }

    public static boolean isFileExists() {
        return storageFile.exists();
    }

    public static String getAbsolutePath() {
        return storageFile.getAbsolutePath();
    }

    public static void writetoFile(String[] data) {
        String dataString = "";
        for (String datum : data) {
            dataString += datum;
            dataString += System.lineSeparator();
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(filePath);
            fw.write(dataString);
            fw.close();
        } catch (IOException e) {
            System.out.println("Error! File might be corrupted!" + e.getMessage());
        }
    }

    public static String[] readfromFile() {
        ArrayList<String> output = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(storageFile);
            while (sc.hasNext()) {
                output.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return output.toArray(new String[0]);
    }

    public static Task parseTaskFromStorage(String line) {
        char taskType = line.charAt(1);
        boolean isDone = (line.charAt(4) == 'X');

        String content = line.substring(7); // Extract description and details

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
        String[] data = readfromFile();
        for (String line : data) {
            tasks.add(parseTaskFromStorage(line));
        }
        return tasks;
    }
}

