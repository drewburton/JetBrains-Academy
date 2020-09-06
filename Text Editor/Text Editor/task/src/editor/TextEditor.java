package editor;

import javax.swing.*;
import java.awt.*;

/*
todo
 - add images to buttons
 - make load use FileChooser
 - add search panel (checkbox for reg exp.)
 - add search menu
 */

public class TextEditor extends JFrame {
    JPanel saveLoadPanel;
    JTextField filenameField;
    JButton saveButton;
    JButton loadButton;

    JPanel textAreaPanel;
    JScrollPane scrollPane;
    JTextArea textArea;

    JMenu menu;
    JMenuItem loadMenuItem;
    JMenuItem saveMenuItem;
    JMenuItem exitMenuItem;

    public TextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setTitle("Text Editor");

        createMenu();
        createSaveLoadPanel();
        createTextArea();

        validate();
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        menu = new JMenu("File");
        menu.setName("MenuFile");

        loadMenuItem = new JMenuItem("Load");
        saveMenuItem = new JMenuItem("Save");
        exitMenuItem = new JMenuItem("Exit");

        loadMenuItem.setName("MenuLoad");
        saveMenuItem.setName("MenuSave");
        exitMenuItem.setName("MenuExit");

        menu.add(loadMenuItem);
        menu.add(saveMenuItem);
        menu.addSeparator();
        menu.add(exitMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        loadMenuItem.addActionListener(actionEvent -> Saver.load(filenameField, textArea));
        saveMenuItem.addActionListener(actionEvent -> Saver.save(filenameField.getText(), textArea.getText()));
        exitMenuItem.addActionListener(actionEvent -> dispose());
    }

    private void createSaveLoadPanel() {
        filenameField = new JTextField();
        filenameField.setName("FilenameField");

        saveButton = new JButton("Save" );
        saveButton.setName("SaveButton");
        saveButton.addActionListener(actionEvent -> Saver.save(filenameField.getText(), textArea.getText()));

        loadButton = new JButton("Load");
        loadButton.setName("LoadButton");
        loadButton.addActionListener(actionEvent -> Saver.load(filenameField, textArea));

        saveLoadPanel = new JPanel();
        saveLoadPanel.setLayout(new BoxLayout(saveLoadPanel, BoxLayout.X_AXIS));
        saveLoadPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        saveLoadPanel.add(filenameField);
        saveLoadPanel.add(Box.createHorizontalStrut(10));
        saveLoadPanel.add(saveButton);
        saveLoadPanel.add(Box.createHorizontalStrut(10));
        saveLoadPanel.add(loadButton);
        add(saveLoadPanel, BorderLayout.NORTH);
    }

    private void createTextArea() {
        textArea = new JTextArea();
        textArea.setName("TextArea");
        textArea.setSize(250, 250);
        textArea.setVisible(true);

        scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setName("ScrollPane");

        textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new BorderLayout());
        textAreaPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        textAreaPanel.add(scrollPane);
        add(textAreaPanel, BorderLayout.CENTER);
    }
}
