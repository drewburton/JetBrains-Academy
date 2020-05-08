//put imports you need here
import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }

        for (int i = lines.size() - 1; i >= 0; i--) {
            System.out.println(lines.get(i));
        }
    }
}