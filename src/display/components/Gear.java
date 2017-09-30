package display.components;

import javax.swing.*;
import java.awt.*;

public class Gear extends JComponent {

    // GEARS
    private static final String REVERSE = "R";
    private static final String NEUTRAL = "N";
    private static final String FIRST   = "1";
    private static final String SECOND  = "2";
    private static final String THIRD   = "3";
    private static final String FOURTH  = "4";
    private static final String FIFTH   = "5";
    private static final String SIXTH   = "6";
    private static final String SEVENTH = "7";
    private static final String EIGHT   = "8";

    private String gearText;
    private JTextField gear;

    public Gear() {
        this.gearText = NEUTRAL;
        this.gear = new JTextField();
        this.gear.setForeground(Color.WHITE);
        this.gear.setBackground(Color.BLACK);
        this.gear.setOpaque(true);
        this.gear.setBorder(null);
        this.gear.setText(gearText);
        this.gear.getCaret().setVisible(false);
    }

    public JTextField getGear() {
        return this.gear;
    }

    public void setGear(int gear) {
        switch (gear) {
            case 0:
                this.gear.setText(REVERSE);
                break;
            case 1:
                this.gear.setText(NEUTRAL);
                break;
            case 2:
                this.gear.setText(FIRST);
                break;
            case 3:
                this.gear.setText(SECOND);
                break;
            case 4:
                this.gear.setText(THIRD);
                break;
            case 5:
                this.gear.setText(FOURTH);
                break;
            case 6:
                this.gear.setText(FIFTH);
                break;
            case 7:
                this.gear.setText(SIXTH);
                break;
            case 8:
                this.gear.setText(SEVENTH);
                break;
            case 9:
                this.gear.setText(EIGHT);
                break;
        }
    }
}
