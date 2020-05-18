package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame{
    JLabel generationLabel;
    JLabel aliveLabel;
    JPanel grid;

    JButton pauseButton;
    JButton resetButton;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);

        JPanel options = new JPanel();
        BoxLayout optionsLayout = new BoxLayout(options, BoxLayout.Y_AXIS);
        options.setLayout(optionsLayout);

        JPanel buttons = new JPanel();
        BoxLayout buttonsLayout = new BoxLayout(buttons, BoxLayout.X_AXIS);
        buttons.setLayout(buttonsLayout);
        buttons.setAlignmentX(0);
        buttons.setAlignmentY(0);

        pauseButton = new JButton(new ImageIcon(
                "C:\\development\\Learning\\Java\\IdeaProjects\\GameOfLife\\Game of Life\\task\\src\\Images\\pause.jpg"));
        pauseButton.setName("PlayToggleButton");
        pauseButton.setVerticalAlignment(SwingConstants.TOP);
        buttons.add(pauseButton);

        resetButton = new JButton(new ImageIcon(
                "C:\\development\\Learning\\Java\\IdeaProjects\\GameOfLife\\Game of Life\\task\\src\\Images\\reset.jpg"));
        resetButton.setName("ResetButton");
        resetButton.setVerticalAlignment(SwingConstants.TOP);
        buttons.add(resetButton);

        options.add(buttons);


        JPanel labels = new JPanel();
        BoxLayout labelsLayout = new BoxLayout(labels, BoxLayout.Y_AXIS);
        labels.setLayout(labelsLayout);
        labels.setAlignmentX(0);
        labels.setAlignmentY(0);

        generationLabel = new JLabel("Generation #1");
        generationLabel.setName("GenerationLabel");
        generationLabel.setVerticalAlignment(SwingConstants.TOP);
        labels.add(generationLabel);

        aliveLabel = new JLabel("Alive: 0");
        aliveLabel.setName("AliveLabel");
        labels.add(aliveLabel);

        options.add(Box.createVerticalStrut(30));
        options.add(labels);
        
        add(options);


        grid = new JPanel();
        add(grid);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        options.revalidate();
        buttons.revalidate();
        labels.revalidate();
        grid.revalidate();
    }

    private void drawLines(Graphics g, Generation gen) {
        //g.drawRect(10, 10, this.getWidth() - 40, this.getHeight() - 100);
        int rectWidth = (this.getWidth() - 40) / gen.getGeneration().length;
        int rectHeight = (this.getHeight() - 150) / gen.getGeneration().length;

        for (int i = 0; i <= gen.getGeneration().length; i++) {
            // draw vertical lines
            g.drawLine(10 + rectWidth * i, 10, 10 + rectWidth * i, 10 + rectHeight * gen.getGeneration().length);

            // draw horizontal lines
            g.drawLine(10, 10 + rectHeight * i, 10 + rectWidth * gen.getGeneration().length, 10 + rectHeight * i);
        }

        boolean[][] map = gen.getGeneration();
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map.length; c++) {
                if (map[r][c]) {
                    g.fillRect(10 + rectWidth * c, 10 + rectHeight * r, rectWidth, rectHeight);
                }
            }
        }
    }

    public void createMap(Generation generation, int generationCount) {
        generationLabel.setText("Generation #" + generationCount);
        aliveLabel.setText("Alive: " + generation.getAlive());

        remove(grid);
        grid = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawLines(g, generation);
            }
        };
        add(grid);
        grid.revalidate();
    }
}
