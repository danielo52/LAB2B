
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerListener implements ActionListener, IObservable {

    private ArrayList<IObserver> observers;

    private CarModel model;

    private final int delay = 50;
    private Timer timer;



    public void actionPerformed(ActionEvent e) {
        int currCar = 0;
        for (ACar car : model.getCars()) {
            currCar++;
            if (model.isCollisionHigh(car)) {
                model.moveCollision(car, -1);
                notifyObs(car.getX(), car.getY(), car, currCar);
            } else if (model.isCollisionLow(car)) {
                model.moveCollision(car, 1);
                notifyObs(car.getX(), car.getY(), car, currCar);
            } else {
                car.move();
                notifyObs(car.getX(), car.getY(), car, currCar);
            }
            int x = Math.round(car.getX()); //car.getX() or xTemp
            int y = Math.round(car.getY()); //same              OBS OBS OBS
            notifyObs(car.getX(), car.getY(), car, currCar);


        }
    }

    TimerListener(CarModel model) {
        this.model = model;
        observers = new ArrayList<>();
    }



    public void add(IObserver obs) {
        this.observers.add(obs);
    }

    public void remove(IObserver obs) {
        int observerIndex = observers.indexOf(obs);
        System.out.println("Observer at index : " + (observerIndex + 1) + " deleted!");
        observers.remove(observerIndex);
    }


    public void notifyObs(int x, int y, ACar car, int currCar) {
        for (IObserver obs : this.observers) {
            obs.update(x, y, car, currCar);
        }
    }

    public CarModel getModel() {
        return model;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getDelay() {
        return delay;
    }
}
