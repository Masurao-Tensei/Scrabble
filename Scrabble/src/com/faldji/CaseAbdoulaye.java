package com.faldji;

import java.awt.*;


public abstract class CaseAbdoulaye {

protected Lettre lettre = null;
	  protected int x; 
	  protected int y; 

	  public CaseAbdoulaye() { }

	  public CaseAbdoulaye(int xx, int yy)
	  { x = xx; 
	    y = yy; 
	  } 

	  public CaseAbdoulaye(Lettre l)
	  { lettre = l; } 

	  public void setlettre(Lettre l)
	  { lettre = l; }

	  public void setX(int xx) 
	  { x = xx; } 

	  public void setY(int yy) 
	  { y = yy; } 

	  public int getX()
	  { return x; } 

	  public int getY()
	  { return y; }

	  public void Vider()
	  { lettre = null; } 

	  public Lettre getlettre()
	  { return lettre; }

	  public boolean estOcupee()
	  { return lettre != null; } 

	 
	  public abstract int getlettreValeur(Lettre l);
	  
	  
	  public int getlettreValeur()
	  { if (lettre == null)
	    { return 0; }
	    return getlettreValeur(lettre);
	  }

	  public abstract int getMotValeur(); 

	  
	  public abstract String CaseAbdoulayeSymbol();
	  
	  
	  public String toString()
	  { String res = "[";
	    if (lettre != null)
	    { res = res + lettre + "]"; }
	    else 
	    { res = res + CaseAbdoulayeSymbol() + "]"; }
	    return res;
	  }

	  public String getText()
	  { if (lettre != null)
	    { return lettre + ""; }
	    return CaseAbdoulayeSymbol();
	  }

	  public abstract Color getColor();

	  public abstract Object clone(); 
	}


	class SimpleCaseAbdoulaye extends CaseAbdoulaye
	{ public SimpleCaseAbdoulaye(Lettre l)
	  { super(l); } 

	  public SimpleCaseAbdoulaye()
	  { super(); }

	  public SimpleCaseAbdoulaye(int xx, int yy)
	  { super(xx,yy); } 

	  public Object clone()
	  { CaseAbdoulaye res = new SimpleCaseAbdoulaye(lettre); 
	    res.setX(x); 
	    res.setY(y); 
	    return res; 
	  } 

	  public int getlettreValeur(Lettre l)
	  { return l.getValeur(); }

	  public int getMotValeur()
	  { return 1; } 

	  public String CaseAbdoulayeSymbol()
	  { return ""; }

	  public Color getColor()
	  { return new Color(0,150,145); } 
	}


	class LdCaseAbdoulaye extends CaseAbdoulaye
	{
	  public LdCaseAbdoulaye()
	  { super(); }

	  public LdCaseAbdoulaye(int xx, int yy)
	  { super(xx,yy); } 

	  public LdCaseAbdoulaye(Lettre l)
	  { super(l); } 

	  public Object clone()
	  { CaseAbdoulaye res = new LdCaseAbdoulaye(lettre); 
	    res.setX(x); 
	    res.setY(y); 
	    return res; 
	  } 

	  public int getlettreValeur(Lettre l)
	  { return 2*l.getValeur(); }

	  public int getMotValeur()
	  { return 1; } 

	  public String CaseAbdoulayeSymbol()
	  { return "LD"; }

	  public Color getColor()
	  { return new Color(198,231,250); } 
	}


	class LtCaseAbdoulaye extends CaseAbdoulaye
	{ public LtCaseAbdoulaye()
	  { super(); }

	  public LtCaseAbdoulaye(Lettre l)
	  { super(l); }

	  public LtCaseAbdoulaye(int xx, int yy)
	  { super(xx,yy); } 

	  public Object clone()
	  { CaseAbdoulaye res = new LtCaseAbdoulaye(lettre); 
	    res.setX(x); 
	    res.setY(y); 
	    return res; 
	  } 

	  public int getlettreValeur(Lettre l)
	  { return 3*l.getValeur(); }

	  public int getMotValeur()
	  { return 1; } 

	  public String CaseAbdoulayeSymbol()
	  { return "LT"; }

	  public Color getColor()
	  { return new Color(1,156,222); } 
	}


	class MdCaseAbdoulaye extends CaseAbdoulaye
	{ public MdCaseAbdoulaye(Lettre l)
	  { super(l); } 

	  public MdCaseAbdoulaye()
	  { super(); }

	  public MdCaseAbdoulaye(int xx, int yy)
	  { super(xx,yy); } 

	  public Object clone()
	  { return new MdCaseAbdoulaye(lettre); } 

	  public int getlettreValeur(Lettre l)
	  { return l.getValeur(); }

	  public int getMotValeur()
	  { return 2; } 

	  public String CaseAbdoulayeSymbol()
	  { return "MD"; }

	  public Color getColor()
	  { return new Color(247,171,148); } 
	}


	class MtCaseAbdoulaye extends CaseAbdoulaye
	{ public MtCaseAbdoulaye(Lettre l)
	  { super(l); } 

	  public MtCaseAbdoulaye()
	  { super(); }

	  public MtCaseAbdoulaye(int xx, int yy)
	  { super(xx,yy); } 

	  public Object clone()
	  { return new MtCaseAbdoulaye(lettre); } 

	  public int getlettreValeur(Lettre l)
	  { return l.getValeur(); }

	  public int getMotValeur()
	  { return 3; } 

	  public String CaseAbdoulayeSymbol()
	  { return "MT"; }

	  public Color getColor()
	  { return new Color(235,28,46); }
	  
	 

}
