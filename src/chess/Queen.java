package chess; //We will use Case[x][y] for all the code even if we know that it is Case[y][x] in reality


public class Queen extends Piece { //Still need to Add Exception TRY CATCH everywhere + Need to transform toMove in a class for all pieces in Pieces Class


	public Queen(int x, int y, String color) {
		super(x, y, "Queen", color);
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
	}
	
	public void toMove(int toX, int toY) {
		
		if (this.isValid(toX, toY) == "Can\'t")
		{
			
		}
		
		else if (this.isValid(toX,  toY) == "Clear")
		{
			this.setX(toX);
			this.setY(toY);
			
		}
		
		else if (this.isValid(toX,  toY) == "Eat")
		{
			PLATEAU.getCase(getX(), getY()).setPieceToNull();
			PLATEAU.getCase(toX, toY).setPieceInPlace(this);
			
		}
	
	}
}
