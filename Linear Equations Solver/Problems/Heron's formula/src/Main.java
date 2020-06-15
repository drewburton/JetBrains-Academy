import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        scanner.nextLine();
        double b = scanner.nextDouble();
        scanner.nextLine();
        double c = scanner.nextDouble();

        double p = (a + b + c) / 2;
        System.out.println(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }
}