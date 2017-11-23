package com.faldji;
import java.util.*;

public class Plateau2 {
	
	 private CaseAbdoulaye[][] CaseAbdoulaye = new CaseAbdoulaye[15][15];
	  // CaseAbdoulaye[x][y] is CaseAbdoulaye at this coordinate
	  private List TousLesCases = new ArrayList(); 

	  public Plateau2(Sac b)
	  { // uses b to do layout -- mostly standard
	    CaseAbdoulaye = b.getPlateau2();
	    for (int i = 0; i < 15; i++)
	    { for (int j = 0; j < 15; j++)
	      { TousLesCases.add(CaseAbdoulaye[i][j]); }
	    }
	  }

	  public Plateau2(CaseAbdoulaye[][] arr) 
	  { CaseAbdoulaye = arr;
	    for (int i = 0; i < 15; i++)
	    { for (int j = 0; j < 15; j++)
	      { TousLesCases.add(CaseAbdoulaye[i][j]); }
	    }
	  } 

	  public Object clone()
	  { CaseAbdoulaye[][] newCaseAbdoulaye = new CaseAbdoulaye[15][15]; 
	    for (int i = 0; i < 15; i++) 
	    { for (int j = 0; j < 15; j++) 
	      { CaseAbdoulaye ca = (CaseAbdoulaye) CaseAbdoulaye[i][j].clone(); 
	        newCaseAbdoulaye[i][j] = ca; 
	      } 
	    } 
	    return new Plateau2(newCaseAbdoulaye); 
	  } 

	  public CaseAbdoulaye getCaseAbdoulaye(int i, int j)
	  { return CaseAbdoulaye[i][j]; }

	  public ArrayList getLigne(int y)
	  { ArrayList res = new ArrayList(); 
	    for (int i = 0; i < 15; i++) 
	    { res.add(CaseAbdoulaye[i][y]); } 
	    return res; 
	  } 

	  public List getCaseAbdoulaye()
	  { return TousLesCases; }

	  public boolean estOcupee(int i, int j)
	  { return CaseAbdoulaye[i][j].estOcupee(); }
	 
	  public boolean AdjacentOcupee(int x, int y)
	  { int x0 = x;
	    int y0 = y;
	    int x1 = x;
	    int y1 = y;
	    if (x > 0)
	    { x0 = x-1; }
	    if (x < 14)
	    { x1 = x+1; }
	    if (y > 0)
	    { y0 = y-1; }
	    if (y < 14)
	    { y1 = y+1; }
	    return CaseAbdoulaye[x][y].estOcupee() ||
	           CaseAbdoulaye[x0][y].estOcupee() ||
	           CaseAbdoulaye[x1][y].estOcupee() ||
	           CaseAbdoulaye[x][y0].estOcupee() ||
	           CaseAbdoulaye[x][y1].estOcupee();
	  }

	  

	  public void placeLettre(Lettre l, int x, int y)
	  { CaseAbdoulaye[x][y].setlettre(l); }

	  public String toString()
	  { String res = "";
	    for (int j = 0; j < 15; j++)
	    { for (int i = 0; i < 15; i++)
	      { res = res + CaseAbdoulaye[i][j]; }
	      res = res + "\n";
	    }
	    return res;
	  }
	}

