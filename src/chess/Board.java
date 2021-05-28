package chess;


public class Board {
	
	private static int lines = 8;
    private static int columns = 8;
    private Case[][] board;


	 public Board() {
		 
		 board = new Case[lines][columns];
		 
		 for(int i = 0; i < lines; i++) 
		 {
			 for(int j = 0; j < columns; j++)
			 {
				 board[i][j] = new Case();
			 }
		 }
		 
		 this.piecesPlacement();
	 }
	 
	 
	 public void piecesPlacement() {
		 
		 String color = "black";
		 int linePieces = 0;
		 int linePawn = 1; 
		 
		 for(int cptr = 0; cptr < 2; cptr ++) {
			 
			 if( color.equals("black")) {
			 }
			 else {
				 linePieces = linePieces + 7;
				 linePawn = linePawn + 5;
			 }
			 board[linePieces][0].setPiece(new Rook(linePieces, 0,color));
			 board[linePieces][1].setPiece(new Knight(linePieces, 1, color));
			 board[linePieces][2].setPiece(new Bishop(linePieces, 2, color));
			 board[linePieces][3].setPiece(new Queen(linePieces, 3, color));
			 board[linePieces][4].setPiece(new King(linePieces, 4, color));
			 board[linePieces][5].setPiece(new Bishop(linePieces, 5, color));
			 board[linePieces][6].setPiece(new Knight(linePieces, 6, color));
			 board[linePieces][7].setPiece(new Rook(linePieces, 7, color));
			 	 
			 for(int a = 0; a < 7; a++) {
				 board[linePawn][a].setPiece(new Pawn(linePawn, a, color));
			 }
			 color = "white";
			 
		 }
		 
	 }
	 
	 public boolean isEmpty(int x, int y) {
		 
		 
		 if(x > 7 || y > 7 || x < 0 || y < 0) {
			 
			 return false;
		 }
		 else {
			 
		 
			 if(board[x][y] == null) {
				 return true;
			 }
			 else {
				 return false;
			 }
		 
		 
		 }
		 
	 }

}
