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
        new Canvas();
    }
}
