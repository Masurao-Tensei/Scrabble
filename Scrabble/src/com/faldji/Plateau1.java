package com.faldji;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Plateau1 extends JFrame {
	
	public Plateau1(){
		//définit un titre
		this.setTitle("Plateau de scrabble");
		//rend visible la fenêtre
		this.setVisible(true);
		//définit la taille
		this.setSize(1000, 1000);
		//positionne au centre
		this.setLocationRelativeTo(null);
		//ferme la fenêtre avec la croix
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ajoute les carrés de la classe case
		this.setContentPane(new Case());
		
		
		
	}    
	      
}
