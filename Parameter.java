public final class Parameter {

    // parameters
    private final double LENGTH1;   // length in LICs 0, 7, 12
    private final double RADIUS1;   // radius in LICs 1, 8, 13
    private final double EPSILON;   // deviation from PI in LICs 2, 9
    private final double AREA1;     // area in LIC 3, 10, 14
    private final int Q_PTS;        // number of consecutive points in LIC 4
    private final int QUADS;        // number of quadrants in LIC 4
    private final double DIST;      // distance in LIC 6
    private final int N_PTS;        // number of consecutive points in LIC 6
    private final int K_PTS;        // number of int. points in LICs 7, 12
    private final int A_PTS;        // number of int. points in LICs 8, 13
    private final int B_PTS;        // number of int. points in LICs 8, 13
    private final int C_PTS;        // number of int. points in LIC 9
    private final int D_PTS;        // number of int. points in LIC 9
    private final int E_PTS;        // number of int. points in LICs 10, 14
    private final int F_PTS;        // number of int. points in LICs 10, 14
    private final int G_PTS;        // number of int. points in LIC 11
    private final double LENGTH2;   // maximum length in LIC 12
    private final double RADIUS2;   // maximum radius in LIC 13
    private final double AREA2;     // maximum area in LIC 14

    /**
     * constructor of the parameters
     */
    public Parameter(double LENGTH1, double RADIUS1, double EPSILON, double AREA1, int q_PTS, int QUADS, double DIST, int n_PTS, int k_PTS, int a_PTS, int b_PTS, int c_PTS, int d_PTS, int e_PTS, int f_PTS, int g_PTS, double LENGTH2, double RADIUS2, double AREA2) {
        this.LENGTH1 = LENGTH1;
        this.RADIUS1 = RADIUS1;
        this.EPSILON = EPSILON;
        this.AREA1 = AREA1;
        Q_PTS = q_PTS;
        this.QUADS = QUADS;
        this.DIST = DIST;
        N_PTS = n_PTS;
        K_PTS = k_PTS;
        A_PTS = a_PTS;
        B_PTS = b_PTS;
        C_PTS = c_PTS;
        D_PTS = d_PTS;
        E_PTS = e_PTS;
        F_PTS = f_PTS;
        G_PTS = g_PTS;
        this.LENGTH2 = LENGTH2;
        this.RADIUS2 = RADIUS2;
        this.AREA2 = AREA2;
    }

    // All getters

    public double getLENGTH1() {
        return LENGTH1;
    }

    public double getRADIUS1() {
        return RADIUS1;
    }

    public double getEPSILON() {
        return EPSILON;
    }

    public double getAREA1() {
        return AREA1;
    }

    public int getQ_PTS() {
        return Q_PTS;
    }

    public int getQUADS() {
        return QUADS;
    }

    public double getDIST() {
        return DIST;
    }

    public int getN_PTS() {
        return N_PTS;
    }

    public int getK_PTS() {
        return K_PTS;
    }

    public int getA_PTS() {
        return A_PTS;
    }

    public int getB_PTS() {
        return B_PTS;
    }

    public int getC_PTS() {
        return C_PTS;
    }

    public int getD_PTS() {
        return D_PTS;
    }

    public int getE_PTS() {
        return E_PTS;
    }

    public int getF_PTS() {
        return F_PTS;
    }

    public int getG_PTS() {
        return G_PTS;
    }

    public double getLENGTH2() {
        return LENGTH2;
    }

    public double getRADIUS2() {
        return RADIUS2;
    }

    public double getAREA2() {
        return AREA2;
    }
}
