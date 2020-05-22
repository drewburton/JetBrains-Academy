package search;

import java.util.Scanner;

public class DataProcessor {
    DataStorage storage;

    public DataProcessor(DataStorage storage) {
        this.storage = storage;
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        for (int num = scanner.nextInt(); num != 0; num = scanner.nextInt()) {
            scanner.nextLine();
            switch(num) {
                case 1:
                    System.out.println("Enter a name or email to search all suitable people");
                    storage.findPeople(scanner.nextLine());
                    break;
                case 2:
                    storage.printAll();
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
            }
        }
        System.out.println("Bye!");
    }
}
