import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        for (int i = 0; i < line.length(); i++) {
            if ((line.charAt(i) == 't' || line.charAt(i) == 'T') && line.charAt(i+1) == 'h' && line.charAt(i+2) == 'e') {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}