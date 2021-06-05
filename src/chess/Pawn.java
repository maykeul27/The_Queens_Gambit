package chess;

public class Pawn extends Piece { //Still need to Add Exception TRY CATCH everywhere + Need to transform toMove in a class for all pieces in Pieces Class
	
	private boolean firstAttempt = true;

	public Pawn(int x, int y, String color) {
		super(x, y, "Pawn", color);

	}
	
	public boolean isFirstAttempt(){
    	return this.firstAttempt;
    }
	
	public void setPremierCoup(boolean b){
    	this.firstAttempt = b;
    }
	
	 public void isPromotion(){
	    	if(this.getColor().equals("black") && this.getY() == 7){
	    		
	    		new Queen(this.getY(), 7, "black");
	    	}
	    	if(this.getColor().equals("white") && this.getY() == 0){
	    		
	    		new Queen(this.getY(), 0, "white");
	    	}
	    }
	
	public String isValid(int toX, int toY) {
		
		int lineDiff= toX - getX();
		int columnDiff= toY - getY();
		int unityLineDiff= lineDiff/Math.abs(lineDiff);
		int unityColumnDiff= columnDiff/Math.abs(columnDiff);
		String res;
		Piece nextPiece = (PLATEAU.getCase(getX() + unityLineDiff, getY())).getPieceInPlace();
		Piece nextDiagonalPiece = (PLATEAU.getCase(getX() + unityLineDiff, getY() + unityColumnDiff)).getPieceInPlace();
		
		if  (!super.isValid(getX(), getY(), toX, toY))
		{
			res = "Can\'t";
			return res;
		}
		
		if(toY == nextPiece.getY() && toX == nextPiece.getX()) {
			if (nextPiece != null)
			{
					res= "Can\'t";
					return res;
			}
		}
		
		else if(toY == nextDiagonalPiece.getY() && toX == nextDiagonalPiece.getX()) {
			
			if (nextDiagonalPiece != null) {
				
				if (nextDiagonalPiece.getColor() == this.getColor())
				{
					res= "Can\'t";
					return res;
				}
				res= "Eat";
				return res;
			}
			
		}
		
		res = "Can\'t";
		return res;
	
	}


	public boolean toMove(int toX, int toY) {
		
		if (this.isValid(toX, toY) == "Can\'t")
		{
			return false;
		}
		
		else if (this.isValid(toX,  toY) == "Clear")
		{
			this.setX(toX);
			this.setY(toY);
			return true;
		}
		
		else if (this.isValid(toX,  toY) == "Eat")
		{
			//Method Eat to Do, ref Player "Killed Pieces"
			return true;
		}
		return false;
	}
}
