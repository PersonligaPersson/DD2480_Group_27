package DD2480_Group_27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LIC2Test {
    /**
     * Verifies that the method returns false for intersecting points.
     */
    @Test
    public void lic2IntersectingPoints(){
        Parameter parameter = new Parameter(0, 0, Math.PI/2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x_cords = {0,1,1};
        double[] y_cords = {0,1,1};
        int numPoints = 3;
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertEquals(false, lics.computeAndGetConditions()[2]);
    }

    /**
     * Verifies that the method returns true when angle < (PI - EPSILON)
     * PI - EPSILON = PI/2, angle = PI/4
     * Second point is the vertex of the triangle.
     */
    @Test
    public void lic2SmallerAngle(){
        Parameter parameter = new Parameter(0, 0, Math.PI/2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0); // Epsilon = PI/2
        double[] x_cords = {1,0,1};
        double[] y_cords = {1,0,0};
        int numPoints = 3;
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertEquals(true, lics.computeAndGetConditions()[2]);
    }

    /**
     * Verifies that the method returns true when angle > (PI + EPSILON)
     * PI + EPSILON = PI angle = 3PI/2
     * Second point is the vertex of the triangle.
     */
    @Test
    public void lic2LargerAngle(){
        Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0); // Epsilon = 0
        double[] x_cords = {1,0,0};
        double[] y_cords = {0,0,-1};
        int numPoints = 3;
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertEquals(true, lics.computeAndGetConditions()[2]);
    }

}
