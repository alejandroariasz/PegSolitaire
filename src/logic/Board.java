package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
	
	private List<Peg> pegs;
	
	public Board()
	{
		initBoard();
	}
	
	public void initBoard()
	{
		this.pegs = new ArrayList<Peg>()
		{
			
		};
	}
	
	public List<Tile> getAvailableMovements()
	{
		
		return null;
	}
	
	public HashMap<Tile, Peg> getLeftMovement(Peg peg)
	{
		if(peg.getX() <= 1)
			return null;
		if(peg.getX() < 5 && (peg.getY() < 3 || peg.getY() > 5))
			return null;
		
		if(getPegToRemove(new Tile(peg.getX()-1, peg.getY())) !=  null)
		{
			HashMap<Tile, Peg> movement = new HashMap<Tile,Peg>();
			movement.put(new Tile(2,3), getPegToRemove(new Tile(peg.getX()-1, peg.getY())));
			return movement;
		}
		return null;
		
	}
	
	public HashMap<Tile, Peg> getRightMovement(Peg peg)
	{
		if(peg.getX() >= 7)
			return null;
		if(peg.getX() > 4 && (peg.getY() < 3 || peg.getY() > 5))
			return null;
		
		if(getPegToRemove(new Tile(peg.getX()+1, peg.getY())) !=  null)
		{
			HashMap<Tile, Peg> movement = new HashMap<Tile,Peg>();
			movement.put(new Tile(2,3), getPegToRemove(new Tile(peg.getX()+1, peg.getY())));
			return movement;
		}
		return null;
		
	}
	
	public Peg getPegToRemove(Tile tile)
	{
		int pegIndex = pegs.indexOf(new Peg(tile.getX(), tile.getY()));
		if(pegIndex >= 0)
			return pegs.get(pegIndex);
		
		return null;
	}

}
