package com.faldji;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;




public class Scrabble {
	private Plateau2 plateau2;
	  private List joueurs = new ArrayList();
	  private int tour = 0;
	  private Sac sac; 
	  private int nombrePlacement = 1; 
	  ArrayList<Lettre> contenudusac = new ArrayList();
	  public Scrabble()
	  { 
		  sac = new Sac(false,contenudusac);
	    plateau2 = new Plateau2(sac);
	    tour = 0;
	    Ai();
	  }
	  public void debutJeu()
	  { nombrePlacement = 1; 
	    tour = 0; 
	  } 
public Sac getSac() {
	return sac;
}
public void Ai()
{ Joueur j ;

j = new  Ai("IA");
  joueurs.add(j); 
}
public void nouveauJoueur(String _nom)
{ Joueur j ;

j = new H(_nom);
  joueurs.add(j); 
}
public void finPlacement(Placement pl){ 

	 Plateau2 p1 = (Plateau2) plateau2.clone();
	Plateau2 p2 = (Plateau2) plateau2.clone();
	  Joueur j = (Joueur) joueurs.get(tour);
	  Grille g = j.getGrille();
if (plateau2.placementValide(pl,nombrePlacement))
{ if (nombrePlacement == 1 || p1.placer(pl, plateau2))
  { if (nombrePlacement == 1 || pl.trouveMot(p1))
    { pl.reinitMot(); 
      plateau2.placer(pl, plateau2); 
      pl.trouveMot(plateau2);
      System.out.println("Lettres placées : " + pl.getPlaceLettre()); 
      System.out.println("Les mots trouvés: " + pl.getMots()); 
      pl.ismotExiste(); 
      int s = pl.getScore(p2); 
      System.out.println("placement valide, votre nouveau score est : " + s);
      j.ajoutScore(s); 
      g.retirerlettres(pl.getLettres());
    }
    else 
    { System.out.println("placement non valide, tour perdu"); } 
  }
  else 
  { System.out.println("placement non valide, tour perdu"); }
}
else 
{ System.out.println("placement non valide, tour perdu"); }
tour = (tour + 1) % joueurs.size(); 
nombrePlacement++; 
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
	    JOptionPane.showMessageDialog(null, "A votre tour "+j.getNom());
	    Grille g = j.getGrille();
	    List selection = sac.tireLettres(7 - g.tailleGrille());
	    g.ajoutlettres(selection);
	  }
	  public void effectuePlacement()
	  { 
		  Joueur j = (Joueur) joueurs.get(tour);
	    Grille g = j.getGrille();
	    List selection = sac.tireLettres(7 - g.tailleGrille());
	    g.ajoutlettres(selection);
	   Placement pl = j.placer(plateau2);
	        Plateau2 p = (Plateau2) plateau2.clone(); 
	        p.placer(pl,plateau2); 
	        pl.trouveMot(p);
	        System.out.println(pl.getPlaceLettre()); 
	        System.out.println(pl.getMots()); 
	        if (plateau2.placementValide(pl,nombrePlacement))
	        { int s = pl.getScore(plateau2); 
	          plateau2.placer(pl,plateau2);
	          System.out.println("placement valide, votre nouveau score est : " + s);
	          j.ajoutScore(s);
	          g.retirerlettres(pl.getLettres());
	        }
	        else
	        { System.out.println("placement non valide, tour perdu"); }
	        tour = (tour + 1) % joueurs.size(); 
	        nombrePlacement++; 
	      }
}
