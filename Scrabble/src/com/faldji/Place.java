package com.faldji;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Place{ private int x;
private int y;
private Lettre lettre;

public Place(int xx, int yy, Lettre l)
{ x = xx;
  y = yy;
  lettre = l;
}

public int getX()
{ return x; }

public int getY()
{ return y; }

public Lettre getlettre()
{ return lettre; }


public List trouveMots(Plateau2 p)
{ List res = trouveMotH(p);
  res.addAll(trouveMotV(p));
  return res;
}

public List trouveMotH(Plateau2 p)
{ List res = new ArrayList();
  if (x == 0 || 
      !p.estOcupee(x-1,y))
  { if (x == 14 ||
        !p.estOcupee(x+1,y))
    {
      return res;
    }
    int i = x+1;
    Mot mt = new Mot(x,y,0,y);
    mt.ajoutFin(lettre);
    while (i <= 14 &&
    		p.estOcupee(i,y))
    { mt.ajoutFin(p.getCaseAbdoulaye(i,y).getlettre());
      i++;
    }
    mt.setFinX(i-1);
    res.add(mt);
    return res;
  }
  int k = x-1;
  Mot mt1 = new Mot(0,y,0,y); 
  mt1.ajoutFin(lettre); 
  while (k >= 0 &&
		  p.estOcupee(k,y))
  { mt1.ajoutDebut(p.getCaseAbdoulaye(k,y).getlettre());
     
    k--;
  }
  mt1.setDebutX(k+1);
  int i = x+1;
  while (i <= 14 && 
		  p.estOcupee(i,y))
  { mt1.ajoutFin(p.getCaseAbdoulaye(i,y).getlettre());
    
    i++;
  }
  mt1.setFinX(i-1);
  res.add(mt1);
  return res;
}

public List trouveMotV(Plateau2 p)
{ List res = new ArrayList();
  
  if (y == 0 || 
      !p.estOcupee(x,y-1))
  { if (y == 14 ||
        !p.estOcupee(x,y+1))
    {
      return res;
    }
    int j = y+1;
    Mot mt = new Mot(x,y,x,0); 
    mt.ajoutFin(lettre);
    
    while (j <= 14 &&
    		p.estOcupee(x,j))
    { mt.ajoutFin(p.getCaseAbdoulaye(x,j).getlettre());
     
      j++;
    }
    mt.setFinY(j-1);
    res.add(mt);
    return res;
  }
  int k = y-1;
  Mot mt1 = new Mot(x,0,x,0);
  
  mt1.ajoutFin(lettre); 
  while (k >= 0 &&
		  p.estOcupee(x,k))
  { mt1.ajoutDebut(p.getCaseAbdoulaye(x,k).getlettre());
    
    k--;
  }
  mt1.setDebutY(k+1);
  int j = y+1;
  while (j <= 14 && 
		  p.estOcupee(x,j))
  { mt1.ajoutFin(p.getCaseAbdoulaye(x,j).getlettre());
    
    j++;
  }
  mt1.setFinY(j-1);
  res.add(mt1);
  return res;
}
        
public static Place placer(Plateau2 p,Grille g)
{ String num = 
      JOptionPane.showInputDialog(
                    "Entrer une valeur V 1..15");
  int x = Integer.parseInt(num);
  if (x < 1 || x > 15)
  { System.out.println("Erreur");
    return null;
  }
  x--;
  num = 
      JOptionPane.showInputDialog(
                    "Entrer une valeur H entre 1..15");
  int y = Integer.parseInt(num);
  if (y < 1 || y > 15)
  { System.out.println("Erreur");
    return null;
  }
  y--;
  // occupée:
  CaseAbdoulaye caseAbdoulaye = p.getCaseAbdoulaye(x,y);
  Lettre lt = caseAbdoulaye.getlettre();
  if (lt != null)
  { System.out.println("Déjà occupée!");
    return null;
  }
  int tailleg = g.tailleGrille();
  num = 
      JOptionPane.showInputDialog(
                    "selectionner un element de la grille" +
                    tailleg);
  int n = Integer.parseInt(num);
  if (n < 1 || n > tailleg)
  { System.out.println("Erreur");
    return null;
  }
  n--;
  Lettre l = g.getLettre(n);
  return new Place(x,y,l);
}

public int getScore(Plateau2 p)
{ CaseAbdoulaye caseAbdoulaye = p.getCaseAbdoulaye(x,y);
  return caseAbdoulaye.getlettreValeur(lettre);
}

public String toString()
{ return "lettre placée: " + lettre+" en: " + x + " " + y; } 


} 
