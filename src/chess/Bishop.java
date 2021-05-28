package chess;

import chess.Board;

public class Bishop extends Pieces {


	public Bishop(int x, int y, String color) {
		super(x, y, "Bishop", color);
	}

	
	public boolean deplacementFouValide(int x, int y) {
		
		for(int i = 0; i < 8; i++) {
			    if(PLATEAU.isEmpty(this.x + i, this.y + i)){
			    	return true;
				}
				if(PLATEAU.isEmpty(this.x -i, this.y - i)){
					return true;
				}
				if(PLATEAU.isEmpty(this.x +i, this.y - i )){
					return true;
				}
				if(PLATEAU.isEmpty(this.x -i, this.y + i)){
					return true;
				}
			}

			return false;
	}
		

}
