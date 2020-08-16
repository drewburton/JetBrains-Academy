import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String array = scanner.nextLine();
        String[] arrayElements = array.split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (String element : rotate(arrayElements, rotations)) {
            System.out.print(element + " ");
        }
    }

    private static String[] rotate(String[] elements, int rotations) {
        if (elements == null || elements.length == 0) {
            throw new IllegalArgumentException();
        }

        rotations = rotations % elements.length;
        String[] newArray = new String[elements.length];
        for (int i = 0; i < newArray.length; i++) {
            int rotatedIndex = i - rotations;
            if (rotatedIndex < 0) {
                rotatedIndex += newArray.length;
            }
            newArray[i] = elements[rotatedIndex];
        }
        return newArray;
    }
}