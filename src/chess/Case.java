package chess;

public class Case {
	
	private Pieces piece;
	
	public Case() {

    }
	
	public Case(Pieces piece) {
		this.piece = piece;

	}
	
	public Pieces getPiece() {
		return piece;
		
	}
	
	public void setPiece(Pieces piece) {
		this.piece = piece;
	}
	
	public boolean isOccupied(String color) {
		if (piece == null)
			return false;
		else
			return (piece.getColor().equals(color));
	}
	
}