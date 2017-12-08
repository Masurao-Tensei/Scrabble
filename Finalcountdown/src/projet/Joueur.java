package projet;

public class Joueur {
	
	protected int score;
	protected MainJoueur main;
	protected String nom;
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public MainJoueur getMain() {
		return main;
	}
	public void setMain(MainJoueur main) {
		this.main = main;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public Joueur(int score, MainJoueur main) {
		super();
		this.score = score;
		this.main = main;
	}
}
