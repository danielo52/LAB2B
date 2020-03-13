import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class ControlPanel extends JPanel  {

    JPanel controlPanel = new JPanel();
    private ActionListener listener;

    public ControlPanel() {
        initControlPanel();
    }



    public ControlPanel(TimerListener listener) {
        initControlPanel();
        this.listener = listener;

    }

    void initControlPanel() {
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            //this.add(controlPanel);
        }


}




