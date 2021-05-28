package chess;

import chess.Board;


public class Rook extends Pieces {


	public Rook(int x, int y, String color) {
		super(x, y, "Rook", color);
		

	}
	
	public boolean deplacementTourValide(int x, int y) {
		
		if(this.x != x && this.y == y) {    //Deplacement Latéraux
			
			if(this.x > x) {           //Gauche vers la Droite
				
				for(int i = this.x + 1; i <= x; i++) {
					
					if(boardkkk.isEmpty(i, y)) {
						
						return true;
					}
					else {
						return false;
						
					}
				}
				
			}	
			
			if(this.x < x) {			//Droite vers la Gauche
				
				for(int i = this.x - 1; i <= x; i--) {
					
					if(board.isEmpty(i, y)) {
						
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
					
					if(board.isEmpty(x, i)) {
						
						return true;
					}
					else {
						return false;
						
					}
				}
				
			}	
			
			if(this.y < y) {		//Bas vers le Haut
				
				for(int i = this.y - 1; i <= y; i--) {
					
					if(board.isEmpty(x, i)) {
						
						return true;
					}
					else {
						return false;
						
					}
				}
				
			}			
			
			
		}
		
		
		
	}
		
		
		
}
	
	

	


