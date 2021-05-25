/**
 * 
 */
package chess;

/**
 * @author Mika
 *
 */
public abstract class Pieces {
	
	private String nom;
	private String couleur;
	
	public Pieces(String nom, String couleur) {
		this.nom = nom;
		this.couleur = couleur;
	}
	
	public String getNom() {
		return nom;
		
	}
	
	public String getColor() {
		return couleur;
		
	}
	
	public void setNom(String nom) {
		this.nom = nom;
		
	}
	
	public void setColor(String couleur) {
		this.couleur = couleur;
	}

}
