package editor;

import javax.swing.*;
import java.io.*;

public class Saver {
    private Saver() {}

    public static void save(JFileChooser fileChooser, String text) {
        int validFile = fileChooser.showSaveDialog(null);
        if (validFile == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(text);
                System.out.println("wrote: ");
                System.out.println(text);
                writer.close();
            } catch (IOException e) {
                System.out.println("couldn't write file");
            }
        }
    }

    public static void load(JFileChooser fileChooser, JTextArea textArea) {
        int validFile = fileChooser.showOpenDialog(null);
        if (validFile == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                FileReader reader = new FileReader(file);
                textArea.read(reader, file);
            } catch (Exception e) {
                textArea.setText("");
            }
        }
    }
}
