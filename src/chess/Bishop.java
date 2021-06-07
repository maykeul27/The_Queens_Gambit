package chess; //We will use Case[x][y] for all the code even if we know that it is Case[y][x] in reality

public class Bishop extends Piece { //Still need to Add Exception TRY CATCH everywhere + Need to transform toMove in a class for all pieces in Pieces Class


	public Bishop(int x, int y, String color) {
		super(x, y, "Bishop", color);
	}
	
	public String isValid(int toX, int toY){ //Voir si possible de tester directement la couleur au lieu des 2 tests via try catch
		
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
			int unityLineDiff= lineDiff/Math.abs(lineDiff);
			int unityColumnDiff= columnDiff/Math.abs(columnDiff);
			
			while((lineDiff != 0) && (columnDiff != 0)) 
			{
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

}
