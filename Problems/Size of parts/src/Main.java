import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int fix = 0;
        int reject = 0;
        int perfect = 0;
        for (int i = 0; i < n; i++) {
            int detector = Integer.parseInt(scanner.nextLine());
            if (detector == 0) {
                perfect++;
            } else if (detector == 1) {
                fix++;
            } else if (detector == -1) {
                reject++;
            }
        }
        System.out.println(perfect + " " + fix + " " + reject);
    }
}