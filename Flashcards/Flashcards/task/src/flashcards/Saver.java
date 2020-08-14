package flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Saver {
    private Scanner scanner;

    public Saver(Scanner scanner) {
        this.scanner = scanner;
    }

    public Map<String, String> importData() {
        System.out.println("File name:");
        File file = new File(scanner.nextLine());

        if (file.exists()) {
            try {
                Scanner fileScanner = new Scanner(file);
                Map<String, String> cards = new HashMap<>();

                int count = 0;
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(":");
                    cards.put(parts[0], parts[1]);
                    count++;
                }
                System.out.println(count + " cards have been loaded.");
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
        System.out.println("File name:");
        File file = new File(scanner.nextLine());
        try {
            file.createNewFile();

            FileWriter writer = new FileWriter(file);
            int count = 0;
            for (String key : cards.keySet()) {
                try {
                    writer.write(key + ":" + cards.get(key) + "\n");
                    count++;
                } catch(IOException e) {
                    System.out.println("Failed to write file");
                }
            }
            writer.close();
            System.out.println(count + " cards have been saved.");
        } catch (IOException e) {
            System.out.println("Failed to create file");
        }
    }
}
