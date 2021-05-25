package chess;

public class Grille {
	
	 private static int lignes = 8;
     private static int colonnes = 8;
     private Case [][] grille;


	 public Grille() {
		 
		 grille = new Case[lignes][colonnes];
		 
		 for(int i = 0; i < lignes; i++) 
		 {
			 for(int j = 0; j < colonnes; j++)
			 {
				 grille[i][j] = new Case();
			 }
		 }
	 }
	 
	 
	 public void placementPieces() {
		 
		 String couleur = "noir";
		 int lignePieces = 0;
		 int lignePion = 1; 
		 
		 for(int cptr = 0; cptr < 2; cptr ++) {
			 
			 if( couleur.equals("noir")) {
			 }
			 else {
				 lignePieces = lignePieces + 7;
				 lignePion = lignePion + 5;
			 }
			 grille[lignePieces][0].setPiece(new Rook(couleur));
			 grille[lignePieces][1].setPiece(new Knight(couleur));
			 grille[lignePieces][2].setPiece(new Bishop(couleur));
			 grille[lignePieces][3].setPiece(new Queen(couleur));
			 grille[lignePieces][4].setPiece(new King(couleur));
			 grille[lignePieces][5].setPiece(new Bishop(couleur));
			 grille[lignePieces][6].setPiece(new Knight(couleur));
			 grille[lignePieces][7].setPiece(new Rook(couleur));
			 	 
			 for(int a = 0; a < 7; a++) {
				 grille[lignePion][a].setPiece(new Pawn(couleur));
			 }
			 couleur = "blanc";
			 
		 }
			 
		 
		 
	 }

}
