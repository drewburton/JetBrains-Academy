package search;

import java.util.Scanner;

public class DataProcessor {
    DataStorage storage;

    public DataProcessor(DataStorage storage) {
        this.storage = storage;
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            int num = scanner.nextInt();
            switch(num) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    
            }
        }
    }
}
