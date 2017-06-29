package view;

import processing.core.PApplet;
import processing.core.PImage;

public class Game extends PApplet{
	
	PImage boardIMG;
	
	@Override
    public void settings(){
		// load board images
    	boardIMG = loadImage("board.jpg");
        size(boardIMG.width,boardIMG.height);
    }

    @Override
    public void setup(){ 
    	imageMode(CENTER);
    	
    	drawBoard();
    }
    
    @Override
    public void draw(){
     //System.out.println(mouseX + " " + mouseY);
    }
    
    public void drawBoard()
    {
      image(boardIMG, width/2, height/2);
    }

	public static void main(String[] args) {
		
		PApplet.main("view.Game");

	}

}
