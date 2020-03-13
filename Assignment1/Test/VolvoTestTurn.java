import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class VolvoTestTurn {
    /**
     * The turn methods are inherited directly from Car so we decided to test it solely through a Volvo object.
     */
    private Volvo240 test;
    @Before
    public void init() {
        test = new Volvo240();
    }

    /*
    Följande tester kollar så att  initial direction är 1. Samt att turnRight-metoden fungerar som det är tänkt.
     */
    @Test
    public void testInitDirectionIs1() {
        assertTrue(test.getParent().getDir() == 1);
    }

    @Test
    public void testDirection1TurnRightIs0() {
        test.turnRightCar();
        assertTrue(test.getParent().getDir() == 0);
    }

    @Test
    public void testDirection2TurnRightIs1() {
        test.getParent().setDir(2);
        test.turnRightCar();
        assertTrue(test.getParent().getDir() == 1);
    }

    @Test
    public void testDirection3turnRightIs2() {
        test.getParent().setDir(3);
        test.getParent().turnRight();
        assertTrue(test.getParent().getDir() == 2);
    }

    @Test
    public void testDirection0turnRightIs3() {
        test.getParent().setDir(0);
        test.getParent().turnRight();
        assertTrue(test.getParent().getDir() == 3);
    }


    /*
    The following test asserts that the turnLeft method acts accordingly.
     */
    @Test
    public void testDirection0turnLeftIs1() {
        test.getParent().setDir(0);
        test.turnLeftCar();
        assertTrue(test.getParent().getDir() == 1);
    }

    @Test
    public void testDirection1turnLeftIs2() {
        test.getParent().setDir(1);
        test.getParent().turnLeft();
        assertTrue(test.getParent().getDir() == 2);
    }

    @Test
    public void testDirection2turnLeftIs3() {
        test.getParent().setDir(2);
        test.getParent().turnLeft();
        assertTrue(test.getParent().getDir() == 3);
    }

    @Test
    public void testDirection3turnLeftIs0() {
        test.getParent().setDir(3);
        test.getParent().turnLeft();
        assertTrue(test.getParent().getDir() == 0);
    }
    

    /*
     *Testing for the move method, to assert that it acts accordingly.
     * Testing for several turns. init = start-dir. L = left, R = right.
     */
     @Test
        public void testMoveForSeveralTurnsInit1LLR() {
            test.getParent().setDir(1);
            test.getParent().turnLeft();
            test.getParent().turnLeft();
            test.getParent().turnRight();
            assertTrue(test.getParent().getDir() == 2);
        }
     @Test
        public void testMoveForSeveralTurnsInit2LRR() {
         test.getParent().setDir(2);
         test.getParent().turnLeft();
         test.getParent().turnRight();
         test.getParent().turnRight();
         assertTrue(test.getParent().getDir() == 1);
     }
}
