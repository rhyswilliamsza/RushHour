package FrontEnd;

import Backend.Engine.BoardManager;
import Backend.Objects.Car;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rhys Williams
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
class Canvas extends JFrame {
    private JPanel mainPanel;

    /**
     * Rendering engine and canvas for the visual representation of my board
     */
    public Canvas() {
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        if (BoardManager.board.isValid()) {
            mainPanel = new JPanel(new GridLayout(BoardManager.board.getRows(), BoardManager.board.getColumns()));
            drawGame();
        }
        this.setVisible(true);
    }

    /**
     * Update the canvas with new information from the BoardManager class.
     */
    public void update() {
        drawGame();
    }

    /**
     * Draws the board by pulling the current board from the BoardManager class.
     */
    private void drawGame() {
        if (BoardManager.board.isValid()) {
            Car[][] array = BoardManager.board.to2DArray();
            JPanel newPanel = new JPanel(new GridLayout(array.length, array[0].length));

            for (int r = 0; r < BoardManager.board.getRows(); r++) {
                for (int c = 0; c < BoardManager.board.getColumns(); c++) {
                    JPanel block = new JPanel();

                    //Check Dimensions and Resizes to fit Screen
                    int blockSize = 100;
                    if (BoardManager.board.getRows() >= 6) {
                        if (800 / BoardManager.board.getRows() < blockSize) {
                            blockSize = 800 / BoardManager.board.getRows();
                        }
                    }

                    if (BoardManager.board.getColumns() >= 6) {
                        if (800 / BoardManager.board.getColumns() < blockSize) {
                            blockSize = 800 / BoardManager.board.getColumns();
                        }
                    }

                    block.setPreferredSize(new Dimension(blockSize, blockSize));
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
        }
    }
}
