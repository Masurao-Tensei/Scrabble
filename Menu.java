package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener {

	private Bouton bouton = new Bouton("Jouer");
	private Bouton bouton2 = new Bouton("Jouer contre une IA");
	private Bouton bouton3 = new Bouton("Règles");
	private Composant c = new Composant();
	private JPanel contient = new JPanel();
	
	private JPanel b = new JPanel();
	private JPanel b1 = new JPanel();
	private JPanel b2 = new JPanel();
	private JPanel b3 = new JPanel();
	
	
	public Menu(){
		this.setTitle("Menu du scrabble");
		this.setVisible(true);
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//// BoxLayout /////
		
		/*b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	    b1.add(c);
		
		b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
	    b2.add(bouton);
	    b2.add(bouton2);
	    b2.add(bouton3);
	    
	    contient.setLayout(new BoxLayout(contient, BoxLayout.PAGE_AXIS));
	    contient.add(b1);
	    contient.add(b2);*/
		
		//// BorderLayout ////
		
		contient.setLayout(new BorderLayout());
		contient.add(c,  BorderLayout.CENTER);
		
	
		contient.add(bouton, BorderLayout.SOUTH);
		//contient.add(bouton2, BorderLayout.SOUTH);
		//contient.add(bouton3, BorderLayout.SOUTH);
		
		//// GridBagLayout ////
		
		/*b.setPreferredSize(new Dimension(300, 300));
		b.setBackground(Color.YELLOW);
		b1.setPreferredSize(new Dimension(300, 300));
		b1.setBackground(Color.RED);
		b2.setPreferredSize(new Dimension(300, 300));
		b2.setBackground(Color.BLUE);
		b3.setPreferredSize(new Dimension(300, 300));
		b3.setBackground(Color.GREEN);
		
		
		contient.setPreferredSize(new Dimension(1000, 1000));
	    contient.setBackground(Color.WHITE);
		contient.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
	    //gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
	    contient.add(b, gbc);
	    
	    
	    gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    contient.add(b1, gbc);
	    
	    gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    contient.add(b2, gbc);
	    
	    gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    contient.add(b3, gbc);*/
	    
	    
	    
		
		
		this.setContentPane(contient);

		bouton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		plateau1 plateau = new plateau1();
		
	}
}
