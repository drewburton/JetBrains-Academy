package search;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        String[] people = new String[count];
        for (int i = 0; i < count; i++) {
            people[i] = scanner.nextLine();
        }

        int searches = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < searches; i++) {
            String data = scanner.nextLine();

            ArrayList<String> foundPeople = new ArrayList<>();
            for (int peopleIndex = 0; peopleIndex < people.length; peopleIndex++) {
               if (people[peopleIndex].toLowerCase().matches(".*" + data.toLowerCase() + ".*")) {
                   foundPeople.add(people[peopleIndex]);
               }
            }
            if (foundPeople.size() > 0) {
                System.out.println("Found people:");
                for (int foundIndex = 0; foundIndex < foundPeople.size(); foundIndex++) {
                    System.out.println(foundPeople.get(foundIndex));
                }
            } else {
                System.out.println("No matching people found.");
            }
        }
    }
}
