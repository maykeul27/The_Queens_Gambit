package chess; //We will use Case[x][y] for all the code even if we know that it is Case[y][x] in reality


public abstract class Piece { //Still need to Add Exception TRY CATCH everywhere + Need to transform toMove in a class for all pieces in Pieces Class
	
	private String name;
	private String color;
	private int x;
	private int y;
	protected static final Board PLATEAU = new Board();
	
	public Piece(int x, int y, String name, String color) {
		this.setX(x);
		this.setY(y);
		this.name = name;
		this.color = color;
	}
	
	public abstract boolean toMove(int x, int y);
	
	public String getname() {
		return name;
		
	}
	
	public String getColor() {
		return color;
		
	}
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	public boolean isValid(int x, int y, int toX, int toY){
        if(toX == x && toY == y)
            return false;
        if(toX > 7 || toY > 7 || toX < 0 || toY < 0)
            return false;
        return true;
        //Appartient-elle à un joueur
    }
}
