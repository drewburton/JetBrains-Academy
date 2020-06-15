import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        scanner.nextLine();
        double b = scanner.nextDouble();
        scanner.nextLine();
        double c = scanner.nextDouble();

        double discrim = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        double r1 = (-b + discrim) / (2 * a);
        double r2 = (-b - discrim) / (2 * a);

        if (r1 < r2) {
            System.out.println(r1 + " " + r2);
        } else {
            System.out.println(r2 + " " + r1);
        }
    }
}