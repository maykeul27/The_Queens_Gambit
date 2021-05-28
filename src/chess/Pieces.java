package chess;


public class Pieces {
	
	private String name;
	private String color;
	protected int x;
	protected int y;
	
	public Pieces(int x, int y, String name, String color) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.color = color;
	}
	
	public String getname() {
		return name;
		
	}
	
	public String getColor() {
		return color;
		
	}
	
	public void setname(String name) {
		this.name = name;
		
	}
	
	public void setColor(String color) {
		this.color = color;
	}

}
