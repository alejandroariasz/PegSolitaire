/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Point;
import logic.Tile;

public class TileTest {

	@Test
	public void testEqualsObject() {
		Tile tileTest = new Tile(new Point(3,1), false);
		assertTrue("equal tile", tileTest.equals(new Tile(new Point(3,1), false)));
		assertFalse("different tile", tileTest.equals(new Tile(new Point(3,1), true)));
		assertFalse("different tile", tileTest.equals(new Tile(new Point(3,2), false)));
	}

}
