package chess;

public class Case {
	
	private Pieces pieceInPlace;
	private String color;
	
	public Case(String color) {
		this.color = color;
		
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
	
	public boolean isOccupied() {
		if (pieceInPlace == null)
			return false;
		else
			return true;
	}
	
}