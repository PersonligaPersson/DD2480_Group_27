package DD2480_Group_27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lic13Test {
    /*
        Verifies that LIC 13 is false for too few points in the input.
        NUMPOINTS < 5.
    */
    @Test
    void Lic13TooFewPoints() {
        Parameter parameter = new Parameter(0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0);
        double[] x = {0, 0, 0, 0};
        double[] y = {0, 0, 0, 0};
        int numPoints = 4;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[13]);
    }

    /*
        Verifies that LIC 13 is false provided a negative radia.
        0 <= RADIUS2
    */
    @Test
    void Lic13NegativeRadius() {
        Parameter parameter = new Parameter(0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -55, 0);
        double[] x = {0, 0, 0, 0, 0};
        double[] y = {0, 0, 0, 0, 0};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[13]);
    }

    /*
        Verifies that LIC 13 returns true when radius1 is too small and radius2 is adequate.        
    */
    @Test
    void Lic13PositiveTest() {
        Parameter parameter = new Parameter(0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 2, 0);
        double[] x = {-2, 0, 0, 0, 2};
        double[] y = {0, 0, 0, 0, 0};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertTrue(lic.computeAndGetConditions()[13]);
    }

    /*
        Verifies that LIC 13 returns false when only one subcondition is met.    
        In this case the points can be enclosed in both circles.
    */
    @Test
    void Lic13OnlyOneSubconditionMet() {
        Parameter parameter = new Parameter(0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 5, 0);
        double[] x = {-2, 0, 0, 0, 2};
        double[] y = {0, 0, 0, 0, 0};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[13]);
    }    
}
