package assignment_1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LIC6Test {

  @Test
  /**
   * Positive test that where both the points that define the line are disjunct.
   */
  void Lic6TestPositiveDifferentEndpoints() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 2, 1, 5 };
    double[] y = { 0, -1, 1, 5 };
    int numPoints = 4;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertTrue(lic.computeAndGetConditions()[6]);
  }

  @Test
  /**
   * Positive test where the two points that are suposed to define the line are
   * identical and the distance calculation is then instead the euclidian distance
   * to that point.
   * 
   * In this case the actual distance is 5 (euclidian distance from (0,0) to (3,4)) 
   * which is greater than DIST = 4.
   */
  void Lic6TestPositiveSameEndpoints() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3, 0 };
    double[] y = { 0, 4, 0 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertTrue(lic.computeAndGetConditions()[6]);
  }

  @Test
  /**
   * Negative test where there are no points length > 5 from the point 
   */
  void Lic6TestNegative() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3, 0 };
    double[] y = { 0, 4, 0 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[6]);
  }

  @Test
  /**
   * Negative test that checks if we handle cases where NUMPOINTS < 3
   */
  void Lic6TestNegativeTooFewPoints() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3 };
    double[] y = { 0, 4 };
    int numPoints = 2;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[6]);
  }

  @Test
  /**
   * Negative test to check that we handle negative DIST.
   */
  void Lic6TestNegativeDistNegative() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, -1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3, 0 };
    double[] y = { 0, 4, 0 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[6]);
  }

  @Test
  /**
   * Negative test to check we handle cases where N_PTS < 3.
   */
  void Lic6TestNegativeNPTSTooSmall() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3, 0 };
    double[] y = { 0, 4, 0 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[6]);
  }

  @Test
  /**
   * Negative test to check that we handle cases where N_PTS > NUMPOINTS.
   */
  void Lic6TestNegativeNPTSGreaterThanNUMPOINTS() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, -1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3, 0 };
    double[] y = { 0, 4, 0 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[6]);
  }
}
