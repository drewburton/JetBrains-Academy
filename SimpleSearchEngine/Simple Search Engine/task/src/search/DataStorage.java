package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataStorage {
    File file;
    ArrayList<String> lines;
    public DataStorage(File file) {
        this.file = file;
        readLines();
    }

    public void findPeople(String searchTerm) {
        
    }

    public void printAll() {
        System.out.println("=== List of people ===");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }

    private void readLines() {
        try {
            Scanner scanner = new Scanner(file);

            lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
