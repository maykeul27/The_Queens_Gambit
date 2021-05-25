package chess;


public class Board {
	
	 private static int lines = 8;
    private static int columns = 8;
    private Case [][] board;


	 public Board() {
		 
		 board = new Case[lines][columns];
		 
		 for(int i = 0; i < lines; i++) 
		 {
			 for(int j = 0; j < columns; j++)
			 {
				 board[i][j] = new Case();
			 }
		 }
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
			 board[linePieces][0].setPiece(new Rook(color));
			 board[linePieces][1].setPiece(new Knight(color));
			 board[linePieces][2].setPiece(new Bishop(color));
			 board[linePieces][3].setPiece(new Queen(color));
			 board[linePieces][4].setPiece(new King(color));
			 board[linePieces][5].setPiece(new Bishop(color));
			 board[linePieces][6].setPiece(new Knight(color));
			 board[linePieces][7].setPiece(new Rook(color));
			 	 
			 for(int a = 0; a < 7; a++) {
				 board[linePawn][a].setPiece(new Pawn(color));
			 }
			 color = "white";
			 
		 }
		 
	 }

}