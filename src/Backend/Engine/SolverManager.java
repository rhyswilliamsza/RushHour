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
    private static Map<Board, Board> map = new HashMap<Board, Board>();
    private static Queue<Board> queue = new LinkedList<>();
    private static boolean found = false;

    public static void main(String[] args) {
        new BoardManager("input.txt");
        Board test = BoardManager.board;

        Solve(test);
    }

    public static void Solve(Board initial) {
        Board now = initial;
        initialConfig = initial;
        lodgeMove(initialConfig.copy(), null);

        int counter = 0;
        while (!queue.isEmpty() && !found) {
            counter++;
            now = queue.remove();
            findMoves(now);
        }

        if (found) {
            System.out.println(counter);

//            Board test;
//            do {
//                test = map.get(now);
//                System.out.println(test.hashCode());
//            } while (test != null);


        }
    }

    // Inspiration for this class was taken from
    // http://stackoverflow.com/questions/2877724/rush-hour-solving-the-game
    static int counter = 0;

    private static void lodgeMove(Board moddedBoard, Board currentBoard) {
        if (!map.containsKey(moddedBoard) && counter < 100000) {
            counter++;
            map.put(moddedBoard, currentBoard);
            queue.add(moddedBoard);

            if (moddedBoard.checkWin()) {
                System.out.println("WON");
                found = true;
            }
        }
    }

    private static void findMoves(Board currentBoard) {
        Board newBoard;
        for (int i = 0; i < currentBoard.getCarArray().length; i++) {

            newBoard = currentBoard.copy();
            //newBoard.getCarArray()[i].moveDown();
            newBoard.runMove(newBoard.getCarArray()[i].getColumn(), newBoard.getCarArray()[i].getRow(), BoardManager.MOVE_DOWN);
            lodgeMove(newBoard, currentBoard);

            newBoard = currentBoard.copy();
            //newBoard.getCarArray()[i].moveUp();
            newBoard.runMove(newBoard.getCarArray()[i].getColumn(), newBoard.getCarArray()[i].getRow(), BoardManager.MOVE_UP);
            lodgeMove(newBoard, currentBoard);

            newBoard = currentBoard.copy();
            //newBoard.getCarArray()[i].moveLeft();
            newBoard.runMove(newBoard.getCarArray()[i].getColumn(), newBoard.getCarArray()[i].getRow(), BoardManager.MOVE_LEFT);
            lodgeMove(newBoard, currentBoard);

            newBoard = currentBoard.copy();
            //newBoard.getCarArray()[i].moveRight();
            newBoard.runMove(newBoard.getCarArray()[i].getColumn(), newBoard.getCarArray()[i].getRow(), BoardManager.MOVE_RIGHT);
            lodgeMove(newBoard, currentBoard);
        }
    }
}
