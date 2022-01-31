import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Lic10Test
 */
public class Lic10Test {

  @Test
  void testLic10Positive() {
    Parameter parameter = new Parameter(0, 0, 0, 5, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0);
    double[] x = { 0, 1, 2, 1, 0 };
    double[] y = { 0, 1, 0, 2, 3 };
    int numPoints = 5;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertTrue(lic.computeAndGetConditions()[10]);
  }

  @Test
  void testLic10Negative() {
    Parameter parameter = new Parameter(0, 0, 0, 5, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    double[] x = { 0, 1, 2, 1, 0 };
    double[] y = { 0, 1, 0, 2, 2 };
    int numPoints = 5;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[10]);
  }

  @Test
  void testLic10FaultyInput() {
    Parameter parameter = new Parameter(0, 0, 0, 5, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    double[] x = { 0, 2, 0 };
    double[] y = { 0, 0, 2 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[10]);
  }

}
