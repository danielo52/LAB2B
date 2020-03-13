import java.util.ArrayList;
import java.util.Random;

public class CarModel {
    /**
     * In the case of this application, the number of maxCars should not be changed (especially not increased, since
     * additional cars will not be visible to the user)
     */
    private static final int maxCars = 10;

    private ArrayList<ACar> cars;
    private ACarFactory randomCarFactory;
    private Random rand;

     CarModel() {
        cars = new ArrayList<>();
        randomCarFactory = new RandomCarFactory();
        rand = new Random();
        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());
    }

    void addAdditionalCar() {
        if(cars.size() < maxCars) {
            int decider = rand.nextInt(3);
            ACar newCar = randomCarFactory.createCar();
            cars.add(newCar);
        } else {
            System.out.println("Too many cars");
        }
    }

    //Always removes the Car that was added last. FILO.
    void removeACar() {
        int length = cars.size();
        cars.remove(length-1);
    }

    public ArrayList<ACar> getCars() {
        return cars;
    }





    /**
     *
     * Methods for operating on the CarModel as a whole.
     *
     */

    public boolean isCollisionHigh(ACar car) {
        return (Math.round(car.getX()) > CarView.getXCarView() - 100);
    }

    public void moveCollision(ACar car, int mover) {
        stopCar(car);
        negateDir(car);
        car.setX(car.getX() + mover);
        startCar(car);
        car.move();

    }


    public boolean isCollisionLow(ACar car) {
        return (Math.round(car.getX()) < 0);
    }

    public void negateDir(ACar car) {
        switch (car.getDir()) {
            case 0:
                car.setDir(2);
                break;
            case 1:
                car.setDir(3);
                break;
            case 2:
                car.setDir(0);
                break;
            case 3:
                car.setDir(1);
                break;
            default:
                System.out.println("Wrong directions");
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (ACar car : cars) {
            car.gas(gas);
        }
    }

    //brakeAmount casting since I believe the dropdown list in the client gives us an Int (0-100) and we need a double
    public void brake(int amount) {
        double brakeAmount = ((double) amount) / 100;
        for (ACar car : cars) {
            car.brake(brakeAmount);
        }
    }


    public void setTurboOn() {
        for (ACar car : cars) {
            if (car.getClass() == Saab95.class) {
                car.setTurboOn();
            } else {
                //Nothing
            }

        }
    }

    public void setTurboOff() {
        for (ACar car : cars) {
            if (car.getClass() == Saab95.class) {
                car.setTurboOff();
            } else {
                //Nothing
            }
        }
    }

    public void raiseBed() {
        for (ACar car : cars) {
            if(car.getClass() == Scania.class) {
                car.raiseBed();
            } else {
                //Nothing
            }
        }
    }

    public void lowerBed() {
        for(ACar car : cars) {
            if(car.getClass() == Scania.class) {
                car.lowerBed();
            } else {
                //Nothing
            }
        }
    }

    public void stopCar(ACar car) {
        car.setCurrentSpeed(0);
    }

    public void startCar(ACar car) {
        car.setCurrentSpeed(1);
    }


    public void stopCars() {
        for (ACar car : cars) {
            stopCar(car);
        }
    }

    public void startCars() {
        for (ACar car : cars) {
            startCar(car);
        }
    }


}
