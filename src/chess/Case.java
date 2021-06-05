package chess;

public class Case {
	
	private Piece pieceInPlace;
	private String color;
	
	public Case(String color) {
		this.setColor(color);
		
    }
	
	public Piece getPieceInPlace() {
		return pieceInPlace;
		
	}
	
	public void setPieceInPlace(Piece pieceToPlace) {
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

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
}