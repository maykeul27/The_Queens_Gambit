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
	
	public boolean estOccupe() {
		return (piece != null);
	}
	
}
