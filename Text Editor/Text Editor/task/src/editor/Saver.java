package editor;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Saver {
    private Saver() {}

    public static void save(String filename, String text) {
        File file = new File(filename);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            System.out.println("wrote: ");
            System.out.println(text);
            writer.close();
        } catch(IOException e) {
           System.out.println("couldn't write file");
        }
    }

    public static void load(JTextField filenameField, JTextArea textArea) {
        try {
            FileReader reader = new FileReader(filenameField.getText());
            textArea.read(reader, filenameField.getText());
        } catch(Exception e) {
            textArea.setText("");
        }
    }
}
