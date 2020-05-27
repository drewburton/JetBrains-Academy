package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class DataStorage {
    File file;
    ArrayList<String> lines;
    SortedMap<String, ArrayList<Integer>> searchMap;

    public DataStorage(File file) {
        this.file = file;
        readLines();
    }

    public void findPeople(String searchTerm) {
        searchMap.forEach((k, v) -> {
            if (k.equals(searchTerm)) {
                v.forEach(i -> System.out.println(lines.get(i)));
            }
        });
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
            buildIndex();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void buildIndex() {
        searchMap = new TreeMap<>();
        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i).split("\\s");
            for (String word : words) {
                ArrayList<Integer> indexes;

                if (searchMap.get(word) == null) {
                    indexes = new ArrayList<>();
                } else {
                    indexes = searchMap.get(word);
                }

                indexes.add(i);
                searchMap.put(word, indexes);
            }
        }
    }
}
