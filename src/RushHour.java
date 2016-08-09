import Backend.Engine.BoardManager;
import Backend.Engine.SolutionManager;
import FrontEnd.UIManager;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class RushHour {
    public static void main(String[] args) {

        //Load File
        new BoardManager(args[0]);

        //Draw to Canvas
        UIManager.startUI();

        //Run Solution File
        if (args.length == 2) {
            SolutionManager.runSolutionsFile(args[1]);
        }
    }
}
