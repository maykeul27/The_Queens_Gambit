package chess;


public class Queen extends Piece { //Still need to Add Exception TRY CATCH everywhere + Need to transform toMove in a class for all pieces in Pieces Class


	public Queen(int x, int y, String color) {
		super(x, y, "Queen", color);

	}

	public String isValid(int toX, int toY) {
		
		int lineDiff= toX - getX();
		int columnDiff= toY - getY();
		int unityLineDiff;
		int unityColumnDiff; 
		if (lineDiff == 0) {
			
			unityColumnDiff = columnDiff/Math.abs(columnDiff);
			unityLineDiff = 0; 
		}
		else if(columnDiff == 0) {
			
			unityColumnDiff = 0; 
			unityLineDiff = lineDiff/Math.abs(lineDiff);
		}
		else {
			unityLineDiff= lineDiff/Math.abs(lineDiff);
			unityColumnDiff= columnDiff/Math.abs(columnDiff);
		}
		
		String res;
		
		if  (!super.isValid(getX(), getY(), toX, toY))
		{
			res = "Can\'t";
			return res;
		}
		
		while((lineDiff != 0) && (columnDiff != 0)) {
			
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
			lineDiff= lineDiff - unityLineDiff;
			columnDiff= columnDiff - unityColumnDiff;
			
		}
		
		res = "Clear";
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
