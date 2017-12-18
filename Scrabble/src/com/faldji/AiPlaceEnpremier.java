package com.faldji;
import java.util.List; 
import java.util.ArrayList; 
import java.util.Set; 
import java.util.Iterator; 

public class AiPlaceEnpremier extends AiPlace
{ public Placement place(Scrabble s) 
  { Plateau2 p = s.getPlateau2(); 
    Grille g = s.getGrille(); 
    int tailleg = g.tailleGrille(); 
    List lettres = new ArrayList(); 
    for (int i = 0; i < tailleg; i++) 
    { lettres.add("" + g.getLettre(i)); }
    lettres.add(null); 
    Solveur solveur = new Solveur(lettres); 
    
    int maxscore = 0; 
    Mot maxmt = null; 

    do
    { ArrayList act = (ArrayList) solveur.getActuel(); 
      System.out.println(act);
      int x = act.size(); 
     

      ArrayList cc = (ArrayList) act.clone(); 
      cc.remove(x-1); 
      Set possible = Dictionnaire.verifie(cc,x-1); 

      System.out.println(possible); 
      for (Iterator j = possible.iterator(); j.hasNext(); )
      { String mot = (String) j.next(); 

        ArrayList cc1 = (ArrayList) cc.clone(); 
        String mt2 = isValide(mot,cc1); 
        if (mt2 != null)
        { 
        	Mot mt = new Mot(7,7,7 + x - 2,7,mt2);
          int score = mt.getScore(p); 
          if (score > maxscore)
          { maxscore = score; 
            maxmt = mt;
          }
        } 
      } 
      solveur.advance();
    } while (!solveur.enFin());

    if (maxmt != null) 
    { Placement pl = new Placement(s.getJoueur(),maxmt,p);
      return pl; 
    }          
    return null; 
  }             

       
  
}

