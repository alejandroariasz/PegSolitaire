/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.Board;
import logic.Point;
import logic.Tile;
import util.Constant;

public class ConstantTest {

	/**
	 * Test method for {@link util.Constant#setBoardPegs(java.util.List)}.
	 */
	@Test
	public void testSetBoardPegs() {
		List<Point> points = new ArrayList<Point>();
		Board boardTest = new Board(1);
		
		points.add(new Point(2,1));
		points.add(new Point(3,3));
		points.add(new Point(3,5));			
		boardTest.setBoard(Constant.setBoardPegs(points));
		assertTrue("Tile set", boardTest.getBoard().indexOf(new Tile(new Point(2,1), true)) != -1);
		assertTrue("Tile set", boardTest.getBoard().indexOf(new Tile(new Point(3,3), true)) != -1);
		assertTrue("Tile set", boardTest.getBoard().indexOf(new Tile(new Point(3,5), true)) != -1);
		assertTrue("Tile unset", boardTest.getBoard().indexOf(new Tile(new Point(3,4), true)) == -1);		
		
	}

}
