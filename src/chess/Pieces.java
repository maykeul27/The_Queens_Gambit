package chess;


public class Pieces {
	
	private String name;
	private String color;
	
	public Pieces(String name, String color) {
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
