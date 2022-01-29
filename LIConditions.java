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
        boolean LIC_0 = false;

        // TODO

        return LIC_0;
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
        boolean LIC_4 = false;

        // TODO

        return LIC_4;
    }

    /**
     * Compute LIC 5
     *
     * @return LIC 5
     */
    private boolean LIC_5() {
        boolean LIC_5 = false;

        // TODO

        return LIC_5;
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

        // Check for faulty parameters
        int aPts = parameter.getA_PTS();
        int bPts = parameter.getB_PTS();
        if (NUM_POINTS < 5 || aPts + bPts > NUM_POINTS-3 || aPts < 1 || bPts < 1) {
            return false;
        }

        // Determine whether the three points fit in a circle of radius RADIUS1
        double radiusPow2 = Math.pow(parameter.getRADIUS1(), 2);
        double centerX = 0;
        double centerY = 0;
        double dist1 = 0;
        double dist2 = 0;
        double dist3 = 0;
        for (int i = 0; i < NUM_POINTS - 2 - aPts - bPts; i++) {
            // Determine the center coordinate of the circle
            centerX = (X_COORDINATES[i] + X_COORDINATES[i+aPts+1] + X_COORDINATES[i+aPts+bPts+2])/3;
            centerY = (Y_COORDINATES[i] + Y_COORDINATES[i+aPts+1] + Y_COORDINATES[i+aPts+bPts+2])/3;
            
            dist1 = distPowTwo(X_COORDINATES[i], Y_COORDINATES[i], centerX, centerY);
            dist2 = distPowTwo(X_COORDINATES[i+aPts+1], Y_COORDINATES[i+aPts+1], centerX, centerY);
            dist3 = distPowTwo(X_COORDINATES[i+aPts+bPts+2], Y_COORDINATES[i+aPts+bPts+2], centerX, centerY);
            if (dist1 <= radiusPow2 && dist2 <= radiusPow2 && dist3 <= radiusPow2) {
                // The points fit in the circle
                continue;
            }
            return true;
        }

        return false;
    }

    private double distPowTwo(double x1, double y1, double x2, double y2) {
        return Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2);
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
        boolean LIC_12 = false;

        // TODO

        return LIC_12;
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
