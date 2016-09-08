import Backend.Engine.BoardManager;
import Backend.Engine.SolutionManager;
import Backend.Engine.SolverManager;
import FrontEnd.UIManager;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class RushHour {
    /**
     * RushHour is a game consists of a collection of cars of varying sizes,
     * set either horizontally or vertically, on a NxM grid that has a single exit.
     * <p>
     * The purpose of the game is to get a red car to the exit,
     * by moving the other cars out of the way.
     *
     * @param args
     */
    public static void main(String[] args) {

        //Load File
        new BoardManager(args[0]);

        //Draw to Canvas
        UIManager.startUI();

        //Run Solution File if 2nd Args Given
        if (args.length == 2) {
            SolutionManager.runSolutionsFile(args[1]);
        } else {
            SolutionManager.runSolutionsString(SolverManager.Solve(BoardManager.board));
        }
    }
}
