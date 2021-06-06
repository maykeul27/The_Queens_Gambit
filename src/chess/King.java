package chess; //We will use Case[x][y] for all the code even if we know that it is Case[y][x] in reality


public class King extends Piece { //Still need to Add Exception TRY CATCH everywhere + Need to transform toMove in a class for all pieces in Pieces Class
	
	boolean echec;

	
	public King(int x, int y, String color) {
		super(x, y, "King", color);
		echec = false;
		
	}
	
	public boolean isEchec() {
		return echec;
	}
	
	public void setEchec(boolean life) {
		this.echec = life;
	}
	
	public String isValid(int toX, int toY) {
		
		String res;
		int lineDiff= toX - getX();
		int columnDiff= toY - getY();
		
		if  (!super.isValid(getX(), getY(), toX, toY))
		{
			res = "Can\'t";
			return res;
		}
		
		else if ((Math.abs(lineDiff) != 1 ) || (Math.abs(columnDiff) != 1 ))
		{
			res = "Can\'t";
			return res;
		}
		
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