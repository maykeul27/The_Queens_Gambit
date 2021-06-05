package chess;
import java.util.ArrayList;

public class Knight extends Piece {

	
	public Knight(int x, int y, String color) {
		super(x, y, "Knight", color);

	}

	
	public String isValid(int toX, int toY){ 
		
		
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		Piece nextPiece0 = (PLATEAU.getCase(getX() + 1, getY() + 2)).getPieceInPlace();
		Piece nextPiece1 = (PLATEAU.getCase(getX() + 1, getY() - 2)).getPieceInPlace();
		Piece nextPiece2 = (PLATEAU.getCase(getX() + 2, getY() + 1)).getPieceInPlace();
		Piece nextPiece3 = (PLATEAU.getCase(getX() + 2, getY() - 1)).getPieceInPlace();
		Piece nextPiece4 = (PLATEAU.getCase(getX() - 1, getY() + 2)).getPieceInPlace();
		Piece nextPiece5 = (PLATEAU.getCase(getX() - 1, getY() - 2 )).getPieceInPlace();
		Piece nextPiece6 = (PLATEAU.getCase(getX() - 2, getY() - 1)).getPieceInPlace();
		Piece nextPiece7 = (PLATEAU.getCase(getX() - 2, getY() + 1)).getPieceInPlace();
		
		pieceList.add(nextPiece0);
		pieceList.add(nextPiece1);
		pieceList.add(nextPiece2);
		pieceList.add(nextPiece3);
		pieceList.add(nextPiece4);
		pieceList.add(nextPiece5);
		pieceList.add(nextPiece6);
		pieceList.add(nextPiece7);
		String res;
		 
		if  (!super.isValid(getX(), getY(), toX, toY))
		{
			res = "Can\'t";
			return res;
		}
		
		for(int i = 0 ; i < pieceList.size(); i++) {
			
			if ((pieceList.get(i).getX() == toX) && (pieceList.get(i).getY() == toY)) {
				
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
		}
		
		res = "Can\'t";
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
