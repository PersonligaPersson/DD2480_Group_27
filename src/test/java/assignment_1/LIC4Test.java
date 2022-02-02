package assignment_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC4Test {

    /*
    Verifies that LIC4 is true when the there is at least one set of Q_PTS consecutive points that cover more than QUADS quadrants. 
    */
    @Test
    void lic4PositiveTest() {
        Parameter parameter = new Parameter(0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, -2, -4, 2, 1};
        double[] y = {0, 2, -4, -3, 1};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertTrue(lic.computeAndGetConditions()[4]);
    }

    /*
    Verifies that LIC4 is false when each set of Q_PTS consecutive points covers QUADS quadrants or less. 
    */
    @Test
    void lic4NegativeTest() {
        Parameter parameter = new Parameter(0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, 2, -4, -3, -1};
        double[] y = {0, 2, 4, 3, -1};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[4]);
    }

    /*
    Verifies that LIC4 is false when QUADS or Q_PTS is outside the permitted intervals. 
    */
    @Test
    void lic4FaultyParamTest() {
        Parameter parameter = new Parameter(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, -2, -4, 0, -1};
        double[] y = {0, 2, -4, -3, -1};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[4]);
    }
} 