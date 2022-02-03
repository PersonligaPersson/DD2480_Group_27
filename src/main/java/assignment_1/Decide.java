package assignment_1;

public final class Decide {

    // boolean operator
    enum Connectors {
        ANDD,
        ORR,
        NOTUSED
    }

    public static void main(String[] args) {
        
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

        System.out.println("LAUNCH = " + decideLaunch(numPoints, x, y, parameter, LCM, PUV));

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
    public static boolean decideLaunch(int numPoints, double[] x, double[] y, Parameter parameter, Connectors[][] LCM, boolean[] PUV) {

        // Check if we have too many input points.
        if(x.length > 100 || y.length > 100){
            return false;
        }

        // define the LI conditions
        LIConditions lic = new LIConditions(parameter, x, y, numPoints);
        // get the CMV
        boolean[] CMV = lic.computeAndGetConditions();
        // compute the PUM
        boolean[][] PUM = computePUM(LCM, CMV);
        // compute FUV
        boolean[] FUV = computeFUV(PUM, PUV);
        // decide the launch
        return forAllTrue(FUV);

    }

}