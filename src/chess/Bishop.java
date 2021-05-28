package chess;

import chess.Board;

public class Bishop extends Pieces {


	public Bishop(int x, int y, String color) {
		super(x, y, "Bishop", color);
	}

	
	public boolean bishopIsValidated(int x, int y) {
		
		for(int i = 1; i < 8; i++) {
			    if((this.x + i == x) && (this.y + i == y )){
			    	return true;
				}
				if((this.x - i == x) && (this.y - i == y )){
					return true;
				}
				if((this.x + i == x) && (this.y - i == y )){
					return true;
				}
				if((this.x - i == x) && (this.y + i == y )){
					return true;
				}
			}

			return false;
	}
		

}
