package projet;

import javax.swing.JFrame;

public class Regles extends JFrame{
	
	public Regles(){
		this.setTitle("Règles du jeu");
		this.setVisible(true);
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new Ecriture());
		
	}		
}
