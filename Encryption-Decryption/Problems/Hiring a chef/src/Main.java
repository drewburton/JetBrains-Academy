//put imports you need here

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.nextLine());
        }

        System.out.print("The form for " + input.get(0) + " is completed. We will contact you ");
        System.out.print("if we need a chef that cooks " + input.get(4) + " dishes.");
    }
}