package chess;


public class Rook extends Piece {


	public Rook(int x, int y, String color) {
		super(x, y, "Rook", color);
		

	}
	
	public boolean deplacementTourValide(int x, int y) {
		
		if (this.getX() != x && this.getY() == y) {    //Deplacement Latéraux
			
			if(this.getX() > x) {           //Gauche vers la Droite
				
				for(int i = this.getX() + 1; i <= x; i++) {
					
					if(PLATEAU.isEmpty(i, y)) {
						
						return true;
					}
					else {
						return false;
						
					}
				}
				
			}	
			
			if(this.getX() < x) {			//Droite vers la Gauche
				
				for(int i = this.getX() - 1; i >= x; i--) {
					
					if(PLATEAU.isEmpty(i, y)) {
						
						return true;
					}
					else {
						return false;
						
					}
				}
				
			}			
			
			
		}
		
		if(this.getX() == x && this.getY() != y) {  	//Deplacements verticaux
			
			if(this.getY() > y) {			//Haut vers le Bas
				
				for(int i = this.getY() + 1; i <= y; i++) {
					
					if(PLATEAU.isEmpty(x, i)) {
						
						return true;
					}
					else {
						return false;
						
					}
				}
				
			}	
			
			if(this.getY() < y) {		//Bas vers le Haut
				
				for(int i = this.getY() - 1; i >= y; i--) {
					
					if(PLATEAU.isEmpty(x, i)) {
						
						return true;
					}
					else {
						return false;
						
					}
				}
				
			}			
			
			
		}
		
		if( this.getX() == x && this.getY() == y) {
			
			return false;
			
		}
		
		
		return false;
		
	}

	@Override
	public boolean toMove(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
		
		
		
}
	
	

	


