package Backend.Engine;

import FrontEnd.UIManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Rhys Williams
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class SolutionManager {

    /**
     * Runs a solution file, as provided in String format.
     *
     * @param solutionString String format of a solution file.
     */
    public static void runSolutionsString(String solutionString) {
        Scanner solutionScan = new Scanner(solutionString);
        runSolution(solutionScan);
    }

    /**
     * Reads a solution file, as provided by a file path.
     *
     * @param filePath File path format of a solution file.
     */
    public static void runSolutionsFile(String filePath) {
        File solutionFile = new File(filePath);
        try {
            Scanner solutionScan = new Scanner(solutionFile);
            runSolution(solutionScan);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Run solution file. This analyses each move, checks if it is valid,
     * and the parses it to the currently displayed board.
     *
     * @param solutionScan Scanner containing the solution file.
     */
    private static void runSolution(Scanner solutionScan) {
        while (solutionScan.hasNextLine() && BoardManager.isRunning()) {
            //Delay each move by 1s
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Scanner lineScan = new Scanner(solutionScan.nextLine()).useDelimiter(" ");
            int c = lineScan.nextInt();
            int r = lineScan.nextInt();
            lineScan.close();

            String directionString = solutionScan.nextLine();
            int directionInt = -1;
            if (directionString.contains("right")) {
                directionInt = BoardManager.MOVE_RIGHT;
            }
            if (directionString.contains("left")) {
                directionInt = BoardManager.MOVE_LEFT;
            }
            if (directionString.contains("up")) {
                directionInt = BoardManager.MOVE_UP;
            }
            if (directionString.contains("down")) {
                directionInt = BoardManager.MOVE_DOWN;
            }

            BoardManager.board.runMove(c, r, directionInt);
            UIManager.runCanvasUpdate();
        }

        solutionScan.close();
    }

}
