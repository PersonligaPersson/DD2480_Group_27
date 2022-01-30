public final class Decide {

    // Final launch decision
    private boolean LAUNCH;

    // boolean operator
    enum Connectors {
        ANDD,
        ORR,
        NOTUSED
    }

    // Logical Connector Matrix
    private Connectors[][] LCM;
    // Preliminary Unlocking Matrix
    private boolean[][] PUM;
    // Conditions Met Vector
    private boolean[] CMV;
    // Preliminary Unlocking Vector
    private boolean[] PUV;
    // Final Unlocking Vector
    private boolean[] FUV;

    private static final int NUM_CONDITIONS = 15;

    public static void main(String[] args) {

        // TODO

    }

    /**
     * Compute the PUM
     *
     * @return the PUM
     */
    private boolean[][] computePUM() {
        boolean[][] temp = new boolean[NUM_CONDITIONS][NUM_CONDITIONS];

        // TODO

        return temp;
    }

    /**
     * Check that all values are true
     *
     * @param array the boolean array
     * @return true if all values are true
     */
    private static boolean forAllTrue(boolean[] array) {
        for (boolean b : array) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compute the FUV
     *
     * @return the FUV
     */
    public static boolean[] computeFUV(boolean[][] PUM, boolean[] PUV) {

        final int LEN = PUV.length;

        boolean[] FUV = new boolean[LEN];

        for (int i = 0; i < LEN; ++i) {
            // PUV[i] is true iff PUV[i] is false or all values in PUM[i] are true
            if (!PUV[i]) {
                FUV[i] = true;
            } else {
                FUV[i] = forAllTrue(PUM[i]);
            }
        }

        return FUV;
    }

    /**
     * Decide the launch
     *
     * @return the decision
     */
    private boolean decideLaunch() {
        boolean launch = false;

        // TODO

        return launch;
    }

}