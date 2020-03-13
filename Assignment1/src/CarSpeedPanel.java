import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class CarSpeedPanel extends ControlPanel implements IObserver {

    private IObservable timeList;


    private JPanel carPanel = new JPanel();
    private JPanel speedPanel = new JPanel();
    private JPanel actualSpeedPanel = new JPanel();

     void addGasSpinnerChanger(ChangeListener list) {}
     void setGasAmount(int i) {}
     int getGasAmount() {return 0;}

    private JLabel carLabelVolvo = new JLabel();
    private JLabel carLabelSaab = new JLabel();
    private JLabel carLabelScania = new JLabel();

    private JLabel speedLabelVolvo = new JLabel();
    private JLabel speedLabelSaab = new JLabel();
    private JLabel speedLabelScania = new JLabel();

    private JLabel actualSpeedLabelVolvo = new JLabel();
    private JLabel actualSpeedLabelSaab = new JLabel();
    private JLabel actualSpeedLabelScania = new JLabel();



    public void update(int hej, int nej, ACar car, int currCar) {
        int curSpeed = (int) car.getCurrentSpeed();
        if(car.getClass() == Volvo240.class) {
            actualSpeedLabelVolvo.setText(Integer.toString(curSpeed));
        }else if(car.getClass() == Saab95.class) {
            actualSpeedLabelSaab.setText(Integer.toString(curSpeed));
        }else if(car.getClass() == Scania.class) {
            actualSpeedLabelScania.setText(Integer.toString(curSpeed));
        } else {

        }
    }
    void addGasListener(ActionListener list) {};

    CarSpeedPanel() {
        initComponents();

        }

    private void initComponents() {
        initControlPanel();

        carPanel.setLayout(new BoxLayout(carPanel, BoxLayout.Y_AXIS));
        speedPanel.setLayout(new BoxLayout(speedPanel, BoxLayout.Y_AXIS));
        actualSpeedPanel.setLayout(new BoxLayout(actualSpeedPanel, BoxLayout.Y_AXIS));

        //Trying to make them all fit
        carLabelVolvo.setSize(50,25);
        carLabelSaab.setSize(50,25);
        carLabelScania.setSize(50,25);
        speedLabelVolvo.setSize(50,25);
        speedLabelSaab.setSize(50,25);
        speedLabelScania.setSize(50,25);
        actualSpeedLabelVolvo.setSize(50,25);
        actualSpeedLabelSaab.setSize(50,25);
        actualSpeedLabelScania.setSize(50,25);

        //add "Car: " and "model" to the CarPanel
        carLabelVolvo.setText("Bil 1");
        carLabelSaab.setText("Bil 2");
        carLabelScania.setText("Bil 3");
        carPanel.add(carLabelVolvo, 0);
        carPanel.add(carLabelSaab, 1);
        carPanel.add(carLabelScania, 2);

        //add "Speed: " and "actual speed" to the speedPanel
        speedLabelVolvo.setText("Speed: ");
        speedLabelSaab.setText("Speed: ");
        speedLabelScania.setText("Speed: ");
        speedPanel.add(speedLabelVolvo, 0);
        speedPanel.add(speedLabelSaab, 1);
        speedPanel.add(speedLabelScania,2);

        actualSpeedPanel.add(actualSpeedLabelVolvo, 0);
        actualSpeedPanel.add(actualSpeedLabelSaab, 1);
        actualSpeedPanel.add(actualSpeedLabelScania, 2);


        //set size, add, and set background to both CarPanel and SpeedPanel
        carPanel.setPreferredSize(new Dimension(266, 60)); //(X/2)+4 -> (X)+4
        this.add(carPanel);
        carPanel.setBackground(Color.LIGHT_GRAY);

        speedPanel.setPreferredSize(new Dimension(266, 60)); //(X/2)+4 -> (X)+4
        this.add(speedPanel);
        speedPanel.setBackground(Color.LIGHT_GRAY);

        actualSpeedPanel.setPreferredSize(new Dimension(266, 60)); //(X/2)+4 -> (X)+4
        this.add(actualSpeedPanel);
        actualSpeedPanel.setBackground(Color.LIGHT_GRAY);

    }

}
