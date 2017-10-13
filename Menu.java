package projet;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame {

	private Bouton bouton = new Bouton("Jouer");
	private Composant c = new Composant();
	private JPanel contient = new JPanel();
	
	public Menu(){
		this.setTitle("Menu du scrabble");
		this.setVisible(true);
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		contient.setLayout(new BorderLayout());
		contient.add(c,  BorderLayout.CENTER);
		contient.add(bouton, BorderLayout.SOUTH);
		this.setContentPane(contient);

		//this.setContentPane(new Composant());
	}
}
