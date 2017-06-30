package view;

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
	
	int margin = 65;
	int cellSize = 70;
	int optionSize = 200;
	int optionMargin = 10;
	int screenSize = 620;
	
	PImage boardIMG;
	Board board;
	boolean pegSelected;
	boolean endGame;
	boolean gameStarted;
	List<Move> availableMovements;
	Stack<List<Tile>> boardRecord;
	Stack<String> playerRecord;
	
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
    	playerRecord = new Stack<>();
    	actualMove = null;
    	previousMove = null;
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
    	boardRecord.add(Constant.cloneList(board.getBoard()));
    	movementsRecord.add(0);
    	playerRecord.add("");
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
    	
    	if(mouseX > 180 && mouseX < 300 && mouseY > 10 && mouseY < 50 && boardRecord.size() > 1 && !endGame)
    	{
    		board.setBoard(boardRecord.pop());
    		movements = movementsRecord.pop();
    		playerRecord.pop();
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
			Point originPoint = board.getBoard().get(movement.getPeg()).getPoint();
    		if(point.equals(movementPoint))
    		{
    			previousMove = actualMove;
        		actualMove = movement;
        		
        		boardRecord.add(Constant.cloneList(board.getBoard()));
        		movementsRecord.add(movements);
        		playerRecord.add( "[" +
        				(char)(originPoint.getX() + 97) + "," + (originPoint.getY() + 1) + " -> " +
        				(char)(movementPoint.getX() + 97) + "," + (movementPoint.getY() + 1) + "]");

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
    	
    	textSize(60);
    	fill(0, 0, 255);
    	if(board.isFinished())
    		text("You have won!", 75, 310);
    	
    	else if(board.isGameOver())
    		text("GAME OVER", 105, 310);
    	
    	if(board.isFinished() || board.isGameOver())
    	{
    		endGame = true;
    		textSize(16);
        	fill(0, 0, 0);
        	String record = "";
        	for(int i = 1; i < playerRecord.size(); i++)
        	{
        		if( (i - 1) % 4 == 0 && (i - 1) > 0)
        			record += "\n" + playerRecord.get(i) + "  ";
        		else
        			record += playerRecord.get(i) + "  ";
        	}
    		text(record, 90, 420);
    	}
    	else
    		drawBoard();
    	
    	drawTopBar();
    }
    
    public void drawTopBar()
    {
    	textSize(18);
    	fill(0, 0, 255);
    	text("Movements:    " + movements, 420, 35);
    	restartButton();
    	if(!endGame)
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
    	{
    		line(margin + 70*i, margin + 0, margin + 70*i, margin + 490);
    		line(margin, margin + 70*i, margin + 490, margin + 70*i);
    	}
    	drawGuide();
    		
    }
    
    public void drawGuide()
    {
    	textSize(18);
    	fill(0, 0, 0);
    	for(int i = 1; i < 8; i++)
    	{
    		text((char)(i+96), margin + 70 * i - 40, 585);
    		text(i, 32, margin + 70 * i - 30);
    	}
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

	public static void main(String[] args) 
	{
		PApplet.main("view.Game");
	}

}
