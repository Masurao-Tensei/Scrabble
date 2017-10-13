package projet;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JButton;

public class Bouton extends JButton {
	  private String nom;
	  public Bouton(String c){
	    super(c);
	    this.nom = c;
	  }
	        
	  public void paintComponent(Graphics f){
	    Graphics2D fond = (Graphics2D)f;
	    GradientPaint fd = new GradientPaint(175, 95, Color.GREEN, 335, 300, Color.black, true);
	    fond.setPaint(fd);
	    fond.fillRect(0, 0, this.getWidth(), this.getHeight());
	    fond.setColor(Color.black);
	    fond.drawString(this.nom, this.getWidth() / 2, (this.getHeight() / 2) + 5);
	  }  
	
}
