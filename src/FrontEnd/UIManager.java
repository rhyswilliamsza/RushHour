package FrontEnd;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class UIManager {
    private static Canvas canvas;
    private static FrontEnd.Message message;

    public static void startUI() {
        canvas = new Canvas();
    }

    public static void runCanvasUpdate() {
        canvas.update();
    }

    public static void showMessage(String messageToShow) {
        if (canvas != null) {
            canvas.setVisible(false);
        }

        if (message != null) {
            message.setMessage(messageToShow);
        } else {
            message = new FrontEnd.Message(messageToShow);
        }

    }
}
