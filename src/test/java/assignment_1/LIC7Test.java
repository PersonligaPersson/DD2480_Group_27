package assignment_1;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LIC7Test {

	@Test
	/**
	 * Positive test for 2 points along the x-axis.
	 */
	void lic7Positive1DTest() {
		Parameter parameter = new Parameter(3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		double x[] = { 0, 1, 2, 3, 4, 5 };
		double y[] = { 0, 0, 0, 0, 0, 0 };
		int numPoints = 6;
		LIConditions lic = new LIConditions(parameter, x, y, numPoints);
		assertTrue(lic.computeAndGetConditions()[7]);
	}

	@Test
	/**
	 * Positive test for points alnog x and y axis ((2,0)-(0,3))
	 */
	void lic7Positive2DTest() {
		Parameter parameter = new Parameter(3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		double x[] = { 2, 1, 2, 3, 0, 5 };
		double y[] = { 0, 3, 1, 0, 3, 0 };
		int numPoints = 6;
		LIConditions lic = new LIConditions(parameter, x, y, numPoints);
		assertTrue(lic.computeAndGetConditions()[7]);
	}

	/**
	 * Negative test where no points are sufficently far apart.
	 */
	@Test
	void lici7NegativeTest() {
		Parameter parameter = new Parameter(5, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		double x[] = { 0, 1, 2, 3, 4, 5 };
		double y[] = { 0, 0, 0, 0, 0, 0 };
		int numPoints = 6;
		LIConditions lic = new LIConditions(parameter, x, y, numPoints);
		assertFalse(lic.computeAndGetConditions()[7]);
	}

	@Test
	/**
	 * Negative test for checking if there are enough points.
	 */
	void lic7NegativeTooFewPoints() {
		Parameter parameter = new Parameter(5, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		double x[] = { 2, 1 };
		double y[] = { 0, 3 };
		int numPoints = 2;
		LIConditions lic = new LIConditions(parameter, x, y, numPoints);
		assertFalse(lic.computeAndGetConditions()[7]);
	}

	@Test
	/**
	 * Negative test to check if 1 <= K_PTS <= NUMPOINTS-2
	 */
	void lic7NegativeFaultyInput() {
		Parameter parameter = new Parameter(5, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		double x[] = { 2, 1, 3 };
		double y[] = { 0, 3, 3 };
		int numPoints = 3;
		LIConditions lic = new LIConditions(parameter, x, y, numPoints);
		assertFalse(lic.computeAndGetConditions()[7]);
	}
}
