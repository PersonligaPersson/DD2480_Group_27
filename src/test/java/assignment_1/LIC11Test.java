package assignment_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC11Test {
    /*
    Verifies that LIC 11 is true for a valid sequence of points that meets the condition.
    */
    @Test
    void lic11ValidSequenceValidCondition() {
        Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0);
        double[] x = {2, 0, 0, 1};
        double[] y = {0, 0, 0, 0};
        int numPoints = 4;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertTrue(lic.computeAndGetConditions()[11]);
    }

    /*
    Verifies that LIC 11 is false for a valid sequence of points that does not meet the condition.
    */
    @Test
    void lic11ValidSequenceInvalidCondition() {
        Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0);
        double[] x = {1, 0, 0, 2};
        double[] y = {0, 0, 0, 0};
        int numPoints = 4;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[11]);
    }

    /*
    Verifies that LIC 11 is false for an invalid sequence of points.
    */ 
    @Test
    void lic11InvalidSequence() {
        Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0);
        double[] x = {2, 0, 0, 1};
        double[] y = {0, 0, 0, 0};
        int numPoints = 4;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[11]);
    }

    /*
    Verifies that LIC 11 is false for an invalid sequence with too few points.
    */ 
    @Test
    void lic11TooFewPoints() {
        Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0);
        double[] x = {1, 0};
        double[] y = {0, 0};
        int numPoints = 2;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[11]);
    }
}
