import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = scanner.nextInt();
        scanner.nextLine();

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> maxes = new ArrayDeque<>();

        for (int i = 0; i < commands; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            switch(parts[0]) {
                case "push":
                    stack.add(Integer.parseInt(parts[1]));
                    if (maxes.size() == 0 || Integer.parseInt(parts[1]) >= maxes.peekLast()) {
                        maxes.add(Integer.parseInt(parts[1]));
                    } else {
                        maxes.addFirst(Integer.parseInt(parts[1]));
                    }
                    break;
                case "pop":
                    int value = stack.pollLast();
                    maxes.remove(value);
                    break;
                case "max":
                    System.out.println(maxes.peekLast());
                    break;
                default:
                    System.out.println("Failure");
            }
        }
    }
}