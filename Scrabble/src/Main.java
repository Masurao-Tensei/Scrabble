import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		ArrayList<Lettre> contenudusac = null;
		Sac s1 = new Sac(false,contenudusac);
		
		
		
		
		
		Plateau1 plateau = new Plateau1();
		
		/*String tableau[][]= { {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
				};*/
		
		plateau.plateauconsole(plateau.tab);
		
		int choixaction;
		
		//MenuJeu menu2 = new MenuJeu();
		s1.remplirsac();
		//s1.contenudusac(); //C'était juste pour vérifier que le sac soit remplit correctement
		
		ArrayList<Lettre> contenumainj1 = null;
		ArrayList<Lettre> contenumainj2 = null;
				
		MainJoueur mainj1= new MainJoueur(7,contenumainj1, contenudusac, s1);
		MainJoueur mainj2= new MainJoueur(7,contenumainj2, contenudusac, s1);
		
				
		Joueur J1=new Joueur(0,mainj1);
		Joueur J2=new Joueur(0,mainj2);
		
		
				
		Menu menu=new Menu(J1,s1);
		
		
		
		J1.main.creationmain();
		J2.main.creationmain();
		
		
		//J1.main.affichermain();
		//J2.main.affichermain();
		
		//s1.contenudusac(); //C'était juste pour vérifier que le sac soit remplit correctement apres la pioche
				
		//menu.affichermenu();
		//System.out.println("\nVotre choix : ");
		//choixaction=sc.nextInt(); //choix de l'action a effectuer
		//menu.actionmenu(choixaction,J1,s1,plateau.tab,plateau);
		//J1.main.affichermain();  //test
		//s1.contenudusac();	//test
		
		while(!s1.vide){
			System.out.println("Tour du Joueur j1 : \n");
			menu.tourjoueur(s1, J1, plateau);
			System.out.println("Tour du joueur j2 : \n");
			menu.tourjoueur2(s1, J2, plateau);
		
		}
		
		
		

	}

}
