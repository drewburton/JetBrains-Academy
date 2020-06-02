import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n != 0) {
            System.out.println(n % 2 == 0 ? "even" : "odd");
            n = Integer.parseInt(scanner.nextLine());
        }
    }
}