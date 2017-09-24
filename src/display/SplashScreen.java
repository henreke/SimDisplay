package display;

import javax.swing.JWindow;
import java.awt.*;

public class SplashScreen extends JWindow {

    private static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    Image img;

    public SplashScreen(String img) {
        try {
            this.img = Toolkit.getDefaultToolkit().getImage(img);
            setLocationRelativeTo(null);
            device.setFullScreenWindow(this);
            this.setVisible(true);
            Thread.sleep(5000);
            dispose();
        } catch (Exception exception) {
            javax.swing.JOptionPane.showMessageDialog((java.awt.Component) null, "Error" + exception.getMessage(), "Error:", javax.swing.JOptionPane.DEFAULT_OPTION);
        }
    }

    public void paint(Graphics g) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        g.drawImage(img, 0, 0, xSize, ySize, this);
    }
}
