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
		add(new Point(3,2));
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
	
	public static List<Tile> getLatinCross()
	{
		List<Tile> board = new ArrayList<Tile>();
		for(int i = 0; i < BOARD_SIZE; i++){
			for(int j = 0; j < BOARD_SIZE; j++){
				Point point = new Point(i,j);
				board.add(new Tile(point,LATIN_CROSS.contains(point)));
			}
		}
		return board;
	}
	
	public static List<Tile> getCross()
	{
		List<Tile> board = new ArrayList<Tile>();
		for(int i = 0; i < BOARD_SIZE; i++){
			for(int j = 0; j < BOARD_SIZE; j++){
				Point point = new Point(i,j);
				board.add(new Tile(point,PLUS.contains(point)));
			}
		}
		return board;
	}

}
