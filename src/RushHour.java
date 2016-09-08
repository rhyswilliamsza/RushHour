import Backend.Engine.BoardManager;
import Backend.Engine.SolutionManager;
import Backend.Engine.SolverManager;
import FrontEnd.UIManager;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
class RushHour {
    /**
     * According to our project spec,
     * RushHour is a game consists of a collection of cars of varying sizes,
     * set either horizontally or vertically, on a NxM grid that has a single exit.
     * <p>
     * The purpose of the game is to get a red car to the exit,
     * by moving the other cars out of the way.
     * <p>
     * There are two methods of game play. If two program arguments are given,
     * the program will use the file provided by the second argument as a 'solutions' file.
     * Otherwise, the program will endeavour to solve the puzzle using a 'SolverManager' class.
     * <p>
     * Please see SolverManager for more information.
     *
     * @param args Program arguments. First, Board File. Second, if given, Solutions file.
     */
    public static void main(String[] args) {

        //Load File
        new BoardManager(args[0]);

        //Draw to Canvas
        UIManager.startUI();

        //Check if solution file provided, and run, otherwise solve.
        if (args.length == 2) {
            SolutionManager.runSolutionsFile(args[1]);
        } else {
            SolutionManager.runSolutionsString(SolverManager.Solve(BoardManager.board));
        }
    }
}
