package util;

import java.util.ArrayList;
import java.util.List;

import logic.Point;
import logic.Tile;

public class Constant {
	
	
	public static int BOARD_SIZE = 7;
	
	
	public static List<Point> LATIN_CROSS = new ArrayList<Point>();
	
	static{
		LATIN_CROSS.add(new Point(3,1));
		LATIN_CROSS.add(new Point(3,2));
		LATIN_CROSS.add(new Point(3,3));
		LATIN_CROSS.add(new Point(3,4));
		
		LATIN_CROSS.add(new Point(4,2));
		LATIN_CROSS.add(new Point(2,2));	
	}
	
	
	public static List<Point> BUTACO = new ArrayList<Point>();
	static{
		BUTACO.add(new Point(2,0));
		BUTACO.add(new Point(2,1));
		BUTACO.add(new Point(2,2));
		BUTACO.add(new Point(2,3));
		
		BUTACO.add(new Point(3,0));
		BUTACO.add(new Point(3,1));
		BUTACO.add(new Point(3,2));
		
		BUTACO.add(new Point(4,0));
		BUTACO.add(new Point(4,1));
		BUTACO.add(new Point(4,2));
		BUTACO.add(new Point(4,3));
	}
	
	
	public static List<Point> PLUS = new ArrayList<Point>();
	static{
		PLUS.add(new Point(3,1));
		PLUS.add(new Point(3,2));
		PLUS.add(new Point(3,3));
		PLUS.add(new Point(3,4));
		PLUS.add(new Point(3,5));
		
		PLUS.add(new Point(1,3));
		PLUS.add(new Point(2,3));
		PLUS.add(new Point(4,3));
		PLUS.add(new Point(5,3));
	}
	
	
	public static List<Point> PYRAMID = new ArrayList<Point>();
	static{
		PYRAMID.add(new Point(3,1));
		
		PYRAMID.add(new Point(2,2));
		PYRAMID.add(new Point(3,2));
		PYRAMID.add(new Point(4,2));
		
		PYRAMID.add(new Point(1,3));
		PYRAMID.add(new Point(2,3));
		PYRAMID.add(new Point(3,3));
		PYRAMID.add(new Point(4,3));
		PYRAMID.add(new Point(5,3));
		
		PYRAMID.add(new Point(0,4));
		PYRAMID.add(new Point(1,4));
		PYRAMID.add(new Point(2,4));
		PYRAMID.add(new Point(3,4));
		PYRAMID.add(new Point(4,4));
		PYRAMID.add(new Point(5,4));
		PYRAMID.add(new Point(6,4));
	}
	
	
	public static List<Point> LAMP = new ArrayList<Point>();
	static{
		LAMP.add(new Point(3,0));
		
		LAMP.add(new Point(2,1));
		LAMP.add(new Point(3,1));
		LAMP.add(new Point(4,1));
		
		LAMP.add(new Point(1,2));
		LAMP.add(new Point(2,2));
		LAMP.add(new Point(3,2));
		LAMP.add(new Point(4,2));
		LAMP.add(new Point(5,2));
		
		LAMP.add(new Point(3,3));
		LAMP.add(new Point(3,4));
		
		LAMP.add(new Point(2,5));
		LAMP.add(new Point(3,5));
		LAMP.add(new Point(4,5));
		
		LAMP.add(new Point(2,6));
		LAMP.add(new Point(3,6));
		LAMP.add(new Point(4,6));
	}
	
	
	
	public static List<Point> DIAMOND = new ArrayList<Point>();
	static{
		DIAMOND.add(new Point(3,0));
		
		DIAMOND.add(new Point(2,1));
		DIAMOND.add(new Point(3,1));
		DIAMOND.add(new Point(4,1));
		
		DIAMOND.add(new Point(1,2));
		DIAMOND.add(new Point(2,2));
		DIAMOND.add(new Point(3,2));
		DIAMOND.add(new Point(4,2));
		DIAMOND.add(new Point(5,2));
		
		DIAMOND.add(new Point(3,4));
		
		DIAMOND.add(new Point(0,3));
		DIAMOND.add(new Point(1,3));
		DIAMOND.add(new Point(2,3));
		DIAMOND.add(new Point(4,3));
		DIAMOND.add(new Point(5,3));
		DIAMOND.add(new Point(6,3));
		
		DIAMOND.add(new Point(1,4));
		DIAMOND.add(new Point(2,4));
		DIAMOND.add(new Point(3,4));
		DIAMOND.add(new Point(4,4));
		DIAMOND.add(new Point(5,4));
		
		DIAMOND.add(new Point(2,5));
		DIAMOND.add(new Point(3,5));
		DIAMOND.add(new Point(4,5));
		
		DIAMOND.add(new Point(3,6));
	}
	
	
	public static List<Point> BUTACO_DOBLE = new ArrayList<Point>();
	static{
		BUTACO_DOBLE.addAll(BUTACO);
		
		BUTACO_DOBLE.add(new Point(2,4));
		BUTACO_DOBLE.add(new Point(3,4));
		BUTACO_DOBLE.add(new Point(4,4));
		
		BUTACO_DOBLE.add(new Point(2,5));
		BUTACO_DOBLE.add(new Point(3,5));
		BUTACO_DOBLE.add(new Point(4,5));
		
		BUTACO_DOBLE.add(new Point(2,6));
		BUTACO_DOBLE.add(new Point(3,6));
		BUTACO_DOBLE.add(new Point(4,6));
	}
	
	
	public static List<Point> HAT = new ArrayList<Point>();
	static{
		HAT.addAll(BUTACO);
		
		HAT.add(new Point(0,4));
		HAT.add(new Point(1,4));
		HAT.add(new Point(2,4));
		
		HAT.add(new Point(4,4));
		HAT.add(new Point(5,4));
		HAT.add(new Point(6,4));
	}
	
	
	
	public static List<Point> COMPLETE = new ArrayList<Point>();
	static{
		COMPLETE.addAll(DIAMOND);
		
		COMPLETE.add(new Point(2,0));
		COMPLETE.add(new Point(4,0));
		
		COMPLETE.add(new Point(0,2));
		COMPLETE.add(new Point(0,4));
		
		COMPLETE.add(new Point(6,2));
		COMPLETE.add(new Point(6,4));
		
		COMPLETE.add(new Point(2,6));
		COMPLETE.add(new Point(4,6));
	}
	
	@SuppressWarnings("serial")
	public static List<List<Tile>> getBoardConfigurations()
	{
		return new ArrayList<List<Tile>>()
		{{
			add(setBoardPegs(LATIN_CROSS));
			add(setBoardPegs(PLUS));
			add(setBoardPegs(BUTACO));
			add(setBoardPegs(PYRAMID));
			add(setBoardPegs(BUTACO_DOBLE));
			add(setBoardPegs(LAMP));
			add(setBoardPegs(HAT));
			add(setBoardPegs(DIAMOND));
			add(setBoardPegs(COMPLETE));
		}};
	}
	
	public static List<Tile> setBoardPegs(List<Point> typeConfig)
	{
		List<Tile> board = new ArrayList<Tile>();
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			for(int j = 0; j < BOARD_SIZE; j++)
			{
				Point point = new Point(i,j);
				board.add(new Tile(point, typeConfig.contains(point)));
			}
		}
		return board;
	}

}
