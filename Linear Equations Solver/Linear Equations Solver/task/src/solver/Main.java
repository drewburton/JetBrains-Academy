package solver;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinearEquation equation = new LinearEquation(args);
        ArrayList<Double> answers = equation.solve();

        try {
            File file = new File(args[3]);
            file.createNewFile();
            System.out.println("created: " + file.toString());
            FileWriter writer = new FileWriter(args[3]);

            System.out.println("Writing to file:");
            for (double answer : answers) {
                System.out.println(answer);
                writer.write(answer + "\n");
            }
            writer.close();
        } catch (Exception e) {}
    }
}
