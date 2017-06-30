package logic;

public class Point extends Position{	
	
	
	public Point(int x, int y)
	{ 	
		super(x, y);		
	}

	public Point getLeftPoint()
	{
		return new Point(getX()-1, getY());
	}
	
	public Point getLeftMove()
	{
		return new Point(getX()-2, getY());
	}
	
	public Point getRightPoint()
	{
		return new Point(getX()+1, getY());
	}
	
	public Point getRightMove()
	{
		return new Point(getX()+2, getY());
	}
	
	public Point getUpPoint()
	{
		return new Point(getX(), getY()-1);
	}
	
	public Point getUpMove()
	{
		return new Point(getX(), getY()-2);
	}
	
	public Point getDownPoint()
	{
		return new Point(getX(), getY()+1);
	}
	
	public Point getDownMove()
	{
		return new Point(getX(), getY()+2);
	}
	
	@Override
	public boolean equals(Object object)
	{
		if (object == null)
		    return false;

		if (this.getClass() != object.getClass())
		    return false;
		  
		return getX() == ((Point)object).getX() && getY() == ((Point)object).getY();  
	}
}
