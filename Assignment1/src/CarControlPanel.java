import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarControlPanel extends ControlPanel   {


    private JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();
    private int gasAmount = 0;
    private JLabel gasLabel = new JLabel("Amount of gas");

    private int brakeAmount = 0;

    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Scania Lower Bed");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");

    private JButton addCarButton = new JButton("Add Car");
    private JButton removeCarButton = new JButton("Remove Car");


    public void setGasAmount(int i) {
        this.gasAmount = i;
    }
    public int getGasAmount() {
        return gasAmount;
    }

    public int getBrakeAmount() {
        return brakeAmount;
    }


    public void update(int x, int y, ACar car, int currCar) {
        //nada
    }


    // Constructor
    public CarControlPanel() {
        initComponents();
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

    }


    void addAddCarButton(ActionListener list) {
        addCarButton.addActionListener(list);
    }

    void addRemoveCarButton(ActionListener list) {
        removeCarButton.addActionListener(list);
    }

    void addGasListener(ActionListener list) {
        gasButton.addActionListener(list);
    }
    void addBrakeListener(ActionListener list) {
        brakeButton.addActionListener(list);
    }

    void addStopCarsListener(ActionListener list) {
        stopButton.addActionListener(list);
    }

    void addStartCarsListener(ActionListener list) {
        startButton.addActionListener(list);
    }

    void addTurboOnListener(ActionListener list) {
        turboOnButton.addActionListener(list);
    }
    void addTurboOffListener(ActionListener list) {
        turboOffButton.addActionListener(list);
    }
    void addLiftBedListener(ActionListener list) {
        liftBedButton.addActionListener(list);
    }

    void addLowerBedListener(ActionListener list) {
        lowerBedButton.addActionListener(list);
    }

    void addGasSpinnerChanger(ChangeListener list) {
        gasSpinner.addChangeListener(list);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, 0, 100, 1);

        gasSpinner = new JSpinner(spinnerModel);

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));


        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addCarButton,6);
        controlPanel.add(removeCarButton,7);
        controlPanel.setPreferredSize(new Dimension((CarView.getXCarView()/2)+4, 200)); //(X/2)+4 -> (X)+4
        this.add(controlPanel);
        controlPanel.setBackground(Color.LIGHT_GRAY);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(CarView.getXCarView()/6-15,100));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(CarView.getXCarView()/6-15,100));
        this.add(stopButton);




    }


}
