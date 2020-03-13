import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends AnimationPanel implements IObserver {



    private ArrayList<BufferedImage> images;
    private ArrayList<ACar> cars;

    private IObservable observable;

    public DrawPanel getDrawPanel() {
        return null;
    }

    /*public void setTimeList(IObservable observable) {
        this.observable = observable;
    }

     */

    public void update(int x, int y, ACar car, int currCar) {
        this.revalidate();
        this.repaint();
    }


    private void tryAddVolvoImage() {
        BufferedImage volvoImage2;
        try {
            volvoImage2 = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/volvo240.jpg"));
            images.add(volvoImage2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tryAddSaabImage() {
        BufferedImage saabImage2;
        try {
            saabImage2 = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/saab95.jpg"));
            images.add(saabImage2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void tryAddScaniaImage() {
        BufferedImage scaniaImage2;
        try {
            scaniaImage2 = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/scania.jpg"));
            images.add(scaniaImage2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<ACar> cars) {
        super(x, y);
        this.images = new ArrayList<>();
        this.cars = cars;
        tryAddVolvoImage();
        tryAddSaabImage();
        tryAddScaniaImage();
        this.setBackground(Color.LIGHT_GRAY); //color of backgrund...
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int counter = 0;
        for (ACar car : cars) {
            if(car.getClass() == Volvo240.class) {
                g.drawImage(images.get(0), car.getX(), car.getY()+(50*counter),null);
            } else if(car.getClass() == Saab95.class) {
                g.drawImage(images.get(1), car.getX(), car.getY()+(50*counter),null);
            } else if (car.getClass() == Scania.class) {
                g.drawImage(images.get(2), car.getX(), car.getY()+(50*counter),null);
            }
            counter++;
        }
    }

}
