package assignment_1;

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

    /**********************************************************************
     * Helper methods
     *********************************************************************/
    
    /**
     * Computes the euclidian distance to the power of two between two points in a plane.
     * 
     * @param x1 x-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y1 y-coordinate of the first point
     * @param y2 y-coordinate of the second point
     * @return the squared distance
     */
    private double distancePowTwo(double x1, double x2, double y1, double y2){
        return Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
    }

    /**
     * This function checks if a set of points of a triangle intersects with a vertex.  
     * 
     * @param pointA the first point
     * @param pointB the second point
     * @param vertex the vertex
     * @return true if it intersects
     */
    private boolean doesIntersect(double[] pointA, double[] pointB, double[] vertex){
        return (pointA[0] == vertex[0] && pointA[1] == vertex[1]) || 
                (pointB[0] == vertex[0] && pointB[1] == vertex[1]);
    }

    /**
     * This method finds the angle A between the the sides b and c in a triangle using the cosine rule.
     * Formula a^2 = b^2 + c^2 - 2bc*cos(A)
     * A = arccos(b^2+c^2-a^2 / 2bc)
     * 
     * @param a side a
     * @param b side b
     * @param c side c
     * @return the angle between side b and c
     */
    private double getAngleInTriangle(double a, double b, double c){
        double expr = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c);
        return Math.acos(expr);
    }

    /**
     * Check if the angle is < PI - EPSILON or > PI - EPSILON
     * 
     * @param pointA    pointA coordinates
     * @param pointB    pointB coordinates 
     * @param vertex    vertex coordinates
     * @param EPSILON   Epsilon
     * @return true if this is the case
     */
    private boolean checkAngle(double[] pointA, double[] pointB, double[] vertex, double EPSILON) {
        // check condition that a =/= vertex and b =/= vertex
        if (!doesIntersect(pointA, pointB, vertex)) {
            // If the points are valid, compute the angle between them.
            // We achieve this by using the cosine rule b^2 = a^2 + c^2 - 2ac*cos(B) where B is the angle at the vertex and b is the opposing side. 
            // Rearranged this gives the forumla B = arccos((a^2 + c^2 - b^2) / 2ac)
            // In this case the opposing side will always be a line between points 1 and 3.
            double a = distance(pointA[0], vertex[0], pointA[1], vertex[1]);
            double b = distance(pointA[0], pointB[0], pointA[1], pointB[1]);
            double c = distance(pointB[0], vertex[0], pointB[1], vertex[1]);
            // Now get the angle.
            double B = getAngleInTriangle(b, a, c);
            // Now we're checking the angle conditions.
            if (B < (PI - EPSILON) || B > (PI + EPSILON)){
                return true;
            }
        }     
        return false;  
    }

    /**
     * Computes the euclidian distance between two points in a plane.
     * 
     * @param x1 x-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y1 y-coordinate of the first point
     * @param y2 y-coordinate of the second point
     * @return the euclidean distance
     */
    private double distance(double x1, double x2, double y1, double y2){
        return Math.sqrt(distancePowTwo(x1, x2, y1, y2));
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
     * This fonction check if a circle rotating around one point (point 1) can contains all points
     * 
     * @param x1 x-coordinate of the first point
     * @param y1 x-coordinate of the second point
     * @param x2 x-coordinate of the third point
     * @param y2 y-coordinate of the first point
     * @param x3 y-coordinate of the second point
     * @param y3 y-coordinate of the third point
     * @param radius the radius of the circle
     * @return true if possible
     */
    private boolean angleSweep(double x1, double y1, double x2, double y2, double x3, double y3, double radius) {
        // Calculate the angles for (x2, y2) at which it enters and exits the circle
        double dist = distance(x1, x2, y1, y2);
        double a = Math.atan2(y1 - y2, x1 - x2);
        double b = Math.acos(dist / (2 * radius));
        double enter2 = a - b;
        double exit2 = a + b;

        // Calculate the angles for (x3, y3) at which it enters and exits the circle
        dist = distance(x1, x3, y1, y3);
        a = Math.atan2(y1 - y3, x1 - x3);
        b = Math.acos(dist / (2 * radius));
        double enter3 = a - b;
        double exit3 = a + b;

        // check if the two intervals intersect
        return enter2 < exit3 && enter3 < exit2;
    }

    /**********************************************************************
     * LICs
     *********************************************************************/

    /**
     * Compute LIC 0
     *
     * @return LIC 0
     */
    private boolean LIC_0() {

        // Get parameter
        final double length1 = parameter.getLENGTH1();

        // Check for faulty parameters
        if (NUM_POINTS != X_COORDINATES.length || NUM_POINTS != Y_COORDINATES.length || length1 <= 0) {
            return false;
        }

        double distPowTwo = 0; 
        double lengthPowTwo = Math.pow(length1, 2);
        for (int i = 0; i < NUM_POINTS - 1; i++) {
            // Refactored to using the euclidian distance helper function.
            distPowTwo = distancePowTwo(X_COORDINATES[i], X_COORDINATES[i+1], Y_COORDINATES[i], Y_COORDINATES[i+1]);
            if (distPowTwo > lengthPowTwo){
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

        // Get parameter
        final double radius = parameter.getRADIUS1();

        // Check for faulty parameters
        if (NUM_POINTS != X_COORDINATES.length || NUM_POINTS != Y_COORDINATES.length || radius <= 0) {
            return false;
        }

        // declare variables
        double x1 = 0;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;
        double x3 = 0;
        double y3 = 0;

        // Then iterate over all points and look for a triple that cannot be contained within an enclosing circle.
        for (int i = 0; i < NUM_POINTS - 2; i++){

            x1 = X_COORDINATES[i];
            y1 = Y_COORDINATES[i];
            x2 = X_COORDINATES[i + 1];
            y2 = Y_COORDINATES[i + 1];
            x3 = X_COORDINATES[i + 2];
            y3 = Y_COORDINATES[i + 2];

            // Angular sweep is used to determine whether the three points fit in a circle of radius RADIUS1
            if (!angleSweep(x1, y1, x2, y2, x3, y3, radius) && !angleSweep(x2, y2, x1, y1, x3, y3, radius) && !angleSweep(x3, y3, x1, y1, x2, y2, radius)) {
                return true;
            } 
        }
        
        // If all point triplets can be contained the method returns false.
        return false;

    }

    /**
     * Compute LIC 2
     *
     * @return LIC 2
     */
    private boolean LIC_2() {

        // Get parameter
        final double EPSILON = parameter.getEPSILON();

        // Check for faulty parameters
        if (NUM_POINTS != X_COORDINATES.length || NUM_POINTS != Y_COORDINATES.length || EPSILON > PI || EPSILON < 0) {
            return false;
        }

        for (int i = 0; i < NUM_POINTS - 2; ++i) {
            // get coordinates
            double[] pointA = new double[]{X_COORDINATES[i], Y_COORDINATES[i]};
            double[] vertex = new double[]{X_COORDINATES[i + 1], Y_COORDINATES[i + 1]};
            double[] pointB = new double[]{X_COORDINATES[i + 2], Y_COORDINATES[i + 2]};
            // check angle
            if (checkAngle(pointA, pointB, vertex, EPSILON)) {
                return true;
            }
        }     

        return false;
    }

    /**
     * Compute LIC 3
     *
     * @return LIC 3
     */
    private boolean LIC_3() {

        // Get parameter
        final double area1 = parameter.getAREA1();

        // Check for faulty parameters
        if (NUM_POINTS != X_COORDINATES.length || NUM_POINTS != Y_COORDINATES.length || area1 < 0) {
            return false;
        }

        for (int i = 0; i < NUM_POINTS - 2; i++){
            
            double triangleArea = 0.5 * Math.abs(
                (X_COORDINATES[i] - X_COORDINATES[i + 2]) * (Y_COORDINATES[i + 1] - Y_COORDINATES[i])
                    - (X_COORDINATES[i] - X_COORDINATES[i + 1]) * (Y_COORDINATES[i + 2] - Y_COORDINATES[i]));

            if (triangleArea > area1){
                return true;
            }

        }

        return false;

    }

    /**
     * Compute LIC 4
     *
     * @return LIC 4
     */
    private boolean LIC_4() {

        // Get parameters
        final int qPts = parameter.getQ_PTS();
        final int QUADS = parameter.getQUADS();

        // Check for faulty parameters
        if (qPts < 2 || qPts > NUM_POINTS || QUADS < 1 || QUADS > 3) {
            return false;
        }

        Set<Integer> quads = new HashSet<Integer> ();
        for (int i = 0; i < NUM_POINTS - qPts; i++) {
            
            // Calculate the number of quads from the set of points
            quads.clear();
            for (int j = i; j < i + qPts; j++) {
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

            if (quads.size() > QUADS) {
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

        // Get parameters
        final int nPTS = parameter.getN_PTS();
        final double dist = parameter.getDIST();

        // Check for faulty parameters
        if (NUM_POINTS < 3 || nPTS < 3 || nPTS > NUM_POINTS || dist < 0) {
            return false;
        } 

        for (int i = 0; i < NUM_POINTS - (nPTS - 1); i++) {

            double p1[] = {X_COORDINATES[i],Y_COORDINATES[i]};
            double p2[] = {X_COORDINATES[i + nPTS - 1],Y_COORDINATES[i + nPTS - 1]};

            double distToLine = 0.0;
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

        // Get parameters
        final int kPTS = parameter.getK_PTS();
        final double len1Squared = Math.pow(parameter.getLENGTH1(), 2);

        // Check for faulty parameters
        if (NUM_POINTS < 3 || kPTS < 1 || kPTS > NUM_POINTS - 2) {
            return false;
        }

        double distSquared = 0.0;
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

        // Get parameters
        final int aPts = parameter.getA_PTS();
        final int bPts = parameter.getB_PTS();
        final double radius = parameter.getRADIUS1();

        // Check for faulty parameters
        if (NUM_POINTS < 5 || aPts + bPts > NUM_POINTS-3 || aPts < 1 || bPts < 1) {
            return false;
        }

        // declare variables
        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 0.0;
        double y2 = 0.0;
        double x3 = 0.0;
        double y3 = 0.0;

        for (int i = 0; i < NUM_POINTS - 2 - aPts - bPts; i++) {

            // get coordinates
            x1 = X_COORDINATES[i];
            y1 = Y_COORDINATES[i];
            x2 = X_COORDINATES[i + aPts + 1];
            y2 = Y_COORDINATES[i + aPts + 1];
            x3 = X_COORDINATES[i + aPts + bPts + 2];
            y3 = Y_COORDINATES[i + aPts + bPts + 2];

            // Angular sweep is used to determine whether the three points fit in a circle of radius RADIUS1: the circle is rotated around one of the points until all three points are enclosed
            if (!angleSweep(x1, y1, x2, y2, x3, y3, radius) && !angleSweep(x2, y2, x1, y1, x3, y3, radius) && !angleSweep(x3, y3, x1, y1, x2, y2, radius)) {
                return true;
            } 
        }

        return false;
    }

    /**
     * Compute LIC 9
     * using the third answer of https://stackoverflow.com/questions/1211212/how-to-calculate-an-angle-from-three-points
     *
     * @return LIC 9
     */
    private boolean LIC_9() {

        // Get parameters
        final double EPSILON = parameter.getEPSILON();
        final int C_PTS = parameter.getC_PTS();
        final int D_PTS = parameter.getD_PTS();

        // Check for faulty parameters
        if (NUM_POINTS < 5 || 1 > C_PTS || 1 > D_PTS || (C_PTS + D_PTS) > (NUM_POINTS - 3)) {
            return false;
        }

        for (int i = 0; i < NUM_POINTS - C_PTS - D_PTS - 2; ++i) {
            // get coordinates
            double[] pointA = new double[]{X_COORDINATES[i], Y_COORDINATES[i]};
            double[] vertex = new double[]{X_COORDINATES[i + C_PTS + 1], Y_COORDINATES[i + C_PTS + 1]};
            double[] pointB = new double[]{X_COORDINATES[i + C_PTS + D_PTS + 2], Y_COORDINATES[i + C_PTS + D_PTS + 2]};
            // check angle
            if (checkAngle(pointA, pointB, vertex, EPSILON)) {
                return true;
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

        // Get parameters
        final int ePTS = parameter.getE_PTS();
        final int fPTS = parameter.getF_PTS();
        final double area1 = parameter.getAREA1();

        // Check for faulty parameters
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

            if (triangleArea > area1) {
                return true;
            }
        }

    return false;
    }

    /**
     * Compute LIC 11
     * Returns true if there is at least one set of points that fulfills the condition.
     * @return LIC 11
     */
    private boolean LIC_11() {

        // Get parameter
        final int g_pts = parameter.getG_PTS();

        // Check for faulty parameters
        if (NUM_POINTS < 3 || g_pts < 1 || g_pts > NUM_POINTS - 2) {
            return false;
        }

        // Then iterate over all adequate points.
        // There needs to be at leat g_pts space between the last iterated over value and the last point.
        for (int i = 0; i < NUM_POINTS - g_pts - 1; i++) {
            if (X_COORDINATES[i + g_pts + 1] - X_COORDINATES[i] < 0)
                return true;
        }

        return false;

    }

    /**
     * Compute LIC 12
     *
     * @return LIC 12
     */
    private boolean LIC_12() {

        // Get parameters
        final double length1 = parameter.getLENGTH1();
        final double length2 = parameter.getLENGTH2();
        final int kPts = parameter.getK_PTS();
        
        // Check for faulty parameters
        if (NUM_POINTS < 3 || length1 < 0 || length2 < 0) {
            return false;
        }

        // declare variables
        double len1PowTwo = Math.pow(length1, 2);
        double len2PowTwo = Math.pow(length2, 2);
        boolean req1 = false;
        boolean req2 = false;
        double distPowTwo = 0.0;

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
     * This condition evaluates to true when there are one set of points that cannot be contained in a circle of radius1 and one set of points that can be contained
     * in a circle of radius2.
     * @return LIC 13
     */
    private boolean LIC_13() {

        // Get parameters
        final int A_PTS = parameter.getA_PTS();
        final int B_PTS = parameter.getB_PTS();
        final double rad1 = parameter.getRADIUS1();
        final double rad2 = parameter.getRADIUS2();

        // Check for faulty parameters
        if (NUM_POINTS < 5 || rad1 < 0 || rad2 < 0 || A_PTS < 0 || B_PTS < 0) {
            return false;
        }

        boolean subcond1 = false; // Cannot be contained in in a circle with the radius rad1.
        boolean subcond2 = false; // Can be contained in a circle with the radius rad2.

        int offset1 = A_PTS + 1; // Offset from the first point to the second point.
        int offset2 = A_PTS + B_PTS + 2; // Offset from the first point to the third point.

        for (int i = 0; i < NUM_POINTS - offset2; i++){

            double x1 = X_COORDINATES[i];
            double x2 = X_COORDINATES[i+offset1];
            double x3 = X_COORDINATES[i+offset2];
            double y1 = Y_COORDINATES[i];
            double y2 = Y_COORDINATES[i+offset1];
            double y3 = Y_COORDINATES[i+offset2];
            
            // Checks if the point set cannot be contained winthin rad1. If not, the first subcond is met.
            if (subcond1 == false) {      
                if (!angleSweep(x1, y1, x2, y2, x3, y3, rad1) && !angleSweep(x2, y2, x1, y1, x3, y3, rad1) && !angleSweep(x3, y3, x1, y1, x2, y2, rad1)) {
                    subcond1 = true;
                } 
            }

            // Checks if the point set can be contained within rad2. If so, the second subcond is met.
            if (subcond2 == false) {
                if (angleSweep(x1, y1, x2, y2, x3, y3, rad2) || angleSweep(x2, y2, x1, y1, x3, y3, rad2) || angleSweep(x3, y3, x1, y1, x2, y2, rad2)) {
                    subcond2 = true;
                }               
            }

            // If both subconditions have been met, return true.
            if (subcond1 && subcond2) {
                return true;
            }
        }

        // If we get to this point both subconditions have not been met and thus we return false.
        return false;

    }

    /**
     * Compute LIC 14
     *
     * @return LIC 14
     */
    private boolean LIC_14() {

        // Get parameters
        final int ePTS = parameter.getE_PTS();
        final int fPTS = parameter.getF_PTS();
        final double area1 = parameter.getAREA1();
        final double area2 = parameter.getAREA2();

        // Check for faulty parameters
        if (NUM_POINTS < 5 || area2 < 0) {
            return false;
        }

        int offset1 = ePTS + 1; // offset from first point to second.
        int offset2 = ePTS + fPTS + 2; // offset from first point to thrid.
        boolean subcond1 = false, subcond2 = false;
        double triangleArea = 0.0;

        for (int i = 0; i < NUM_POINTS - offset2; i++) {
            triangleArea = 0.5
                    * Math.abs(
                            (X_COORDINATES[i] - X_COORDINATES[i + offset2])
                                    * (Y_COORDINATES[i + offset1] - Y_COORDINATES[i])
                                    - (X_COORDINATES[i] - X_COORDINATES[i + offset1])
                                            * (Y_COORDINATES[i + offset2] - Y_COORDINATES[i]));
            if (triangleArea > area1) {
                subcond1 = true;
            }

            if (triangleArea < area2) {
                subcond2 = true;
            }

            if (subcond1 && subcond2) {
                return true;
            }
        }

        return false;
        
    }

}
