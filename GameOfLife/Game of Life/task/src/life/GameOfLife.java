package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame{
    JLabel generationLabel;
    JLabel aliveLabel;
    JPanel grid;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);

        JPanel labels = new JPanel();
        BoxLayout layout = new BoxLayout(labels, BoxLayout.Y_AXIS);
        labels.setLayout(layout);

        labels.setAlignmentX(0);
        labels.setAlignmentY(0);

        generationLabel = new JLabel("Generation #1");
        generationLabel.setName("GenerationLabel");
        generationLabel.setVerticalAlignment(SwingConstants.TOP);
        labels.add(generationLabel);

        aliveLabel = new JLabel("Alive: 0");
        aliveLabel.setName("AliveLabel");
        labels.add(aliveLabel);

        add(labels);

        grid = new JPanel();
        add(grid);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        labels.revalidate();
        grid.revalidate();
    }

    private void drawLines(Graphics g, Generation gen) {
        //g.drawRect(10, 10, this.getWidth() - 40, this.getHeight() - 100);
        int rectWidth = (this.getWidth() - 40) / gen.getGeneration().length;
        int rectHeight = (this.getHeight() - 100) / gen.getGeneration().length;

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
