package chess;

public class Bishop extends Pieces {


	public Bishop(int x, int y, String color) {
		super(x, y, "Bishop", color);
	}
	
	public boolean isValid(int x, int y, int toX, int toY){ //Voir si possible de tester directement la couleur au lieu des 2 tests via try catch
		
		int lineDiff= toX - x;
		int columnDiff= toY - y;
		int unityLineDiff= lineDiff/Math.abs(lineDiff);
		int unityColumnDiff= columnDiff/Math.abs(columnDiff);
		Pieces piece = (PLATEAU.getCase(x + unityLineDiff, y + unityColumnDiff)).getPieceInPlace();
		
		 
		if  (!super.isValid(x, y, toX, toY))
		{
			return false;
		}
		
		while ((lineDiff > 0) && (columnDiff > 0))
		{
			if (piece != null)
				{
					if (piece.getColor() == this.getColor())
					{
						return false;
					}
					return true;
				}
			lineDiff= lineDiff - unityLineDiff;
			columnDiff= columnDiff - unityColumnDiff;
						
		}
		return false;
	}

	@Override
	public boolean toMove(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}
