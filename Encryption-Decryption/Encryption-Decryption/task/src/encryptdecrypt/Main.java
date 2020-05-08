package encryptdecrypt;
import kotlin.reflect.KFunction;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String GetMode(String[] args) {
        for (int i = 0; i < args.length; i++) {
           if ("-mode".equals(args[i])) {
               return args[i + 1];
           }
        }
        return new String("Failure");
    }

    public static int GetKey(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if ("-key".equals(args[i])) {
                return Integer.parseInt(args[i + 1]);
            }
        }
        return -1;
    }

    public static String GetData(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if ("-data".equals(args[i])) {
                return args[i + 1];
            }
        }
        return new String("Failure");
    }

    public static void main(String[] args) {
        String mode = GetMode(args);
        int key = GetKey(args);
        String input = GetData(args);

        if ("Faluire".equals(mode)) {
            System.out.println("fail");
        }

        String output;
        if ("enc".equals(mode)) {
            output = encrypt(input, key);
        } else {
            output = decrypt(input, key);
        }
        System.out.println(output);
    }

    public static String encrypt(String string, int key) {
        StringBuilder newString = new StringBuilder();
        for (char letter : string.toCharArray()) {
            newString.append((char)(letter + key));
        }
        return newString.toString();
    }

    public static String decrypt(String string, int key) {
        StringBuilder newString = new StringBuilder();
        for (char letter : string.toCharArray()) {
            newString.append((char)(letter - key));
        }
        return newString.toString();
    }
}
