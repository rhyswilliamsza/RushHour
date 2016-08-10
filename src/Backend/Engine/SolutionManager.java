package Backend.E
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

    //Reads solution file and parses each move to the BoardManager
    public static void runSolutionsFile(String filePath) {
        File solutionFile = new File(filePath);
        try {
            Scanner solutionScan = new Scanner(solutionFile);

            while (solutionScan.hasNextLine() && BoardManager.isRunning()) {
                //Delay each move by 1s
                try {
                    Thread.sleep(1000);
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

                BoardManager.runMove(c, r, directionInt);
                UIManager.runCanvasUpdate();
            }

            solutionScan.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
