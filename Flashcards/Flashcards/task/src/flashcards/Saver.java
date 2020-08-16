package flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Saver {
    private Scanner scanner;
    private static ArrayList<String> log;

    public Saver(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void println(String message) {
        if (log == null) {
            log = new ArrayList<>();
        }
        log.add(message + "\n");
        System.out.println(message);
    }

    public static String nextLine(Scanner s) {
        String input = s.nextLine();
        if (log == null) {
            log = new ArrayList<>();
        }
        log.add(input + "\n");
        return input;
    }

    public void log() {
        println("File name:");
        File file = new File(nextLine(scanner));
        println("The log has been saved.");
        try {
            file.createNewFile();

            FileWriter writer = new FileWriter(file);
            for (String line : log) {
                try {
                    writer.write(line);
                } catch(IOException e) {
                    System.out.println("Failed to write file");
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to create file");
        }
    }

    public Map<String, String> importData() {
        println("File name:");
        return importData(nextLine(scanner));
    }

    public Map<String, String> importData(String filename) {
        File file = new File(filename);

        if (file.exists()) {
            try {
                Scanner fileScanner = new Scanner(file);
                Map<String, String> cards = new HashMap<>();

                int count = 0;
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(":");
                    cards.put(parts[0], parts[1]);
                    StatsManager.addMistake(parts[0], Integer.parseInt(parts[2]));
                    count++;
                }
                println(count + " cards have been loaded.");
                fileScanner.close();
                return cards;
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                return null;
            }
        }

        System.out.println("File not found");
        return null;
    }

    public void exportData(Map<String, String> cards) {
        println("File name:");
        exportData(cards, nextLine(scanner));
    }

    public void exportData(Map<String, String> cards, String filename) {
        File file = new File(filename);

        try {
            file.createNewFile();

            FileWriter writer = new FileWriter(file);
            int count = 0;
            for (String key : cards.keySet()) {
                try {
                    writer.write(key + ":" + cards.get(key) + ":" + StatsManager.getMistakes(key) + "\n");
                    count++;
                } catch(IOException e) {
                    System.out.println("Failed to write file");
                }
            }
            writer.close();
            println(count + " cards have been saved.");
        } catch (IOException e) {
            System.out.println("Failed to create file");
        }
    }
}
