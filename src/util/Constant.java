package util;

import java.util.ArrayList;
import java.util.List;

import logic.Point;
import logic.Tile;

public class Constant {
	
	
	public static int BOARD_SIZE = 7;
	
	@SuppressWarnings("serial")
	public static List<Point> LATIN_CROSS = new ArrayList<Point>()
	{{
		add(new Point(3,1));
		add(new Point(3,2));
		add(new Point(3,3));
		add(new Point(3,4));
		
		add(new Point(4,2));
		add(new Point(2,2));
	}};
	
	@SuppressWarnings("serial")
	public static List<Point> BUTACO = new ArrayList<Point>()
	{{
		add(new Point(2,0));
		add(new Point(2,1));
		add(new Point(2,2));
		add(new Point(2,3));
		
		add(new Point(3,0));
		add(new Point(3,1));
		add(new Point(3,2));
		
		add(new Point(4,0));
		add(new Point(4,1));
		add(new Point(4,2));
		add(new Point(4,3));
	}};
	
	@SuppressWarnings("serial")
	public static List<Point> PLUS = new ArrayList<Point>()
	{{
		add(new Point(3,1));
		add(new Point(3,2));
		add(new Point(3,3));
		add(new Point(3,4));
		add(new Point(3,5));
		
		add(new Point(1,2));
		add(new Point(2,2));
		add(new Point(3,2));
		add(new Point(4,2));
		add(new Point(5,2));
	}};
	
	@SuppressWarnings("serial")
	public static List<Point> PYRAMID = new ArrayList<Point>()
	{{
		add(new Point(3,1));
		
		add(new Point(2,2));
		add(new Point(3,2));
		add(new Point(4,2));
		
		add(new Point(1,3));
		add(new Point(2,3));
		add(new Point(3,3));
		add(new Point(4,3));
		add(new Point(5,3));
		
		add(new Point(0,4));
		add(new Point(1,4));
		add(new Point(2,4));
		add(new Point(3,4));
		add(new Point(4,4));
		add(new Point(5,4));
		add(new Point(6,4));
	}};
	
	public static List<Tile> getLatinCross()
	{
		return setBoardPegs(LATIN_CROSS);
	}
	
	public static List<Tile> getCross()
	{
		return setBoardPegs(PLUS);
	}
	
	public static List<Tile> getButaco()
	{
		return setBoardPegs(BUTACO);
	}
	
	public static List<Tile> getPyramid()
	{
		return setBoardPegs(PYRAMID);
	}
	
	public static List<Tile> setBoardPegs(List<Point> typeConfig){
		List<Tile> board = new ArrayList<Tile>();
		for(int i = 0; i < BOARD_SIZE; i++){
			for(int j = 0; j < BOARD_SIZE; j++){
				Point point = new Point(i,j);
				board.add(new Tile(point,typeConfig.contains(point)));
			}
		}
		return board;
	}

}
