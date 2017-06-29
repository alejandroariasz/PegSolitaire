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

public class BoardTest {

	/**
	 * Test method for {@link logic.Board#Board()}.
	 */
	@Test
	public void testBoard() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logic.Board#initBoard()}.
	 */
	@Test
	public void testInitBoard() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logic.Board#isFinished()}.
	 */
	@Test
	public void testIsFinished() {
		List<Tile> tiles = new ArrayList<Tile>();
		Board board = new Board();
		
		tiles.add(new Tile(new Point(3,3), true));
		board.setBoard(tiles);
		assertTrue("Win the game", board.isFinished());
		
		tiles.clear();
		tiles.add(new Tile(new Point(3,2), true));
		assertFalse("fail winning", board.isFinished());
		
		tiles.clear();
		tiles.add(new Tile(new Point(3,2), true));
		tiles.add(new Tile(new Point(3,3), true));
		assertFalse("fail winning", board.isFinished());
	}

	/**
	 * Test method for {@link logic.Board#isGameOver()}.
	 */
	@Test
	public void testIsGameOver() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logic.Board#getPeg(logic.Point)}.
	 */
	@Test
	public void testGetPeg() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logic.Board#move(logic.Move)}.
	 */
	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logic.Board#getAvailableMovements(logic.Tile)}.
	 */
	@Test
	public void testGetAvailableMovements() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logic.Board#getMove(logic.Point, logic.Point, logic.Point)}.
	 */
	@Test
	public void testGetMove() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logic.Board#getBoard()}.
	 */
	@Test
	public void testGetBoard() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logic.Board#setBoard(java.util.List)}.
	 */
	@Test
	public void testSetBoard() {
		fail("Not yet implemented");
	}

}
