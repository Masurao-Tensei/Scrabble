package com.faldji;
import java.util.*;
import javax.swing.*;
      
public class Placement
{ private List mots = new ArrayList();
  public Joueur getJ() {
	return j;
}

public void setJ(Joueur j) {
	this.j = j;
}

public List getMots() {
	return mots;
}

public int getScore() {
	return score;
}

public void setPlaceLettre(List placeLettre) {
	placeLettres = placeLettre;
}

private List placeLettres = new ArrayList(); 
  private int score = 0;  
  private Joueur j;      

  public Placement(Joueur _j)
  { j = _j; }

  public Placement(Joueur _j, List _Placements)
  { placeLettres = _Placements;
    j = _j; 
  }

  public Placement(Joueur _j, int _score, List _placements)
  { this(_j,_placements); 
    setScore(_score); 
  }

  public Placement(Joueur _j, Mot mt, Plateau2 p)
  { j = _j; 
    int x1 = mt.getDebutX(); 
    int y1 = mt.getDebutY(); 
    int x2 = mt.getFinX(); 
    int y2 = mt.getFinY(); 
    int len = 0; 
    if (x1 < x2)
    { len = x2 - x1 + 1; 
      for (int i = 0; i < len; i++) 
      { placeLettres.add(new Place(x1+i,y1,mt.getLettre(i))); } 
    } 
    else if (y1 < y2)  
    { len = y2 - y1 + 1; 
      for (int i = 0; i < len; i++) 
      { placeLettres.add(new Place(x1,y1+i,mt.getLettre(i))); } 
    } 
  }
  public void reinitMot()
  { mots = new ArrayList(); } 
  public void ajoutPlacementLettre(Place lm)
  { placeLettres.add(lm); }

  public void setScore(int i)
  { score = i; } 

  public List getPlaceLettre()
  { return placeLettres; }

  

  public List getLettres()
  { List res = new ArrayList(); 
    for (int i = 0; i < placeLettres.size(); i++) 
    { Place pl = (Place) placeLettres.get(i); 
      res.add(pl.getlettre()); 
    } 
    return res; 
  }   

  public static Placement effectuePlacement(Joueur j, Plateau2 p)
  { Grille g = j.getGrille();
    System.out.println(j.getNom()+" : " + g);
    List Placements = new ArrayList();
    String termine = 
        JOptionPane.showInputDialog(
                      "Entre Placement");
    while (termine != null && !termine.equals("fin"))
    { Place lm = Place.placer(p,g);
      if (lm != null)
      { Placements.add(lm); }
      termine = 
        JOptionPane.showInputDialog(
                      "Entrer fin pour terminer Placement");
    }
    return new Placement(j,Placements);
  }

  public boolean isPlacementValide(int nb)
  { 
    boolean vf = true; 
    Set xcoords = new TreeSet();
    Set ycoords = new TreeSet();
    for (int i = 0; i < placeLettres.size(); i++)
    { Place pl = (Place) placeLettres.get(i);
      xcoords.add(new Integer(pl.getX()));
      ycoords.add(new Integer(pl.getY()));
      if (xcoords.size() > 1 &&
          ycoords.size() > 1)  // erreur
      { return false; }
    }
    if (nb == 1) 
    { Integer sept = new Integer(7);
      if (xcoords.contains(sept) &&
          ycoords.contains(sept))
      { vf = true; }
      else 
      { vf = false; }
    }                                     
    for (int i = 0; i < mots.size(); i++)
    { Mot mt = (Mot) mots.get(i); 
      boolean vf1 = Dictionnaire.verifie1(mt); 
      System.out.println("Le mot " + mt + " existe?: " + vf1);
      
    } 
    return vf;
  }
  public boolean ismotExiste()
  { boolean existe = false; 
    for (int i = 0; i < mots.size(); i++)
    { Mot mt = (Mot) mots.get(i); 
      boolean existe1 = Dictionnaire.verifie1(mt);
      existe = existe && existe1;  
    } 
    return existe;
  }  

  

  public boolean trouveMot(Plateau2 p)
  { int tailleplacement = placeLettres.size();
    if (tailleplacement == 0)
    { mots = new ArrayList();
      return false;
    } 
    Place pl1 = (Place) placeLettres.get(0);
    Place pl2 = (Place) placeLettres.get(tailleplacement-1);

    int x1 = pl1.getX();
    int x2 = pl2.getX();
    int y1 = pl1.getY();
    int y2 = pl2.getY();

    if (x1 == x2 && y1 == y2) 
    { mots = pl1.trouveMotV(p); 
      mots.addAll(pl1.trouveMotH(p)); 
      return true; 
    } 

    if (x1 == x2) 
    { List vertic = pl1.trouveMotV(p); 
      if (vertic.size() == 1)
      { mots.addAll(vertic); }  
      else 
      { return false; }
      Mot motvertic = (Mot) vertic.get(0); 
  
      for (int i = 0; i < tailleplacement; i++)
      { Place pl = (Place) placeLettres.get(i);
        if (motvertic.isMotcontient(pl))
        { mots.addAll(pl.trouveMotH(p)); }
        else 
        { System.out.println("Placement libre: " + pl); 
          return false; 
        } 
      }
      return true; 
    }

    if (y1 == y2)  //placement horizontal 
    { List horizon = pl1.trouveMotH(p);
      if (horizon.size() == 1)
      { mots.addAll(horizon); }
      else 
      { return false; } 
      Mot motHorizon = (Mot) horizon.get(0); 

      for (int j = 0; j < tailleplacement; j++)
      { Place pl = (Place) placeLettres.get(j);
        if (motHorizon.isMotcontient(pl))
        { mots.addAll(pl.trouveMotV(p)); }
        else 
        { System.out.println("Placement libre: " + pl); 
          return false; 
        }         
      }
    }
    return true; 
  }
 



  
  public int getScore(Plateau2 p)
  { int total = 0;
    for (int i = 0; i < mots.size(); i++)
    { Mot mot = (Mot) mots.get(i);
      total += mot.getScore(p);
    }
    if (placeLettres.size() == 7) // bonus
    { total += 50; }
    score = total;
    return total;
  }

  public String toString()
  { String res = "Placement: du joueur " + j + " score = " + score + "\n"; 
    for (int i = 0; i < placeLettres.size(); i++)
    { Place pl = (Place) placeLettres.get(i); 
      res = res + " Place lettres: " + pl + "\n"; 
    }
    return res;
  }

}

