import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lic6Test {

  @Test
  void Lic6TestPositiveDifferentEndpoints() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 2, 1, 5 };
    double[] y = { 0, -1, 1, 5 };
    int numPoints = 4;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertTrue(lic.computeAndGetConditions()[6]);
  }

  @Test
  void Lic6TestPositiveSameEndpoints() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3, 0, 5 };
    double[] y = { 0, 4, 0, 5 };
    int numPoints = 4;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertTrue(lic.computeAndGetConditions()[6]);
  }

  @Test
  void Lic6TestNegative() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3, 0 };
    double[] y = { 0, 4, 0 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[6]);
  }

  @Test
  void Lic6TestNegativeTooFewPoints() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3, 1 };
    double[] y = { 0, 4, 1 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[6]);
  }

  @Test
  void Lic6TestNegativeDistNegative() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, -1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3, 0 };
    double[] y = { 0, 4, 0 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[6]);
  }

  @Test
  void Lic6TestNegativeNPTSTooSmall() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, -1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3, 0 };
    double[] y = { 0, 4, 0 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[6]);
  }

  @Test
  void Lic6TestNegativeNPTSGreaterThanNUMPOINTS() {
    Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, -1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    double[] x = { 0, 3, 0 };
    double[] y = { 0, 4, 0 };
    int numPoints = 3;
    LIConditions lic = new LIConditions(parameter, x, y, numPoints);
    assertFalse(lic.computeAndGetConditions()[6]);
  }
}
