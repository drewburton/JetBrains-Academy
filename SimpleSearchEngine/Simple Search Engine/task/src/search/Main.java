package search;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        DataStorage storage = new DataStorage(new File(args[1]));
        DataProcessor processor = new DataProcessor(storage);
        processor.process();
    }
}
