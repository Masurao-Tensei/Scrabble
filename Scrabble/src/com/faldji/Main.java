import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		ArrayList<Lettre> contenudusac = null;
		Sac s1 = new Sac(false,contenudusac);
		
		
		ArrayList<Lettre> contenumainj1 = null;
		ArrayList<Lettre> contenumainj2 = null;
		
		MainJoueur mainj1= new MainJoueur(7,contenumainj1, contenudusac, s1);
		MainJoueur mainj2= new MainJoueur(7,contenumainj2, contenudusac, s1);
		
		
		Joueur J1=new Joueur(0,mainj1);
		Joueur J2=new Joueur(0,mainj2);
		
		Menu menu=new Menu(J1,s1);
		
		Dictionnaire d=new Dictionnaire();
		Plateau1 plateau = new Plateau1();
		
		int choixaction;
		
		s1.remplirsac();
		//s1.contenudusac(); //C'était juste pour vérifier que le sac soit remplit correctement
		J1.main.creationmain();
		J1.main.affichermain();
		//s1.contenudusac(); //C'était juste pour vérifier que le sac soit remplit correctement apres la pioche
		menu.affichermenu();
		System.out.println("\nVotre choix : ");
		choixaction=sc.nextInt(); //choix de l'action a effectuer
		menu.actionmenu(choixaction,J1,s1);
		//J1.main.affichermain();  //test
		//s1.contenudusac();	//test
		
		//d.dico();  //A utiliser quand on aura besoin de vérifier des mots --> mais fonctionne bien
		

	}

}
