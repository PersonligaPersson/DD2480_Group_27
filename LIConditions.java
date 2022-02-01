import java.util.*;

public final class LIConditions {

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
     * To calculate the distance this formula is used: https://en.wikipedia.org/wiki/Distance_from_a_point_to_a_line#Line_defined_by_two_points
     * Makes the assumption that the line is defined by the two endpoints, so the line will go on until infinity in both directions. 
     * @return LIC 6
     */
    private boolean LIC_6() {
        int nPTS = parameter.getN_PTS();
        double dist = parameter.getDIST();
        if (NUM_POINTS < 3 || nPTS < 3 || nPTS > NUM_POINTS) {
            return false;
        } 

        for (int i = 0; i < NUM_POINTS - (nPTS - 1); i++) {
            double p1[] = {X_COORDINATES[i],Y_COORDINATES[i]};
            double p2[] = {X_COORDINATES[i + nPTS - 1],Y_COORDINATES[i + nPTS - 1]};

            double distToLine;
            for (int j = i; j < i + (nPTS - 1); j++) {
               // enpoints are the same point.
               if (doubleCompare(p1[0], p2[0]) == 0 && doubleCompare(p1[1], p2[1]) == 0) {
                    distToLine = Math.sqrt(Math.pow(p2[0] - X_COORDINATES[j],2) + Math.pow(p2[1]- X_COORDINATES[j],2));
               // endpoints are different points.
               } else {
                    distToLine = (Math.abs(
                                    (p2[0] - p1[0])*(p1[1] - Y_COORDINATES[j])
                                    - (p1[0] - X_COORDINATES[j])*(p2[1] - p1[1]))) 
                                    / (Math.sqrt(Math.pow(p2[0] - p1[0],2) + Math.pow(p2[1]- p1[1],2)));
               }

               if (distToLine > dist) {
                   return true;
               }
            }
        }
        return false;
    }

    /**
     * Compute LIC 7
     *
     * @return LIC 7
     */
    private boolean LIC_7() {
        boolean LIC_7 = false;

        // TODO

        return LIC_7;
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
     *
     * @return LIC 9
     */
    private boolean LIC_9() {
        boolean LIC_9 = false;

        // TODO

        return LIC_9;
    }

    /**
     * Compute LIC 10
     *
     * @return LIC 10
     */
    private boolean LIC_10() {
        boolean LIC_10 = false;

        // TODO

        return LIC_10;
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
