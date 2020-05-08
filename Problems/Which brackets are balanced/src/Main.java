import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Character> stack = new ArrayDeque<>();
        try {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                switch (line.charAt(i)) {
                    case '[':
                    case '{':
                    case '(':
                        stack.offerLast(line.charAt(i));
                        break;
                    case ']':
                        if (stack.pollLast() != '[') {
                            System.out.println(false);
                            return;
                        }
                        break;
                    case ')':
                        if (stack.pollLast() != '(') {
                            System.out.println(false);
                            return;
                        }
                        break;
                    case '}':
                        if (stack.pollLast() != '{') {
                            System.out.println(false);
                            return;
                        }
                        break;
                    default:
                        System.out.println(false);
                        return;
                }
            }
        } catch (Exception e) {
            System.out.println(false);
            return;
        }

        if (stack.size() > 0) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }
}