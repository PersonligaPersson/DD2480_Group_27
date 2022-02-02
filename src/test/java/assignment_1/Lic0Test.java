package assignment_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Lic0Test {

    /*
    Verifies that LIC0 is true when the there are at least consecutive two points that are strictly more than LENGTH1 units apart. 
    */
    @Test
    void lic0PositiveTest() {
        Parameter parameter = new Parameter(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, 3, 2};
        double[] y = {0, 4, 2};
        int numPoints = 3;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertEquals(true, lic.computeAndGetConditions()[0]);
    }

    /*
    Verifies that LIC0 is false when the distance between every consecutive pair of points is LENGTH1 units or less.
    */
    @Test
    void lic0NegativeTest() {
        Parameter parameter = new Parameter(5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, 3, 6};
        double[] y = {0, 4, 6};
        int numPoints = 3;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertEquals(false, lic.computeAndGetConditions()[0]);
    }

    /*
    Verifies that LIC0 is false when the distance is less than 0 (faulty distance value).
    */
    @Test
    void lic0NegativeFaultyDistTest() {
        Parameter parameter = new Parameter(-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, 2, 3};
        double[] y = {0, 2, 4};
        int numPoints = 3;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertEquals(false, lic.computeAndGetConditions()[0]);
    }

    /**
    *   Verifies that the method returns false for faulty input where we have too many points in the input. 
    */
    @Test
    public void lic0TooManyPointsTest(){
        Parameter parameter = new Parameter(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x_cords = new double[101];
        double[] y_cords = new double[101];
        int numPoints = 101;
        for(int i = 0; i < numPoints; i++){
            x_cords[i] = i;
            y_cords[i] = i;
        }
        LIConditions lics = new LIConditions(parameter, x_cords, y_cords, numPoints);
        assertFalse(lics.computeAndGetConditions()[0]);
    }
}