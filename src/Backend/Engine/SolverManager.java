package Backend.Engine;

import Backend.Objects.Board;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class SolverManager {
    private static Board initialConfig;
    private static Map<Board, Board> map = new HashMap<>();
    private static Queue<Board> queue = new LinkedList<>();
    private static boolean found = false;

    public static void main(String[] args) {
        new BoardManager("input.txt");
        Board test = BoardManager.board;
        Solve(test);
    }

    /**
     * One calls upon this method, providing an initial board object,
     * and the method will endeavour to solve the puzzle.
     * <p>
     * This is done using a classic Breadth-First Search, incorporating a queue to line up
     * the next board objects to be processed.
     *
     * @param initial An initial board file. The one you wish to solve
     */
    public static void Solve(Board initial) {
        //Copy the initial to resolve reference issues.
        initialConfig = initial.copy();

        //Lodge the first move upon null, thereby activating 'layer 1' of the BFS
        lodgeMove(initialConfig, null);

        //Initialise current to null, hence allowing the queue to be extracted to it.
        Board current = null;
        while (!queue.isEmpty() && !found) {
            current = queue.remove();
            System.out.println(current.toString());
            findMoves(current);
        }
    }

    /**
     * This method is called once the program has detected a solution
     * It backtracks through the HashMap, thereby continually grabbing the previous board state,
     * and hence tracing and counting the required moves to solve
     *
     * @param winBoard The board layout of the successfully completed puzzle, as supplied by lodgeMove
     */
    public static void runWin(Board winBoard) {
        found = true;
        System.out.println(winBoard.toString());
        Board test = map.get(winBoard);
        int counter = 0;
        do {
            counter++;
            test = map.get(test);
        } while (test != null);

        System.out.println(counter + " moves.");

    }

    /**
     * Inspiration for this class was taken from:
     * http://stackoverflow.com/questions/2877724/rush-hour-solving-the-game
     *
     * LodgeMove incorporates a HashMap to track the tree of solutions.
     * It uses a queue to tell the program to search the newly created modified board objects.
     *
     * @param moddedBoard The board with a modified piece
     * @param currentBoard The board from the previous step (the node before the modified board in the has map tree)
     */
    private static void lodgeMove(Board moddedBoard, Board currentBoard) {
        int overflowLimit = 100000;
        if (moddedBoard.isValid()) {
            if (!map.containsKey(moddedBoard) && overflowLimit >= 0) {
                overflowLimit--;

                //Place the modified board into the hash map, with the current board as reference.
                map.put(moddedBoard, currentBoard);

                //Add the modified board to the queue, thereby activating it for the next level of processing.
                queue.add(moddedBoard);

                //Checks for a win
                if (moddedBoard.checkWin()) {
                    runWin(moddedBoard);
                }
            }
        }
    }

    /**
     * This method scans creates a new instance of a board for every piece that can move.
     *
     * These instances are passed onto lodgeMove, which adds them to the solutions tree,
     * as well as to the queue for the next step.
     *
     * @param currentBoard Current node you are working with in the tree, from which nodes will be created.
     */
    private static void findMoves(Board currentBoard) {
        for (int i = 0; i < currentBoard.getCarArray().length; i++) {

            if (currentBoard.getCarArray()[i].movesDown()) {
                Board newBoardDown = currentBoard.copy();
                newBoardDown.runMove(newBoardDown.getCarArray()[i].getColumn(), newBoardDown.getCarArray()[i].getRow(), BoardManager.MOVE_DOWN);
                lodgeMove(newBoardDown, currentBoard);
            }

            if (currentBoard.getCarArray()[i].movesUp()) {
                Board newBoardUp = currentBoard.copy();
                newBoardUp.runMove(newBoardUp.getCarArray()[i].getColumn(), newBoardUp.getCarArray()[i].getRow(), BoardManager.MOVE_UP);
                lodgeMove(newBoardUp, currentBoard);
            }

            if (currentBoard.getCarArray()[i].movesLeft()) {
                Board newBoardLeft = currentBoard.copy();
                newBoardLeft.runMove(newBoardLeft.getCarArray()[i].getColumn(), newBoardLeft.getCarArray()[i].getRow(), BoardManager.MOVE_LEFT);
                lodgeMove(newBoardLeft, currentBoard);
            }

            if (currentBoard.getCarArray()[i].movesRight()) {
                Board newBoardRight = currentBoard.copy();
                newBoardRight.runMove(newBoardRight.getCarArray()[i].getColumn(), newBoardRight.getCarArray()[i].getRow(), BoardManager.MOVE_RIGHT);
                lodgeMove(newBoardRight, currentBoard);
            }
        }
    }
}
