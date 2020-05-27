package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class DataStorage {
    File file;
    ArrayList<String> lines;
    SortedMap<String, ArrayList<Integer>> searchMap;

    public DataStorage(File file) {
        this.file = file;
        readLines();
    }

    public void findPeople(String searchTerm, String strategy) {
        String[] terms = searchTerm.toLowerCase().split("\\s");

        switch (strategy.toLowerCase()) {
            case "all":
                strategyAll(terms);
                break;
            case "any":
                strategyAny(terms);
                break;
            case "none":
                strategyNone(terms);
                break;
            default:
                System.out.println("Not a valid command");
        }


    }

    private void strategyAny(String[] terms) {
        for (String term : terms) {
            searchMap.forEach((k, v) -> {
                if (k.equals(term)) {
                    v.forEach(i -> System.out.println(lines.get(i)));
                }
            });
        }
    }

    private void strategyAll(String[] terms) {
        SortedMap<Integer, Integer> indexes = new TreeMap<>();
        for (String term : terms) {
            searchMap.forEach((k, v) -> {
                if (k.equals(term)) {
                    v.forEach(i -> {
                        if (indexes.get(i) == null) {
                            indexes.put(i, 1);
                        } else {
                            indexes.put(i, indexes.get(i) + 1);
                        }
                    });
                }
            });
        }
        indexes.forEach((k, v) -> {
            if (v >= terms.length) {
                System.out.println(lines.get(k));
            }
        });
    }

    private void strategyNone(String[] terms) {
        Set<Integer> indexes = new HashSet<>();
        for (String term : terms) {
            searchMap.forEach((k, v) -> {
                if (k.equals(term)) {
                    v.forEach(i -> {
                        if (!indexes.contains(i)) {
                            indexes.add(i);
                        }
                    });
                }
            });
        }

        for (int i = 0; i < lines.size(); i++) {
            if (!indexes.contains(i)) {
                System.out.println(lines.get(i));
            }
        }
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
            String[] words = lines.get(i).toLowerCase().split("\\s");
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
