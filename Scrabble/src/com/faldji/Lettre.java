package com.faldji;


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
	
	public boolean estJoker() {
		return nom == "_";
	}

	public String getNom() {
		return nom;
	}
	public String toString()
	  { return "" + nom; }

	public void setNom(String nom) {
		if (this.nom == "_")
	    { this.nom = nom; }}

	public Lettre(String nom, int nombre, int valeur) {
		super();
		this.nom = nom;
		this.nombre = nombre;
		this.valeur = valeur;
	}

	public Object clone()
	  { return new Lettre(nom,nombre,valeur); } 
	

	
	
	
	
}
