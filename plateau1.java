package projet;

import javax.swing.JFrame;

public class plateau1 extends JFrame {
	
	public plateau1(){
		//d�finit un titre
		this.setTitle("Plateau de scrabble");
		//rend visible la fen�tre
		this.setVisible(true);
		//d�finit la taille
		this.setSize(1000, 1000);
		//positionne au centre
		this.setLocationRelativeTo(null);
		//ferme la fen�tre avec la croix
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ajoute les carr�s de la classe case
		this.setContentPane(new Case());
		
		
		
	}    
	      
}
