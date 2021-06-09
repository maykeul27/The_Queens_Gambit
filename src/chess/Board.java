package chess; //We will use Case[x][y] for all the code even if we know that it is Case[y][x] in reality


public class Board { //Still need to Add Exception TRY CATCH everywhere
	
	private static int lines = 8;
    private static int columns = 8;
    private Case[][] board;


	 public Board() {
		 
		 board = new Case[lines][columns];
		 
		 for(int i = 0; i < lines; i++) 
		 {
			 for(int j = 0; j < columns; j++)
			 {
				 if ((i+j)%2 == 0)
				 {
					 board[i][j] = new Case("black"); //Too use Later IHM?
				 } else
				 {
					 board[i][j] = new Case("white"); //Too use Later IHM?
				 }
			 }
		 }
		 
		 this.piecesPlacement();
	 }

	 public Case getCase(int x, int y)
	 {
		 Case res = board[x][y];
		 
		 return res;
	 } //Still need to Add Exception TRY CATCH
	 
	 public void piecesPlacement() {
		 
		 String color = "black";
		 int linePieces = 0;
		 int linePawn = 1; 
		 
		 for(int cptr = 0; cptr < 2; cptr ++) {
			 
			 if( color.equals("black")) {
			 }
			 else {
				 linePieces = 7;
				 linePawn = 6;
			 }
			 board[linePieces][0].setPieceInPlace(new Rook(linePieces, 0,color));
			 board[linePieces][1].setPieceInPlace(new Knight(linePieces, 1, color));
			 board[linePieces][2].setPieceInPlace(new Bishop(linePieces, 2, color));
			 board[linePieces][3].setPieceInPlace(new Queen(linePieces, 3, color));
			 board[linePieces][4].setPieceInPlace(new King(linePieces, 4, color));
			 board[linePieces][5].setPieceInPlace(new Bishop(linePieces, 5, color));
			 board[linePieces][6].setPieceInPlace(new Knight(linePieces, 6, color));
			 board[linePieces][7].setPieceInPlace(new Rook(linePieces, 7, color));
			 	 
			 for(int a = 0; a <= 7; a++) {
				 board[linePawn][a].setPieceInPlace(new Pawn(linePawn, a, color));
			 }
			 color = "white";
			 
		 }
		 
	 }
	 
	 

}
