package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import logic.Board;
import logic.Move;
import logic.Point;
import logic.Tile;
import processing.core.PApplet;
import processing.core.PImage;
import util.Constant;

public class Game extends PApplet{
	
	PImage boardIMG;
	Board board;
	boolean pegSelected;
	boolean endGame;
	boolean gameStarted;
	List<Move> availableMovements;
	Stack<List<Tile>> boardRecord;
	
	
	int margin = 65;
	int cellSize = 70;
	int optionSize = 200;
	int optionMargin = 10;
	int screenSize = 620;
	
	int movements;
	Stack<Integer> movementsRecord;
	
	Tile actualPeg;
	
	Move actualMove;
	Move previousMove;
	
	@Override
    public void settings()
	{
		size(screenSize, screenSize);
    }

    @Override
    public void setup()
    {
    	pegSelected = false;
    	endGame = false;
    	gameStarted = false;
    	movements = 0;
    	boardRecord = new Stack<>();
    	movementsRecord = new Stack<>();
    	drawHome();
    }
    
    public Point getPointFromCell(Cell cell)
    {
    	return new Point( (cell.getX() - margin) / cellSize, (cell.getY() - margin) / cellSize );
    }
    
    public int getOptionFromCell(Cell cell)
    {
    	return (cell.getX() - optionMargin) / optionSize + (cell.getY() - optionMargin) / optionSize * 3;
    }
    
    public Cell getCellFromPoint(Point point)
    {
    	return new Cell( point.getX() * cellSize + margin, point.getY() * cellSize + margin );
    }
    
    public void startGame()
    {
    	int option = getOptionFromCell(new Cell(mouseX, mouseY));
		if(option < 0 || option > 8) return;
    	board = new Board(option);
    	boardRecord.add(cloneList(board.getBoard()));
    	movementsRecord.add(0);
		gameStarted = true;
		drawGame();
    }
    
    @Override
    public void draw()
    {
    	// Do nothing, we are using mouseClicked event, and not iterating on this method by default.
    }
    
    public void restartButton()
    {
    	fill(0,0,255);
		rect(30, 10, 120, 40);
		fill(0);
		textSize(18);
		text("Restart", 58, 36);
    }
    
    public void undoButton()
    {
    	fill(0,0,255);
		rect(180, 10, 120, 40);
		fill(0);
		textSize(18);
		text("Undo", 220, 36);
    }
    
    public void mouseClicked() 
    {
    	if(!gameStarted)
    	{
    		startGame();
    		return;
    	}
    	
    	if(mouseX > 30 && mouseX < 150 && mouseY > 10 && mouseY < 50)
    	{
    		setup();
    		return;
    	}
    	
    	if(mouseX > 180 && mouseX < 300 && mouseY > 10 && mouseY < 50 && boardRecord.size() > 1)
    	{
    		board.setBoard(boardRecord.pop());
    		movements = movementsRecord.pop();
    		drawGame();
    		return;
    	}
    	
    	drawGame();
    	if(endGame) return;
    	
    	Point point = getPointFromCell(new Cell(mouseX, mouseY));
    	
    	if(pegSelected)
    		makeMovement(point);
    	
    	pegSelected = false;
    	
    	if(board.getPeg(point) != null)
    		selectPeg(point);
	}
    
    public void makeMovement(Point point)
    {
    	for(Move movement : availableMovements)
		{
			Point movementPoint = board.getBoard().get(movement.getMove()).getPoint();
    		if(point.equals(movementPoint))
    		{
    			previousMove = actualMove;
        		actualMove = movement;
        		
        		boardRecord.add(cloneList(board.getBoard()));
        		movementsRecord.add(movements);
        		
        		if(previousMove != null)
        		{
        			Point actualOrigin = board.getBoard().get(actualMove.getPeg()).getPoint();
            		Point previousFinal = board.getBoard().get(previousMove.getMove()).getPoint();
            		movements += actualOrigin.equals(previousFinal) ? 0 : 1;
        		}else
        			movements++;
        		
    			board.move(movement);
    			drawGame();
    		}
		}
    }
    
    public void selectPeg(Point point)
    {
    	pegSelected = true;
		availableMovements = board.getAvailableMovements(board.getPeg(point));
		for(Move movement : availableMovements)
			drawHint( board.getBoard().get(movement.getMove()).getPoint() );
    }
    
    public void drawGame()
    {
    	background(255, 255, 255);
    	
    	drawTopBar();
    	
    	textSize(60);
    	fill(0, 0, 255);
    	if(board.isFinished())
    		text("You have won!", 75, 310);
    	
    	else if(board.isGameOver())
    		text("GAME OVER", 105, 310);
    	
    	if(board.isFinished() || board.isGameOver())
    		endGame = true;
    	else
    		drawBoard();
    }
    
    public void drawTopBar()
    {
    	textSize(18);
    	fill(0, 0, 255);
    	text("Movements:    " + movements, 420, 35);
    	restartButton();
    	undoButton();
    }
    
    public void drawHome()
    {
    	background(255, 255, 255);
    	fill(255);
    	for(int i = 0; i < 3; i++)
    		for(int j = 0; j < 3; j++)
    			rect(optionMargin + optionSize * i, optionMargin + optionSize * j, optionSize, optionSize);    	
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
		rect(cell.getX() + 10, cell.getY() + 10, 50, 50);
    }
    
    public void drawHint(Point point)
    {
    	fill(255, 0, 0, 125);
    	Cell cell = getCellFromPoint(point);
    	rect(cell.getX(), cell.getY(), cellSize, cellSize);
    }
    
    public static List<Tile> cloneList(List<Tile> boardList) {
        List<Tile> clonedList = new ArrayList<Tile>(boardList.size());
        for (Tile tile : boardList) {
            clonedList.add(new Tile(tile));
        }
        return clonedList;
    }

	public static void main(String[] args) 
	{
		PApplet.main("view.Game");
	}

}
