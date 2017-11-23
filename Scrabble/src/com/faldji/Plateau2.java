
/*import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;*/

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*import javax.swing.JPanel;
import javax.swing.table.TableColumn;*/

public class Plateau2 extends JFrame {
	
	 /* private JTable tableau;
	  private JButton change = new JButton("Changer la taille");
	  private JButton retablir = new JButton("Rétablir");*/
	
	public Plateau2(){
		this.setTitle("Plateau de scrabble");
		this.setSize(1400, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	Object[][] data = {
	      {"bla  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", " " },
	      {" bla  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", " " },
	      {" bla ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", " " },
	      {" bla ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", " " },
	      {"  bla", "  ", "  ", "  ", "  ", "  ", "  ", "  ", " " },
	      
	    };
	
	
	    String  title[] = {" 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 "};
	    JTable tableau = new JTable(data, title);
	    
	   /* JPanel pan = new JPanel();

	    change.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {            
	        changeSize(200, 80);
	        change.setEnabled(false);
	        retablir.setEnabled(true);
	      }         
	    });

	    retablir.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {

	        changeSize(75, 16);
	        change.setEnabled(true);
	        retablir.setEnabled(false);
	      }         
	    });

	    retablir.setEnabled(false);
	    pan.add(change);
	    pan.add(retablir);

	    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	    this.getContentPane().add(pan, BorderLayout.SOUTH);
	  }
	   
	  
	  public void changeSize(int width, int height){
	    //Nous créons un objet TableColumn afin de travailler sur notre colonne
	    TableColumn col;
	    for(int i = 0; i < tableau.getColumnCount(); i++){
	      if(i == 1){
	        //On récupère le modèle de la colonne
	        col = tableau.getColumnModel().getColumn(i);
	        //On lui affecte la nouvelle valeur
	        col.setPreferredWidth(width);
	      }
	    }            
	    for(int i = 0; i < tableau.getRowCount(); i++){
	      //On affecte la taille de la ligne à l'indice spécifié !
	      if(i == 1)
	        tableau.setRowHeight(i, height);
	      }
	    }*/
	    
	    this.getContentPane().add(new JScrollPane(tableau));   
	}     
}


