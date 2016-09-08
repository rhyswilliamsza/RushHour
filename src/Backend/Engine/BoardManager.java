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
    public static Board board;
    private static boolean running = true;

    /**
     * This class manages the currently displayed board (on screen).
     * It also manages checking for a win.
     *
     * @param inputFileString
     */
    public BoardManager(String inputFileString) {
        BoardFile boardFile = new BoardFile(inputFileString);
        board = new Board();
        board.setRows(boardFile.getM());
        board.setColumns(boardFile.getN());
        board.setCarArray(boardFile.getCarArray());

        if (!board.isValid()) {
            UIManager.showMessage("The board file is corrupt!");
            running = false;
        }
    }

    public static void checkWin() {
        if (board.checkWin()) {
            UIManager.showMessage("You won!");
        }
    }

    public static boolean isRunning() {
        return running;
    }
}
