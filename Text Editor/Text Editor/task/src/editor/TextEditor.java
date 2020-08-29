package editor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TextEditor extends JFrame {
    JTextArea textArea;

    public TextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
        setLayout(null);
        setTitle("Text Editor");

        textArea = new JTextArea();
        textArea.setName("TextArea");
        textArea.setSize(250, 250);
        textArea.setLineWrap(true);
        textArea.setVisible(true);
        getContentPane().add(textArea);

        validate();
    }
}
