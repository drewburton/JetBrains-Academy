import InitializationBlocks.MagicNumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("C:\\development\\Learning\\Java\\IdeaProjects\\Testing\\src\\dataset_91022.txt"));
            String line = scanner.nextLine();
            String[] parts = line.split("\\s");

            int count = 0;
            for (String part : parts) {
                int num = Integer.parseInt(part);
                if (num >= 9999) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

    }
}
