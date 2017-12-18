package com.faldji;

public abstract class Joueur
{ private String nom;
  private Grille g;
  private int score = 0;

  public Joueur(String _nom)
  { nom = _nom;
    g = new Grille(); 
  }

  public String getNom()
  { return nom; }

  public Grille getGrille()
  { return g; }

  public int getScore()
  { return score; }

  public void ajoutScore(int x)
  { score += x; }

  public abstract Placement placer(Plateau2 b); 

  public String toString()
  { return nom; } 

 
}

class H extends Joueur
{ 
  public H(String _nom)
  { super(_nom); }

  public Placement placer(Plateau2 b)
  { return Placement.effectuePlacement(this,b); } 
}

class Ai extends Joueur
{ 
  public Ai(String _nom)
  { super(_nom); }

  public Placement placer(Plateau2 b) 
  { return Placement.effectuePlacement(this,b); } 
}


