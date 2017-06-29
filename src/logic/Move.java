package logic;

public class Move {
	
	private int pegIndex;
	private int moveIndex;
	private int pegToRemoveIndex;
	
	public Move(int peg, int move, int pegToRemove)
	{
		this.pegIndex = peg;
		this.moveIndex = move;
		this.pegToRemoveIndex = pegToRemove;
	}

	public int getMove() {
		return moveIndex;
	}

	public void setMove(int move) {
		this.moveIndex = move;
	}

	public int getPeg() {
		return pegIndex;
	}

	public void setPeg(int peg) {
		this.pegIndex = peg;
	}

	public int getPegToRemove() {
		return pegToRemoveIndex;
	}

	public void setPegToRemove(int pegToRemoveIndex) {
		this.pegToRemoveIndex = pegToRemoveIndex;
	}

}
