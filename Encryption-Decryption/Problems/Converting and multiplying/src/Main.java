import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if ("0".equals(input))
                break;

            try {
                int converted = Integer.parseInt(input);
                System.out.println(converted * 10);
            } catch(Exception e) {
                System.out.println("Invalid user input: " + input);
            }
        }
    }
}