package projet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Ecriture extends JPanel {

	 public void paintComponent(Graphics g){
		               
		    g.setColor(Color.black);          
		     
		    g.drawString("1. G�n�ralit�s", 30, 20);
		    g.drawString("1.1 Le dictionnaire utilis� pour juger de la validit� des mots jou�s, est l'�dition en vigueur de l'Officiel du Jeu Scrabble", 30, 40);
		    g.drawString("1.2 Le Scrabble Classique suit les r�gles du jeu de Scrabble (placement et comptage des mots, prime de scrabble�) consign�es dans l'�dition en vigueur", 30, 60);
		    g.drawString("2. La phase de jeu �normale�", this.getWidth(), 80);
		    g.drawString("2.1. La phase de jeu normale consiste, pour un joueur, � placer un mot sur la grille, selon les r�gles du jeu de Scrabble, consign�es dans l'�dition en vigueur", 30, 100);
		    g.drawString("2.2. Pendant son tour de jeu, un joueur est libre de poser et de reprendre librement ses lettres sur la grille, mais ne doit pas d�placer les lettres d�j� en place sur la grille.", 30, 120);
		    g.drawString("2.3. Une fois le score annonc�, le joueur ne peut plus toucher aux lettres qu'il vient de poser.", 30, 140);
		    g.drawString("2.4. Lorsqu'un joueur place un joker (lettre blanche), il doit sp�cifier express�ment la lettre repr�sent�e (exemple : A de ALGERIE)", 30, 160);
		    g.drawString("3. Passer son tour", 30, 180);
		    g.drawString("3.1. Il est possible, pour un joueur dont c'est le tour, de n'effectuer aucun mouvement. Ainsi, � n'importe quel moment, il peut passer en annon�ant clairement : � JE PASSE � .", 30, 200);
		    g.drawString("3.2. Chaque joueur peut passer son tour autant de fois qu'il le souhaite au cours d'une partie, � cette exception pr�s : si les deux joueurs passent chacun leur tour trois fois cons�cutivement (donc six � JE PASSE �), la partie s'arr�te.", 30, 220); 
		    g.drawString("4. Rejeter", 30, 240);
		    g.drawString("4.1. Lorsqu'il reste au moins 7 lettres dans le sac (et seulement dans ce cas), il est possible pour un joueur dont c'est le tour, de rejeter tout ou partie de ses lettres.", 30, 260);
		    g.drawString("4.2. Lorsqu'on rejette on perd son tour.", 30, 280);
		    g.drawString("4.3. Le rejet doit respecter le formalisme suivant : le joueur annonce � JE CHANGE n LETTRES �, n �tant le nombre de lettres qu'il d�sire changer.", 30, 300); 
		    g.drawString("4.4. Le joueur ne peut changer plus (ou moins) de lettres que le nombre qu'il a annonc�.", 30, 320);
		    g.drawString("5. Sanctions", 30, 340);
		    g.drawString("- Si tous les mots sont non admis, X reprend ses lettres, et passe son tour. C'est � Y de jouer.", 30, 360);
		    g.drawString("6. Fin de partie", 30, 380);
		    g.drawString("6.1. La situation la plus courante se produit lorsqu'un joueur a �puis� toutes ses lettres et que le sac est vide.", 30, 400);
		    g.drawString("6.2. La valeur faciale des lettres (un joker vaut 0) restant � l'adversaire est alors d�falqu�e de son cumul, et est ajout�e au cumul du joueur ayant termin�.", 30, 420);
		    g.drawString("7. Blocage : Il se peut que les joueurs ne trouvent plus de mot � jouer, et qu'il ne reste pas suffisamment de lettres dans le sac pour changer de lettres, dans ce cas on applique la r�gle du 3.2", this.getWidth(), 440);
		    	    
		  }  
}
