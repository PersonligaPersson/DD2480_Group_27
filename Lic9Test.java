package DD2480_Group_27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lic9Test {

    /**
     * if NUMPOINTS < 5, it has to return false
     */
    @Test
    void checkNumPointsCond() {
        Parameter parameter = new Parameter(0, 0, Math.PI / 8, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0);
        double[] x = new double[]{0};
        double[] y = new double[]{0};
        int numPoints = 1;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[9]);
    }

    /**
     * if C_PTS < 1, it has to return false
     */
    @Test
    void checkC_PTS() {
        Parameter parameter = new Parameter(0, 0, Math.PI / 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
        double[] x = new double[]{0, 0, 0, 0, 0};
        double[] y = new double[]{0, 0, 0, 0, 0};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[9]);
    }

    /**
     * if D_PTS < 1, it has to return false
     */
    @Test
    void checkD_PTS() {
        Parameter parameter = new Parameter(0, 0, Math.PI / 8, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
        double[] x = new double[]{0, 0, 0, 0, 0};
        double[] y = new double[]{0, 0, 0, 0, 0};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[9]);
    }

    /**
     * if C_PTS + D_PTS > NUMPOINTS - 3, it has to return false
     */
    @Test
    void checkCond() {
        Parameter parameter = new Parameter(0, 0, Math.PI / 8, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0);
        double[] x = new double[]{0, 0, 0, 0, 0};
        double[] y = new double[]{0, 0, 0, 0, 0};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[9]);
    }

    /**
     * the three points have to be distinct
     */
    @Test
    void samePoints() {
        Parameter parameter = new Parameter(0, 0, Math.PI / 8, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0);
        double[] x = new double[]{0, 0, 0, 0, 0};
        double[] y = new double[]{0, 0, 0, 0, 0};
        int numPoints = 5;
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[9]);
    }

    /**
     * Test false samples
     */
    @Test
    void falseSamples() {
        Parameter parameter = new Parameter(0, 0, Math.PI / 8, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0);
        int numPoints = 5;
        // Test 1
        double[] x = new double[]{1, 0, 0, 0, -1};
        double[] y = new double[]{0.03, 0, 0, 0, 0.01};
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[9]);
        // Test 2
        x = new double[]{0.02, 0, 0, 0, 0.01};
        y = new double[]{1, 0, 0, 0, -1};
        lic = new LIConditions(parameter, x, y, numPoints);
        assertFalse(lic.computeAndGetConditions()[9]);
    }

    /**
     * Test true samples
     */
    @Test
    void trueSamples() {
        Parameter parameter = new Parameter(0, 0, Math.PI / 8, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0);
        int numPoints = 5;
        // Test 1
        double[] x = new double[]{1, 0, 0, 0, 0};
        double[] y = new double[]{0, 0, 0, 0, 1};
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        assertTrue(lic.computeAndGetConditions()[9]);
        // Test 2
        x = new double[]{-0.5, 0, 0, 0, 2};
        y = new double[]{0.5, 0, 0, 0, 0};
        lic = new LIConditions(parameter, x, y, numPoints);
        assertTrue(lic.computeAndGetConditions()[9]);
    }

}
