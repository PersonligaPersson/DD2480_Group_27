//package DD2480_Group_27;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Lic10Test
 */
public class Lic10Test {

  @Test
  /**
   * Positive test using a a 3-2-4 right angle triangle at the
   * origin (exact area = 3).
   */
  void testLic10PositiveRightAngle() {
    Parameter parameter = new Parameter(0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0);
    double[] x = { 0, 1, 2, 1, 0 };
    double[] y = { 0, 1, 0, 2, 3 };
    int numPoints = 5;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertTrue(lic.computeAndGetConditions()[10]);
  }

  @Test
  /**
   * Positive test a tringale formed by the points (-3,2), (3,5), (6,4) (exact
   * area = 37.5)
   * 
   */
  void testLic10Positive() {
    Parameter parameter = new Parameter(0, 0, 0, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0);
    double[] x = { -3, 1, 3, 2, 6 };
    double[] y = { -2, 1, 5, 4, -4 };
    int numPoints = 5;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertTrue(lic.computeAndGetConditions()[10]);
  }

  @Test
  /**
   * Negative test that where there are no trinagles large enough (Inputs supplied
   * correctly).
   */
  void testLic10Negative() {
    Parameter parameter = new Parameter(0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0);
    double[] x = { 0, 1, 2, 1, 0 };
    double[] y = { 0, 1, 0, 2, 2 };
    int numPoints = 5;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[10]);
  }

  @Test
  /**
   * Negative test to ensure enough points are supplied.
   */
  void testLic10ToFewPoints() {
    Parameter parameter = new Parameter(0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0);
    double[] x = { 0, 2, 0 };
    double[] y = { 0, 0, 2 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[10]);
  }

  @Test
  /**
   * Negative test to test if E_PTS + F_PTS <= NUMPOINTS - 3.
   * 
   */
  void testLic10NegativeFaultyInputs() {
    Parameter parameter = new Parameter(0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0);
    double[] x = { 0, 1, 2, 1, 0, 3 };
    double[] y = { 0, 1, 0, 2, 2, 3 };
    int numPoints = 6;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[10]);
  }
}
