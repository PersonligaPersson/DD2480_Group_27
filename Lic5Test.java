import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lic5Test {

    /*
    Verifies that LIC5 is true when there exists at least two consecutive points, p1 and p2, such that p2.x - p1.x < 0. 
    */
    @Test
    void lic5PositiveTest() {
        Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {5, 2, 4, 3};
        double[] y = {0, 1, 2, 3};
        int numPoints = 4;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertTrue(lic.computeAndGetConditions()[5]);
    }

    /*
    Verifies that LIC5 is false when each pair of consecutive points, p1 and p2, fulfill p2.x - p1.x >= 0. 
    */
    @Test
    void lic5NegativeTest() {
        Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        int numPoints = 4;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[5]);
    }
} 