import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends ViewFrame {
    private static final int X = 800; //800 på båda
    private static final int Y = 800;

    private static int x = 800;
    private static int y = 800; ;

    static int getXCarView() {
        return X;
    }


    //Constructor for CarView w/o CarAndSpeedPanel
    public CarView(String framename, ControlPanel cPanel, AnimationPanel drawPanel){
        super(framename, cPanel, drawPanel, x, y);
        this.setBackground(Color.LIGHT_GRAY);

    }

    public AnimationPanel getAnimationPanel() {
        return drawPanel;
    }

    public ControlPanel getCPanel() {
        return cPanel;
    }

    public ControlPanel getControlPanel() {
        return cPanel;
    }

}