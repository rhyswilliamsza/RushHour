import Backend.Engine.BoardManager;
import Backend.Engine.SolutionManager;
import FrontEnd.Canvas;
import FrontEnd.UIManager;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class Run {
    public static void main(String[] args) {
        //Load File
        new BoardManager("input.txt");

        //Draw to Canvas
        UIManager.startUI();

        //Run Solution File
        SolutionManager.runSolutionsFile("solution.txt");
        UIManager.showMessage("Completed!");
    }
}
