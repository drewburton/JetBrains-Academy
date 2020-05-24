import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lines = scanner.nextLine();

        ArrayList<Integer> numbers = getSortedInput(lines);

        int n = scanner.nextInt();
        printClosestInteger(n, numbers);
    }

    public static ArrayList<Integer> getSortedInput(String input) {
        String[] numberStrings = input.split(" ");

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numberStrings.length; i++) {
            numbers.add(Integer.parseInt(numberStrings[i]));
        }

        //numbers.sort((i1, i2) -> i1 > i2 ? i1 : i2);
        Collections.sort(numbers);
        return numbers;
    }

    public static void printClosestInteger(int n, ArrayList<Integer> numbers) {
        if (numbers.contains(n)) {
            numbers.forEach(num -> {
                if (num == n) {
                    System.out.print(num + " ");
                }
            });
            return;
        }

        int indexOfNext = numbers.size();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > n) {
                indexOfNext = i;
                break;
            }
        }

        try {
            int nextHighest = numbers.get(indexOfNext);

            Integer nextLowest = null;
            for (int i = indexOfNext - 1; i >= 0; i--) {
                if (nextLowest == null) {
                    nextLowest = numbers.get(i);
                    if (nextHighest - n >= n - nextLowest) {
                        System.out.print(nextLowest + " ");
                    }
                } else if (numbers.get(i) == nextLowest) {
                    System.out.print(nextLowest + " ");
                }
            }


            if (nextHighest - n == n - nextLowest) {
                System.out.print(nextHighest + " ");
                for (int i = indexOfNext + 1; i < numbers.size(); i++) {
                    if (numbers.get(i) == nextHighest) {
                        System.out.print(nextHighest + " ");
                    }
                }
            }
        } catch (Exception e) {
            Integer nextLowest = null;
            for (int i = indexOfNext - 1; i >= 0; i--) {
                if (nextLowest == null) {
                    nextLowest = numbers.get(i);
                    System.out.print(nextLowest + " ");
                } else if (numbers.get(i) == nextLowest) {
                    System.out.print(nextLowest + " ");
                }
            }
        }
    }
}