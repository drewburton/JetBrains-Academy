package solver;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Complex number = new Complex(1, 2);
        Complex number2 = new Complex("1+i");
        Complex number3 = new Complex("1-1i");
        Complex number4 = new Complex("-1-i");
        Complex number5 = new Complex("1");
        Complex number6 = new Complex("-i");

//        System.out.println(number.toString());
//        System.out.println(number2.toString());
//        System.out.println(number3.toString());
//        System.out.println(number4.toString());
//        System.out.println(number5.toString());
//        System.out.println(number6.toString());

//        LinearEquation equation = new LinearEquation(args);
//        ArrayList<String> answers = equation.solve();
//
//        try {
//            File file = new File(args[3]);
//            file.createNewFile();
//            System.out.println("created: " + file.toString());
//            FileWriter writer = new FileWriter(args[3]);
//
//            System.out.println("Writing to file:");
//            for (String answer : answers) {
//                System.out.println(answer);
//                writer.write(answer + "\n");
//            }
//            writer.close();
//        } catch (Exception e) {}
    }
}
