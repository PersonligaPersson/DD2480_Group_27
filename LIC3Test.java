package DD2480_Group_27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LIC3Test {
    
    /**
    * Verifies that the method returns true for positive integers and a great area.
    */
    @Test
    public void lic3PositiveIntegersLargerArea(){
        Parameter parameter = new Parameter(0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x_cords = {0,3,0};
        double[] y_cords = {0,2,5};
        int numPoints = 3;
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertEquals(true, lics.computeAndGetConditions()[3]);
    }

    /**
    * Verifies that the method returns true for negative integers. Is essentially the same triangle as above but reflected. 
    */
    @Test
    public void licNegativeIntegersLargerArea(){
        Parameter parameter = new Parameter(0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x_cords = {0,-3,0};
        double[] y_cords = {0,-2,-5};
        int numPoints = 3;
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertEquals(true, lics.computeAndGetConditions()[3]);
    }

    /**
    * Verifies that the method returns false for equal areas.
    */
    @Test
    public void lic3EqualAreas(){
        Parameter parameter = new Parameter(0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x_cords = {0,0,2};
        double[] y_cords = {0,2,0};
        int numPoints = 3;
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertEquals(false, lics.computeAndGetConditions()[3]);
    }

    /**
    * Verifies that the method returns false for a too small area.
    */
    @Test
    public void lic3SmallerArea(){
        Parameter parameter = new Parameter(0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x_cords = {0,0,1};
        double[] y_cords = {0,1,0};
        int numPoints = 3;
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertEquals(false, lics.computeAndGetConditions()[3]);
    }
}
