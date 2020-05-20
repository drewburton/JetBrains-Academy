package search;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File dataFile = new File(args[1]);

        DataStorage storage = new DataStorage(dataFile);
        DataProcessor processor = new DataProcessor(storage);
        processor.process();
    }
}
