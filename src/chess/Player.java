package chess;


public class Player {

    private String name;
    private Piece[] killedPieces;
    
	public Player() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the killedPieces
	 */
	public Piece[] getKilledPieces() {
		return killedPieces;
	}

	/**
	 * @param killedPieces the killedPieces to set
	 */
	public void setKilledPieces(Piece[] killedPieces) {
		this.killedPieces = killedPieces;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
