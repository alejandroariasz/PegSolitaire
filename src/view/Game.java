package view;

import java.util.List;

import logic.Board;
import logic.Move;
import logic.Point;
import logic.Tile;
import processing.core.PApplet;
import processing.core.PImage;

public class Game extends PApplet{
	
	PImage boardIMG;
	Board board;
	boolean pegSelected;
	List<Move> availableMovements;
	
	@Override
    public void settings(){
		// load board images
    	//boardIMG = loadImage("board.jpg");
        //size(boardIMG.width,boardIMG.height);
		size(510, 510);
    }

    @Override
    public void setup(){ 
    	board = new Board();
    	drawBoard();
    }
    
    public Point getPointFromCell(Cell cell)
    {
    	System.out.println("Cell " + cell.getX() + " " + cell.getY());
    	return new Point( (cell.getX() - 10) / 70, (cell.getY() - 10) / 70 );
    }
    
    public Cell getCellFromPoint(Point point){
    	return new Cell( point.getX() * 70 + 10, point.getY() * 70 + 10 );
    }
    
    @Override
    public void draw(){
     //System.out.println(mouseX + " " + mouseY);
    }
    
    public void mouseClicked() {
    	drawBoard();
    	Point point = getPointFromCell(new Cell(mouseX, mouseY));
    	if(pegSelected)
    	{
    		for(Move movement : availableMovements)
    		{
    			Point movementPoint = board.getBoard().get(movement.getMove()).getPoint();
        		if(point.equals(movementPoint))
        		{
        			board.move(movement);
        			drawBoard();
        		}
    		}
    	}
    	
    	pegSelected = false;
    	
    	if(board.getPeg(point) != null)
    	{
    		fill(255, 0, 0, 125);
    		pegSelected = true;
    		availableMovements = board.getAvailableMovements(board.getPeg(point));
    		for(Move movement : availableMovements){
    			Cell cell = getCellFromPoint(board.getBoard().get(movement.getMove()).getPoint());
    			rect(cell.getX(), cell.getY(), 70, 70);
    		}
    	}
	}
    
    public void drawBoard()
    {
    	background(255, 255, 255);
    	
    	for(Tile tile : board.getBoard()){
    		if(!tile.hasPeg()) continue;
    		fill(0,0,255);
    		Cell cell = getCellFromPoint(tile.getPoint());
    		rect(cell.getX() + 10, cell.getY() + 10, 50, 50);
    	}
    	
    	line(10, 10 + 140, 10, 10 + 350);
    	line(10 + 70*7, 10 + 140, 10 + 70*7, 10 + 350);
    	line(10 + 70, 10 + 140, 10 + 70, 10 + 350);
    	line(10 + 70*6, 10 + 140, 10 + 70*6, 10 + 350);
    	for(int i = 2; i < 6; i++)
    		line(10 + 70*i, 10 + 0, 10 + 70*i, 10 + 490);
    	
    	line(10 + 140, 10, 10 + 350, 10);
    	line(10 + 140, 10 + 70*7, 10 + 350, 10 + 70*7);
    	line(10 + 140, 10 + 70, 10 + 350, 10 + 70);
    	line(10 + 140, 10 + 70*6, 10 + 350, 10 + 70*6);
    	for(int i = 2; i < 6; i++)
    		line(10, 10 + 70*i, 10 + 490, 10 + + 70*i);
    }

	public static void main(String[] args) {
		
		PApplet.main("view.Game");

	}

}
