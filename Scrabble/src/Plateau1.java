

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Plateau1 extends JFrame {
	
	
		String tab[][]= { {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
			};
	
	
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
	
	public void plateauconsole(String tab[][]){
		
		
		
		for(int i=0;i<15;i++){
			
			for(int j=0;j<15;j++){
			System.out.print(tab[i][j]+"  |");	
			}
			
			System.out.println("\n---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
		}
	}



boolean vide(String[][] t) {
	int n = 0;
	for (int i = 0; i < 15; i++) {
		for (int j = 0; j < 15; j++) {
			if (t[i][j] != " ") {
				n = 1;
			}
		}
	}
	if (n == 1)
		return false;
	else
		return true;
}
	      
}
