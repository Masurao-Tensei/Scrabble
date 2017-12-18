package com.faldji;
import javax.swing.*;
import javax.swing.border.LineBorder;

import com.faldji.jetons.Imagedefond;
 

import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List; 

public class Main extends JFrame implements ActionListener 
{Dimension bt20 = new Dimension(128,50);
	Dictionnaire dictionnaire; 
	JPanel Scrabble = new JPanel();
	JPanel tabPanel = new JPanel(); 
	JPanel labelPanel = new JPanel();
	JPanel grillePanel = new JPanel();
	JPanel JeuPanel = new JPanel();
	JLabel saclabel;
    JLabel joueurLabel = new JLabel("Joueur");
	JLabel[] jouerscores = new JLabel[5]; 
	JLabel presentation;
	JButton[] grilleButtons = new JButton[7];
	JButton[][] tabButtons = new JButton[15][15]; 
	JButton PlaceMot = new JButton("Placer"); 
	JButton annuler = new JButton("Annuler"); 
	JButton FinPlace = new JButton("Terminer");
	JButton ajoutJoueur = new JButton("Ajouter Joueur");
	Map xcoord = new HashMap();  
	Map ycoord = new HashMap(); 
	Placement placementActuel;
	int finGrille;
	Lettre lettre;
	static Scrabble mainj;
    int nbJoueur = 1;
	public Main()
	  {   this.setMinimumSize(new Dimension(800,800));
	  this.setLocationRelativeTo(null);
		mainj = new Scrabble();
	    tabPanel.setLayout(new GridLayout(15,15));
	    grillePanel.setLayout(new GridLayout(2,2));
	    grillePanel.setBackground(new Color(0, 90, 85));
	    JeuPanel.setBackground(new Color(0, 90, 85));
	    labelPanel.setBackground(new Color(0, 90, 85));
	    
        ajoutCases();
	    getContentPane().add(tabPanel, BorderLayout.CENTER); 
	    ajoutGrille();
        getContentPane().add(grillePanel, BorderLayout.SOUTH);
        ajoutlabel();
        getContentPane().add(labelPanel, BorderLayout.PAGE_START);
        getContentPane().add(JeuPanel, BorderLayout.EAST);
   Dictionnaire.dictionnaire();
	    addWindowListener(new WindowAdapter() 
	      { public void windowClosing(WindowEvent e) 
	        { 
	          System.exit(0);
	        }
	      }); 
	    
	  }
	//Ajout (affichage) des 7 Grilles 
	private void ajoutGrille()
	  { JPanel Panel1 = new JPanel();
	  JPanel btPanel = new JPanel();
	  
	  PlaceMot.addActionListener(this);
	  PlaceMot.setPreferredSize(bt20);
	  btPanel.add(PlaceMot);
	  
	  annuler.addActionListener(this);
	  annuler.setPreferredSize(bt20);
	  btPanel.add(annuler); 
	  
	  FinPlace.addActionListener(this);
	  FinPlace.setPreferredSize(bt20);
	  btPanel.add(FinPlace); 

	  ajoutJoueur.addActionListener(this);
	  ajoutJoueur.setPreferredSize(bt20);
	  btPanel.add(ajoutJoueur);
	  
	 Panel1.setBackground(new Color(0, 90, 85));
	 btPanel.setBackground(new Color(0, 90, 85));
	    for (int i = 0; i < 7; i++) 
	    { 
	    	JButton jb = new JButton("-"); 

	      jb.setPreferredSize(new Dimension(60,60));
	      xcoord.put(jb,new Integer(i)); 
	      jb.addActionListener(this);  
	      grilleButtons[i] = jb;
	      Panel1.add(jb);

	      jb.setEnabled(false); 
	    }
	    grillePanel.add(Panel1); 
	    grillePanel.add(btPanel);
	  }
	


	  

	
	private void ajoutlabel()
	  { JPanel lab = new JPanel();
	  JPanel score = new JPanel();
	  presentation = new JLabel("Masurao-Tensei");
	  presentation.setFont(new Font("Arial-Serif", Font.BOLD, 60));
	  presentation.setForeground(Color.white);
	    lab.add(presentation);  
	    lab.setBackground(new Color(0, 90, 85));
	    
	    labelPanel.add(lab); 
	    for (int i = 0; i < 2; i++) 
	    { JLabel jl = new JLabel("Joueur " + (i+1) + " Score");
	    jouerscores[i] = jl; 
	    jl.setFont(new Font("Arial-Serif", Font.BOLD, 16));
	    jl.setPreferredSize( new Dimension(150,80));
	    jl.setForeground(Color.white);
	    
	    score.add(jl);
	    } 
	    saclabel = new JLabel("SAC = " + mainj.getTailleSac()); 
	    jouerscores[4] = saclabel;
	    saclabel.setFont(new Font("Century", Font.ITALIC, 26));
	    saclabel.setForeground(Color.yellow);

	    saclabel.setPreferredSize( new Dimension(150,80));
	    score.add(saclabel);
	    JeuPanel.add(score);
	    score.setLayout(new GridLayout(5,1));
	    score.setBackground(new Color(0, 90, 85));
	  }  
private void videGrille() {
	for (int i = 0; i < 7; i++)
    { grilleButtons[i].setText("-");
      grilleButtons[i].setEnabled(false);
    }
	
}
	public Scrabble getMainj() {
	return mainj;
}
	private void ajoutCases()
	{ for (int j = 0; j < 15; j++) 
	  { for (int i = 0; i < 15; i++)
	    { JButton jb = new JButton();
	      xcoord.put(jb,new Integer(i)); 
	      ycoord.put(jb,new Integer(j));  
	      jb.addActionListener(this); 
	      tabButtons[i][j] = jb;
	     if(jb == tabButtons[7][7]) {
	    jb.setBackground(Color.ORANGE); 	 
	      jb.setLabel("*");
	     }
	     else {
	      jb.setBackground(mainj.getCaseAbdoulaye(i, j).getColor()); 
	      jb.setLabel(mainj.getCaseAbdoulaye(i, j).CaseAbdoulayeSymbol());
	      }
	     
	      jb.setBorder(new LineBorder(Color.LIGHT_GRAY/*new Color(196,232,222)*/,2));
	    
	      
	      tabPanel.add(jb);  
	    }
	  }
	}
	
	public void actionPerformed(ActionEvent e) 
	  {  Object event = e.getSource(); 
	    if (event instanceof JButton)
	    { JButton jb = (JButton) event;
	      String command = jb.getText();
	      if (command != null)
	      {
	        if (command.equals("Ajouter Joueur"))
	        { String nom = JOptionPane.showInputDialog("Entrer un nouveau nom"); 
	           mainj.nouveauJoueur(nom);
	          nbJoueur++;  
	          System.out.println(mainj.getSac().tailleSac());
if(mainj.getSac().tailleSac() == 0) {
	           mainj.getSac().remplirsac();
	           System.out.println(mainj.getSac().tailleSac());}
	          if (nbJoueur >= 2)
	          { ajoutJoueur.setEnabled(false); 
	          } actualisertab();
	          actualiseJoueurs();
	          return; 
	        }
	        if (command.equals("Placer"))
	        { mainj.placement();
	          Joueur j = mainj.getJoueur(); 
	          placementActuel = new Placement(j);  
	          
	          actualisertab();
	          ajoutJoueur.setEnabled(false); 
	          if (j instanceof Ai) 
	          { Placement pl = null; 
	            
	             AiPlaceEnpremier ai = new AiPlaceEnpremier(); 
	              pl = ai.place(mainj); 
	             
	            if (pl != null)
	            { mainj.finPlacement(pl); 
	            actualisertab(); 
	            placementActuel = null;
	              videGrille();
	            }
	          }
	        return;
	        } 
	        if (command.equals("Annuler"))
	        { actualisertab();
	        placementActuel = new Placement(mainj.getJoueur());
	          return;
	        }
	        if (command.equals("Terminer"))
	        { mainj.finPlacement(placementActuel);
	          actualisertab(); 
	          placementActuel = null;
	          videGrille();
	          return;
	        }
	      }
	      if (ycoord.get(jb) != null) 
	      { if (lettre == null || placementActuel == null) 
	        { System.err.println("Vous devez dabord choisir une lettre à placer"); } 
	        else 
	        { int x = ((Integer) xcoord.get(jb)).intValue(); 
	          int y = ((Integer) ycoord.get(jb)).intValue();
	          if (lettre.estJoker())
	          { String resp = 
	              JOptionPane.showInputDialog("Entrer une lettre pour le joker"); 
	          
	            if (resp != null && resp.length() > 0)
	            { lettre.setNom(resp.toUpperCase().charAt(0)+""); } 
	          }
	          Place pl = new Place(x,y,lettre); 
	          placementActuel.ajoutPlacementLettre(pl);  
	          tabButtons[x][y].setText(lettre.nom+""); 
	          tabButtons[x][y].setEnabled(false); 
	          grilleButtons[finGrille].setEnabled(false); 
	          lettre = null; 
	          finGrille = -1; 
	        } 
	      }
	      else if (xcoord.get(jb) != null)  
	      { Integer coord = (Integer) xcoord.get(jb); 
	        int x = coord.intValue(); 
	        lettre = mainj.getLettreGrille(x); 
	        finGrille = x; }
	    }
	  }
	
	     
	
	  
	public void actualisertab(){
		 FinPlace.setEnabled(false);	
		annuler.setEnabled(false);
		PlaceMot.setEnabled(false );	
		    if (nbJoueur >= 2) {
		    	FinPlace.setEnabled(true);	
				annuler.setEnabled(true);
				PlaceMot.setEnabled(true );
		    } 
		saclabel.setText("SAC = " + mainj.getTailleSac());
    	 for (int i = 0; i < 15; i++) 
	    { for (int j = 0; j < 15; j++) 
	      { CaseAbdoulaye caseAbdoulaye = mainj.getCaseAbdoulaye(i, j); 
	        JButton jb = tabButtons[i][j]; 
	        jb.setText(caseAbdoulaye.getText());
	        if (caseAbdoulaye.estOcupee())
	        { jb.setEnabled(false); 
	          jb.setBackground(Color.YELLOW); 
	        }
	  	     else {
	  	      jb.setText(caseAbdoulaye.CaseAbdoulayeSymbol());
	          jb.setBackground(caseAbdoulaye.getColor());
	          if(jb == tabButtons[7][7]) {jb.setBackground(Color.orange);
	          jb.setText("*");}
	          jb.setEnabled(true);
	        }
	      } 
	    }
	    Grille g = mainj.getGrille();
	    changeGrille(g);
	    actualiseJoueurs();
	    joueurLabel.setText("Joueur " + mainj.getJoueur().getNom()); 
	   
	  }
	
	private void changeGrille(Grille g)
	  { int i;
	 // Imagedefond imfond = new Imagedefond();
	  //ImageIcon icon = new ImageIcon("");
	  String l;
	    for (i = 0; i < g.tailleGrille(); i++)
	    { Lettre lt = g.getLettre(i);
	    l = ""+lt.nom;
	grilleButtons[i].setText(l);
		      grilleButtons[i].setToolTipText("score = " + lt.getValeur()); 
		
	    
	      grilleButtons[i].setEnabled(true);
	    }
	    for (; i < 7; i++)
	    { grilleButtons[i].setText("-");
	    
	      grilleButtons[i].setEnabled(false);
	    }
	  }
	private void actualiseJoueurs()
	  { List joueur = mainj.getJoueurs();
	    int nbJoueurs = joueur.size();
	    if (nbJoueurs > 2)
	    { nbJoueurs = 2; }  
	    for (int i = 0; i < nbJoueurs; i++)
	    { Joueur j = (Joueur) joueur.get(i); 
	      jouerscores[i].setText(j.getNom() + " score: " +  j.getScore()); 
	    }
	  }

	public static void main(String[] args) 
	  { Main window; 
	     window = new Main(); 
	  window.setTitle("SCRABBLE Masurao"); 
	    window.setSize(800, 800);
	    window.setVisible(true); 
	  }
	
}
