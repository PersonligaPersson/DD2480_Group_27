package assignment_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LIC1Test {

    /**
     * Verifies that the method returns true for positive integers where the last remaining point is just out of reach.
     */
    @Test
    public void lic1JustOutOfRangeTest(){
        Parameter parameter = new Parameter(0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x_cords = {0,0,2};
        double[] y_cords = {5,1,2};
        int numPoints = 3;
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertEquals(true, lics.computeAndGetConditions()[1]);
    }

    /**
     * Verifies that the method returns false for a very basic test case with mixed integers.
     */
    @Test
    public void lic1MixedIntegersTest(){
        Parameter parameter = new Parameter(0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x_cords = {0,0,1};
        double[] y_cords = {2,-2,0};
        int numPoints = 3;
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertEquals(false, lics.computeAndGetConditions()[1]);
    }

    /**
     * Verifies that the method returns false for negative integers that can be contained.
     */
    @Test
    public void lic1NegativeIntegersTest(){
        Parameter parameter = new Parameter(0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x_cords = {-2,-2,-1};
        double[] y_cords = {-1,-3,-2};
        int numPoints = 3;
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertEquals(false, lics.computeAndGetConditions()[1]);
    }

    /**
     * Verifies that the method returns true if one point is spaced too far apart.
     */
    @Test
    public void lic1TooGreatDistanceTest(){
        Parameter parameter = new Parameter(0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x_cords = {0,0,10};
        double[] y_cords = {2,-2,2};
        int numPoints = 3;
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertEquals(true, lics.computeAndGetConditions()[1]);
    }
}
