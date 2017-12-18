package com.faldji;

import java.util.*;

public class Solveur
{ private List l; 
  private int index = 0;
  private List actuel = new ArrayList();
  private Object contenu;   
  private List sublist = null;
  private Solveur solv = null;

  public Solveur(List ll)
  { l = ll;
    index = 0;
    if (l.size() > 0)
    { actuel = (List) ((ArrayList) l).clone();
      sublist = (List) ((ArrayList) l).clone();
      contenu = sublist.get(0); 
      sublist.remove(0);
       
      solv = new Solveur(sublist);
    }
  }

  public List getActuel()
  { return actuel; }

  public boolean enFin()
  { if (l.size() == 0)
    { return true; }
    
    return (index == l.size() - 1 &&
            solv.enFin());
  }

  public void advance()
  { if (l.size() == 0) { return; }  // can't move
   
    if (solv.enFin())
    { if (index == l.size() - 1)
      { actuel = new ArrayList(); 
        return; 
      } 
      index++;
      contenu = sublist.get(0); 
      actuel = (List) ((ArrayList) sublist).clone();
      sublist.remove(0);
      solv = new Solveur(sublist);
      return;
    }
    solv.advance();
    List sb = solv.getActuel();
    actuel = (List) ((ArrayList) sb).clone();
    actuel.add(0,l.get(index));
  }

 
}

