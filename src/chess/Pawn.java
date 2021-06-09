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
		
		String res;
		
		if  (super.isValid(toX, toY) == "Can\'t")
		{
			res = "Can\'t";
			return res;
		}
		
		else
		{
			int lineDiff= toX - getX();
			int columnDiff= toY - getY();
			int unityLineDiff = lineDiff/Math.abs(lineDiff);
			int unityColumnDiff; 
			
			if (columnDiff == 0) {
				
				unityColumnDiff = 0;
				
				if ((lineDiff == 1 || lineDiff == -1)) 
				{
					
					Piece nextPiece = (PLATEAU.getCase(getX() + unityLineDiff, getY())).getPieceInPlace();
					if (nextPiece != null)
					{
							res= "Can\'t";
							return res;
					}
					
					firstAttempt = false; // need to put it in toMove because if move is not valid, firstAttempt still = false
					res = "Clear";
					return res;
					
				}
				
				else if(firstAttempt == true && (lineDiff == 2 || lineDiff == -2)) 
				{
					
					while(lineDiff != 0) {
						
						Piece nextPiece = (PLATEAU.getCase(getX() + unityLineDiff, getY())).getPieceInPlace();
						if (nextPiece != null)
						{
								res= "Can\'t";
								return res;
						}
						
						lineDiff= lineDiff - unityLineDiff;
					}
					
					firstAttempt = false; // need to put it in toMove because if move is not valid, firstAttempt still = false
					res = "Clear";
					return res;
					
				}
				
				else 
				{
					
					res = "Can\'t";
					return res;
				}
				
			}
				
			else{
				
				unityColumnDiff = columnDiff/Math.abs(columnDiff);
				Piece nextPiece = (PLATEAU.getCase(getX() + unityLineDiff, getY() + unityColumnDiff)).getPieceInPlace();
				if (nextPiece != null)
				{
					if (nextPiece.getColor() == this.getColor())
					{
						res= "Can\'t";
						return res;
					}
					res= "Eat";
					return res;
				}
				res= "Can\'t";
				return res;
			}
		}
	}
}
