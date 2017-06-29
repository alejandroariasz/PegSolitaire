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
	
	public boolean isFinished()
	{
		int numOfPegs = 0;
		Tile peg = board.get(0);
		for(Tile tile : board)
		{
			if(!tile.hasPeg()) continue;
			numOfPegs++;
			peg = tile;
		}
		return numOfPegs == 1 && peg.getPoint().equals(new Point(3,3));
	}
	
	public boolean isGameOver()
	{
		for(Tile tile : board)
		{
			if(!tile.hasPeg()) continue;
			if(getAvailableMovements(tile).size() > 0)
				return false;
		}
		return true;
	}
	
	public Tile getPeg(Point point)
	{
		int pegIndex = board.indexOf(new Tile(point, true)); 
		if( pegIndex == -1)
			return null;
		
		return board.get(pegIndex); 
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
	
	private Move getUpMovement(Tile peg)
	{
		Point point = peg.getPoint();
		if(point.getY() < 2)
			return null;
		if(point.getY() < 3 && (point.getX() < 2 || point.getX() > 4))
			return null;
		
		return getMove(peg.getPoint(), point.getUpPoint(), point.getUpMove());
	}
	
	private Move getRightMovement(Tile peg)
	{
		Point point = peg.getPoint();
		if(point.getX() > 4)
			return null;
		if(point.getX() > 2 && (point.getY() < 2 || point.getY() > 4))
			return null;
		
		return getMove(peg.getPoint(), point.getRightPoint(), point.getRightMove());
	}
	
	private Move getDownMovement(Tile peg)
	{
		Point point = peg.getPoint();
		if(point.getY() > 4)
			return null;
		if(point.getY() > 2 && (point.getX() < 2 || point.getX() > 4))
			return null;
		
		return getMove(peg.getPoint(), point.getDownPoint(), point.getDownMove());
	}
	
	private Move getLeftMovement(Tile peg)
	{
		Point point = peg.getPoint();
		if(point.getX() < 2)
			return null;
		if(point.getX() < 4 && (point.getY() < 2 || point.getY() > 4))
			return null;
		
		return getMove(peg.getPoint(), point.getLeftPoint(), point.getLeftMove());
	}
	
	public Move getMove(Point peg, Point pegToRemove, Point move)
	{
		int pegIndex = board.indexOf(new Tile(peg, true));
		int pegToRemoveIndex = board.indexOf(new Tile(pegToRemove, true));
		int moveIndex = board.indexOf(new Tile(move, false));
		if(pegToRemoveIndex >= 0 && moveIndex != -1)
			return new Move(pegIndex, moveIndex, pegToRemoveIndex);
		
		return null;
	}
	
	public List<Tile> getBoard() {
		return board;
	}

	public void setBoard(List<Tile> board) {
		this.board = board;
	}

}
