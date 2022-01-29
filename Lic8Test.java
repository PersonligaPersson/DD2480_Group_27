import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lic8Test {

    /*
    Verifies that LIC8 is true when there is at least three points separated by A_PTS and B_PTS points, respectively, that cannot be contained in or on a circle of radius RADIUS1. 
    */
    @Test
    void lic8PositiveTest() {
        Parameter parameter = new Parameter(0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, -2, 8, 2, 5};
        double[] y = {0, 1, 8, -3, 5};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertTrue(lic.computeAndGetConditions()[8]);
    }

    /*
    Verifies that LIC8 is false when every set of three points separated by A_PTS and B_PTS points, respectively, can be contained in or on a circle of radius RADIUS1. 
    */
    @Test
    void lic8NegativeTest() {
        Parameter parameter = new Parameter(0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, -2, 2, 2, 2};
        double[] y = {0, 1, 2, -3, 1};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[8]);
    }

    /*
    Verifies that LIC8 is false when A_PTS, B_PTS or NUM_POINTS is outside the allowed interval.
    */
    @Test
    void lic8FaultyParamTest() {

        // NUM_POINTS is too small (less than 5)
        Parameter parameter = new Parameter(0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x_small = {0, -2, 8, 2};
        double[] y_small = {0, 1, 8, -3};
        int numPoints = 4;
        LIConditions lic = new LIConditions(parameter, x_small, y_small, numPoints);
        assertFalse(lic.computeAndGetConditions()[8]);

        // A_PTS and B_PTS are too small (less than 1)
        parameter = new Parameter(0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, -2, 8, 2, 5};
        double[] y = {0, 1, 8, -3, 5};
        numPoints = 5;
        lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[8]);
    }
}  