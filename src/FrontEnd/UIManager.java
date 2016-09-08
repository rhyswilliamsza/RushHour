package FrontEnd;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class UIManager {
    private static Canvas canvas;
    private static FrontEnd.Message message;

    /**
     * Starts the canvas UI.
     */
    public static void startUI() {
        canvas = new Canvas();
    }

    /**
     * Requests a  change on the canvas UI, therefore forcing an update.
     */
    public static void runCanvasUpdate() {
        canvas.update();
    }

    /**
     * Show a message using the Message class.
     *
     * @param messageToShow Message in String format
     */
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
