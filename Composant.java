package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Composant extends JPanel{
	
	public void paintComponent(Graphics f){

		Graphics2D fond=(Graphics2D)f;
		
		GradientPaint fd= new GradientPaint(100,100, Color.GREEN, 300, 300, Color.black, true);
		fond.setPaint(fd);
		fond.fillRect(0, 0, this.getWidth(), this.getHeight());
		try {
		Image img = ImageIO.read(new File("scrabble.png"));
		
		int largeur= getWidth();
		int longueur= getHeight();
		 
		Double scaleWidth = new Double(largeur) / new Double(img.getWidth(null));
		Double scaleHeight = new Double(longueur) / new Double(img.getHeight(null));
		if (scaleWidth > scaleHeight)
			scaleWidth = scaleHeight;
		else
			scaleHeight = scaleWidth;
		int x = (int) (((largeur - (img.getWidth(null)*scaleWidth))/2));
		int y = (int) ((longueur - (img.getHeight(null)*scaleHeight))/2);
		
		fond.translate(x, y);
		
		fond.scale(scaleWidth, scaleHeight);
		fond.drawImage(img, 0, 0, this);
		
		} catch (IOException e){
			e.printStackTrace();
		}
		/*try {
			Image img = ImageIO.read(new File("scrabble.png"));
			f.drawImage(img, 0, 0, this);
					
	} catch (IOException e){
		e.printStackTrace();
	}*/
	}
}