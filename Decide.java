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

    private static final int NUM_CONDITIONS = 15;

    public static void main(String[] args) {

        // TODO

    }

    /**
     * Compute the PUM
     *
     * @return the PUM
     */
    public static boolean[][] computePUM(Connectors[][] LCM, boolean[] CMV) {

        final int LEN = CMV.length;

        boolean[][] PUM = new boolean[LEN][LEN];

        for (int i = 0; i < LEN; ++i) {
            for (int j = i; j < LEN; ++j) {
                if (i == j) {
                    PUM[i][j] = true;
                } else {
                    // since LCM symmetric, PUM is also symmetric, hence we fill in (i, j) and (j, i)
                    switch (LCM[i][j]) {
                        case ANDD:
                            PUM[i][j] = CMV[i] && CMV[j];
                            PUM[j][i] = CMV[i] && CMV[j];
                            break;
                        case ORR:
                            PUM[i][j] = CMV[i] || CMV[j];
                            PUM[j][i] = CMV[i] || CMV[j];
                            break;
                        default:
                            PUM[i][j] = true;
                            PUM[j][i] = true;
                    }
                }
            }
        }

        return PUM;
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