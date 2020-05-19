package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame{
    JLabel generationLabel;
    JLabel aliveLabel;
    JPanel grid;

    JButton pauseButton;
    JButton resetButton;
    JSlider speedSlider;

    private boolean reset = false;
    private boolean paused = false;
    private int speed = 10;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);

        JPanel options = new JPanel();
        BoxLayout optionsLayout = new BoxLayout(options, BoxLayout.Y_AXIS);
        options.setLayout(optionsLayout);

        JPanel interactions = createInteractions();
        options.add(interactions);

        JPanel labels = createLabels();
        options.add(Box.createVerticalStrut(30));
        options.add(labels);
        
        add(options);

        grid = new JPanel();
        add(grid);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        options.revalidate();
        interactions.revalidate();
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

    private JPanel createInteractions() {
        JPanel interactions = new JPanel();
        BoxLayout buttonsLayout = new BoxLayout(interactions, BoxLayout.X_AXIS);
        interactions.setLayout(buttonsLayout);
        interactions.setAlignmentX(0);
        interactions.setAlignmentY(0);

        pauseButton = new JButton(new ImageIcon(
                "C:\\development\\Learning\\Java\\IdeaProjects\\GameOfLife\\Game of Life\\task\\src\\Images\\pause.jpg"));
        pauseButton.setName("PlayToggleButton");
        pauseButton.setVerticalAlignment(SwingConstants.TOP);
        interactions.add(pauseButton);

        pauseButton.addActionListener(e -> {
            if (paused) {
                paused = false;
                pauseButton.setIcon(new ImageIcon(
                        "C:\\development\\Learning\\Java\\IdeaProjects\\GameOfLife\\Game of Life\\task\\src\\Images\\pause.jpg"));
            } else {
                paused = true;
                pauseButton.setIcon(new ImageIcon(
                        "C:\\development\\Learning\\Java\\IdeaProjects\\GameOfLife\\Game of Life\\task\\src\\Images\\play.png"));
            }
        });

        resetButton = new JButton(new ImageIcon(
                "C:\\development\\Learning\\Java\\IdeaProjects\\GameOfLife\\Game of Life\\task\\src\\Images\\reset.jpg"));
        resetButton.setName("ResetButton");
        resetButton.setVerticalAlignment(SwingConstants.TOP);
        interactions.add(resetButton);

        resetButton.addActionListener(e -> {
            reset = true;
        });

        speedSlider = new JSlider();
        speedSlider.setMinimum(1);
        speedSlider.setMaximum(30);
        speedSlider.setValue(10);
        interactions.add(speedSlider);

        speedSlider.addChangeListener(e -> {
            speed = speedSlider.getValue();
        });

        return interactions;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public boolean isPaused() {
        return paused;
    }

    public int getSpeed() {
        return speed;
    }

    private JPanel createLabels() {
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

        return labels;
    }
}
