package FrontEnd;

import Backend.Engine.BoardManager;
import Backend.Pieces.Car;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rhys Williams
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class Canvas extends JFrame {
    JPanel mainPanel;

    public Canvas() {
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel = new JPanel(new GridLayout(BoardManager.getBoardRows(), BoardManager.getBoardColumns()));
        drawGame();
    }

    public void update() {
        drawGame();
    }

    public void showMessage (String message) {
        JPanel messagePanel = new JPanel(new GridBagLayout());
        messagePanel.setPreferredSize(new Dimension(BoardManager.getBoardColumns()*100,BoardManager.getBoardRows()*100));
        messagePanel.setBackground(new Color(65, 131, 215));
        JLabel messageLabel = new JLabel(message);
        messagePanel.add(messageLabel);
        this.getContentPane().removeAll();
        this.add(messagePanel);
        this.getContentPane().repaint();
        this.pack();
    }

    private void drawGame() {
        Car[][] array = BoardManager.to2DArray();
        JPanel newPanel = new JPanel(new GridLayout(array.length, array[0].length));

        for (int r = 0; r < BoardManager.getBoardRows(); r++) {
            for (int c = 0; c < BoardManager.getBoardColumns(); c++) {
                JPanel block = new JPanel();
                block.setPreferredSize(new Dimension(100, 100));
                block.setBorder(BorderFactory.createLineBorder(new Color(58, 58, 58)));
                try {
                    block.setBackground(array[r][c].getCarColour());
                } catch (Exception e) {
                    int greyScale = 255 - (int) ((Math.random()) * 10);
                    block.setBackground(new Color(greyScale, greyScale, greyScale));
                }
                newPanel.add(block);
            }
        }

        this.add(newPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
