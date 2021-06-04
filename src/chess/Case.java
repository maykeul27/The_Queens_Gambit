package chess;

public class Case {
	
	private Pieces pieceInPlace;
	private String color;
	
	public Case(String color) {
		this.setColor(color);
		
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