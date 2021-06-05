package chess;

public class Bishop extends Piece {


	public Bishop(int x, int y, String color) {
		super(x, y, "Bishop", color);
	}
	
	public String isValid(int toX, int toY){ //Voir si possible de tester directement la couleur au lieu des 2 tests via try catch
		
		int lineDiff= toX - getX();
		int columnDiff= toY - getY();
		int unityLineDiff= lineDiff/Math.abs(lineDiff);
		int unityColumnDiff= columnDiff/Math.abs(columnDiff);
		Piece nextPiece = (PLATEAU.getCase(getX() + unityLineDiff, getY() + unityColumnDiff)).getPieceInPlace();
		String res;
		 
		if  (!super.isValid(getX(), getY(), toX, toY))
		{
			res = "Can\'t";
			return res;
		}
		
		while ((lineDiff > 0) && (columnDiff > 0))
		{
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
