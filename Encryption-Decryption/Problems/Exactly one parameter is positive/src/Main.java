import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<>();
        while(scanner.hasNext()) {
            input.add(Integer.parseInt(scanner.next()));
        }

        int onePositive = 0;
        for (int number : input) {
            if (onePositive == 0 && number > 0)
                onePositive = 1;
            else if (onePositive == 1 && number > 0)
                onePositive = -1;
        }
        if (onePositive == -1)
            System.out.println(false);
        else if (onePositive == 1)
            System.out.println(true);
        else
            System.out.println(false);
    }
}