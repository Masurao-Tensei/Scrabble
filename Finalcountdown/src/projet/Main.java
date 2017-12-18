package projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		 List<Joueur> joueurs = new ArrayList<Joueur>();
		
		ArrayList<Lettre> contenudusac = null;
		Sac s1 = new Sac(false,contenudusac);
		
		
		Plateau plateau = new Plateau();

		plateau.plateauconsole(plateau.tab);
		
		int choixaction;
		
		s1.remplirsac();
	
		ArrayList<Lettre> contenumainj1 = null;
		ArrayList<Lettre> contenumainj2 = null;
				
		MainJoueur mainj1= new MainJoueur(7,contenumainj1, contenudusac, s1);
		MainJoueur mainj2= new MainJoueur(7,contenumainj2, contenudusac, s1);
		
				
		Joueur J1=new Joueur(0,mainj1);
		Joueur J2=new Joueur(0,mainj2);
		joueurs.add(J1);
		joueurs.add(J2);
				
		MenuJeu menu= new MenuJeu(J1,s1);
		
		J1.main.creationmain();
		J2.main.creationmain();
		
		while(!s1.vide){
			System.out.println("Tour du Joueur j1 : \n");
			menu.tourjoueur(s1, J1, plateau);
			System.out.println("Tour du joueur j2 : \n");
			menu.tourjoueur2(s1, J2, plateau);
		
		}

	}

}