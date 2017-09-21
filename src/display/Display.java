package display;

import javax.swing.*;
import java.awt.*;

public class Display {

    private static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    private final JFrame frame = new JFrame("Display");

    public Display() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        device.setFullScreenWindow(frame);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        frame.add(panel);

        frame.pack();
    }

    public void init() {
        frame.setVisible(true);
    }
}