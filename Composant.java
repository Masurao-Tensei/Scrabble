package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class Composant extends JPanel{

	
	public void paintComponent(Graphics f){
		Graphics2D fond=(Graphics2D)f;
		GradientPaint fd= new GradientPaint(100,100, Color.GREEN, 300, 300, Color.black, true);
		fond.setPaint(fd);
		fond.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		
		try {
			Image img = ImageIO.read(new File("scrabble.png"));
			f.drawImage(img, 300, 250, this);
			
		
	} catch (IOException e){
		e.printStackTrace();
	}
	}
}