/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Point;

public class PointTest {

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
