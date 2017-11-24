package com.faldji;
import java.util.ArrayList;
import java.util.List;


public class Main {
	private Plateau2 plateau2;
	  private List joueurs = new ArrayList();
	  private int tour = 0;
	  private Sac sac; 
	  private int nombrePlacement = 1; 
	  ArrayList<Lettre> contenudusac = new ArrayList();
	  public Main()
	  { 
	    sac = new Sac(false,contenudusac);
	    plateau2 = new Plateau2(sac);
	    tour = 0;
	  }
public Sac getSac() {
	return sac;
}
public void nouveauJoueur(String _nom)
{ Joueur j = new Joueur(_nom); 
  joueurs.add(j); 
}

public CaseAbdoulaye getCaseAbdoulaye(int i, int j)
		{ return plateau2.getCaseAbdoulaye(i,j); }
	public Grille getGrille()
	  { return ((Joueur) joueurs.get(tour)).getGrille(); }

	  public Lettre getLettreGrille(int i)
	  { Grille g = getGrille(); 
	    return g.getLettre(i); 
	  } 
	  public Plateau2 getPlateau2()
	  { return plateau2; }
	  
	  public int getTailleSac()
	  { return sac.tailleSac(); } 

	  public List getJoueurs()
	  { return joueurs; } 

	  public Joueur getJoueur()
	  { return (Joueur) joueurs.get(tour); }
	  
	  public void placeLettre(Lettre l, int x, int y)
	  { plateau2.placeLettre(l,x,y); } 
	  public void placement()
	  { 
		  Joueur j = (Joueur) joueurs.get(tour);
	    Grille g = j.getGrille();
	    List selection = sac.tireLettres(7 - g.tailleGrille());
	    g.ajoutlettres(selection);
	  }
}
