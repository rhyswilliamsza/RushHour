import Backend.Engine.BoardManager;
import FrontEnd.Canvas;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class Main {
    public static void main(String[] args) {
        //Load File
        new BoardManager("input.txt");

        //Draw to Canvas
        Canvas test = new Canvas();

        BoardManager.runMove(2,1,BoardManager.MOVE_DOWN);
        test.update();
    }
}
