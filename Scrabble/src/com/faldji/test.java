package com.faldji;
import javax.swing.*;
import javax.swing.border.LineBorder;

import com.faldji.jetons.Imagedefond;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List; 

public class test extends JFrame implements ActionListener 
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
	Main main;
    int nbJoueur = 0;
	public test()
	  {   this.setMinimumSize(new Dimension(800,800));
	  this.setLocationRelativeTo(null);
		main = new Main();
	    tabPanel.setLayout(new GridLayout(15,15));
	    grillePanel.setLayout(new GridLayout(2,2));
	    grillePanel.setBackground(new Color(0, 90, 85));
	    JeuPanel.setBackground(new Color(0, 90, 85));
	    labelPanel.setBackground(new Color(0, 90, 85));
	   
        getContentPane().add(labelPanel, BorderLayout.PAGE_START);
	    getContentPane().add(tabPanel, BorderLayout.CENTER); 
        getContentPane().add(grillePanel, BorderLayout.SOUTH);
        getContentPane().add(JeuPanel, BorderLayout.EAST);
        
	    ajoutCases(); 
	    ajoutGrille();
	    ajoutlabel();
        


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
	  
	  annuler.addActionListener(this);
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
	    saclabel = new JLabel("SAC = " + main.getTailleSac()); 
	    jouerscores[4] = saclabel;
	    saclabel.setFont(new Font("Century", Font.ITALIC, 26));
	    saclabel.setForeground(Color.yellow);

	    saclabel.setPreferredSize( new Dimension(150,80));
	    score.add(saclabel);
	    JeuPanel.add(score);
	    score.setLayout(new GridLayout(5,1));
	    score.setBackground(new Color(0, 90, 85));
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
	      jb.setBackground(main.getCaseAbdoulaye(i, j).getColor()); 
	      jb.setLabel(main.getCaseAbdoulaye(i, j).CaseAbdoulayeSymbol());
	      }
	     
	      jb.setBorder(new LineBorder(Color.LIGHT_GRAY/*new Color(196,232,222)*/,2));
	    
	      
	      tabPanel.add(jb);  
	    }
	  }
	}
	
	public void actionPerformed(ActionEvent e) 
	  { Object eventSource = e.getSource(); 
	  if (eventSource instanceof JButton)
	    { JButton b = (JButton) eventSource;
	      String exe = b.getText();
	      if (exe != null)
	      {
	        if (exe.equals("Placer")) {
	        	JOptionPane.showMessageDialog(this, "LE SAC EST DEP DEP"); 
	    main.getSac().remplirsac();
	    
        Joueur j = main.getJoueur(); 
        main.placement();
	        	actualisertab();
	        	}
	        }
	      if (exe.equals("Ajouter Joueur"))
	        { String nom = 
	            JOptionPane.showInputDialog("ENTRER votre nom"); 
	          main.nouveauJoueur(nom);
	          nbJoueur++;  
	          if (nbJoueur >= 2)
	          { b.setEnabled(false); } 
	          actualiseJoueurs(); 
	          return; 
	        }
	     
	}
	  }
	public void actualisertab(){
		saclabel.setText("SAC = " + main.getTailleSac());
    	Grille g = main.getGrille();
        changeGrille(g); 
	    joueurLabel.setText("Joueur " + main.getJoueur().getNom()); 
	    actualiseJoueurs();
	}
	private void changeGrille(Grille g)
	  { int i;
	  Imagedefond imfond = new Imagedefond();
	  ImageIcon icon = new ImageIcon("");
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
	  { List joueur = main.getJoueurs();
	    int nbJoueurs = joueur.size();
	    if (nbJoueurs > 2)
	    { nbJoueurs = 2; }  
	    for (int i = 0; i < nbJoueurs; i++)
	    { Joueur j = (Joueur) joueur.get(i); 
	      jouerscores[i].setText(j.getNom() + " score: " +  j.getScore()); 
	    }
	  }

	public static void main(String[] args) 
	  { test window; 
	     window = new test(); 
	  window.setTitle("SCRABBLE"); 
	    window.setSize(800, 800);
	    window.setVisible(true); 
	  }
	
}
