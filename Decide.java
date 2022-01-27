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
    // Final Unlocking Vector
    private boolean[] FUV;

    private final int NUM_CONDITIONS = 15;

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
     * Compute the FUV
     *
     * @return the FUV
     */
    private boolean[] computeFUV() {
        boolean[] temp = new boolean[NUM_CONDITIONS];

        // TODO

        return temp;
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