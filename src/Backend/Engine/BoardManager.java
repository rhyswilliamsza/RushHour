package Backend.Engine;

import Backend.Objects.Board;
import FrontEnd.UIManager;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class BoardManager {
    public static final int MOVE_RIGHT = 0;
    public static final int MOVE_LEFT = 1;
    public static final int MOVE_UP = 2;
    public static final int MOVE_DOWN = 3;
    private static boolean running = true;
    public static Board board;

    //BoardManager - Loads Board File from Input
    public BoardManager(String inputFileString) {
        board = new Board();
        BoardFile boardFile = new BoardFile(inputFileString);
        board.setRows(boardFile.getM());
        board.setColumns(boardFile.getN());
        board.setCarArray(boardFile.getCarArray());

        if (!board.isValid()) {
            UIManager.showMessage("The board file is corrupt!");
        }
    }

    /**
     * Checks if the player has won
     */
    public static void checkWin() {
        if (board.getCarArray()[0].getColumn() + board.getCarArray()[0].getWidth() == board.getColumns()) {
            UIManager.showMessage("You won!");
        }
    }

    public static boolean isRunning() {
        return running;
    }
}
