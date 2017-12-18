package com.faldji;
import java.util.List; 
import java.util.ArrayList; 
import java.util.Set; 
import java.util.Iterator; 

public abstract class AiPlace
{ public abstract Placement place(Scrabble s); 

  public boolean verifie(String mot, List cc)
  { for (int i = 0; i < mot.length(); i++) 
    { String lett = "" + mot.charAt(i);
      int ind = cc.indexOf(lett); 
      if (ind >= 0)
      { cc.remove(ind); } 
      else 
      { int ind2 = cc.indexOf(" "); 
        if (ind2 >= 0)
        { cc.remove(ind2); } 
        else 
        { return false; }
      } 
    }
    return true; 
  } 

  public String isValide(String mot, List cc)
  { 
    String res = ""; 

    for (int i = 0; i < mot.length(); i++) 
    { String lett = "" + mot.charAt(i);
      int ind = cc.indexOf(lett); 
      if (ind >= 0)
      { cc.remove(ind);
        res = res + lett;
      } 
      else 
      { int ind2 = cc.indexOf(" "); 
        if (ind2 >= 0)
        { cc.remove(ind2);
          res = res + lett.toUpperCase(); 
        } 
        else 
        { return null; }
      } 
    }
    return res; 
  } 
} 


class AiPlaceSpecial extends AiPlace
{ public Placement place(Scrabble s)
  { Grille g = s.getGrille(); 
    Plateau2 p = s.getPlateau2(); 
    int tailleG = g.tailleGrille(); 
    List special = new ArrayList(); 
   
    special.addAll(p.getCaseAbdoulaye());    
    
    int caseSp = special.size(); 

    Mot[] vertic = new Mot[caseSp]; 
    Mot[] horiz = new Mot[caseSp]; 

    for (int i = 0; i < special.size(); i++) 
    { CaseAbdoulaye sp = (CaseAbdoulaye) special.get(i); 
      vertic[i] = trouveVertic(sp,tailleG,p);
      horiz[i] = trouveHoriz(sp,tailleG,p);
      
    } 
    

    List lettres = new ArrayList(); 
    for (int i = 0; i < tailleG; i++) 
    { lettres.add("" + g.getLettre(i)); }

    System.out.println("Grille de l'IA: " + lettres); 
    if (lettres.size() == 7)
    { System.out.println("Tous les mots trouvés: " + 
                         Dictionnaire.verifie(lettres,7)); 
    }  


    lettres.add(null); 
    Solveur solveur = new Solveur(lettres); 

    
    int scoremax = 0; 
    Mot motmax = null; 
    List maxlettre = null; 

    do
    { ArrayList actuel = (ArrayList) solveur.getActuel(); 
      
      int x = actuel.size();

      ArrayList cc = (ArrayList) actuel.clone(); 
      cc.remove(x-1); 
      for (int i = 0; i < special.size(); i++) 
      { CaseAbdoulaye ca = (CaseAbdoulaye) special.get(i); 
        if (vertic[i] != null)
        { Mot liste = vertic[i]; 
          int sp = liste.getSpecial(); 
          { int dispo = 0; 
            List toutesLett = liste.toutesLettres(cc,dispo);
            if (toutesLett != null && 
            		toutesLett.size() > x)
            {
              int newstarty = ((Integer) toutesLett.get(0)).intValue(); 
              toutesLett.remove(0); 
              int newendy = ((Integer) toutesLett.get(0)).intValue(); 
              toutesLett.remove(0); 
              int y = toutesLett.size(); 
              Set possible = Dictionnaire.verifie(toutesLett,y);
             
              for (Iterator j = possible.iterator(); j.hasNext(); )
              { String mot = (String) j.next();
                ArrayList toutesLettc = (ArrayList) ((ArrayList) toutesLett).clone(); 
                String mot2 = isValide(mot,toutesLettc);
                if (mot2 != null) 
                { List nouveauLett = liste.fitsY(mot2,newstarty); 
                  if (nouveauLett.size() > 0)
                  { Placement pla = new Placement(s.getJoueur(),nouveauLett);
                    Plateau2 pp = (Plateau2) p.clone(); 
                    if (pp.placer(pla,p))
                    { pla.trouveMot(pp); 
                      if (pla.ismotExiste())
                      { int score = pla.getScore(p); 
                        if (score > scoremax)
                        { scoremax = score; 
                      
                          maxlettre = nouveauLett; 
                          System.out.println(toutesLett + " " + possible + 
                                       " Mot " + mot2 +  " Score = " + scoremax);
                        }
                      } 
                    }
                  } 
                } 
              } 
            }
          }
        }
        if (horiz[i] != null)
        { Mot hliste = horiz[i]; 
          int spec = hliste.getSpecial(); 
          
          { int disp = 0; 
            List toutesLett = hliste.toutesLettres(cc,disp);
            if (toutesLett != null && 
                toutesLett.size() > x)
            { 
              int newstartx = ((Integer) toutesLett.get(0)).intValue(); 
              toutesLett.remove(0); 
              int newendx = ((Integer) toutesLett.get(0)).intValue(); 
              toutesLett.remove(0); 
              int y = toutesLett.size(); 
              Set possible = Dictionnaire.verifie(toutesLett,y);
              
              for (Iterator j = possible.iterator(); j.hasNext(); )
              { String mot = (String) j.next();
                ArrayList toutesLettc = (ArrayList) ((ArrayList) toutesLett).clone(); 
                String mot2 = isValide(mot,toutesLettc); 
                if (mot2 != null)
                { List nouveauLett = hliste.fitsX(mot2,newstartx); 
                  if (nouveauLett.size() > 0)
                  { Placement pla = new Placement(s.getJoueur(),nouveauLett);
                    Plateau2 pp = (Plateau2) p.clone(); 
                    if (pp.placer(pla,p))
                    { pla.trouveMot(pp); 
                      if (pla.ismotExiste())
                      { int score = pla.getScore(p); 
                        if (score > scoremax)
                        { scoremax = score; 
                        
                          maxlettre = nouveauLett; 
                          System.out.println(toutesLett + " " + possible + 
                                       " Mot " + mot +   " score maxi= " + scoremax);
                        }
                      } 
                    }
                  } 
                } 
              } 
            }
          }        

        }
      }
      solveur.advance();
    } while (!solveur.enFin());

    if (maxlettre == null) 
    { return null; } 
    return new Placement(s.getJoueur(),maxlettre);
  }

  private Mot trouveVertic(CaseAbdoulaye spec, int tailleG, Plateau2 p)
  { 
    int vide = 0; 
    int occupee = 0; 
    Lettre debut = new Lettre("*",0,0); 

    int maxvide = 2*tailleG + 1; 
    int x = spec.getX(); 
    int y = spec.getY(); 
    int j = y; 
    if (y == 0)
    { Mot mt = new Mot(x,0,x,0); 
      while (j < 15 && vide < maxvide)
      { if (p.estOcupee(x,j))
        { occupee++; 
          mt.ajoutFin(p.getCaseAbdoulaye(x,j).getlettre()); 
        } 
        else 
        { vide++; 
          mt.ajoutFin(debut); 
        } 
        j++; 
      } 
      mt.setFinY(j-1); 
      if (occupee == 0) 
      { return null; } 
      mt.setSpecial(0); 
      return mt; 
    } 
    else 
    { Mot mt2 = new Mot(x,y,x,y); 
      while (j >= 0 && vide < tailleG) 
      { if (p.estOcupee(x,j))
        {  mt2.ajoutDebut(p.getCaseAbdoulaye(x,j).getlettre());
          
          occupee++; 
        } 
        else 
        { mt2.ajoutDebut(debut); 
          vide++; 
        } 
        j--; 
      } 
      mt2.setDebutY(j+1);
      int k = y+1;  
      while (k < 15 && vide < maxvide)
      { if (p.estOcupee(x,k))
        { occupee++; 
          mt2.ajoutFin(p.getCaseAbdoulaye(x,k).getlettre()); 
        } 
        else 
        { vide++; 
          mt2.ajoutFin(debut); 
        } 
        k++; 
      } 
      mt2.setFinY(k-1); 
      if (occupee == 0) 
      { return null; } 
      mt2.setSpecial(y - (j+1));  
      return mt2; 
    }    
  }  

  private Mot trouveHoriz(CaseAbdoulaye spec, int tailleG, Plateau2 p)
  { 
    int vide = 0; 
    int occupee = 0; 
    Lettre star = new Lettre("*",0,0); 

    int maxvide = 2*tailleG + 1; 
    int x = spec.getX(); 
    int y = spec.getY(); 
    int j = x; 
    if (x == 0)
    { Mot mt = new Mot(0,y,0,y); 
      while (j < 15 && vide < maxvide)
      { if (p.estOcupee(j,y))
        { occupee++; 
          mt.ajoutFin(p.getCaseAbdoulaye(j,y).getlettre()); 
        } 
        else 
        { vide++; 
          mt.ajoutFin(star); 
        } 
        j++; 
      } 
     mt.setDebutX(j-1); 
      if (occupee == 0) 
      { return null; } 
      mt.setSpecial(0); 
      return mt; 
    } 
    else 
    { Mot mt2 = new Mot(x,y,x,y); 
      while (j >= 0 && vide < tailleG) 
      { if (p.estOcupee(j,y))
        { mt2.ajoutDebut(p.getCaseAbdoulaye(j,y).getlettre()); 
          occupee++; 
        } 
        else 
        { mt2.ajoutDebut(star); 
          vide++; 
        } 
        j--; 
      } 
      mt2.setDebutX(j+1);
      int k = x+1;  
      while (k < 15 && vide < maxvide)
      { if (p.estOcupee(k,y))
        { occupee++; 
          mt2.ajoutFin(p.getCaseAbdoulaye(k,y).getlettre()); 
        } 
        else 
        { vide++; 
          mt2.ajoutFin(star); 
        } 
        k++; 
      } 
      mt2.setFinX(k-1); 
      if (occupee == 0) 
      { return null; } 
      mt2.setSpecial(x - (j+1));  
      return mt2; 
    }    
  }  
  
}

class CompositeAiPlace extends AiPlace
{  
	public Placement place(Scrabble s)
  { AiPlaceSpecial plc = new AiPlaceSpecial(); 
    Placement res1 = plc.place(s); 
    if (res1 == null)
    { Grille r = s.getGrille(); 
      System.out.println(r.getSuffixes());
      System.out.println("Je passe"); 
    } 
    return res1; 
  } 
} 

