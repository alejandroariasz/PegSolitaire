package logic;

import java.util.ArrayList;
import java.util.List;

import util.Constant;

public class Board {
	
	private List<Tile> boardTiles;

	public Board(int option)
	{
		initBoard(option);
	}
	
	public void initBoard(int option)
	{
		this.boardTiles = Constant.getBoardConfigurations().get(option);
	}
	
	public boolean isFinished()
	{
		int numOfPegs = 0;
		Tile peg = boardTiles.get(0);
		for(Tile tile : boardTiles)
		{
			if(!tile.hasPeg()) continue;
			numOfPegs++;
			peg = tile;
		}
		return numOfPegs == 1 && peg.getPoint().equals(new Point(3,3));
	}
	
	public boolean isGameOver()
	{
		for(Tile tile : boardTiles)
		{
			if(!tile.hasPeg()) continue;
			if(!getAvailableMovements(tile).isEmpty())
				return false;
		}
		return true;
	}
	
	public Tile getPeg(Point point)
	{
		int pegIndex = boardTiles.indexOf(new Tile(point, true)); 
		if( pegIndex == -1)
			return null;
		
		return boardTiles.get(pegIndex); 
	}
	
	public void move(Move move){
		boardTiles.get(move.getPeg()).changePeg(false);
		boardTiles.get(move.getMove()).changePeg(true);
		boardTiles.get(move.getPegToRemove()).changePeg(false);
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
		if(point.getY() < 4 && (point.getX() < 2 || point.getX() > 4))
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
		int pegIndex = boardTiles.indexOf(new Tile(peg, true));
		int pegToRemoveIndex = boardTiles.indexOf(new Tile(pegToRemove, true));
		int moveIndex = boardTiles.indexOf(new Tile(move, false));
		if(pegToRemoveIndex >= 0 && moveIndex != -1)
			return new Move(pegIndex, moveIndex, pegToRemoveIndex);
		
		return null;
	}
	
	public List<Tile> getBoard() {
		return boardTiles;
	}

	public void setBoard(List<Tile> board) {
		this.boardTiles = board;
	}

	public List<Tile> getBoard() {
		return board;
	}

	public void setBoard(List<Tile> board) {
		this.board = board;
	}

}
