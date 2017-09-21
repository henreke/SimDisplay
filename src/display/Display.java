package display;

import display.components.Gear;

import javax.swing.*;
import java.awt.*;

public class Display {

    private static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    private final JFrame frame = new JFrame("Display");


    // Gear
    JPanel gearPanel;
    Gear gear = new Gear();

    public Display() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        device.setFullScreenWindow(frame);

        this.initializePanels();

        frame.pack();
    }

    public void init() {
        frame.setVisible(true);
    }

    public void changeGear(int gear) {
        this.gear.setGear(gear);
        gearPanel.validate();
        gearPanel.repaint();
    }

    private void initializePanels() {
        gearPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        gearPanel.add(gear.getGear(), BorderLayout.CENTER);
        gearPanel.setBackground(Color.BLACK);
        frame.add(gearPanel);
    }
}