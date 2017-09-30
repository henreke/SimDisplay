package display;

import display.components.Gear;
import server.UDPPacket;

import javax.swing.*;
import java.awt.*;

public class Display {

    private static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    private Image img;

    private final JWindow splash = new JWindow();
    private final JFrame frame = new JFrame("Display");

    // Gear
    private JPanel gearPanel;
    private Gear gear = new Gear();

    public Display(String img) {

        //this.showSplashScreen(img);

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setUndecorated(true);

        this.device.setFullScreenWindow(this.frame);

        this.initializePanels();

        this.frame.pack();
    }

    public void init() {
        frame.setVisible(true);
    }

    public void refresh (UDPPacket info) {
        this.gear.setGear(Math.round(info.m_gear));
        this.validate();
        this.repaint();
    }

    private void showSplashScreen(String img) {
        new SplashScreen(img);
    }

    private void initializePanels() {
        this.gearPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.gearPanel.add(gear.getGear(), BorderLayout.CENTER);
        this.gearPanel.setBackground(Color.BLACK);
        this.frame.add(this.gearPanel);
    }

    private void validate() {
        this.gearPanel.validate();
    }

    private void repaint() {
        this.gearPanel.repaint();
    }
}