package FrontEnd;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rhys Williams
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class Message extends JFrame {
    JLabel messageLabel;

    /**
     * Displays message of type String in it's own window.
     *
     * @param message Message in String format.
     */
    public Message(String message) {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel messagePanel = new JPanel(new GridBagLayout());
        messagePanel.setPreferredSize(new Dimension(400, 400));
        messagePanel.setBackground(new Color(65, 131, 215));
        messageLabel = new JLabel(message);
        messageLabel.setForeground(Color.WHITE);
        messagePanel.add(messageLabel);
        this.add(messagePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setMessage(String message) {
        messageLabel.setText(message);
    }
}
