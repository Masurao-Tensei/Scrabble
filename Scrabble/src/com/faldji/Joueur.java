package com.faldji;

public class Joueur {
	
	protected int score;
	protected MainJoueur main;
	
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
	
	
	
	public Joueur(int score, MainJoueur main) {
		super();
		this.score = score;
		this.main = main;
	}
	
	
	
	
	
	
}
