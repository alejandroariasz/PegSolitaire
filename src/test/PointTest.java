/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Point;

/**
 * @author FABIAN
 *
 */
public class PointTest {

	/**
	 * Test method for {@link logic.Point#getLeftPoint()}.
	 */
	@Test
	public void testGetLeftPoint() {
		Point testPoint = new Point(2, 1);
		assertTrue("Equal Point", (new Point(1,1).equals(testPoint.getLeftPoint())));
	}

	/**
	 * Test method for {@link logic.Point#getLeftMove()}.
	 */
	@Test
	public void testGetLeftMove() {
		Point testPoint = new Point(3, 1);
		assertTrue("Equal Point", (new Point(1,1).equals(testPoint.getLeftMove())));
	}

	/**
	 * Test method for {@link logic.Point#getRightPoint()}.
	 */
	@Test
	public void testGetRightPoint() {
		Point testPoint = new Point(2, 1);
		assertTrue("Equal Point", (new Point(3,1).equals(testPoint.getRightPoint())));
	}

	/**
	 * Test method for {@link logic.Point#getRightMove()}.
	 */
	@Test
	public void testGetRightMove() {
		Point testPoint = new Point(2, 1);
		assertTrue("Equal Point", (new Point(4,1).equals(testPoint.getRightMove())));
	}

	/**
	 * Test method for {@link logic.Point#getUpPoint()}.
	 */
	@Test
	public void testGetUpPoint() {
		Point testPoint = new Point(2, 4);
		assertTrue("Equal Point", (new Point(2,3).equals(testPoint.getUpPoint())));
	}

	/**
	 * Test method for {@link logic.Point#getUpMove()}.
	 */
	@Test
	public void testGetUpMove() {
		Point testPoint = new Point(2, 4);
		assertTrue("Equal Point", (new Point(2,2).equals(testPoint.getUpMove())));
	}

	/**
	 * Test method for {@link logic.Point#getDownPoint()}.
	 */
	@Test
	public void testGetDownPoint() {
		Point testPoint = new Point(2, 4);
		assertTrue("Equal Point", (new Point(2,5).equals(testPoint.getDownPoint())));
	}

	/**
	 * Test method for {@link logic.Point#getDownMove()}.
	 */
	@Test
	public void testGetDownMove() {
		Point testPoint = new Point(2, 4);
		assertTrue("Equal Point", (new Point(2,6).equals(testPoint.getDownMove())));
	}

	/**
	 * Test method for {@link logic.Point#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Point pointTest = new Point(3,1);
		assertTrue("equal points", pointTest.equals(new Point(3, 1)));
		assertFalse("different points", pointTest.equals(new Point(3, 2)));
	}

}
