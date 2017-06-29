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

public class BoardTest {

	/**
	 * Test method for {@link logic.Board#Board()}.
	 */
	@Test
	public void testBoard() {
		Board boardTest = new Board(1);
		assertTrue("board not empty", boardTest.getBoard() != null);
	}
	

	/**
	 * Test method for {@link logic.Board#isFinished()}.
	 */
	@Test
	public void testIsFinished() {
		List<Tile> tiles = new ArrayList<Tile>();
		Board boardTest = new Board(1);
		
		tiles.add(new Tile(new Point(3,3), true));
		boardTest.setBoard(tiles);
		assertTrue("Win the game", boardTest.isFinished());
		
		tiles.clear();
		tiles.add(new Tile(new Point(3,2), true));
		boardTest.setBoard(tiles);
		assertFalse("fail winning", boardTest.isFinished());
		
		tiles.clear();
		tiles.add(new Tile(new Point(3,2), true));
		tiles.add(new Tile(new Point(3,3), true));
		boardTest.setBoard(tiles);
		assertFalse("fail winning", boardTest.isFinished());
	}

	/**
	 * Test method for {@link logic.Board#isGameOver()}.
	 */
	@Test
	public void testIsGameOver() {
		List<Point> points = new ArrayList<Point>();
		Board boardTest = new Board(1);
		
		points.add(new Point(2,1));
		points.add(new Point(3,3));
		points.add(new Point(3,5));			
		boardTest.setBoard(Constant.setBoardPegs(points));
		assertTrue("game over", boardTest.isGameOver());
		
		points.clear();
		points.add(new Point(3,2));
		points.add(new Point(3,3));
		boardTest.setBoard(Constant.setBoardPegs(points));
		assertFalse("continue playing", boardTest.isGameOver());
	}

	/**
	 * Test method for {@link logic.Board#getPeg(logic.Point)}.
	 */
	@Test
	public void testGetPeg() {
		List<Tile> tiles = new ArrayList<Tile>();
		Board boardTest = new Board(1);
		
		tiles.add(new Tile(new Point(3,3), true));
		boardTest.setBoard(tiles);
		assertTrue("return peg", boardTest.getPeg(new Point(3,3)) != null);
		
		tiles.clear();
		tiles.add(new Tile(new Point(3,2), true));
		boardTest.setBoard(tiles);
		assertTrue("null peg", boardTest.getPeg(new Point(3,3)) == null);
		
		tiles.clear();
		tiles.add(new Tile(new Point(3,2), false));
		boardTest.setBoard(tiles);
		assertTrue("null peg", boardTest.getPeg(new Point(3,2)) == null);
	}	
	

	/**
	 * Test method for {@link logic.Board#getMove(logic.Point, logic.Point, logic.Point)}.
	 */
	@Test
	public void testGetMove() {
		
		List<Tile> tiles = new ArrayList<Tile>();
		Board boardTest = new Board(1);
		
		tiles.add(new Tile(new Point(3,3), true));
		tiles.add(new Tile(new Point(3,4), true));
		tiles.add(new Tile(new Point(3,5), false));
		boardTest.setBoard(tiles);
		assertTrue("move peg", boardTest.getMove(new Point(3,3), new Point(3,4), new Point(3,5)) != null);
		
		tiles.add(new Tile(new Point(3,3), true));
		tiles.add(new Tile(new Point(3,4), true));
		tiles.add(new Tile(new Point(3,5), false));
		boardTest.setBoard(tiles);
		assertTrue("move peg", boardTest.getMove(new Point(3,3), new Point(3,4), new Point(4,2)) == null);
	}
	

}
