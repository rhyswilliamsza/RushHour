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
     *             Ammend -v for visual, -c for counter
     */
    public static void main(String[] args) {

        //Checks if an input file was given and assigns to variable.
        if (args.length > 0) {
            new BoardManager(args[0]);
        } else {
            System.out.println("Please give an input file");
        }

        //Checks if a solutions file is given
        if (args.length >= 2) {
            String arguments = "";
            for (int i = 1; i < args.length; i++) {
                arguments += " " + args[i];
            }

            if (!args[1].contains("-")) {
                UIManager.startUI();
                SolutionManager.runSolutionsFile(args[1]);
            } else {
                if (arguments.contains("-v")) {

                    //Draw to Canvas
                    UIManager.startUI();

                    //Run solution on UI
                    SolutionManager.runSolutionsString(SolverManager.Solve(BoardManager.board));
                } else if (arguments.contains("-c")) {

                    //Print solution to console
                    SolverManager.Solve(BoardManager.board);

                }
            }


        }
    }
}
