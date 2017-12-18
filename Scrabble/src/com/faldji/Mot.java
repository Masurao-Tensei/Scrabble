package com.faldji;

import java.util.*;

import javax.swing.JFrame;

public class Mot
{ private int debutx;
  private int debuty; 
  private int finx;
  private int finy; 
  private List lettres = new ArrayList(); 
  private int score = 0;

  private int special = -1;  
  
  public Mot(int x1,int y1,int x2,int y2)
  { debutx = x1;
    debuty = y1;
    finx = x2;
    finy = y2;
  }

  public Mot(int x1,int y1,int x2,int y2, String s)
  { this(x1,y1,x2,y2); 
    for (int i = 0; i < s.length(); i++)
    {System.out.println(s+"-----"+s.charAt(i));
    	char c = s.toUpperCase().charAt(i); 
      Lettre lett = (Lettre) Main.mainj.getSac().getLettre(c).clone();
      System.out.println(lett+"oui");
      lettres.add(lett); 
    }
  }

  public void setLettres(List letts) 
  { lettres = letts; } 

  public void setSpecial(int prem)
  { special = prem; } 

  public int getSpecial() 
  { return special; } 

  public int getDebutX() { return debutx; }

  public int getDebutY() { return debuty; }

  public int getFinX() { return finx; }

  public int getFinY() { return finy; }

  public Lettre getLettre(int i)
  { return (Lettre) lettres.get(i); } 

  public int getLength()
  { if (debutx == finx) 
    { return finy - debuty + 1; } 
    else 
    { return finx - debutx + 1; } 
  } 

  public boolean isVertical()
  { return debutx == finx; } 

  public boolean isHorizontal()
  { return debuty == finy; } 

  private CaseAbdoulaye getCaseAbdoulaye(int i, Plateau2 b)
  { if (isVertical())
    { return b.getCaseAbdoulaye(debutx,debuty+i); } 
    return b.getCaseAbdoulaye(debutx+i,debuty); 
  }

  public int getScore(Plateau2 b)
  { int factor = 1; 
    for (int i = 0; i < lettres.size(); i++) 
    { Lettre l = (Lettre) lettres.get(i); 
    CaseAbdoulaye caseAbdoulaye = getCaseAbdoulaye(i, b); 
      if (caseAbdoulaye.estOcupee()) 
      { score += l.getValeur(); } 
      else 
      { score += caseAbdoulaye.getlettreValeur(l); 
        factor *= caseAbdoulaye.getMotValeur(); 
      } 
    } 
    score = score*factor; 
    return score; 
  } 

  public boolean isMotcontient(Place pl)
  { int x = pl.getX(); 
    int y = pl.getY(); 
    return (debutx <= x && x <= finx &&
            debuty <= y && y <= finy); 
  } 

      
  public void ajoutDebut(Lettre l)
  { lettres.add(0,l); }

  public void ajoutFin(Lettre l)
  { lettres.add(l); }

  public void setDebutX(int x)
  { debutx = x; }

  public void setDebutY(int y)
  { debuty = y; }

  public void setFinX(int x)
  { finx = x; }

  public void setFinY(int y)
  { finy = y; }

  public String toString()
  { String res = ""; 
    for (int i = 0; i < lettres.size(); i++)
    { res = res + ((Lettre) lettres.get(i)); }
    return res;
  }

  public boolean equals(Object obj)
  { if (obj instanceof Mot)
    { Mot mt = (Mot) obj; 
      if (mt.toString().equals(toString()) &&
          mt.getDebutX() == debutx &&
          mt.getDebutY() == debuty &&
          mt.getFinX() == finx &&
          mt.getFinY() == finy)
      { return true; }
    }
    return false;
  }

  public List toutesLettres(List racklettres, int disp)
  { if (debutx == finx) 
    { return touteslLettresV(racklettres,disp); } 
    else 
    { return touteslLettresH(racklettres,disp); } 
  } 

  private List touteslLettresV(List rlettres, int disp)
  { if (disp + debuty > finy) { return null; } 
    if (disp > special) { return null; } 
    boolean found = false; 
    int tailleg = rlettres.size(); 
   
    List res = new ArrayList(); 
    int p = 0; 
    int i = disp; 
  
    int k = i - 1; 
    for ( ; k >= 0; k--)
    { String st = "" + ((Lettre) lettres.get(k)); 
      if (st.equals("*")) { break; } 
      res.add(0,st); 
      found = true; 
    }
    while (i < finy - debuty + 1 && p < tailleg) 
    { String loc = "" + ((Lettre) lettres.get(i)); 
      if (loc.equals("*"))
      { res.add(rlettres.get(p)); 
        p++; 
      } 
      else 
      { res.add(loc);
        found = true; 
      } 
      i++; 
    } 
    while (i < finy - debuty + 1)  // p == tailleg
    { String loc = "" + ((Lettre) lettres.get(i)); 
      if (loc.equals("*"))
      { break; } 
      else 
      { res.add(loc); 
        found = true; 
      } 
      i++; 
    }
    if (!found) { return null; } 

    res.add(0,new Integer(i-1)); 
    res.add(0,new Integer(k+1)); 
    return res; 
  }     

  private List touteslLettresH(List rlettres, int disp)
  { if (disp + debutx > finx) { return null; } 
    if (disp > special) { return null; } 
    boolean found = false; 
    int tailleg = rlettres.size(); 
    
    List res = new ArrayList(); 
    int p = 0; 
    int i = disp; 

    int k = i - 1; 
    for ( ; k >= 0; k--)
    { String st = "" + ((Lettre) lettres.get(k)); 
      if (st.equals("*")) { break; } 
      res.add(0,st); 
      found = true; 
    }
    while (i < finx - debutx + 1 && p < tailleg) 
    { String loc = "" + ((Lettre) lettres.get(i)); 
      if (loc.equals("*"))
      { res.add(rlettres.get(p)); 
        p++; 
      } 
      else 
      { res.add(loc);
        found = true; 
      } 
      i++; 
    } 
    while (i < finx - debutx + 1)  // p == tailleg
    { String loc = "" + ((Lettre) lettres.get(i)); 
      if (loc.equals("*"))
      { break; } 
      else 
      { res.add(loc); 
        found = true; 
      } 
      i++; 
    }
    if (!found) { return null; } 

    res.add(0,new Integer(i-1)); 
    res.add(0,new Integer(k+1)); 
    return res; 
  }     

  public List fitsY(String letts, int disp) 
  {  List res = new ArrayList(); 
    for (int i = disp; i < finy - debuty + 1; i++) 
    { String loc = "" + ((Lettre) lettres.get(i)); 
      if (i < letts.length())
      { String lett = "" + letts.charAt(i); 
        if (loc.equals("*"))  
        { Lettre ll = 
            (Lettre) Main.mainj.getSac().getLettre(lett.toUpperCase().charAt(0)).clone();
          res.add(new Place(debutx, i + debuty, ll));
        } 
        else if (loc.equalsIgnoreCase(lett))  
        { } 
        else 
        { return new ArrayList(); }  
      }
    }
    return res; 
  } 

  public List fitsX(String letts, int disp) 
  { 
    List res = new ArrayList(); 
    for (int i = disp; i < finx - debutx + 1; i++) 
    { String loc = "" + ((Lettre) lettres.get(i)); 
      if (i < letts.length())
      { String lett = "" + letts.charAt(i); 
        if (loc.equals("*"))  
        { Lettre ll = 
            (Lettre) Main.mainj.getSac().getLettre(lett.toUpperCase().charAt(0)).clone();
          res.add(new Place(debutx + i,debuty, ll));
        } 
        else if (loc.equalsIgnoreCase(lett)) 
        { } 
        else 
        { return new ArrayList(); } 
      }
    }
    return res; 
  } 

   
       
}
