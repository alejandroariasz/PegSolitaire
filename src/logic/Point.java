package logic;

public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Point getLeftPoint()
	{
		return new Point(x-1, y);
	}
	
	public Point getLeftMove()
	{
		return new Point(x-2, y);
	}
	
	public Point getRightPoint()
	{
		return new Point(x+1, y);
	}
	
	public Point getRightMove()
	{
		return new Point(x+2, y);
	}
	
	public Point getUpPoint()
	{
		return new Point(x, y-1);
	}
	
	public Point getUpMove()
	{
		return new Point(x, y-2);
	}
	
	public Point getDownPoint()
	{
		return new Point(x, y+1);
	}
	
	public Point getDownMove()
	{
		return new Point(x, y+2);
	}
	
	@Override
	public boolean equals(Object object)
	{
		if (object == null)
		    return false;

		if (this.getClass() != object.getClass())
		    return false;
		  
		return x == ((Point)object).x && y == ((Point)object).y;  
	}
}
