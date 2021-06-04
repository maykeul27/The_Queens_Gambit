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
	

	public boolean isValid(int x, int y, int toX, int toY){
		
		if  (!super.isValid(x, y, toX, toY))
		{
			return false;
		}
		
		else if ((Math.abs(x-toX) != 1 ) || (Math.abs(y-toY) != 1 ))
		{
			return false;
		}
		
		return true;
	}

	@Override
	public boolean toMove(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
		
		
		
		
		
		
		
		
		
		/*else if ((PLATEAU.isEmpty(this.x + 1, this.y)) || (PLATEAU.isEmpty(this.x - 1, this.y))) {     // Horizontal moves
			
			return true;
		}
				
		if((PLATEAU.isEmpty(this.x, this.y + 1)) || (PLATEAU.isEmpty(this.x, this.y - 1))) {	  // Vertical moves
			
			return true;			
		}
		
		if((PLATEAU.isEmpty(this.x+1, this.y+1)) || (PLATEAU.isEmpty(this.x+1, this.y-1)) || (PLATEAU.isEmpty(this.x-1, this.y+1)) || (PLATEAU.isEmpty(this.x-1, this.y-1))) {		// Diagonal moves
			
			return true;
		}
		
		return false;*/
		
		
		
	}