
public class Lettre {
	
	protected String nom;
	protected int nombre; 
	protected int valeur;
	
	public int getNombre() {
		return nombre;
	}
	
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	public int getValeur() {
		return valeur;
	}
	
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Lettre(String nom, int nombre, int valeur) {
		super();
		this.nom = nom;
		this.nombre = nombre;
		this.valeur = valeur;
	}
	
	

	
	
	
	
}
