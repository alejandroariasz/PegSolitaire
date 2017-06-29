package logic;

public class Tile {

	private Point point;
	private boolean hasPeg;
	
	public Tile(Point point, boolean hasPeg)
	{
		this.point = point;
		this.hasPeg = hasPeg;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public boolean hasPeg() {
		return hasPeg;
	}

	public void changePeg(boolean hasPeg) {
		this.hasPeg = hasPeg;
	}
	
	@Override
	public boolean equals(Object object)
	{
		if (object == null)
		    return false;

		if (this.getClass() != object.getClass())
		    return false;
		
		return point.equals(((Tile)object).point) && ((Tile)object).hasPeg == hasPeg;  
	}
	
}
