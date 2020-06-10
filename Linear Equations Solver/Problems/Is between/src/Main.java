import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split("\\s");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String num : split) {
            numbers.add(Integer.parseInt(num));
        }

        if (numbers.get(0) < numbers.get(1) && numbers.get(0) < numbers.get(2)) {
            System.out.println("false");
            return;
        } else if (numbers.get(0) > numbers.get(1) && numbers.get(0) > numbers.get(2)) {
            System.out.println("false");
            return;
        }

        System.out.println("true");
    }
}