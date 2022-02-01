import java.util.*;

public final class LIConditions {

    private static final double PI = Math.PI;

    private final int NUM_CONDITIONS = 15;

    private boolean[] conditions;

    private final Parameter parameter;
    private final double[] X_COORDINATES;
    private final double[] Y_COORDINATES;
    private final int NUM_POINTS;

    /**
     * constructor of the LIConditions
     */
    public LIConditions(Parameter parameter, double[] x_COORDINATES, double[] y_COORDINATES, int NUM_POINTS) {
        this.parameter = parameter;
        X_COORDINATES = x_COORDINATES;
        Y_COORDINATES = y_COORDINATES;
        this.NUM_POINTS = NUM_POINTS;

        conditions = new boolean[NUM_CONDITIONS];
    }

    /**
     * Compute and return the LIC
     *
     * @return the computed LIC
     */
    public boolean[] computeAndGetConditions() {
        // compute LIC
        conditions[0] = LIC_0();
        conditions[1] = LIC_1();
        conditions[2] = LIC_2();
        conditions[3] = LIC_3();
        conditions[4] = LIC_4();
        conditions[5] = LIC_5();
        conditions[6] = LIC_6();
        conditions[7] = LIC_7();
        conditions[8] = LIC_8();
        conditions[9] = LIC_9();
        conditions[10] = LIC_10();
        conditions[11] = LIC_11();
        conditions[12] = LIC_12();
        conditions[13] = LIC_13();
        conditions[14] = LIC_14();
        // return the results
        return conditions;
    }

    /**
     * Compare two doubles
     *
     * @param a first double
     * @param b second double
     * @return 0 if equal, -1 if a < b, 1 if a > b
     */
    private int doubleCompare(double a, double b) {
        if (Math.abs(a - b) < 0.00001) {
            return 0;
        } else if (a < b) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Compute LIC 0
     *
     * @return LIC 0
     */
    private boolean LIC_0() {
        // Check for faulty parameters
        if (NUM_POINTS != X_COORDINATES.length || NUM_POINTS != Y_COORDINATES.length || parameter.getLENGTH1() <= 0) {
            return false;
        }

        double distPowTwo = 0; 
        double lengthPowTwo = Math.pow(parameter.getLENGTH1(), 2);
        for (int i = 0; i < NUM_POINTS-1; i++) {

            // Calculate Euclidean distance
            distPowTwo = Math.pow(X_COORDINATES[i]-X_COORDINATES[i+1], 2)
                            +Math.pow(Y_COORDINATES[i]-Y_COORDINATES[i+1], 2);
            if (distPowTwo > lengthPowTwo) {
                return true;
            }

        }
        return false;
    }

    /**
     * Compute LIC 1
     *
     * @return LIC 1
     */
    private boolean LIC_1() {
        boolean LIC_1 = false;

        // TODO

        return LIC_1;
    }

    /**
     * Compute LIC 2
     *
     * @return LIC 2
     */
    private boolean LIC_2() {
        boolean LIC_2 = false;

        // TODO

        return LIC_2;
    }

    /**
     * Compute LIC 3
     *
     * @return LIC 3
     */
    private boolean LIC_3() {
        boolean LIC_3 = false;

        // TODO

        return LIC_3;
    }

    /**
     * Compute LIC 4
     *
     * @return LIC 4
     */
    private boolean LIC_4() {
        // Check for faulty parameters
        if (parameter.getQ_PTS() < 2 || parameter.getQ_PTS() > NUM_POINTS || parameter.getQUADS() < 1 || parameter.getQUADS() > 3) {
            return false;
        }

        Set<Integer> quads = new HashSet<Integer> ();
        for (int i = 0; i < NUM_POINTS - parameter.getQ_PTS(); i++) {
            
            // Calculate the number of quads from the set of points
            quads.clear();
            for (int j = i; j < i + parameter.getQ_PTS(); j++) {
                if (X_COORDINATES[j] >= 0 && Y_COORDINATES[j] >= 0) {
                    // First quadrant
                    quads.add(0);
                } else if (X_COORDINATES[j] < 0 && Y_COORDINATES[j] >= 0) {
                    // Second quadrant
                    quads.add(1);
                } else if (X_COORDINATES[j] <= 0 && Y_COORDINATES[j] < 0) {
                    // Third quadrant
                    quads.add(2);
                } else {
                    // Fourth quadrant
                    quads.add(3);
                }
            }

            if (quads.size() > parameter.getQUADS()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Compute LIC 5
     *
     * @return LIC 5
     */
    private boolean LIC_5() {
        for (int i = 0; i < NUM_POINTS-1; i++) {
            if (X_COORDINATES[i] > X_COORDINATES[i+1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * Compute LIC 6
     *
     * @return LIC 6
     */
    private boolean LIC_6() {
        boolean LIC_6 = false;

        // TODO

        return LIC_6;
    }

    /**
     * Compute LIC 7
     *
     * @return LIC 7
     */
    private boolean LIC_7() {
        int kPTS = parameter.getK_PTS();
        double len1Squared = Math.pow(parameter.getLENGTH1(), 2);

        if (NUM_POINTS < 3 || kPTS < 1 || kPTS > NUM_POINTS - 2) {
            return false;
        }
        double distSquared;
        for (int i = 0; i < NUM_POINTS - (kPTS + 1); i++) {
            distSquared = Math.pow(X_COORDINATES[i] - X_COORDINATES[i + kPTS + 1], 2)
                    + Math.pow(Y_COORDINATES[i] - Y_COORDINATES[i + kPTS + 1], 2);

            if (distSquared > len1Squared) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compute LIC 8
     *
     * @return LIC 8
     */
    private boolean LIC_8() {
        boolean LIC_8 = false;

        // TODO

        return LIC_8;
    }

    /**
     * Compute LIC 9
     * using the third answer of https://stackoverflow.com/questions/1211212/how-to-calculate-an-angle-from-three-points
     *
     * @return LIC 9
     */
    private boolean LIC_9() {

        // retrieve constants
        final double EPSILON = parameter.getEPSILON();
        final int C_PTS = parameter.getC_PTS();
        final int D_PTS = parameter.getD_PTS();

        // check conditions
        if (NUM_POINTS < 5 || 1 > C_PTS || 1 > D_PTS || (C_PTS + D_PTS) > (NUM_POINTS - 3)) {
            return false;
        }

        for (int i = 0; i < NUM_POINTS - C_PTS - D_PTS - 2; ++i) {
            // get coordinates
            // regarding the documentation, a is the first point, b is the third
            double aX = X_COORDINATES[i];
            double aY = Y_COORDINATES[i];
            double vertex_X = X_COORDINATES[i + C_PTS + 1];
            double vertex_Y = Y_COORDINATES[i + C_PTS + 1];
            double bX = X_COORDINATES[i + C_PTS + D_PTS + 2];
            double bY = Y_COORDINATES[i + C_PTS + D_PTS + 2];
            // check condition that a =/= vertex and b =/= vertex
            if ((aX != vertex_X || aY != vertex_Y) && (bX != vertex_X || bY != vertex_Y)) {
                // compute the two vectors
                double vectA_X = vertex_X - aX;
                double vectA_Y = vertex_Y - aY;
                double vectB_X = vertex_X - bX;
                double vectB_Y = vertex_Y - bY;
                // compute the two relative angles
                double angleA = Math.atan2(vectA_Y, vectA_X);
                double angleB = Math.atan2(vectB_Y, vectB_X);
                // compute angle
                double angle = angleA - angleB;
                // adjust it
                angle = angle < 0 ? angle + 2 * PI : angle;
                System.out.println(angle);
                if (angle < PI - EPSILON || angle > PI + EPSILON) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Compute LIC 10
     * 
     * Formula used for calculating triangle area of three coordinates: https://en.wikipedia.org/wiki/Triangle#Using_coordinates
     *
     * @return LIC 10
     */
    private boolean LIC_10() {
        int ePTS = parameter.getE_PTS();
        int fPTS = parameter.getF_PTS();

        if (ePTS < 1 || fPTS < 1 || NUM_POINTS < 5
                     || ePTS + fPTS > NUM_POINTS - 3) {
            return false;
        }

        int offset1 = ePTS + 1; // offset from first point to second point.
        int offset2 = ePTS + fPTS + 2; // offset from second point to third point

        for (int i = 0; i < NUM_POINTS - offset2; i++) {
            double triangleArea = 0.5
                * Math.abs(
                    (X_COORDINATES[i] - X_COORDINATES[i + offset2]) * (Y_COORDINATES[i + offset1] - Y_COORDINATES[i])
                        - (X_COORDINATES[i] - X_COORDINATES[i + offset1]) * (Y_COORDINATES[i + offset2] - Y_COORDINATES[i]));

            if (triangleArea > parameter.getAREA1()) {
                return true;
            }
        }

    return false;
    }

    /**
     * Compute LIC 11
     *
     * @return LIC 11
     */
    private boolean LIC_11() {
        boolean LIC_11 = false;

        // TODO

        return LIC_11;
    }

    /**
     * Compute LIC 12
     *
     * @return LIC 12
     */
    private boolean LIC_12() {
        // Check for faulty parameters
        if (NUM_POINTS < 3 || parameter.getLENGTH1() < 0 || parameter.getLENGTH2() < 0) {
            return false;
        }

        double len1PowTwo = Math.pow(parameter.getLENGTH1(), 2);
        double len2PowTwo = Math.pow(parameter.getLENGTH2(), 2);
        int kPts = parameter.getK_PTS();
        boolean req1 = false;
        boolean req2 = false;
        double distPowTwo = 0;
        for (int i = 0; i < NUM_POINTS - kPts - 1; i++) {
            distPowTwo = Math.pow(X_COORDINATES[i]-X_COORDINATES[i+kPts+1], 2)+Math.pow(Y_COORDINATES[i]-Y_COORDINATES[i+kPts+1], 2);

            if (distPowTwo > len1PowTwo) {
                req1 = true;
            }
            if (distPowTwo < len2PowTwo) {
                req2 = true;
            }
            if (req1 && req2) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compute LIC 13
     *
     * @return LIC 13
     */
    private boolean LIC_13() {
        boolean LIC_13 = false;

        // TODO

        return LIC_13;
    }

    /**
     * Compute LIC 14
     *
     * @return LIC 14
     */
    private boolean LIC_14() {
        boolean LIC_14 = false;

        // TODO

        return LIC_14;
    }

}
