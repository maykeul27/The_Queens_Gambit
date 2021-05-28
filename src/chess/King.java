package chess;


public class King extends Pieces {
	
	boolean echec;

	
	public King(int x, int y, String color) {
		super(x, y, "King", color);
		echec = false;
		
	}
	
	public boolean isEchec() {
		return echec;
	}
	

	public boolean deplacementRoiValide(int x, int y) {
		
		if ((PLATEAU.isEmpty(this.x + 1, this.y)) || (PLATEAU.isEmpty(this.x - 1, this.y))) {     // Horizontal moves
			
			return true;
		}
				
		if((PLATEAU.isEmpty(this.x, this.y + 1)) || (PLATEAU.isEmpty(this.x, this.y - 1))) {	  // Vertical moves
			
			return true;			
		}
		
		if((PLATEAU.isEmpty(this.x+1, this.y+1)) || (PLATEAU.isEmpty(this.x+1, this.y-1)) || (PLATEAU.isEmpty(this.x-1, this.y+1)) || (PLATEAU.isEmpty(this.x-1, this.y-1))) {		// Diagonal moves
			
			return true;
		}
		
		return false;
		
		
		
	}

}
