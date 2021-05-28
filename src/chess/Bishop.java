package chess;

import chess.Board;
import chess.Case;

public class Bishop extends Pieces {


	public Bishop(int x, int y, String color) {
		super(x, y, "Bishop", color);
	}

	
	public boolean isValid(int x, int y, int toX, int toY){
		
		int lineDiff= toX - x;
		int columnDiff= toY - y;
		int unitylineDiff= lineDiff/Math.abs(lineDiff);
		int unitycolumnDiff= columnDiff/Math.abs(columnDiff);
		
		 
		if  (!super.isValid(x, y, toX, toY))
		{
			return false;
		}
		
		while ((lineDiff > 0) && (columnDiff > 0))
		{
			if (Piece.Case.Board[x+(lineDiff/Math.abs(lineDiff))][y+(columnDiff/Math.abs(columnDiff))] != null) //Reste à coder la méthode qui retourne la valeur de l'attribut Piece de l'objet Case dans le tableau Board
				{
					if (Piece.Case.Board[x+(lineDiff/Math.abs(lineDiff))][y+(columnDiff/Math.abs(columnDiff))].getColor() == this.getColor()) //Reste à coder la méthode qui retourne la valeur de l'attribut Piece de l'objet Case dans le tableau Board
					{
						return false;
					}
					return true;
				}
			lineDiff= lineDiff - unitylineDiff;
			columnDiff= columnDiff - unitycolumnDiff;
						
		}
	}
}
