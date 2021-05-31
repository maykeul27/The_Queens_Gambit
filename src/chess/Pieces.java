package chess;


public abstract class Pieces {
	
	private String name;
	private String color;
	protected int x;
	protected int y;
	protected static final Board PLATEAU = new Board();
	
	public Pieces(int x, int y, String name, String color) {
		this.x = x;
		this.y = y;
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
	
	public boolean isValid(int x, int y, int toX, int toY){
        if(toX == x && toY == y)
            return false;
        if(toX > 7 || toY > 7 || toX < 0 || toY < 0)
            return false;
        return true;
        //Appartient-elle à un joueur
    }
}
