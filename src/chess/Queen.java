package chess; //We will use Case[x][y] for all the code even if we know that it is Case[y][x] in reality

//Still need to add comment on all methods for java doc + add TRY Catch everywhere

public class Queen extends Piece { 


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
	
	public boolean toMove(int toX, int toY) {
		
		if (this.isValid(toX, toY) == "Can\'t")
		{
			return false;
		}
		
		else if (this.isValid(toX,  toY) == "Clear")
		{
			int oldX = getX();
			int oldY = getY();
			PLATEAU.getCase(toX, toY).setPieceInPlace(this);
			this.setX(toX);
			this.setY(toY);
			PLATEAU.getCase(oldX, oldY).setPieceToNull();
			return true;
		}
		
		else if (this.isValid(toX,  toY) == "Eat")
		{
			PLATEAU.getCase(toX, toY).setPieceInPlace((PLATEAU.getCase(getX(), getY())).getPieceInPlace());
			PLATEAU.getCase(getX(), getY()).setPieceToNull();
			return true;
		}
		return false;
	}
}
