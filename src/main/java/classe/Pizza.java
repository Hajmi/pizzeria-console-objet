package classe;
/**
 * 
 * @author Samir BENAKCHA
 * @since 19/11/2018
 *
 */

public class Pizza {
	/**
	 * Création de la classe Pizza 
	 * 
	 */
	public int id;
	public String code;
	public String designation;
	public double prix;
	public static int count = 0;
	
	/**
	 * Mise en place d'un constructeur pour la classe Pizza
	 * @param id est l'identifiant 
	 * @param code c'est le code de chaque pizza
	 * @param designation c'est le nom de la pizza
	 * @param prix désigne le prix de la pizza
	 */
	public Pizza(String code, String designation, double prix) {
		
		this.id = count++;
		this.code = code;
		this.designation = designation;
		this.prix = prix;
	}
	/**
	 * Constructeur vide
	 */
	public Pizza() {
		
	}
	/**
	 * Retourne l'identifiant de la pizza désignée
	 * @return l'identifiant de chaque pizza
	 */
	public int getId() {
		return id;
	}
	/**
	 * Met à jour l'identifiant de la pizza
	 * @param id est l'identifiant de la pizza
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Retourne le code de la pizza
	 * @return Retourne le code de la pizza
	 */
	public String getCode() {
		return code;
	}
	/**
	 * Met à jour le code de la pizza
	 * @param code est le code de la pizza
	 */
	public void setCode(String code) {
		this.code = code.toUpperCase();
	}
	/**
	 * Retourne la designation de la pizza
	 * @return retourne la désignation de la pizza
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * Met à jour le nom de la pizza
	 * @param designation est le nom de la pizza
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * Retourne le prix de la pizza
	 * @return retourne le prix de la pizza
	 */
	public double getPrix() {
		return prix;
	}
	/**
	 * Met à jour le prix de la pizza
	 * @param prix est le prix de la pizza
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	public String toString () {
		return " "+this.code+" -> "+this.designation+" ("+this.prix+"€)";
	}
	

}
