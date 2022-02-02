package assignment_1;

import org.junit.jupiter.api.Test;

import assignment_1.Decide.Connectors;

import static org.junit.jupiter.api.Assertions.*;

class DecideTest {

    /**
     * The test checks the following:
     *      - The resulting diagonal values are always true independently of the connector
     *      - The ORR connector gives right results for every possible cases
     *      - The ANDD connector gives right results for every possible cases
     *      - The NOTUSED connector gives right results for every possible cases
     */
    @Test
    void checkPUM() {
        Decide.Connectors[][] LCM_ORR = new Decide.Connectors[][]{
                {Decide.Connectors.ANDD, Decide.Connectors.ORR, Decide.Connectors.ORR, Decide.Connectors.ORR},
                {Decide.Connectors.ORR, Decide.Connectors.ORR, Decide.Connectors.ORR, Decide.Connectors.ORR},
                {Decide.Connectors.ORR, Decide.Connectors.ORR, Decide.Connectors.NOTUSED, Decide.Connectors.ORR},
                {Decide.Connectors.ORR, Decide.Connectors.ORR, Decide.Connectors.ORR, Decide.Connectors.NOTUSED}
        };
        Decide.Connectors[][] LCM_ANDD = new Decide.Connectors[][]{
                {Decide.Connectors.ANDD, Decide.Connectors.ANDD, Decide.Connectors.ANDD, Decide.Connectors.ANDD},
                {Decide.Connectors.ANDD, Decide.Connectors.ORR, Decide.Connectors.ANDD, Decide.Connectors.ANDD},
                {Decide.Connectors.ANDD, Decide.Connectors.ANDD, Decide.Connectors.NOTUSED, Decide.Connectors.ANDD},
                {Decide.Connectors.ANDD, Decide.Connectors.ANDD, Decide.Connectors.ANDD, Decide.Connectors.NOTUSED}
        };
        Decide.Connectors[][] LCM_NOTUSED = new Decide.Connectors[][]{
                {Decide.Connectors.ANDD, Decide.Connectors.NOTUSED, Decide.Connectors.NOTUSED, Decide.Connectors.NOTUSED},
                {Decide.Connectors.NOTUSED, Decide.Connectors.ORR, Decide.Connectors.NOTUSED, Decide.Connectors.NOTUSED},
                {Decide.Connectors.NOTUSED, Decide.Connectors.NOTUSED, Decide.Connectors.NOTUSED, Decide.Connectors.NOTUSED},
                {Decide.Connectors.NOTUSED, Decide.Connectors.NOTUSED, Decide.Connectors.NOTUSED, Decide.Connectors.NOTUSED}
        };
        boolean[] CMV = new boolean[]{true, false, true, false};
        boolean[][] result_ORR = Decide.computePUM(LCM_ORR, CMV);
        boolean[][] result_ANDD = Decide.computePUM(LCM_ANDD, CMV);
        boolean[][] result_NOTUSED = Decide.computePUM(LCM_NOTUSED, CMV);

        boolean[][] expected_ORR = new boolean[][]{
                {true, true, true, true},
                {true, true, true, false},
                {true, true, true, true},
                {true, false, true, true}
        };
        boolean[][] expected_ANDD = new boolean[][]{
                {true, false, true, false},
                {false, true, false, false},
                {true, false, true, false},
                {false, false, false, true}
        };
        boolean[][] expected_NOTUSED = new boolean[][]{
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true}
        };

        for (int i = 0; i < expected_ORR.length; ++i) {
            assertArrayEquals(result_ORR[i], expected_ORR[i]);
        }
        for (int i = 0; i < expected_ANDD.length; ++i) {
            assertArrayEquals(result_ANDD[i], expected_ANDD[i]);
        }
        for (int i = 0; i < expected_NOTUSED.length; ++i) {
            assertArrayEquals(result_NOTUSED[i], expected_NOTUSED[i]);
        }
    }

    /**
     * This test checks all possible cases encountered when computing the FUV
     */
    @Test
    void checkFUV() {
        boolean[][] PUM = new boolean[][]{
                {true, false, true, false},
                {true, true, true, true},
                {true, true, true, true},
                {false, true, true, true}
        };
        boolean[] PUV = new boolean[]{false, true, false, true};
        boolean[] result = Decide.computeFUV(PUM, PUV);

        boolean[] expected = new boolean[]{true, true, true, false};
        assertArrayEquals(result, expected);
    }

    /**
     * A Positive Launch test, LIC 0, 2, 3 and 5 are satisfied, the LCM and PUV.
     * The LCM is defined in such a way that the entire first row PUM is true.
     * The PUV requires the first row to be true. 
     * This leads to a launch
     */
    @Test
    void decideLaunchTestPositive() {
            
        // To defined
        Parameter parameter = new Parameter(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, 3, 2};
        double[] y = {0, 4, 2};
        int numPoints = 3;
        Connectors[][] LCM = new Connectors[][]{
          {Decide.Connectors.ANDD,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ANDD,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          };
        boolean[] PUV = new boolean[]{true,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

        // decide launch
        assertTrue(Decide.decideLaunch(numPoints, x, y, parameter, LCM, PUV));

    }

    /**
     * Negative Launch test.
     * The LCM is designed in such a way that LIC1 has to be satsified to in order for the first row to be true
     * The input data does not satisfy LIC1, and the PUV requires the first row of the PUM to be true.
     * This leads to a no-launch.
     */
    @Test
    void decideLaunchTestNegative() {
            
        // To defined
        Parameter parameter = new Parameter(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = {0, 3, 2};
        double[] y = {0, 4, 2};
        int numPoints = 3;
        Connectors[][] LCM = new Connectors[][]{
          {Decide.Connectors.ANDD,Decide.Connectors.ANDD,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR,Decide.Connectors.ORR},
          {Decide.Connectors.ANDD,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ANDD,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          {Decide.Connectors.ORR,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED,Decide.Connectors.NOTUSED},
          };
        boolean[] PUV = new boolean[]{true,true,false,false,false,false,false,false,false,false,false,false,false,false,false};

        // decide launch
        assertFalse(Decide.decideLaunch(numPoints, x, y, parameter, LCM, PUV));

    }
} 
