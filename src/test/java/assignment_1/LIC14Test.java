package assignment_1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * lic14Test
 */
public class LIC14Test {

  @Test
  /**
   * Positive test where the same set of three points (a 3-4-5 right angle
   * triangle at the origin) satisfy the 2 sub-condtitions
   */
  void lic14PositiveTestSamePoints() {
    Parameter parameter = new Parameter(0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 7);
    double[] x = { 0, 1, 3, 2, 0 };
    double[] y = { 0, 1, 0, 2, 4 };
    int numPoints = 5;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertTrue(lic.computeAndGetConditions()[14]);
  }

  /**
   * Positive test where three sets of different points (3-4-5 right angle
   * triangle at the origin, and a trinagle formed by (-3,2), (3,5), (6,-4))
   * satisfy the two sub conditions.
   */
  @Test
  void lic14PositiveTestDifferentPoints() {
    Parameter parameter = new Parameter(0, 0, 0, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 7);
    double[] x = { -3, 0, 3, 3, 6, 0 };
    double[] y = { -2, 0, 5, 0, -4, 4 };
    int numPoints = 6;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertTrue(lic.computeAndGetConditions()[14]);
  }

  @Test
  /**
   * Negative test where there are no triangles that satisfy the sub-conditions.
   */
  void lic14NegativeTestNoTriangles() {
    Parameter parameter = new Parameter(0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 5);
    double[] x = { 0, 1, 3, 2, 0 };
    double[] y = { 0, 1, 0, 2, 4 };
    int numPoints = 5;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[14]);
  }

  @Test
  /**
   * Proceed test where there are just one sub-condition is satisfied.
   */
  void lic14NegativeTestOneTriangle() {
    Parameter parameter = new Parameter(0, 0, 0, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 4);
    double[] x = { -3, 0, 3, 3, 6, 0 };
    double[] y = { -2, 0, 5, 0, -4, 4 };
    int numPoints = 6;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[14]);
  }

  @Test
  /**
   * Negative test that checks that the condition handles the case NUMPOINTS < 5
   * correctly.
   */
  void lic14NegativeTestTooFewPoints() {
    Parameter parameter = new Parameter(0, 0, 0, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 4);
    double[] x = { -3, 0, 3 };
    double[] y = { -2, 0, 5 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[14]);
  }

  @Test
  /**
   * Negative testr that cheks that the condition handles the case of AREA2 < 0
   * correctly.
   */
  void lic14NegativeTestToSmallArea2() {
    Parameter parameter = new Parameter(0, 0, 0, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, -1);
    double[] x = { -3, 0, 3, 3, 6, 0 };
    double[] y = { -2, 0, 5, 0, -4, 4 };
    int numPoints = 6;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[14]);
  }
}