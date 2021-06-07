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
		int unityLineDiff;
		int unityColumnDiff; 
		String res;
		
		
		if  (!super.isValid(getX(), getY(), toX, toY))
		{
			res = "Can\'t";
			return res;
		}
		
		if (columnDiff == 0) {
			
			unityLineDiff = lineDiff/Math.abs(lineDiff);
			unityColumnDiff = 0;
			
			if ((lineDiff == 1 || lineDiff == -1)) {
				
				Piece nextPiece = (PLATEAU.getCase(getX() + unityLineDiff, getY() + unityColumnDiff)).getPieceInPlace();
				if (nextPiece != null)
				{
						res= "Can\'t";
						return res;
				}
				
				firstAttempt = false;
				res = "Clear";
				return res;
				
			}
			
			else if(firstAttempt == true && (lineDiff == 2 || lineDiff == -2)) {
				
				while((lineDiff != 0) && (columnDiff != 0)) {
					
					Piece nextPiece = (PLATEAU.getCase(getX() + unityLineDiff, getY() + unityColumnDiff)).getPieceInPlace();
					if (nextPiece != null)
					{
							res= "Can\'t";
							return res;
					}
					
					lineDiff= lineDiff - unityLineDiff;
					columnDiff= columnDiff - unityColumnDiff;
					
				}
				
				firstAttempt = false;
				res = "Clear";
				return res;
				
				
			}
			
			else {
				
				res = "Can\'t";
				return res;
			}
			
			
		}
			
		else{
			
			unityColumnDiff = columnDiff/Math.abs(columnDiff);
			unityLineDiff = lineDiff/Math.abs(lineDiff);
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
			
			res = "Can\'t";
			return res;
			
		}
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
