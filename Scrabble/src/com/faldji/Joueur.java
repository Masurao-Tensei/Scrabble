package com.faldji;


public class Joueur {
	protected String nom;
	protected int score;
	protected MainJoueur main;
	protected Grille grille;
	
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
	public Joueur(String _nom) {
		this.score = 0;
		grille = new Grille();
		this.nom =_nom;
	}
	public String getNom()
	  { return nom; }

	  public Grille getGrille()
	  { return grille; }


	  public void ajoutScore(int s)
	  { score += s; }

	 
	
	public Joueur(int score, MainJoueur main) {
		super();
		this.score = score;
		this.main = main;
	}
	
	
	
	
	
	
}
