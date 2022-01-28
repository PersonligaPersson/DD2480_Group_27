

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lic0Test {

    /*
    Verifies that LIC0 is true when the there are at least two points that are strictly more than LENGTH1 units apart. 
    */
    @Test
    void lic0PositiveTest() {
        Parameter parameter = new Parameter(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, 2, 3};
        double[] y = {0, 2, 4};
        int numPoints = 3;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertEquals(true, lic.computeAndGetConditions()[0]);
    }

    /*
    Verifies that LIC0 is false when the distance between every pair of points is LENGTH1 units or less.
    */
    @Test
    void lic0NegativeTest() {
        Parameter parameter = new Parameter(5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, 2, 3};
        double[] y = {0, 2, 4};
        int numPoints = 3;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertEquals(false, lic.computeAndGetConditions()[0]);
    }
}