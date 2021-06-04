package chess;


public class Rook extends Pieces {


	public Rook(int x, int y, String color) {
		super(x, y, "Rook", color);
		

	}
	
	public boolean deplacementTourValide(int x, int y) {
		
		if (this.x != x && this.y == y) {    //Deplacement Lat�raux
			
			if(this.x > x) {           //Gauche vers la Droite
				
				for(int i = this.x + 1; i <= x; i++) {
					
					if(PLATEAU.isEmpty(i, y)) {
						
						return true;
					}
					else {
						return false;
						
					}
				}
				
			}	
			
			if(this.x < x) {			//Droite vers la Gauche
				
				for(int i = this.x - 1; i >= x; i--) {
					
					if(PLATEAU.isEmpty(i, y)) {
						
						return true;
					}
					else {
						return false;
						
					}
				}
				
			}			
			
			
		}
		
		if(this.x == x && this.y != y) {  	//Deplacements verticaux
			
			if(this.y > y) {			//Haut vers le Bas
				
				for(int i = this.y + 1; i <= y; i++) {
					
					if(PLATEAU.isEmpty(x, i)) {
						
						return true;
					}
					else {
						return false;
						
					}
				}
				
			}	
			
			if(this.y < y) {		//Bas vers le Haut
				
				for(int i = this.y - 1; i >= y; i--) {
					
					if(PLATEAU.isEmpty(x, i)) {
						
						return true;
					}
					else {
						return false;
						
					}
				}
				
			}			
			
			
		}
		
		if( this.x == x && this.y == y) {
			
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
	
	

	


