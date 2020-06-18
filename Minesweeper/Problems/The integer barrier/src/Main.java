import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNextLine()) {
            int n = Integer.parseInt(scanner.nextLine());
            sum += n;
            if (n == 0 || sum >= 1000) {
                break;
            }
        }

        if (sum >= 1000) {
            System.out.println(sum - 1000);
        } else {
            System.out.println(sum);
        }
    }
}