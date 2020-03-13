import java.awt.*;

public class Volvo240 implements Transportable, ACar {

    private final static double trimFactor = 1.25;
    private LandVehicle parent;
    private boolean isLoaded;


    public Volvo240(double trimFactor, LandVehicle parent, boolean isLoaded) {
        this.parent = parent;
        this.isLoaded = isLoaded;

    }
    protected Volvo240() {
       parent = new LandVehicle(2, 100, 0, Color.black, "Volvo240", 1,1,0);
       setIsLoadedFalse();

   }


   public void setIsLoadedTrue() {
        isLoaded = true;
   }

   public void setIsLoadedFalse() {
        isLoaded = false;
   }

   public boolean getIsLoaded() {
        return isLoaded;
   }

    public void setTurboOn() {
        throw new UnsupportedOperationException("Volvo does not support Turbo");
    }

    public void setTurboOff() {
        throw new UnsupportedOperationException("Volvo does not support Turbo");
    }

    public void lowerBed() {
        throw new UnsupportedOperationException("Volvo does not have a bed");
    }

    public void raiseBed() {
        throw new UnsupportedOperationException("Volvo does not have a bed");
    }

    public void setCurrentSpeed(int speed) {
        parent.setCurrentSpeed(speed);
    }


    public LandVehicle getParent() {
        return parent;
    }

    public int getX() {
        return parent.getX();
    }

    public int getY() {
        return parent.getY();
    }

    public void setX(int x) {
        parent.setX(x);
    }

    public void setY(int y) {
        parent.setY(y);
    }

    public int getDir() {return parent.getDir();}

    public void setDir(int dir) {
        parent.setDir(dir);
    }


    public void move() {
        parent.move();
    }

    public void turnLeft() {
        parent.turnLeft();
    }

    public void turnRight() {
        parent.turnRight();
    }


    private double speedFactor(){
        return parent.getEnginePower() * 0.01 * trimFactor;
    }

    public double getSpeedFactor() {
        return speedFactor();
    }

    public double getCurrentSpeed() {
        return getParent().getCurrentSpeed();
    }

    public void moveCar() {
        parent.setCurrentSpeed(parent.getCurrentSpeed()*getSpeedFactor());
        parent.move();
    }

    /**
     *
     * @param amount an amount to scale the speedFactor. Method currently public due to testing.
     */
    public void incrementSpeed(double amount){
	    parent.setCurrentSpeed(Math.min(parent.getCurrentSpeed() + speedFactor() * amount, parent.getEnginePower()));
    }

    /**
     *
     * @param amount an amount to scale the speedFactor. Method currently public due to testing.
     */
    public void decrementSpeed(double amount){
        parent.setCurrentSpeed(Math.max(parent.getCurrentSpeed() - speedFactor() * amount,0));
    }

    /**
     *
     * @param amount an amount between 0 - 1 that scales the braking.
     */
    public void brake(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else {
            decrementSpeed(amount);
        }

    }

    /**
     *
     * @param amount an amount between 0 - 1 that scales the gas.
     */
    public void gas(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else  {
            incrementSpeed(amount);
        }
    }


    public void  turnRightCar() {
        parent.turnRight();
    }

    public void turnLeftCar() {
        parent.turnLeft();
    }




}




