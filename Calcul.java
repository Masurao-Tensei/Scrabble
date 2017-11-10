package Scoring;
import java.util.Scanner;

public class Calcul {
	  
	Scanner sc = new Scanner(System.in);

	boolean vide(String[][] t) {
		int n = 0;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (t[i][j] != " ") {
					n = 1;
				}
			}
		}
		if (n == 1)
			return false;
		else
			return true;
	}

	void placerLrettre(String[][] t, int n, int m) 
	{


          
			if (t[n - 1][m - 1] == " ") {
				System.out.println("Lettre");
				t[n - 1][m - 1] = sc.nextLine();
			} else
				System.out.println("deja une lettre dans cette case");
		

	}

	public void placerMot(String[][] t, String mot) {
		int i;

		
		System.out.println("===Choix====\n 1_ Mot horizontale\n 2_ Mot Verticale");
			i = sc.nextInt();
			sc.nextLine();

			switch (i) {
			case 1:
			{
				if (vide(t) == true)
				{
					System.out.println("Premier Lettre du jeu");
					t[6][6] = sc.nextLine();
					
					mot+=t[6][6];
					
					int n1 = 1,n2 = 0;
					int j = 7; 
					while (n1<7) //sept lettre dans le sac
					{
					  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
					  n2 = sc.nextInt();
					  sc.nextLine();

					  switch (n2) {
					     case 1: {
					    	 t[6][j] = sc.nextLine();
					    	 mot+=t[6][j];
					    	 j++;
					    	 n1++;
					    	 break;
					     }
					     case 0: {
						     n1=7;
						     System.out.println("fin");
						     break;
					     }
					  }
					}

				} 
				else {
					int lig,col=0;
		           // ligne et colonne juste pour le test. 
					System.out.println("ligne");
					lig = sc.nextInt();
					sc.nextLine();
					System.out.println("colonne");
					col = sc.nextInt();
					sc.nextLine();
					if (t[lig - 1][col - 1].equalsIgnoreCase(" ")) {
						System.out.println("Lettre");
						t[lig - 1][col - 1] = sc.nextLine();
						mot+=t[lig - 1][col - 1];
						int n1 = 1,n2 = 0;
						while (n1<7)
						{
						  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
						  n2 = sc.nextInt();
						  sc.nextLine();

						  switch (n2) {
						     case 1: {
						    	 t[lig-1][col] = sc.nextLine();
						    	 mot+=t[lig-1][col];
						    	 col++;
						    	 break;
						     }
						     case 0: {
							     n1=7;
							     System.out.println("Fin");
							     break;
						     }

						  }
						  }
					} else
						System.out.println("deja une lettre dans cette case");
				}

			};
			break;
				
			case 2:
			{

				if (vide(t) == true)
				{
					System.out.println("Premier Lettre du jeu");
					t[6][6] = sc.nextLine();
					mot+=t[6][6];
					
					int n1 = 1,n2 = 0;
					int j = 7; 
					while (n1<7)
					{
					  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
					  n2 = sc.nextInt();
					  sc.nextLine();

					  switch (n2) {
					     case 1: {
					    	 t[j][6] = sc.nextLine();
					    	 mot+=t[j][6];
					    	 j++;
					    	 break;
					     }
					     case 0: {
						     n1=7;
						     System.out.println("Fin");
						     break;
					     }

					  }
					}

				} 
				else {
					int lig,col=0;
		           // ligne et colonne juste pour le test. 
					System.out.println("ligne");
					lig = sc.nextInt();
					sc.nextLine();
					System.out.println("colonne");
					col = sc.nextInt();
					sc.nextLine();
					if (t[lig - 1][col - 1] == " ") {
						System.out.println("Lettre");
						t[lig - 1][col - 1] = sc.nextLine();
						mot+=t[lig - 1][col - 1];
						int n1 = 1,n2 = 0;
						while (n1<7)
						{
						  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
						  n2 = sc.nextInt();
						  sc.nextLine();

						  switch (n2) {
						     case 1: {
						    	 t[lig][col-1] = sc.nextLine();
						    	 mot+=t[lig][col-1];
						    	 lig++;
						    	 break;
						     }
						     case 0: {
							     n1=7;
							     System.out.println("fin");
							     break;
						     }

						  }
						  }
					} else
						System.out.println("deja une lettre dans cette case");
				}

			
			}
			break;
				
			}
			System.out.println(mot);
			if (new Dictionnaire.VerifMot().dico(mot).equalsIgnoreCase("Mot correcte")) { affTableau(t);}
			else System.out.println(new Dictionnaire.VerifMot().dico(mot));
	}

	public static void affTableau(String[][] t) {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print("[" + t[i][j] + "]");
			}
			System.out.print("\n");
		}
	}

}
