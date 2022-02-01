package DD2480_Group_27;

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
            // FUV[i] is true iff PUV[i] is false or all values in PUM[i] are true
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
    public static boolean decideLaunch(boolean[] FUV) {

        return forAllTrue(FUV);

    }

}