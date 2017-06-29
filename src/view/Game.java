package view;

import java.util.ArrayList;
import java.util.List;

import logic.Board;
import logic.Point;
import logic.Tile;
import processing.core.PApplet;
import processing.core.PImage;
import util.Constant;

public class Game extends PApplet{
	
	PImage boardIMG;
	Board board;
	
	// image of piece
	PImage pieceA_IMG, pieceB_IMG;
	
	@Override
    public void settings(){
		// load board images
    	boardIMG = loadImage("board.jpg");
        size(boardIMG.width,boardIMG.height);
    }

    @Override
    public void setup(){ 
    	imageMode(CENTER);
    	
    	//load piece images
    	pieceA_IMG = loadImage("figureA.png");
    	pieceB_IMG = loadImage("figureB.png");
    	
    	board = new Board();
    	
    	drawBoard();
    	setUpPegs();
    }
    
    @Override
    public void draw(){
     //System.out.println(mouseX + " " + mouseY);
    	drawBoard();
    	setUpPegs();
    }
    
    public void drawBoard()
    {
      image(boardIMG, width/2, height/2);
      
    }
    
    public void setUpPegs()
    {    	
    	
    	for (Tile peg : board.getBoard()) {
    		if(peg.hasPeg()){
    			int calcX =  (peg.getPoint().getX() * 70) + 36;
        		int calcY =  (peg.getPoint().getY() * 70) + 36;
        		image(pieceA_IMG, calcX, calcY);
    		}
    		
		}
    	
    }
    
    public void keyPressed()
    {
    	if(key == '1'){
    		board.setBoard(Constant.getCross());
    		setUpPegs();
    	}
    	if(key == '2'){
    		board.setBoard(Constant.getLatinCross());
    		setUpPegs();
    	}
    }

	public static void main(String[] args) {
		
		PApplet.main("view.Game");

	}

}
