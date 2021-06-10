package chess; //We will use Case[x][y] for all the code even if we know that it is Case[y][x] in reality


public class Rook extends Piece { //Still need to Add Exception TRY CATCH everywhere + Need to transform toMove in a class for all pieces in Pieces Class


	public Rook(int x, int y, String color) {
		super(x, y, "Rook", color);
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
	}
	
public void toMove(int toX, int toY) {
		
		if (this.isValid(toX, toY) == "Can\'t")
		{
			System.out.println("Tu ne peux pas aller l�");
			
		}
		
		else if (this.isValid(toX,  toY) == "Clear")
		{
			int oldX = getX();
			int oldY = getY();
			PLATEAU.getCase(toX, toY).setPieceInPlace(this);
			PLATEAU.getCase(oldX, oldY).setPieceToNull();
			this.setX(toX);
			System.out.println("La coordonn�e Y de la pi�ce actuelle a �t� modifi� pour :"+ getX());
			this.setY(toY);
			System.out.println("La coordonn�e X de la pi�ce actuelle a �t� modifi� pour :"+ getY());
			
			System.out.println("La case o� se trouvait la pi�ce a bien �t� remise � pi�ce nulle. Pi�ce � la case d'avant = "+ PLATEAU.getCase(oldX, oldY).getPieceInPlace());
			System.out.println("La case o� se trouve actullement la pi�ce contient:" + PLATEAU.getCase(getX(), getY()).getPieceInPlace());
			
		}
		
		else if (this.isValid(toX,  toY) == "Eat")
		{
			int oldX = getX();
			int oldY = getY();
			PLATEAU.getCase(toX, toY).setPieceInPlace((PLATEAU.getCase(getX(), getY())).getPieceInPlace());
			System.out.println("La pi�ce s'est bien d�plac�e en: "+ getX() + ","+ getY()+ " (nouvelles coordonn�es de case destination).");
			PLATEAU.getCase(getX(), getY()).setPieceToNull();
			System.out.println("La case o� se trouvait la pi�ce � bien �t� remise � pi�ce nulle. Pi�ce � la case d'avant = "+ PLATEAU.getCase(oldX, oldY).getPieceInPlace());
			
		}
		
	System.out.println(PLATEAU.getCase(getX() +1, getY()).getPieceInPlace() );
	
	}
}
	


