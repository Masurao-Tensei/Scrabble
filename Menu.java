package projet;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {

	private Bouton bouton = new Bouton("Jouer");
	private Bouton bouton2 = new Bouton("Jouer contre une IA");
	private Bouton bouton3 = new Bouton("Règles");
	
	private Composant c = new Composant();
	//fenêtre du Menu
	private JPanel contient = new JPanel();
	
	private JPanel b1 = new JPanel();
	private JPanel b2 = new JPanel();
	
	
	public Menu(){
		this.setTitle("Menu du scrabble");
		this.setVisible(true);
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//// BoxLayout /////
		
		bouton.setMaximumSize(new Dimension(4000, 400));
		bouton.setMinimumSize(new Dimension(4000, 200));
		bouton.setPreferredSize(new Dimension(333, 40));
		
		bouton2.setMaximumSize(new Dimension(4000, 400));
		bouton2.setMinimumSize(new Dimension(4000, 40));
		bouton2.setPreferredSize(new Dimension(333, 40));
		
		bouton3.setMaximumSize(new Dimension(4000, 400));
		bouton3.setMinimumSize(new Dimension(4000, 40));
		bouton3.setPreferredSize(new Dimension(333, 40));
		
		b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	    b1.add(c);
		
		b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
	    b2.add(bouton);
	    b2.add(bouton2);
	    b2.add(bouton3);
	    
	    contient.setLayout(new BoxLayout(contient, BoxLayout.PAGE_AXIS));
	    contient.add(b1);
	    contient.add(b2);
		
		contient.add(c);
		ButtonGroup groupe= new ButtonGroup();
		groupe.add(bouton);
		groupe.add(bouton2);
		groupe.add(bouton3);
		
		contient.add(bouton);
		contient.add(bouton2);
		contient.add(bouton3);
		
		 this.getContentPane().add(contient);

		bouton.addActionListener(this);
		bouton2.addActionListener(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0 == null){
			Regles r = new Regles();
		}
		else{ plateau1 plateau = new plateau1();}		
	}
}
