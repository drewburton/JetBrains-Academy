package editor;

import javax.swing.*;
import java.awt.*;

/*
todo
 - make load use FileChooser
 - make searching work
 */

public class TextEditor extends JFrame {
    JTextField filenameField;
    JTextArea textArea;
    JCheckBox regExpCheckBox;

    JFileChooser fileChooser;

    boolean useRegex;

    public TextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setTitle("Text Editor");

        // for testing
//        fileChooser = new JFileChooser(
//                "C:\\development\\Learning\\Java\\IdeaProjects\\Text Editor");
        fileChooser = new JFileChooser();
        fileChooser.setName("FileChooser");
        add(fileChooser);

        createMenuBar();
        createSaveLoadPanel();
        createTextArea();

        validate();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu searchMenu = new JMenu("Search");

        createFileMenu(fileMenu);
        createSearchMenu(searchMenu);

        menuBar.add(fileMenu);
        menuBar.add(searchMenu);
        setJMenuBar(menuBar);
    }

    private void createFileMenu(JMenu fileMenu) {
        fileMenu.setName("MenuFile");

        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        openMenuItem.setName("MenuOpen");
        saveMenuItem.setName("MenuSave");
        exitMenuItem.setName("MenuExit");

        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        openMenuItem.addActionListener(actionEvent -> Saver.load(fileChooser, textArea));
        saveMenuItem.addActionListener(actionEvent -> Saver.save(filenameField.getText(), textArea.getText()));
        exitMenuItem.addActionListener(actionEvent -> dispose());
    }

    private void createSearchMenu(JMenu searchMenu) {
        searchMenu.setName("MenuSearch");

        JMenuItem startSearchMenuItem = new JMenuItem("Start search");
        JMenuItem previousMenuItem = new JMenuItem("Previous search");
        JMenuItem nextMenuItem = new JMenuItem("Next match");
        JMenuItem regExpMenuItem = new JMenuItem("Use regular expressions");

        startSearchMenuItem.setName("MenuStartSearch");
        previousMenuItem.setName("MenuPreviousMatch");
        nextMenuItem.setName("MenuNextMatch");
        regExpMenuItem.setName("MenuUseRegExp");

        searchMenu.add(startSearchMenuItem);
        searchMenu.add(previousMenuItem);
        searchMenu.add(nextMenuItem);
        searchMenu.add(regExpMenuItem);

        startSearchMenuItem.addActionListener(actionEvent -> new Thread(() -> Searcher.startSearch(textArea, filenameField.getText(), useRegex)).start());
        previousMenuItem.addActionListener(actionEvent -> new Thread(Searcher::previousMatch).start());
        nextMenuItem.addActionListener(actionEvent -> new Thread(Searcher::nextMatch).start());
        regExpMenuItem.addActionListener(actionEvent -> {
            useRegex = !useRegex;
            regExpCheckBox.setSelected(useRegex);
        });
    }

    private void createSaveLoadPanel() {
        filenameField = new JTextField();
        filenameField.setName("SearchField");

        JButton[] buttons = getButtons();

        regExpCheckBox = new JCheckBox("Use regex");
        regExpCheckBox.setName("UseRegExCheckbox");
        regExpCheckBox.addActionListener(actionEvent -> useRegex = regExpCheckBox.isSelected());

        JPanel saveLoadPanel = new JPanel();
        saveLoadPanel.setLayout(new BoxLayout(saveLoadPanel, BoxLayout.X_AXIS));
        saveLoadPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        saveLoadPanel.add(buttons[0]);
        saveLoadPanel.add(Box.createHorizontalStrut(10));
        saveLoadPanel.add(buttons[1]);
        saveLoadPanel.add(Box.createHorizontalStrut(10));
        saveLoadPanel.add(filenameField);
        saveLoadPanel.add(Box.createHorizontalStrut(10));
        saveLoadPanel.add(buttons[2]);
        saveLoadPanel.add(Box.createHorizontalStrut(10));
        saveLoadPanel.add(buttons[3]);
        saveLoadPanel.add(Box.createHorizontalStrut(10));
        saveLoadPanel.add(buttons[4]);
        saveLoadPanel.add(Box.createHorizontalStrut(10));
        saveLoadPanel.add(regExpCheckBox);

        add(saveLoadPanel, BorderLayout.NORTH);
    }

    private JButton[] getButtons() {
        JButton saveButton = new JButton(new ImageIcon(
                "C:\\development\\Learning\\Java\\IdeaProjects\\Text Editor\\Text Editor\\task\\src\\editor\\save.png"));
        saveButton.setPreferredSize(new Dimension(35, 30));
        saveButton.setName("SaveButton");
        saveButton.addActionListener(actionEvent -> Saver.save(filenameField.getText(), textArea.getText()));

        JButton loadButton = new JButton(new ImageIcon(
                "C:\\development\\Learning\\Java\\IdeaProjects\\Text Editor\\Text Editor\\task\\src\\editor\\import.png"));
        loadButton.setPreferredSize(new Dimension(35, 30));
        loadButton.setName("OpenButton");
        loadButton.addActionListener(actionEvent -> Saver.load(fileChooser, textArea));

        JButton searchButton = new JButton(new ImageIcon(
                "C:\\development\\Learning\\Java\\IdeaProjects\\Text Editor\\Text Editor\\task\\src\\editor\\search.png"));
        searchButton.setPreferredSize(new Dimension(35, 30));
        searchButton.setName("StartSearchButton");
        searchButton.addActionListener(actionEvent -> new Thread(() -> Searcher.startSearch(textArea, filenameField.getText(), useRegex)).start());

        JButton previousButton = new JButton(new ImageIcon(
                "C:\\development\\Learning\\Java\\IdeaProjects\\Text Editor\\Text Editor\\task\\src\\editor\\left.png"));
        previousButton.setPreferredSize(new Dimension(35, 30));
        previousButton.setName("PreviousMatchButton");
        previousButton.addActionListener(actionEvent -> new Thread(Searcher::previousMatch).start());

        JButton nextButton = new JButton(new ImageIcon(
                "C:\\development\\Learning\\Java\\IdeaProjects\\Text Editor\\Text Editor\\task\\src\\editor\\right.png"));
        nextButton.setPreferredSize(new Dimension(35, 30));
        nextButton.setName("NextMatchButton");
        nextButton.addActionListener(actionEvent -> new Thread(Searcher::nextMatch).start());

        JButton[] buttons = new JButton[5];
        buttons[0] = saveButton;
        buttons[1] = loadButton;
        buttons[2] = searchButton;
        buttons[3] = previousButton;
        buttons[4] = nextButton;
        return buttons;
    }

    private void createTextArea() {
        textArea = new JTextArea();
        textArea.setName("TextArea");
        textArea.setSize(250, 250);
        textArea.setVisible(true);

        JScrollPane scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setName("ScrollPane");

        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new BorderLayout());
        textAreaPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        textAreaPanel.add(scrollPane);
        add(textAreaPanel, BorderLayout.CENTER);
    }
}
