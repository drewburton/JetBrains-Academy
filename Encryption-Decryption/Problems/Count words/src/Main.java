import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            int count = 0;
            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
            System.out.println(count);
        }
    }

}