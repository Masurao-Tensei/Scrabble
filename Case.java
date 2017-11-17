package projet;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Case extends JPanel {

	
	public void paintComponent(Graphics g){
		
		Graphics2D g2d = (Graphics2D)g;
		List <Graphics> tab= new  ArrayList <Graphics>();
		
		for(int i=1; i<=15; i++){
			for(int j=1; j<=15; j++){
				int x=55+(45*j);
				int y=1+(45)*i;
				g.drawRect(x, y, 45, 45);
				tab.add(g);
				
			}	
		}
		
		///// rang1 //////
		GradientPaint gp = new  GradientPaint(50,50, Color.RED, 125, 75, Color.RED, true);
		g2d.setPaint(gp);
		g2d.fillRect(101, 47, 44, 44); //x, y, xplus, yplus
		GradientPaint gp2 = new  GradientPaint(40, 75, Color.CYAN, 80, 55, Color.CYAN, true);
		g2d.setPaint(gp2);
		g2d.fillRect(236, 47, 44, 44);
		GradientPaint gp3 = new  GradientPaint(0,0, Color.RED, 101, 10, Color.RED, true);
		g2d.setPaint(gp3);
		g2d.fillRect(416, 47, 44, 44);
		GradientPaint gp4 = new  GradientPaint(101,47, Color.CYAN, 0, 0, Color.CYAN, true);
		g2d.setPaint(gp4);
		g2d.fillRect(596, 47, 44, 44);
		GradientPaint gp5 = new  GradientPaint(125,75, Color.RED, 10, 0, Color.RED, true);
		g2d.setPaint(gp5);
		g2d.fillRect(731, 47, 44, 44);
		
		///// 2e rang //////
		GradientPaint gp11 = new  GradientPaint(0,0, Color.MAGENTA, 101, 10, Color.MAGENTA, true);
		g2d.setPaint(gp11);
		g2d.fillRect(146, 92, 44, 44); //x, y, xplus, yplus
		GradientPaint gp12 = new  GradientPaint(101,47, Color.BLUE, 0, 0, Color.BLUE, true);
		g2d.setPaint(gp12);
		g2d.fillRect(326, 92, 44, 44);
		GradientPaint gp13 = new  GradientPaint(0,0, Color.BLUE, 101, 10, Color.BLUE, true);
		g2d.setPaint(gp13);
		g2d.fillRect(506, 92, 44, 44);
		GradientPaint gp14 = new  GradientPaint(101,47, Color.MAGENTA, 0, 0, Color.MAGENTA, true);
		g2d.setPaint(gp14);
		g2d.fillRect(686, 92, 44, 44);
		
		///// 3e rang /////
		GradientPaint gp21 = new  GradientPaint(0,0, Color.MAGENTA, 101, 10, Color.MAGENTA, true);
		g2d.setPaint(gp21);
		g2d.fillRect(191, 137, 44, 44); //x, y, xplus, yplus
		GradientPaint gp22 = new  GradientPaint(101,47, Color.CYAN, 0, 0, Color.CYAN, true);
		g2d.setPaint(gp22);
		g2d.fillRect(371, 137, 44, 44);
		GradientPaint gp23 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
		g2d.setPaint(gp23);
		g2d.fillRect(461, 137, 44, 44);
		GradientPaint gp24 = new  GradientPaint(101,47, Color.MAGENTA, 0, 0, Color.MAGENTA, true);
		g2d.setPaint(gp24);
		g2d.fillRect(641, 137, 44, 44);
		
		///// 4e rang /////
		GradientPaint gp31 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
		g2d.setPaint(gp31);
		g2d.fillRect(101, 182, 44, 44); //x, y, xplus, yplus
		GradientPaint gp32 = new  GradientPaint(101,47, Color.MAGENTA, 0, 0, Color.MAGENTA, true);
		g2d.setPaint(gp32);
		g2d.fillRect(236, 182, 44, 44);
		GradientPaint gp33 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
		g2d.setPaint(gp33);
		g2d.fillRect(416, 182, 44, 44);
		GradientPaint gp34 = new  GradientPaint(101,47, Color.MAGENTA, 0, 0, Color.MAGENTA, true);
		g2d.setPaint(gp34);
		g2d.fillRect(596, 182, 44, 44);
		GradientPaint gp35 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
		g2d.setPaint(gp35);
		g2d.fillRect(731, 182, 44, 44);
		
		///// 5e rang /////
		GradientPaint gp40 = new  GradientPaint(101,47, Color.MAGENTA, 0, 0, Color.MAGENTA, true);
		g2d.setPaint(gp40);
		g2d.fillRect(281, 227, 44, 44);
		
		g2d.setPaint(gp40);
		g2d.fillRect(551, 227, 44, 44);
		
		///// 6e rang /////
		GradientPaint gp51 = new  GradientPaint(0,0, Color.BLUE, 101, 10, Color.BLUE, true);
		g2d.setPaint(gp51);
		g2d.fillRect(146, 272, 44, 44); //x, y, xplus, yplus
		GradientPaint gp52 = new  GradientPaint(101,47, Color.BLUE, 0, 0, Color.BLUE, true);
		g2d.setPaint(gp52);
		g2d.fillRect(326, 272, 44, 44);
		GradientPaint gp53 = new  GradientPaint(0,0, Color.BLUE, 101, 10, Color.BLUE, true);
		g2d.setPaint(gp53);
		g2d.fillRect(506, 272, 44, 44);
		GradientPaint gp54 = new  GradientPaint(101,47, Color.BLUE, 0, 0, Color.BLUE, true);
		g2d.setPaint(gp54);
		g2d.fillRect(686, 272, 44, 44);
		
		///// 7e rang /////
		GradientPaint gp61 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
		g2d.setPaint(gp61);
		g2d.fillRect(191, 317, 44, 44); //x, y, xplus, yplus
		GradientPaint gp62 = new  GradientPaint(101,47, Color.CYAN, 0, 0, Color.CYAN, true);
		g2d.setPaint(gp62);
		g2d.fillRect(371, 317, 44, 44);
		GradientPaint gp63 = new  GradientPaint(0,0, Color.CYAN, 101, 10, Color.CYAN, true);
		g2d.setPaint(gp63);
		g2d.fillRect(461, 317, 44, 44);
		GradientPaint gp64 = new  GradientPaint(101,47, Color.CYAN, 0, 0, Color.CYAN, true);
		g2d.setPaint(gp64);
		g2d.fillRect(641, 317, 44, 44);
		
		///// 8e rang /////
		
		g2d.setPaint(gp);
		g2d.fillRect(101, 362, 44, 44); 
		
		g2d.setPaint(gp2);
		g2d.fillRect(236, 362, 44, 44);
		
		g2d.setPaint(gp21);
		g2d.fillRect(416, 362, 44, 44);
		
		g2d.setPaint(gp4);
		g2d.fillRect(596, 362, 44, 44);
		
		g2d.setPaint(gp5);
		g2d.fillRect(731, 362, 44, 44);
		
		///// 9e rang /////
		
		g2d.setPaint(gp61);
		g2d.fillRect(191, 407, 44, 44); 
		
		g2d.setPaint(gp62);
		g2d.fillRect(371, 407, 44, 44);
		
		g2d.setPaint(gp63);
		g2d.fillRect(461, 407, 44, 44);
		
		g2d.setPaint(gp64);
		g2d.fillRect(641, 407, 44, 44);
		
		///// 10e rang /////
		g2d.setPaint(gp51);
		g2d.fillRect(146, 452, 44, 44); 
		
		g2d.setPaint(gp52);
		g2d.fillRect(326, 452, 44, 44);
		
		g2d.setPaint(gp53);
		g2d.fillRect(506, 452, 44, 44);

		g2d.setPaint(gp54);
		g2d.fillRect(686, 452, 44, 44);
		
		///// 11e rang /////
		
		g2d.setPaint(gp40);
		g2d.fillRect(281, 497, 44, 44);
		
		g2d.setPaint(gp40);
		g2d.fillRect(551, 497, 44, 44);
		
		///// 12e rang /////
		
		g2d.setPaint(gp31);
		g2d.fillRect(101, 542, 44, 44); 
		
		g2d.setPaint(gp32);
		g2d.fillRect(236, 542, 44, 44);
		
		g2d.setPaint(gp33);
		g2d.fillRect(416, 542, 44, 44);
		
		g2d.setPaint(gp34);
		g2d.fillRect(596, 542, 44, 44);
		
		g2d.setPaint(gp35);
		g2d.fillRect(731, 542, 44, 44);
		
		///// 13e rang /////
		
		g2d.setPaint(gp21);
		g2d.fillRect(191, 587, 44, 44); 
		
		g2d.setPaint(gp22);
		g2d.fillRect(371, 587, 44, 44);
		
		g2d.setPaint(gp23);
		g2d.fillRect(461, 587, 44, 44);
		
		g2d.setPaint(gp24);
		g2d.fillRect(641, 587, 44, 44);
		
		///// 14e rang /////
		
		g2d.setPaint(gp11);
		g2d.fillRect(146, 632, 44, 44); 
		
		g2d.setPaint(gp12);
		g2d.fillRect(326, 632, 44, 44);
		
		g2d.setPaint(gp13);
		g2d.fillRect(506, 632, 44, 44);
		
		g2d.setPaint(gp14);
		g2d.fillRect(686, 632, 44, 44);
		
		////// 15e rang /////
		
		g2d.setPaint(gp);
		
		g2d.fillRect(101, 677, 44, 44); 
		
		
		g2d.setPaint(gp2);
		g2d.fillRect(236, 677, 44, 44);
		
		
		g2d.setPaint(gp3);
		g2d.fillRect(416, 677, 44, 44);
		
		g2d.setPaint(gp4);
		g2d.fillRect(596, 677, 44, 44);
		
		g2d.setPaint(gp5);
		g2d.fillRect(731, 677, 44, 44);
		
		
		
		////////////// COULEUR
		g.setColor(Color.black);
		
		//légende
		g.drawString("L pour lettre", 101, 33);
		
		////// case rouge //////
		g.drawString("Mot x3", 106, 73);
		g.drawString("Mot x3", 736, 73);
		g.drawString("Mot x3", 421, 73);
		
		g.drawString("Mot x3", 106, 390);
		g.drawString("Mot x3", 736, 390);
		
		g.drawString("Mot x3", 106, 703);
		g.drawString("Mot x3", 421, 703);
		g.drawString("Mot x3", 736, 703);
		
		////// case cyan //////
		g.drawString("L  x2", 246, 73);
		g.drawString("L  x2", 606, 73);
		
		g.drawString("L  x2", 381, 163);
		g.drawString("L  x2", 471, 163);
		
		g.drawString("L  x2", 111, 208);
		g.drawString("L  x2", 741, 208);
		g.drawString("L  x2", 426, 208);
		
		g.drawString("L  x2", 201, 345);
		g.drawString("L  x2", 381, 345);
		g.drawString("L  x2", 471, 345);
		g.drawString("L  x2", 651, 345);
		
		g.drawString("L  x2", 246, 390);
		g.drawString("L  x2", 606, 390);
		
		g.drawString("L  x2", 201, 435);
		g.drawString("L  x2", 381, 435);
		g.drawString("L  x2", 471, 435);
		g.drawString("L  x2", 651, 435);
		
		g.drawString("L  x2", 111, 568);
		g.drawString("L  x2", 741, 568);
		g.drawString("L  x2", 426, 568);
		
		g.drawString("L  x2", 381, 613);
		g.drawString("L  x2", 471, 613);
		
		g.drawString("L  x2", 246, 703);
		g.drawString("L  x2", 606, 703);
		
		////// case magenta ///////
		g.drawString("Mot x2", 151, 118);
		g.drawString("Mot x2", 691, 118);
		
		g.drawString("Mot x2", 196, 163);
		g.drawString("Mot x2", 646, 163);
		
		g.drawString("Mot x2", 241, 208);
		g.drawString("Mot x2", 601, 208);
		
		g.drawString("Mot x2", 286, 253);
		g.drawString("Mot x2", 556, 253);
		//
		g.drawString("Mot x2", 286, 523);
		g.drawString("Mot x2", 556, 523);
		
		g.drawString("Mot x2", 241, 568);
		g.drawString("Mot x2", 601, 568);
		
		g.drawString("Mot x2", 196, 613);
		g.drawString("Mot x2", 646, 613);
		
		g.drawString("Mot x2", 151, 658);
		g.drawString("Mot x2", 691, 658);
		
		////// case bleu ///////
		g.drawString("L  x3", 336, 118);
		g.drawString("L  x3", 516, 118);
		
		g.drawString("L  x3", 156, 300);
		g.drawString("L  x3", 336, 300);
		g.drawString("L  x3", 516, 300);
		g.drawString("L  x3", 696, 300);
		
		g.drawString("L  x3", 156, 480);
		g.drawString("L  x3", 336, 480);
		g.drawString("L  x3", 516, 480);
		g.drawString("L  x3", 696, 480);
		
		g.drawString("L  x3", 336, 658);
		g.drawString("L  x3", 516, 658);
	   
	  } 
}
