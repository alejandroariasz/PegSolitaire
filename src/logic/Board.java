package logic;

import java.util.ArrayList;
import java.util.List;

import util.Constant;

public class Board {
	
	private List<Tile> board;
	
	public Board()
	{
		initBoard();
	}
	
	public void initBoard()
	{
		this.board = Constant.getCross();
	}
	
	public void move(Move move){
		board.get(move.getPeg()).changePeg(false);
		board.get(move.getMove()).changePeg(true);
		board.get(move.getPegToRemove()).changePeg(false);
	}
	
	public List<Move> getAvailableMovements(Tile peg)
	{
		List<Move> movements = new ArrayList<>();
		
		if(getUpMovement(peg) != null)
			movements.add(getUpMovement(peg));
		
		if(getRightMovement(peg) != null)
			movements.add(getRightMovement(peg));
		
		if(getDownMovement(peg) != null)
			movements.add(getDownMovement(peg));
		
		if(getLeftMovement(peg) != null)
			movements.add(getLeftMovement(peg));
		
		return movements;
	}
	
	public Move getUpMovement(Tile peg)
	{
		Point point = peg.getPoint();
		if(point.getY() < 2)
			return null;
		if(point.getY() < 5 && (point.getX() < 3 || point.getX() > 5))
			return null;
		
		return getMove(peg.getPoint(), point.getUpPoint(), point.getUpMove());
	}
	
	public Move getRightMovement(Tile peg)
	{
		Point point = peg.getPoint();
		if(point.getX() > 6)
			return null;
		if(point.getX() > 3 && (point.getY() < 3 || point.getY() > 5))
			return null;
		
		return getMove(peg.getPoint(), point.getRightPoint(), point.getRightMove());
	}
	
	public Move getDownMovement(Tile peg)
	{
		Point point = peg.getPoint();
		if(point.getY() > 6)
			return null;
		if(point.getY() > 3 && (point.getX() < 3 || point.getX() > 5))
			return null;
		
		return getMove(peg.getPoint(), point.getUpPoint(), point.getUpMove());
	}
	
	public Move getLeftMovement(Tile peg)
	{
		Point point = peg.getPoint();
		if(point.getX() < 2)
			return null;
		if(point.getX() < 5 && (point.getY() < 3 || point.getY() > 5))
			return null;
		
		return getMove(peg.getPoint(), point.getLeftPoint(), point.getLeftMove());
	}
	
	public Move getMove(Point peg, Point pegToRemove, Point move)
	{
		int pegIndex = board.indexOf(new Tile(peg, true));
		int pegToRemoveIndex = board.indexOf(new Tile(pegToRemove, true));
		int moveIndex = board.indexOf(new Tile(move, true));
		if(pegToRemoveIndex >= 0 && moveIndex == -1)
			return new Move(pegIndex, moveIndex, pegToRemoveIndex);
		
		return null;
	}

}
