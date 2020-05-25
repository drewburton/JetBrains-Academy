import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder line = new StringBuilder(scanner.nextLine());
        System.out.println(Integer.parseInt(line.reverse().toString()));
    }
}