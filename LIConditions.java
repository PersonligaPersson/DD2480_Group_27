package DD2480_Group_27;

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
     * Computes the euclidian distance to the power of two between two points in a plane.
     * 
     * @param x1 x-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y1 y-coordinate of the first point
     * @param y2 y-coordinate of the second point
     * @return
     */
    private double distancePowTwo(double x1, double x2, double y1, double y2){
        return Math.pow(x2-x1,2) + Math.pow(y2-y1,2);
    }

    /**
     * This function checks if a set of points of a triangle intersects with a vertex.     
     * @param coordinates
     * @return
     */
    private boolean doesIntersect(double[] pointA, double[] pointB, double[] vertex){
        // for(int i=0; i<coordinates.length-1; i++){
        //     for(int j=i+1; j<coordinates.length; j++){
        //         if(coordinates[i][0] == coordinates[i+1][0] && coordinates[i][1] == coordinates[i+1][1]){
        //             return true;
        //         }
        //     }
        // }
        if(pointA[0] == vertex[0] && pointA[1] == vertex[1]){ return true; } // Does the vertex intersect with point A?
        if(pointB[0] == vertex[0] && pointB[1] == vertex[1]){ return true; } // Does the vertex intersect with point B?
        return false;
    }

    /**
     * This method finds the angle A between the the sides b and c in a triangle using the cosine rule.
     * Formula a^2 = b^2 + c^2 - 2bc*cos(A)
     * A = arccos(b^2+c^2-a^2 / 2bc)
     * 
     * @param a
     * @param b
     * @param c
     * @return
     */
    private double getAngleInTriangle(double a, double b, double c){
        double expr = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2*b*c);
        double A = Math.acos(expr);
        return A;
    }

    /**
     * This method computes the area of a triangle with two sides and the angle between them. 
     * Can be used in conjunction with the method getAngleInTriangle.
     * Mathematical reference: https://onteachingmath.com/courses/trigonometry/area-non-right-triangle/
     * 
     * @param b
     * @param c
     * @param A
     * @return
     */
    private double getTriangleArea(double b, double c, double A){
        return 0.5*b*c*Math.sin(A);
    }

    /**
     * Computes the euclidian distance between two points in a plane.
     * 
     * @param x1 x-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y1 y-coordinate of the first point
     * @param y2 y-coordinate of the second point
     * @return
     */
    private double distance(double x1, double x2, double y1, double y2){
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }

    /**
     * This method returns the centerpoint between the points in a plane.
     * 
     * @param x1 x-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y1 y-coordinate of the first point
     * @param y2 y-coordinate of the second point
     * @return
     */
    private double[] getCenterpoint(double x1, double x2, double y1, double y2){
        double c_x, c_y;        

        // Compute the x-coordinate.
        if(x1 > x2){
            c_x = x1 - Math.abs(x1-x2)/2;
        } else {
            c_x = x1 + Math.abs(x1-x2)/2;
        }

        // Compute the y-coordinate.
        if(y1 > y2){
            c_y = y1 - Math.abs(y1-y2)/2;
        } else {
            c_y = y1 + Math.abs(y1-y2)/2;
        }

        // Return the coordinates.
        return new double[]{c_x, c_y};
    }

    /**
     * This method checks whether or not three points can be contained within a circle.
     * 
     * @param x1
     * @param x2
     * @param x3
     * @param y1
     * @param y2
     * @param y3
     * @return
     */
    private boolean canBeContained(double x1, double x2, double x3, double y1, double y2, double y3, double diameter){
        // Compute the distance between the three points.            
        double dist_p1p2 = distance(x1, x2, y1, y2);
        double dist_p2p3 = distance(x2, x3, y2, y3);
        double dist_p3p1 = distance(x3, x1, y3, y1);                

        // Then check if any of the points are further away from each other than the circle's diameter. This would make it impossible to contain them in a circle.
        if(dist_p1p2 > diameter || dist_p2p3 > diameter || dist_p3p1 > diameter)
            return false;
        
        // If not, compute which points are furthest away from each other and compute the centerpoint.
        double[] center_cords;
        double[] remaining_point;
        if(dist_p1p2 >= dist_p2p3 && dist_p1p2 >= dist_p3p1){
            // In this case the centerpoint is drawn between points 1 and 2.
            center_cords = getCenterpoint(x1, x2, y1, y2);
            remaining_point = new double[]{x3,y3};
        } else if(dist_p2p3 >= dist_p1p2 && dist_p2p3 >= dist_p3p1){
            // In this case the centerpoint is drawn between points 2 and 3.
            center_cords = getCenterpoint(x2, x3, y2, y3);
            remaining_point = new double[]{x1,y1};
        } else {
            // In this case the centerpoint is drawn between points 3 and 1.
            center_cords = getCenterpoint(x3, x1, y3, y1);
            remaining_point = new double[]{x2,y2};
        }

        // At this point the remaining coordinate has to be at most the radius of the circle away from the centerpoint in order to be able to fit.
        final double center_dist = distance(center_cords[0], remaining_point[0], center_cords[1], remaining_point[1]);
        if(center_dist <= diameter/2)
            return true;

        return false;
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

            // // Calculate Euclidean distance
            // distPowTwo = Math.pow(X_COORDINATES[i]-X_COORDINATES[i+1], 2) + Math.pow(Y_COORDINATES[i]-Y_COORDINATES[i+1], 2);
            // if (distPowTwo > lengthPowTwo) {
            //     return true;
            // }

            // Refactored to using the euclidian distance helper function.
            distPowTwo = distancePowTwo(X_COORDINATES[i], X_COORDINATES[i+1], Y_COORDINATES[i], Y_COORDINATES[i+1]);
            if(distPowTwo > lengthPowTwo){
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

        // Start by checking for faulty input.
        // Check for faulty parameters
        if (NUM_POINTS != X_COORDINATES.length || NUM_POINTS != Y_COORDINATES.length || parameter.getRADIUS1() <= 0) {
            return false;
        }

        // Declare the diameter of the circle.
        double diameter = parameter.getRADIUS1()*2;

        // Then iterate over all points and look for a tripple that can be contained within an enclosing circle.
        for(int i=0; i < NUM_POINTS-2; i++){
            LIC_1 = canBeContained(X_COORDINATES[i], X_COORDINATES[i+1], X_COORDINATES[i+2], Y_COORDINATES[i], Y_COORDINATES[i+1], Y_COORDINATES[i+2], diameter);
            if(LIC_1)        
                break;
        }

        return LIC_1;
    }

    /**
     * Compute LIC 2
     *
     * @return LIC 2
     */
    private boolean LIC_2() {
        boolean LIC_2 = false;

        // Get the epsilon parameter.
        double epsilon = parameter.getEPSILON();

        // Start by checking for faulty input.
        if (NUM_POINTS != X_COORDINATES.length || NUM_POINTS != Y_COORDINATES.length || epsilon > Math.PI || epsilon < 0) {
            return false;
        }
        
        // Then iterate over all points and...
        for(int i=0; i < NUM_POINTS-2; i++){
            // Check if the points are a potentially valid combination.
            double[] point1 =  {X_COORDINATES[i], Y_COORDINATES[i]};
            double[] point2 = {X_COORDINATES[i+1], Y_COORDINATES[i+1]}; // The second point is the potential vertex of the triangle.
            double[] point3 = {X_COORDINATES[i+2], Y_COORDINATES[i+2]};
            if(doesIntersect(point1, point3, point2)){ continue; } // If the current set of points are not valid, skip to the next pass.

            // If the points are valid, compute the angle between them.
            // We achieve this by using the cosine rule b^2 = a^2 + c^2 - 2ac*cos(B) where B is the angle at the vertex and b is the opposing side. 
            // Rearranged this gives the forumla B = arccos((a^2 + c^2 - b^2) / 2ac)
            // In this case the opposing side will always be a line between points 1 and 3.
            double a = distance(point1[0], point2[0], point1[1], point2[1]);
            double b = distance(point1[0], point3[0], point1[1], point3[1]);
            double c = distance(point3[0], point2[0], point3[1], point2[1]);

            // Now get the angle.
            double B = getAngleInTriangle(b, a, c);

            // Now we're checking the angle conditions.
            if(B < (Math.PI-epsilon)){ LIC_2 = true; }
            if(B > (Math.PI+epsilon)){ LIC_2 = true; }
        }        

        // Lastly return the result.
        return LIC_2;
    }

    /**
     * Compute LIC 3
     *
     * @return LIC 3
     */
    private boolean LIC_3() {
        boolean LIC_3 = false;   

        // Get the area parameter.
        double area1 = parameter.getAREA1();

        // Start by checking for faulty input.
        if (NUM_POINTS != X_COORDINATES.length || NUM_POINTS != Y_COORDINATES.length || area1 < 0) {
            return false;
        }

        // The area in the non right triangle is computed by the formula area = 1/2 * bc*sin(A) where A, B and C are angles and a,b,c their opposing sides.
        // Then iterate over all points...
        for(int i=0; i < NUM_POINTS-2; i++){
            // Store the points.
            double[] pointA = {X_COORDINATES[i], Y_COORDINATES[i]};
            double[] pointB = {X_COORDINATES[i+1], Y_COORDINATES[i+1]};
            double[] pointC = {X_COORDINATES[i+2], Y_COORDINATES[i+2]};

            // Find the distnace between the points.
            double a = distance(pointB[0], pointC[0], pointB[1], pointC[1]);
            double b = distance(pointA[0], pointC[0], pointA[1], pointC[1]);
            double c = distance(pointA[0], pointB[0], pointA[1], pointB[1]);

            // Compute the angle A.
            double A =  getAngleInTriangle(a, b, c);

            // Compute the area of the triangle.
            double area = getTriangleArea(b,c,A);

            if(area > area1){
                LIC_3 = true;
            }

        }

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
