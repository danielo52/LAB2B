import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) {
        // Instance of this class

        initiateSimulation();

    }

    private static void initiateSimulation() {
        CarModel carMod = new CarModel();

        TimerListener timeList = new TimerListener(carMod);
        CarControlPanel carCPanel = new CarControlPanel();

        DrawPanel drawPanel = new DrawPanel(800, 500, carMod.getCars());

        CarSpeedPanel casPanel = new CarSpeedPanel();
        CarView carView = new CarView("CarSim 1.0", carCPanel, drawPanel);

        carView.add(casPanel);  //Swing let's us add CarSpeedPanel as a module post creation of CarView. Imo nice.
        //Adding all Subscribers to the Observers list in TimeListener
        timeList.add(casPanel);
        timeList.add(drawPanel);

        //Initiate a new CarController
        CarController cc = new CarController(carView, carMod, carCPanel);

        //Set the Timer to: delay, and our TimerListener
        timeList.setTimer(new Timer(timeList.getDelay(), timeList));
        timeList.getTimer().start();
    }

}
