package FrontEnd;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class UIManager {
    private static Canvas canvas;
    public static void startUI () {
        canvas = new Canvas();
    }

    public static void runCanvasUpdate () {
        canvas.update();
    }

    public static void showMessage (String message) {
        canvas.showMessage(message);
    }
}
