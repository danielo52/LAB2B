import com.sun.jdi.VoidValue;

import java.awt.*;
import java.awt.image.ConvolveOp;
import java.util.ArrayList;
import java.util.Random;

public class RandomCarFactory implements ACarFactory {


    private static Random rand = new Random();

    public RandomCarFactory() {

    }

    public ACar createCar() {
        int decider = rand.nextInt(3);
        ACar newCar;
        if(decider == 0) {
            newCar = new Volvo240();
            return newCar;
        } else if(decider == 1) {
            newCar = new Saab95();
            return newCar;
        } else if (decider == 2) {
            newCar = new Scania();
            return newCar;
        } else {
            System.out.println("Could not add additional car.");
        }
        return null;
    }


}
