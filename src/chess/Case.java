package chess;

public class Case {
	
	private Pieces pieceInPlace;
	
	public Case() {

    }
	
	public Case(Pieces piece) {
		pieceInPlace = piece;

	}
	
	public Pieces getPieceInPlace() {
		return pieceInPlace;
		
	}
	
	public void setPieceInPlace(Pieces pieceToPlace) {
		pieceInPlace = pieceToPlace;
		return; 
	}
	
	public void setPieceToNull()
	{
		pieceInPlace = null;
	}
	
	public boolean isOccupied(int x, int y) {
		if (pieceInPlace == null)
			return false;
		else
			return (pieceInPlace.getColor().equals(color)); //???
	}
	
}