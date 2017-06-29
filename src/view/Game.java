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
	boolean endGame;
	boolean gameStarted;
	List<Move> availableMovements;
	
	int margin = 10;
	int cellSize = 70;
	
	@Override
    public void settings(){
		size(510, 510);
    }

    @Override
    public void setup(){
    	pegSelected = false;
    	endGame = false;
    	board = new Board();
    	
    	drawGame();
    }
    
    public Point getPointFromCell(Cell cell)
    {
    	return new Point( (cell.getX() - margin) / cellSize, (cell.getY() - margin) / cellSize );
    }
    
    public Cell getCellFromPoint(Point point){
    	return new Cell( point.getX() * cellSize + margin, point.getY() * cellSize + margin );
    }
    
    @Override
    public void draw(){
    	
    }
    
    public void mouseClicked() {
    	drawGame();
    	if(endGame) return;
    	Point point = getPointFromCell(new Cell(mouseX, mouseY));
    	if(pegSelected)
    	{
    		for(Move movement : availableMovements)
    		{
    			Point movementPoint = board.getBoard().get(movement.getMove()).getPoint();
        		if(point.equals(movementPoint))
        		{
        			board.move(movement);
        			drawGame();
        		}
    		}
    	}
    	
    	pegSelected = false;
    	
    	if(board.getPeg(point) != null)
    	{
    		pegSelected = true;
    		availableMovements = board.getAvailableMovements(board.getPeg(point));
    		for(Move movement : availableMovements)
    			drawHint( board.getBoard().get(movement.getMove()).getPoint() );
    	}
	}
    
    public void drawGame()
    {
    	textSize(60);
    	background(255, 255, 255);
    	if(board.isFinished())
    		text("You have won!", 55, 260);
    	
    	else if(board.isGameOver())
    		text("GAME OVER", 70, 260);
    	
    	if(board.isFinished() || board.isGameOver())
    		endGame = true;
    	else
    		drawBoard();
    }
    
    public void drawBoard()
    {
    	for(Tile tile : board.getBoard())
    	{
    		if(!tile.hasPeg()) continue;
    		drawPeg(tile.getPoint());
    	}
    	
    	for(int i = 0; i < 2; i++)
    	{
    		line(margin + cellSize * i, margin + 140, margin + cellSize * i, margin + 350);
    		line(margin + 140, margin + cellSize * i, margin + 350, margin + cellSize * i);
    	}
    		
    	for(int i = 6; i < 8; i++)
    	{
    		line(margin + cellSize * i, margin + 140, margin + cellSize * i, margin + 350);
    		line(margin + 140, margin + cellSize * i, margin + 350, margin + cellSize * i);
    	}
    		
    	for(int i = 2; i < 6; i++)
    		line(margin + 70*i, margin + 0, margin + 70*i, margin + 490);
    	
    	for(int i = 2; i < 6; i++)
    		line(margin, margin + 70*i, margin + 490, margin + 70*i);
    }
    
    public void drawPeg(Point point)
    {
    	fill(0,0,255);
		Cell cell = getCellFromPoint(point);
		rect(cell.getX() + margin, cell.getY() + margin, 50, 50);
    }
    
    public void drawHint(Point point)
    {
    	fill(255, 0, 0, 125);
    	Cell cell = getCellFromPoint(point);
    	rect(cell.getX(), cell.getY(), cellSize, cellSize);
    }

	public static void main(String[] args) 
	{
		PApplet.main("view.Game");
	}

}
