import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double first = scanner.nextDouble();
        scanner.nextLine();
        double second = scanner.nextDouble();
        System.out.println(second - first);
    }
}