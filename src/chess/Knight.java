package chess;

public class Knight extends Piece {

	
	public Knight(int x, int y, String color) {
		super(x, y, "Knight", color);

	}

	
	public boolean deplacementCavalierValide(int x, int y) {
			
			if(PLATEAU.isEmpty(this.getX() - 2, this.getY() - 1))
			{
			
			}
		return true;
		
		
	}


	@Override
	public boolean toMove(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
