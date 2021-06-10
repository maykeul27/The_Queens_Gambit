package chess; //We will use Case[x][y] for all the code even if we know that it is Case[y][x] in reality

//Still need to add comment on all methods for java doc + add TRY Catch everywhere

public class Case { 
	
	private Piece pieceInPlace;
	private String color;
	
	public Case(String color) {
		this.setColor(color);
		setPieceToNull();
    }
	
	public Piece getPieceInPlace() {
		return pieceInPlace;
		
	}
	
	
	public void setPieceInPlace(Piece pieceToPlace) {
		this.pieceInPlace = pieceToPlace;
	}
	
	public void setPieceToNull()
	{
		pieceInPlace = null;
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