package projet;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test {
	
	public static void main(String[] args) /*throws FileNotFoundException*/{
		//Plateau p = new Plateau();
		Menu m = new Menu();
		
		/*JFrame fenetre = new JFrame("Règles du jeu");
		Scanner user_input = new Scanner(System.in);
		String all = new Scanner(new File("regles.txt")).useDelimiter("\\A").next();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textArea = new JTextArea(10,20);
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		fenetre.setBackground(new Color(25, 90, 40));
		fenetre.add(scroll);
		fenetre.setSize(1200,750);
		fenetre.setVisible(true);
		fenetre.setLocationRelativeTo(null);
		
		textArea.setText(all);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		
		fenetre.add(scroll);*/
	}
}
