//put imports you need here

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> namesList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] names = line.split("\\s");
            for (String name : names) {
                namesList.add(name);
            }
        }

        Collections.reverse(namesList);
        for (String name : namesList) {
            System.out.println(name);
        }
    }
}