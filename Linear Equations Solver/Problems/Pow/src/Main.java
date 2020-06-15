import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split("\\s");
        double a = Double.parseDouble(parts[0]);
        double b = Double.parseDouble(parts[1]);
        System.out.println(Math.pow(a, b));
    }
}