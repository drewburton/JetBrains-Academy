import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("dataset_91065.txt"))) {
            int evens = 0;
            while (scanner.hasNextLine()) {
                try {
                    int input = Integer.parseInt(scanner.nextLine());
                    if (input == 0)
                        break;
                    if (input % 2 == 0) {
                        evens++;
                    }
                } catch (Exception e) {
                    System.out.println("***********input errror*****************");
                }
            }
            System.out.println(evens);
        } catch (FileNotFoundException fn) {
            System.out.println("File not found!");
        }
    }
}
