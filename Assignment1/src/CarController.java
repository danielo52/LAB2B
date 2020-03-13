import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:


    CarView carView;
    CarControlPanel ccPanel;
    CarModel carModel;

    public CarController(CarView theView, CarModel theModel, CarControlPanel cacPanel) {
        this.carView = theView;
        this.carModel = theModel;
        this.ccPanel = cacPanel;

        setAllListeners(cacPanel);

    }

    private void setAllListeners(CarControlPanel cacPanel) {
        cacPanel.addGasListener(new GasListener());
        cacPanel.addGasSpinnerChanger(new GasChangeListener());
        cacPanel.addBrakeListener(new BrakeListener());
        cacPanel.addTurboOnListener(new TurboOnListener());
        cacPanel.addTurboOffListener(new TurboOffListener());
        cacPanel.addStartCarsListener(new StartCarsListener());
        cacPanel.addStopCarsListener(new StopCarsListener());
        cacPanel.addLiftBedListener(new LiftBedListener());
        cacPanel.addLowerBedListener(new LowerBedListener());
        cacPanel.addAddCarButton(new AddCarListener());
        cacPanel.addRemoveCarButton(new RemoveCarListener());
    }

     private class GasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carModel.gas(ccPanel.getGasAmount());
        }
    }

    private class BrakeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carModel.brake(ccPanel.getBrakeAmount());
        }
    }

    private class TurboOnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carModel.setTurboOn();
            System.out.println(carModel.getCars().size());
        }
    }

    class TurboOffListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carModel.setTurboOff();
        }
    }
    class StartCarsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carModel.startCars();
        }
    }
    class StopCarsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carModel.stopCars();
        }
    }
    class LiftBedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carModel.raiseBed();
        }
    }
    class LowerBedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carModel.lowerBed();
        }
    }

    class GasChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            ccPanel.setGasAmount( (int) ((JSpinner)e.getSource()).getValue());
        }
    }

    class AddCarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carModel.addAdditionalCar();
        }
    }

    class RemoveCarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carModel.removeACar();
        }
    }



}

