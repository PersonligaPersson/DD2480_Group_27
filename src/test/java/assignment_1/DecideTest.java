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
     * This test the entire program with data that allow the launch
     */
    @Test
    void decideReturnTrue() {
            
        // To defined
        Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = new double[]{0};
        double[] y = new double[]{0};
        int numPoints = 1;
        Connectors[][] LCM = new Connectors[][]{{Connectors.NOTUSED}};
        boolean[] PUV = new boolean[]{true};

        // decide launch
        // assertTrue(Decide.decideLaunch(numPoints, x, y, parameter, LCM, PUV));

    }

    /**
     * Verifies that the decide function returns false for input that's too long (>100 points).
     */
    @Test
    void decideTooManyPointsTest(){
        Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = new double[101];
        double[] y = new double[101];
        int numPoints = 101;
        for(int i = 0; i < numPoints; i++){
            x[i] = 0;
            y[i] = 0;
        }
        Connectors[][] LCM = new Connectors[][]{{Connectors.NOTUSED}};
        boolean[] PUV = new boolean[]{true};
        
        assertFalse(Decide.decideLaunch(numPoints, x, y, parameter, LCM, PUV));
    }

    /**
     * This test the entire program with data that don't allow the launch
     */
    @Test
    void decideReturnFalse() {
            
        // To defined
        Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[] x = new double[]{0};
        double[] y = new double[]{0};
        int numPoints = 1;
        Connectors[][] LCM = new Connectors[][]{{Connectors.NOTUSED}};
        boolean[] PUV = new boolean[]{true};

        // decide launch
        // assertFalse(Decide.decideLaunch(numPoints, x, y, parameter, LCM, PUV));

    }

} 