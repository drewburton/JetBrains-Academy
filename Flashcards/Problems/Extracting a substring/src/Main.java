import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        int begin = Integer.parseInt(parts[0]);
        int end = Integer.parseInt(parts[1]) + 1;
        System.out.println(string.substring(begin, end));
    }
}