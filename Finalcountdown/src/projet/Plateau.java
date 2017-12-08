package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Plateau extends JFrame{
	
		Dimension base = new Dimension(120,30);
		JButton PlaceMot = new JButton("Placer"); 
		JButton Annuler = new JButton("Annuler"); 
		JButton FinPlace = new JButton("Terminer");
		JButton AjoutJoueur = new JButton("Ajouter Joueur");
		JButton Change = new JButton("Changer les lettres");
		JButton Retour = new JButton("Retour"); 
		JButton[] grilleBoutons = new JButton[7];
		JLabel[] tabjoueurs = new JLabel[5]; 
		JPanel grillePanel = new JPanel();
		JPanel PanelInfos = new JPanel();
		JPanel c =new Case();
		
	public Plateau(){

		this.setTitle("Plateau de scrabble");
		this.setMinimumSize(new Dimension(1200,750));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 c.setBorder(new LineBorder(Color.BLACK,2));
		 grillePanel.setLayout(new GridLayout(2,2));
		 PanelInfos.setBackground(new Color(0, 90, 15));
		 
		 getContentPane().add(c ,BorderLayout.CENTER);
		 getContentPane().add(grillePanel, BorderLayout.SOUTH);
		 getContentPane().add(PanelInfos, BorderLayout.EAST);
		 
		 ajoutPanel();
		 ajoutPanInformations();
			 
		 this.setVisible(true);
		}
			

	//////////
	private void ajoutPanel(){
	  JPanel Panmain = new JPanel();
	  JPanel Panbouton = new JPanel();
	  
	  PlaceMot.setPreferredSize(base);
	  Panbouton.add(PlaceMot);
	  Annuler.setPreferredSize(base);
	  Panbouton.add(Annuler); 
	  FinPlace.setPreferredSize(base);
	  Panbouton.add(FinPlace); 
	  AjoutJoueur.setPreferredSize(base);
	  Panbouton.add(AjoutJoueur);
	  Change.setPreferredSize(new Dimension(150,30));
	  Panbouton.add(Change);
	  Retour.setPreferredSize(base);
	  Panbouton.add(Retour);
	  
	  Panmain.setBackground(new Color(0, 90, 15));
	  Panbouton.setBackground(new Color(0, 90, 15));
	 	
	  for (int i = 0; i < 7; i++) 
	    { 
	    	JButton setmain = new JButton("Vide"); 

	    	setmain.setPreferredSize(new Dimension(60,40));
	    	grilleBoutons[i] = setmain;
	    	Panmain.add(setmain);

	    	setmain.setEnabled(false); 
	    }
	  grillePanel.add(Panmain); 
	  grillePanel.add(Panbouton);
	}
	
	//////////
	private void ajoutPanInformations(){
		JPanel Paneljoueurs = new JPanel();
		
		JLabel haut = new JLabel("Le jeu du Scrabble ");
		haut.setFont(new Font("Arial", Font.BOLD, 40));
		haut.setForeground(Color.white);
		haut.setBackground(new Color(0, 90, 15));
		
		haut.setLayout(new GridLayout(4,1));
		Paneljoueurs.add(haut);
		
		for (int i = 0; i < 2; i++) 
	    	{ 
			JLabel j = new JLabel("Joueur " + (i+1) + " : score à zéro");
			tabjoueurs[i] = j; 
			j.setFont(new Font("Arial", Font.BOLD, 16));
			j.setForeground(Color.WHITE);
			j.setPreferredSize( new Dimension(550,80));
			Paneljoueurs.add(j);
	    	}
	    
	   JLabel Sac = new JLabel("Pour l'instant le sac est vide " /*+ main.getTailleSac()*/); 
	   tabjoueurs[4] = Sac;
	   Sac.setFont(new Font("Arial", Font.BOLD, 16));
	   Sac.setForeground(Color.WHITE);
	   Sac.setPreferredSize(new Dimension(550,80));
	   
	   Paneljoueurs.add(Sac);	
	   
	   Paneljoueurs.setLayout(new GridLayout(4,1));
	   Paneljoueurs.setBackground(new Color(0, 90, 15));
	  
	   PanelInfos.add(Paneljoueurs);
	}
	
	/////////////

	public void actionPerformed(ActionEvent arg0) 
	  { 
	 
	      //if (exe.equals("Ajouter Joueur"))
	        { String nom = 
	            JOptionPane.showInputDialog("Entrer votre nom"); 
	         /* main.nouveauJoueur(nom);
	          nbJoueur++;  
	          if (nbJoueur >= 2)
	          { b.setEnabled(false); } 
	          actualiseJoueurs(); 
	          return; */
	        }
	      if (arg0.getSource() == Retour)
	      {
	    	  Menu m2 = new Menu();
	      }
	     }
	  
	
	///////////
	public class Case extends JPanel{
		
		public Case(){
			setBackground(new Color(25, 90, 40));
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			
			Graphics2D g2d = (Graphics2D)g;
			List <Graphics> tab= new  ArrayList <Graphics>();
			
			for(int i=1; i<=15; i++){
				for(int j=1; j<=15; j++){
					int x=1+(36*j);
					int y=1+(36*i);
					g.drawRect(x, y, 36, 36);
					tab.add(g);
					
				}	
			}
			
			///// rang1 //////
			GradientPaint gp = new  GradientPaint(50,50, Color.RED, 125, 75, Color.RED, true);
			g2d.setPaint(gp);
			g2d.fillRect(38, 38, 35, 35); //x, y, xplus, yplus
			GradientPaint gp2 = new  GradientPaint(40, 75, Color.CYAN, 80, 55, Color.CYAN, true);
			g2d.setPaint(gp2);
			g2d.fillRect(146, 38, 35, 35);
			GradientPaint gp3 = new  GradientPaint(0,0, Color.RED, 101, 10, Color.RED, true);
			g2d.setPaint(gp3);
			g2d.fillRect(290, 38, 35, 35);
			GradientPaint gp4 = new  GradientPaint(101,47, Color.CYAN, 0, 0, Color.CYAN, true);
			g2d.setPaint(gp4);
			g2d.fillRect(434, 38, 35, 35);
			GradientPaint gp5 = new  GradientPaint(125,75, Color.RED, 10, 0, Color.RED, true);
			g2d.setPaint(gp5);
			g2d.fillRect(542, 38, 35, 35);
			
			///// 2e rang //////
			GradientPaint gp11 = new  GradientPaint(0,0, Color.MAGENTA, 101, 10, Color.MAGENTA, true);
			g2d.setPaint(gp11);
			g2d.fillRect(74, 74, 35, 35); //x, y, xplus, yplus
			GradientPaint gp12 = new  GradientPaint(101,47, Color.BLUE, 0, 0, Color.BLUE, true);
			g2d.setPaint(gp12);
			g2d.fillRect(218, 74, 35, 35);
			GradientPaint gp13 = new  GradientPaint(0,0, Color.BLUE, 101, 10, Color.BLUE, true);
			g2d.setPaint(gp13);
			g2d.fillRect(362, 74, 35, 35);
			GradientPaint gp14 = new  GradientPaint(101,47, Color.MAGENTA, 0, 0, Color.MAGENTA, true);
			g2d.setPaint(gp14);
			g2d.fillRect(506, 74, 35, 35);
			
			///// 3e rang /////
			GradientPaint gp21 = new  GradientPaint(0,0, Color.MAGENTA, 101, 10, Color.MAGENTA, true);
			g2d.setPaint(gp21);
			g2d.fillRect(110, 110, 35, 35); //x, y, xplus, yplus
			GradientPaint gp22 = new  GradientPaint(101,47, Color.CYAN, 0, 0, Color.CYAN, true);
			g2d.setPaint(gp22);
			g2d.fillRect(254, 110, 35, 35);
			GradientPaint gp23 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
			g2d.setPaint(gp23);
			g2d.fillRect(326, 110, 35, 35);
			GradientPaint gp24 = new  GradientPaint(101,47, Color.MAGENTA, 0, 0, Color.MAGENTA, true);
			g2d.setPaint(gp24);
			g2d.fillRect(470, 110, 35, 35);
			
			///// 4e rang /////
			GradientPaint gp31 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
			g2d.setPaint(gp31);
			g2d.fillRect(38, 146, 35, 35); //x, y, xplus, yplus
			GradientPaint gp32 = new  GradientPaint(101,47, Color.MAGENTA, 0, 0, Color.MAGENTA, true);
			g2d.setPaint(gp32);
			g2d.fillRect(146, 146, 35, 35);
			GradientPaint gp33 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
			g2d.setPaint(gp33);
			g2d.fillRect(290, 146, 35, 35);
			GradientPaint gp34 = new  GradientPaint(101,47, Color.MAGENTA, 0, 0, Color.MAGENTA, true);
			g2d.setPaint(gp34);
			g2d.fillRect(434, 146, 35, 35);
			GradientPaint gp35 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
			g2d.setPaint(gp35);
			g2d.fillRect(542, 146, 35, 35);
			
			///// 5e rang /////
			GradientPaint gp40 = new  GradientPaint(101,47, Color.MAGENTA, 0, 0, Color.MAGENTA, true);
			g2d.setPaint(gp40);
			g2d.fillRect(182, 182, 35, 35);
			
			g2d.setPaint(gp40);
			g2d.fillRect(398, 182, 35, 35);
			
			///// 6e rang /////
			GradientPaint gp51 = new  GradientPaint(0,0, Color.BLUE, 101, 10, Color.BLUE, true);
			g2d.setPaint(gp51);
			g2d.fillRect(74, 218, 35, 35); //x, y, xplus, yplus
			GradientPaint gp52 = new  GradientPaint(101,47, Color.BLUE, 0, 0, Color.BLUE, true);
			g2d.setPaint(gp52);
			g2d.fillRect(218, 218, 35, 35);
			GradientPaint gp53 = new  GradientPaint(0,0, Color.BLUE, 101, 10, Color.BLUE, true);
			g2d.setPaint(gp53);
			g2d.fillRect(362, 218, 35, 35);
			GradientPaint gp54 = new  GradientPaint(101,47, Color.BLUE, 0, 0, Color.BLUE, true);
			g2d.setPaint(gp54);
			g2d.fillRect(506, 218, 35, 35);
			
			///// 7e rang /////
			GradientPaint gp61 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
			g2d.setPaint(gp61);
			g2d.fillRect(110, 254, 35, 35); //x, y, xplus, yplus
			GradientPaint gp62 = new  GradientPaint(101,47, Color.CYAN, 0, 0, Color.CYAN, true);
			g2d.setPaint(gp62);
			g2d.fillRect(254, 254, 35, 35);
			GradientPaint gp63 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
			g2d.setPaint(gp63);
			g2d.fillRect(326, 254, 35, 35);
			GradientPaint gp64 = new  GradientPaint(101,47, Color.CYAN, 0, 0, Color.CYAN, true);
			g2d.setPaint(gp64);
			g2d.fillRect(470, 254, 35, 35);
			
			///// 8e rang /////
			
			g2d.setPaint(gp);
			g2d.fillRect(38, 290, 35, 35); 
			
			g2d.setPaint(gp2);
			g2d.fillRect(146, 290, 35, 35);
			
			g2d.setPaint(gp21);
			g2d.fillRect(290, 290, 35, 35);
			
			g2d.setPaint(gp4);
			g2d.fillRect(434, 290, 35, 35);
			
			g2d.setPaint(gp5);
			g2d.fillRect(542, 290, 35, 35);
			
			///// 9e rang /////
			
			g2d.setPaint(gp61);
			g2d.fillRect(110, 326, 35, 35); 
			
			g2d.setPaint(gp62);
			g2d.fillRect(254, 326, 35, 35);
			
			g2d.setPaint(gp63);
			g2d.fillRect(326, 326, 35, 35);
			
			g2d.setPaint(gp64);
			g2d.fillRect(470, 326, 35, 35);
			
			///// 10e rang /////
			g2d.setPaint(gp51);
			g2d.fillRect(74, 362, 35, 35); 
			
			g2d.setPaint(gp52);
			g2d.fillRect(218, 362, 35, 35);
			
			g2d.setPaint(gp53);
			g2d.fillRect(362, 362, 35, 35);

			g2d.setPaint(gp54);
			g2d.fillRect(506, 362, 35, 35);
			
			///// 11e rang /////
			
			g2d.setPaint(gp40);
			g2d.fillRect(182, 398, 35, 35);
			
			g2d.setPaint(gp40);
			g2d.fillRect(398, 398, 35, 35);
			
			///// 12e rang /////
			
			g2d.setPaint(gp31);
			g2d.fillRect(38, 434, 35, 35); 
			
			g2d.setPaint(gp32);
			g2d.fillRect(146, 434, 35, 35);
			
			g2d.setPaint(gp33);
			g2d.fillRect(290, 434, 35, 35);
			
			g2d.setPaint(gp34);
			g2d.fillRect(434, 434, 35, 35);
			
			g2d.setPaint(gp35);
			g2d.fillRect(542, 434, 35, 35);
			
			///// 13e rang /////
			
			g2d.setPaint(gp21);
			g2d.fillRect(110, 470, 35, 35); 
			
			g2d.setPaint(gp22);
			g2d.fillRect(254, 470, 35, 35);
			
			g2d.setPaint(gp23);
			g2d.fillRect(326, 470, 35, 35);
			
			g2d.setPaint(gp24);
			g2d.fillRect(470, 470, 35, 35);
			
			///// 14e rang /////
			
			g2d.setPaint(gp11);
			g2d.fillRect(74, 506, 35, 35); 
			
			g2d.setPaint(gp12);
			g2d.fillRect(218, 506, 35, 35);
			
			g2d.setPaint(gp13);
			g2d.fillRect(362, 506, 35, 35);
			
			g2d.setPaint(gp14);
			g2d.fillRect(506, 506, 35, 35);
			
			////// 15e rang /////
			
			g2d.setPaint(gp);
			
			g2d.fillRect(38, 542, 35, 35); 
			
			
			g2d.setPaint(gp2);
			g2d.fillRect(146, 542, 35, 35);
			
			
			g2d.setPaint(gp3);
			g2d.fillRect(290, 542, 35, 35);
			
			g2d.setPaint(gp4);
			g2d.fillRect(434, 542, 35, 35);
			
			g2d.setPaint(gp5);
			g2d.fillRect(542, 542, 35, 35);
			
			
			
			////////////// COULEUR /////////////
			g.setColor(Color.black);
			
			//légende
			//g.drawString("L pour lettre", 101, 33);
			
			////// case rouge //////
			g.drawString("Mot x3", 39, 60);
			g.drawString("Mot x3", 291, 60);
			g.drawString("Mot x3", 543, 60);
			
			g.drawString("Mot x3", 39, 312);
			g.drawString("Mot x3", 543, 312);
			
			g.drawString("Mot x3", 39, 564);
			g.drawString("Mot x3", 291, 564);
			g.drawString("Mot x3", 543, 564);
			
			////// case cyan //////
			g.drawString("L  x2", 150, 60);
			g.drawString("L  x2", 438, 60);
			
			g.drawString("L  x2", 258, 132);//y+22
			g.drawString("L  x2", 330, 132);
			
			g.drawString("L  x2", 42, 166);
			g.drawString("L  x2", 294, 166);
			g.drawString("L  x2", 546, 166);
			
			g.drawString("L  x2", 114, 276);
			g.drawString("L  x2", 258, 276);
			g.drawString("L  x2", 330, 276);
			g.drawString("L  x2", 474, 276);
			
			g.drawString("L  x2", 148, 312);
			g.drawString("L  x2", 438, 312);
			
			g.drawString("L  x2", 114, 348);
			g.drawString("L  x2", 258, 348);
			g.drawString("L  x2", 330, 348);
			g.drawString("L  x2", 474, 348);
			
			g.drawString("L  x2", 42, 456);
			g.drawString("L  x2", 294, 456);
			g.drawString("L  x2", 546, 456);
			
			g.drawString("L  x2", 258, 492);
			g.drawString("L  x2", 330, 492);
			
			g.drawString("L  x2", 150, 564);
			g.drawString("L  x2", 438, 564);
			
			////// case magenta ///////
			g.drawString("Mot x2", 75, 96);
			g.drawString("Mot x2", 507, 96);
			
			g.drawString("Mot x2", 111, 132);
			g.drawString("Mot x2", 471, 132);
			
			g.drawString("Mot x2", 147, 166);
			g.drawString("Mot x2", 435, 166);
			
			g.drawString("Mot x2", 183, 202);
			g.drawString("Mot x2", 399, 202);
			//
			g.drawString("Mot x2", 183, 420);
			g.drawString("Mot x2", 399, 420);
			
			g.drawString("Mot x2", 147, 456);
			g.drawString("Mot x2", 435, 456);
			
			g.drawString("Mot x2", 111, 492);
			g.drawString("Mot x2", 471, 492);
			
			g.drawString("Mot x2", 75, 528);
			g.drawString("Mot x2", 507, 528);
			
			////// case bleu ///////
			g.drawString("L  x3", 222, 96);
			g.drawString("L  x3", 366, 96);
			
			g.drawString("L  x3", 77, 238);
			g.drawString("L  x3", 222, 238);
			g.drawString("L  x3", 366, 238);
			g.drawString("L  x3", 509, 238);
			
			g.drawString("L  x3", 77, 384);
			g.drawString("L  x3", 222, 384);
			g.drawString("L  x3", 366, 384);
			g.drawString("L  x3", 509, 384);
			
			g.drawString("L  x3", 222, 528);
			g.drawString("L  x3", 366, 528);
		   
		  }
		
	}
	}

	
  


