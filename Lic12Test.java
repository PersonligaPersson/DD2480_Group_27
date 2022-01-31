import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lic12Test {

    /*
    Verifies that LIC12 is true when the there is at least one pair of points, separated by K_PTS consecutive points, where the points are more than LENGTH1 units apart and one pair where the points are less than LENGTH2 units apart. 
    */
    @Test
    void lic12PositiveTest() {
        Parameter parameter = new Parameter(3, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0);
        double[] x = {0, -2, 4, 2, 3};
        double[] y = {0, 2, 3, -3, 2};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertTrue(lic.computeAndGetConditions()[12]);
    }

    /*
    Verifies that LIC12 is false when there is no pair of points, separated by K_PTS consecutive points, where the the points are more than LENGTH1 units apart, or there is no pair where the points are less than LENGTH2 units apart.
    */
    @Test
    void lic12NegativeTest() {

        // Every pair of points, separated by K_PTS points, are more than LENGTH1 and LENGTH2 units apart (only first requirement fulfilled)
        Parameter parameter = new Parameter(1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
        double[] x = {0, 1, 2, 3, 4};
        double[] y = {0, 0, 0, 0, 0};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[12]);

        // Every pair of points, separated by K_PTS points, are less than LENGTH1 and LENGTH2 units apart (only second requirement fulfilled)
        parameter = new Parameter(3, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0);
        lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[12]);

        // Every pair of points, separated by K_PTS points, are less than LENGTH1 units apart and more than LENGTH2 units apart (neither requirement fulfilled)
        parameter = new Parameter(3, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
        lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[12]);
    }

    /*
    Verifies that LIC12 is false when NUM_POINTS, LENGTH1 or LENGTH2 is outside the permitted intervals. 
    */
    @Test
    void lic4FaultyParamTest() {
        // NUM_POINTS is less than 3
        Parameter parameter = new Parameter(1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
        double[] x1 = {0, -2};
        double[] y1 = {0, 2};
        int numPoints = 2;
        LIConditions lic = new LIConditions(parameter, x1, y1, numPoints);
        assertFalse(lic.computeAndGetConditions()[12]);

        // LENGTH1 and LENGTH2 are too small
        parameter = new Parameter(-1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0);
        double[] x2 = {0, -2, 1};
        double[] y2 = {0, 2, 1};
        numPoints = 3;
        lic = new LIConditions(parameter, x2, y2, numPoints);
        assertFalse(lic.computeAndGetConditions()[12]);
    }
} 