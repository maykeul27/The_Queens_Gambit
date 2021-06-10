package chess; //We will use Case[x][y] for all the code even if we know that it is Case[y][x] in reality
import java.util.ArrayList;

//Still need to add comment on all methods for java doc + add TRY Catch everywhere

public class Knight extends Piece { 

	
	public Knight(int x, int y, String color) {
		super(x, y, "Knight", color);

	}
	
	public String isValid(int toX, int toY){ 
		
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		
		int x = this.getX();
		int y = this.getY();
		
		if(x == 0) {
			
			if(y == 0) {
				
				Piece nextPiece2 = (PLATEAU.getCase(x + 2, y + 1)).getPieceInPlace();
				Piece nextPiece0 = (PLATEAU.getCase(x + 1, y + 2)).getPieceInPlace();
				
				pieceList.add(nextPiece2);
				pieceList.add(nextPiece0);
			}
			else if(y == 1) {
				Piece nextPiece2 = (PLATEAU.getCase(x + 2, y + 1)).getPieceInPlace();
				Piece nextPiece0 = (PLATEAU.getCase(x + 1, y + 2)).getPieceInPlace();
				Piece nextPiece1 = (PLATEAU.getCase(x + 2, y - 1)).getPieceInPlace();
				
				pieceList.add(nextPiece2);
				pieceList.add(nextPiece0);
				pieceList.add(nextPiece1);				
			}
			else if(y == 7) {
				Piece nextPiece2 = (PLATEAU.getCase(x + 2, y - 1)).getPieceInPlace();
				Piece nextPiece0 = (PLATEAU.getCase(x + 1, y - 2)).getPieceInPlace();
				
				pieceList.add(nextPiece2);
				pieceList.add(nextPiece0);			
			}
			else if(y == 6) {
				Piece nextPiece2 = (PLATEAU.getCase(x + 2, y - 1)).getPieceInPlace();
				Piece nextPiece0 = (PLATEAU.getCase(x + 1, y - 2)).getPieceInPlace();
				Piece nextPiece1 = (PLATEAU.getCase(x + 2, y + 1)).getPieceInPlace();
				
				pieceList.add(nextPiece2);
				pieceList.add(nextPiece0);
				pieceList.add(nextPiece1);	
			}
			else {
				Piece nextPiece2 = (PLATEAU.getCase(x + 2, y + 1)).getPieceInPlace();
				Piece nextPiece0 = (PLATEAU.getCase(x + 1, y + 2)).getPieceInPlace();
				Piece nextPiece1 = (PLATEAU.getCase(x + 2, y - 1)).getPieceInPlace();
				Piece nextPiece3 = (PLATEAU.getCase(x + 1, y - 2)).getPieceInPlace();
				
				
				pieceList.add(nextPiece2);
				pieceList.add(nextPiece0);
				pieceList.add(nextPiece1);
				pieceList.add(nextPiece3);
			}
			
		}
		
		else if(x == 7) {
			
			if(y == 0) {
				
				Piece nextPiece2 = (PLATEAU.getCase(x - 2, y + 1)).getPieceInPlace();
				Piece nextPiece0 = (PLATEAU.getCase(x - 1, y + 2)).getPieceInPlace();
				
				pieceList.add(nextPiece2);
				pieceList.add(nextPiece0);
			}
			else if(y == 1) {
				Piece nextPiece2 = (PLATEAU.getCase(x - 2, y + 1)).getPieceInPlace();
				Piece nextPiece0 = (PLATEAU.getCase(x - 1, y + 2)).getPieceInPlace();
				Piece nextPiece1 = (PLATEAU.getCase(x - 2, y - 1)).getPieceInPlace();
				
				pieceList.add(nextPiece2);
				pieceList.add(nextPiece0);
				pieceList.add(nextPiece1);				
			}
			else if(y == 7) {
				Piece nextPiece2 = (PLATEAU.getCase(x - 2, y - 1)).getPieceInPlace();
				Piece nextPiece0 = (PLATEAU.getCase(x - 1, y - 2)).getPieceInPlace();
				
				pieceList.add(nextPiece2);
				pieceList.add(nextPiece0);			
			}
			else if(y == 6) {
				Piece nextPiece2 = (PLATEAU.getCase(x - 2, y - 1)).getPieceInPlace();
				Piece nextPiece0 = (PLATEAU.getCase(x - 1, y - 2)).getPieceInPlace();
				Piece nextPiece1 = (PLATEAU.getCase(x - 2, y + 1)).getPieceInPlace();
				
				pieceList.add(nextPiece2);
				pieceList.add(nextPiece0);
				pieceList.add(nextPiece1);	
			}
			else {
				Piece nextPiece2 = (PLATEAU.getCase(x - 2, y + 1)).getPieceInPlace();
				Piece nextPiece0 = (PLATEAU.getCase(x - 1, y + 2)).getPieceInPlace();
				Piece nextPiece1 = (PLATEAU.getCase(x - 2, y - 1)).getPieceInPlace();
				Piece nextPiece3 = (PLATEAU.getCase(x - 1, y - 2)).getPieceInPlace();
				
				
				pieceList.add(nextPiece2);
				pieceList.add(nextPiece0);
				pieceList.add(nextPiece1);
				pieceList.add(nextPiece3);
			}
			
		}
		
		
		String res;
		
		if  (super.isValid(toX, toY) == "Can\'t")
		{
			res = "Can\'t";
			return res;
		}
		
		else
		{
			for(int i = 0 ; i < pieceList.size(); i++) {
				
					if (pieceList.get(i) != null)
					{
						if (pieceList.get(i).getColor() == this.getColor())
						{
							res= "Can\'t";
							return res;
						}
						res= "Eat";
						return res;
					}
					else {
					res = "Clear";
					return res;
					}
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
