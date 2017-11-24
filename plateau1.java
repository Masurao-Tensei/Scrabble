package projet;

import javax.swing.JFrame;

public class plateau1 extends JFrame {
	
	public plateau1(){
		//définit un titre
		this.setTitle("Plateau de scrabble");
		//rend visible la fenêtre
		this.setVisible(true);
		//définit la taille de la fenetre par defaut
		this.setSize(1100, 1100);
		//positionne au centre
		this.setLocationRelativeTo(null);
		//ferme la fenêtre avec la croix
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ajoute les carrés de la classe case
		this.setContentPane(new Case());
		
		
		
	}    
	      
}
