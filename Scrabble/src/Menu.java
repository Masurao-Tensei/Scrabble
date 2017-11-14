import java.util.Scanner;

public class Menu {

	protected int choixaction;
	protected int possibilitechoix;
	protected Joueur joueur;
	protected Sac sac;
	
	public int getChoixaction() {
		return choixaction;
	}
	public void setChoixaction(int choixaction) {
		this.choixaction = choixaction;
	}
	public int getPossibilitechoix() {
		return possibilitechoix;
	}
	public void setPossibilitechoix(int possibilitechoix) {
		this.possibilitechoix = possibilitechoix;
	}
	
	
	
	public Menu(Joueur joueur, Sac sac/*int choixaction, int possibilitechoix*/) {
		super();
		this.choixaction = choixaction;
		this.possibilitechoix = possibilitechoix;
	}
	
	/**
	 * Affichage du menu
	 */
	public void affichermenu(){
		
		
			System.out.println("\nChoisissez une action : \n "
					+ "1 : Poser un mot, \n "
			 		+ "2 : Changer des lettres, \n"
			 		+ "0 : Fin de tour. \n");
			
		}
	
	
	/**
	 * Choix des différentes actions possibles en jeu
	 */
	
	
	public void actionmenu(int choixaction, Joueur joueur, Sac sac, String tab[][], Plateau1 plateau){
		
		switch(choixaction)
	    {
        case 1 :
        	placermot(joueur, sac, plateau, tab);
        break;
        
        case 2:
        	
        	changerlettres(joueur,sac);
        break;
        default:
            System.out.println("Fin de tour."); 
        break;
	    }
		
	}
	
	/**
	 *Méthode pour placer un mot sur le plateau
	 */
	 
	
	public void placermot(Joueur joueur, Sac sac, Plateau1 plateau, String tab[][]){
		
		int lettre, ligne, colonne;
		int hv;
		System.out.println("===Choix====\n 1_ Mot horizontale\n 2_ Mot Verticale"); //choix de si le mot sera à la verticale ou horizontal
		hv = sc.nextInt();
		sc.nextLine();
		
		
		
		switch (hv) {
		case 1:  //gestion des mots à l'horizontal
		{
			int choix; String mot;
			
				
				
			
			if (plateau.vide(tab) == true) //si le plateau est complétement vide
			{	
				ifplateauvidehorizontal(joueur, sac, plateau, tab);
			} 
			
			else 
			{ //si le plateau n'est pas vide au départ				
				elseplateauvidehorizontal(joueur, sac, plateau, tab);						
			} 
		
			
			
		//} //fin if=1
		
		
		break;
		
		
		}//end case1
		
		
		case 2: //gestion des mots à la vertical
		{
			int choix; String mot;
			
			
			if (plateau.vide(tab) == true) //si le plateau est complétement vide
			{	
				ifplateauvidevertical(joueur, sac, plateau, tab);
			} 
			
			else 
			{ //si le plateau n'est pas vide au départ				
				elseplateauvidevertical(joueur, sac, plateau, tab);						
			} 
		
			
		
		break;
		
		
		}//end case2
		
		
		
		
		}//fin du switch
		
	}//fin méthode
	
	
	/**
	 *  Méthode pour gérer le premier mot du jeu, s'il est placé à l'horizontal
	 */
	
	
	public void ifplateauvidehorizontal(Joueur joueur, Sac sac, Plateau1 plateau, String tab[][]){
		
		
		int lettre, ligne, colonne; String mot;
		System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");
		    
		lettre=sc.nextInt();  //choix de la lettre
		System.out.println("Premiere Lettre du jeu");
		tab[7][7] = joueur.main.contenumain.get(lettre-1).nom; //placement de la lettre au centre
		
										
		plateau.plateauconsole(tab); //affichage tableau après le coup
		
		joueur.main.contenumain.remove(lettre-1); //MAJ de la main
		
						
		joueur.main.affichermain(); //afichage de la nouvelle main ainsi obtenue
		
		// mot=tab[7][7];  //MAJ du mot en cours (pour verif apres)
		
		int n1 = 1, choix2=0;
		
		while (n1<7) //sept lettre dans la main
		{
		  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
		  choix2 = sc.nextInt();  //nouveau choix de placer ou non
		  

		  switch (choix2) {
		     case 1: {  //si on veut placer une lettre
		     	
		     	System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
				lettre=sc.nextInt();  //choix de la lettre à placer
				
				
				System.out.println("Choisissez la case où le placer (colonne)");						
				colonne=sc.nextInt();  //choix de la colonne (uniquement colonne car mot horizontal)
				
				if (tab[7][colonne - 1].equalsIgnoreCase(" ")) { //si la case est vide
				
		    	 tab[7][colonne-1]=joueur.main.contenumain.get(lettre-1).nom;  ////7 pour la lignne car doit suivre la premiere lettre placée + horizontal
		    	 //mot=tab[7][colonne-1]; //MAJ du mot
		    	 
		    	 				 		
		 		plateau.plateauconsole(tab); //aff tableau
		 		
		 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
		 		
		 		joueur.main.affichermain();  //aff main apres coup
		    	 //j++;
		    	 n1++; 		    	 //compteur : pas plus de 7 lettres par tour
				}
				else{
					System.out.println("Il y deja une lettre dans cette case");
				}
		    	 break;
		     }//fin case 1
		     case 0: { // si on ne veut plus placer de lettre ce tour ci
			     n1=7;
			     System.out.println("fin");
			     
			     break;
		     }//fin case 0
		  } //fin switch
		}// fin while
		
		
	}//fin méthode
	
	
	
	/**
	 *  Méthode pour placé un mot, s'il est placé à l'horizontal
	 */
	
	
	public void elseplateauvidehorizontal(Joueur joueur, Sac sac, Plateau1 plateau, String tab[][]){
		
		int nbl = 0,choix2 = 0; int lettre,ligne,colonne;
		String mot;
		
		
		  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
		  choix2 = sc.nextInt();  //nouveau choix de placer ou non
		  
		  if(choix2==1){ //si on veut placer une lettre
			  
			  /**
			   * ici on gere la 1e lettre du mot à placer, on a le choix de la ligne et de la colonne
			   */
			  System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
			  lettre=sc.nextInt();  //choix de la lettre à placer
				
				
				System.out.println("Choisissez la case où le placer (ligne, colonne)");		///choix de la ligne et colonne				
				ligne=sc.nextInt();
				colonne=sc.nextInt();
				if (tab[ligne-1][colonne-1].equalsIgnoreCase(" ")) {
				tab[ligne-1][colonne-1]=joueur.main.contenumain.get(lettre-1).nom;  
		    	  //mot=tab[ligne-1][colonne-1]; //MAJ du mot
		    	 
		    	 				 		
		 		plateau.plateauconsole(tab); //aff tableau
		 		
		 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
		 		
		 		joueur.main.affichermain();  //aff main apres coup
		    	 
		    	 nbl++;
				}
				else{
					System.out.println("Il y deja une lettre dans cette case");
				}
		    	 
		    	 /**
				   * à partir de la, on ne choisit plus que la colonne, car le mot est horizontal, la ligne est fixée
				   */
		  
		    	 while (nbl<7){//sept lettre dans la main
		  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
		  int choix3 = sc.nextInt();  //nouveau choix de placer ou non
		  
			
		  switch (choix3) {
		     case 1: {
		     	
		     	System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
				lettre=sc.nextInt();  //choix de la lettre à placer
				
				
				System.out.println("Choisissez la case où le placer (colonne)");						
				colonne=sc.nextInt();  //choix de la colonne (uniquement colonne car mot horizontal)
				
				if (tab[ligne-1][colonne-1].equalsIgnoreCase(" ")) {
		    	 tab[ligne-1][colonne-1]=joueur.main.contenumain.get(lettre-1).nom;  
		    	 //mot=tab[7][colonne-1]; //MAJ du mot
		    	 
		    	 				 		
		 		plateau.plateauconsole(tab); //aff tableau
		 		
		 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
		 		
		 		joueur.main.affichermain();  //aff main apres coup
		    	 //j++;
		    	 nbl++;  //compteur : pas plus de 7 lettres par tour
				}
				else{
					System.out.println("Il y deja une lettre dans cette case");
				}
		    	 break;
		     }//end case 1
		     case 0: {
			     nbl=7;
			     System.out.println("fin");
			     
			     break;
		     }//end case 0
		  }//end swithc
		}//while
	    } //end if
		  
		else{
			nbl=7;
			System.out.println("fin");
		}
			
		
		
	}//fin methode
	
	
	
	/**
	 *  Méthode pour gérer le premier mot du jeu, s'il est placé à la vertical
	 */
	
	
	public void ifplateauvidevertical(Joueur joueur, Sac sac, Plateau1 plateau, String tab[][]){
		
		
		int lettre, ligne, colonne; String mot;
		System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");
		    
		lettre=sc.nextInt();  //choix de la lettre
		System.out.println("Premiere Lettre du jeu");
		tab[7][7] = joueur.main.contenumain.get(lettre-1).nom; //placement de la lettre au centre
		
										
		plateau.plateauconsole(tab); //affichage tableau après le coup
		
		joueur.main.contenumain.remove(lettre-1); //MAJ de la main
		
						
		joueur.main.affichermain(); //afichage de la nouvelle main ainsi obtenue
		
		 //mot=tab[7][7];  //MAJ du mot en cours (pour verif apres)
		
		int n1 = 1,choix2 = 0;
		
		while (n1<7) //sept lettre dans la main
		{
		  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
		  choix2 = sc.nextInt();  //nouveau choix de placer ou non
		  

		  switch (choix2) {
		     case 1: {  //si on veut placer une lettre
		     	
		     	System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
				lettre=sc.nextInt();  //choix de la lettre à placer
				
				
				System.out.println("Choisissez la case où le placer (ligne)");						
				ligne=sc.nextInt();  //choix de la colonne (uniquement colonne car mot horizontal)
				
				if (tab[ligne-1][7].equalsIgnoreCase(" ")) {
		    	 tab[ligne-1][7]=joueur.main.contenumain.get(lettre-1).nom;  ////7 pour la lignne car doit suivre la premiere lettre placée + horizontal
		    	 //mot=tab[ligne-1][7]; //MAJ du mot
		    	 
		    	 				 		
		 		plateau.plateauconsole(tab); //aff tableau
		 		
		 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
		 		
		 		joueur.main.affichermain();  //aff main apres coup
		    	 //j++;
		    	 n1++;  //compteur : pas plus de 7 lettres par tour
				}
				else{
					System.out.println("Il y deja une lettre dans cette case");
				}
		    	 break;
		     }//fin case 1
		     case 0: { // si on ne veut plus placer de lettre ce tour ci
			     n1=7;
			     System.out.println("fin");
			     
			     break;
		     }//fin case 0
		  } //fin switch
		}// fin while
		
		
		
	}//fin methode
	
	
	
	/**
	 *  Méthode pour placé un mot, s'il est placé à la vertical
	 */
		
	
	public void elseplateauvidevertical(Joueur joueur, Sac sac, Plateau1 plateau, String tab[][]){
		
		int nbl = 0,choix2 = 0; int lettre,ligne,colonne;
		String mot;
		
		
		  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
		  choix2 = sc.nextInt();  //nouveau choix de placer ou non
		  
		  if(choix2==1){ //si on veut placer une lettre
			  
			  /**
			   * ici on gere la 1e lettre du mot à placer, on a le choix de la ligne et de la colonne
			   */
			  System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
			  lettre=sc.nextInt();  //choix de la lettre à placer
				
				
				System.out.println("Choisissez la case où le placer (ligne, colonne)");		///choix de la ligne et colonne				
				ligne=sc.nextInt();
				colonne=sc.nextInt();
				
				if (tab[ligne-1][colonne-1].equalsIgnoreCase(" ")) {
				
				tab[ligne-1][colonne-1]=joueur.main.contenumain.get(lettre-1).nom;  
		    	 // mot=tab[ligne-1][colonne-1]; //MAJ du mot
		    	 
		    	 				 		
		 		plateau.plateauconsole(tab); //aff tableau
		 		
		 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
		 		
		 		joueur.main.affichermain();  //aff main apres coup
		    	 
		    	 nbl++;
				}
				else{
					System.out.println("Il y deja une lettre dans cette case");
				}
		    	 
		    	 /**
				   * à partir de la, on ne choisit plus que la ligne, car le mot est vertical, la colonne est fixée
				   */
		  
		    	 while (nbl<7){//sept lettre dans la main
		  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
		  int choix3 = sc.nextInt();  //nouveau choix de placer ou non
		  
			
		  switch (choix3) {
		     case 1: {
		     	
		     	System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
				lettre=sc.nextInt();  //choix de la lettre à placer
				
				
				System.out.println("Choisissez la case où le placer (ligne)");						
				ligne=sc.nextInt();  //choix de la colonne (uniquement colonne car mot horizontal)
				
				if (tab[ligne-1][colonne-1].equalsIgnoreCase(" ")) {
		    	 tab[ligne-1][colonne-1]=joueur.main.contenumain.get(lettre-1).nom;  
		    	// mot=tab[7][colonne-1]; //MAJ du mot
		    	 
		    	 				 		
		 		plateau.plateauconsole(tab); //aff tableau
		 		
		 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
		 		
		 		joueur.main.affichermain();  //aff main apres coup
		    	 //j++;
		    	 nbl++;  //compteur : pas plus de 7 lettres par tour
				}
				else{
					System.out.println("Il y deja une lettre dans cette case");
				}
				
		    	 break;
		     }//end case 1
		     case 0: {
			     nbl=7;
			     System.out.println("fin");
			     
			     break;
		     }//end case 0
		  }//end swithc
		}//while
	    } //end if
		  
		else{
			nbl=7;
			System.out.println("fin");
		}
		
		
		
		
	}
	
	
	
	
	/**
	 * Méthode pour changer les lettres de la main du joueur
	 */
	
	public void changerlettres(Joueur joueur, Sac sac){
		
		Scanner sc= new Scanner(System.in);
		int choixlettre, nblettres;
		int i=0;
				
		System.out.println("Combien de lettres souhaitez vous changer?\n");
		nblettres=sc.nextInt();
		
		while(1>nblettres || nblettres>7){    //on ne peut pas rentrer autre chose qu'un nombre entre 1 et 7
			System.out.println("Combien de lettres souhaitez vous changer?\n");
			nblettres=sc.nextInt();
		}
		
			
		while(i<nblettres){
			
		
		System.out.println("Quelle lettre souhaitez vous changer? Indiquez son numero : \n");
		
		choixlettre=sc.nextInt();
		
		
		sac.contenusac.add(joueur.main.contenumain.get(choixlettre-1));
		
		joueur.main.contenumain.remove(choixlettre-1);
		
		joueur.main.pioche(sac);
		
		joueur.main.affichermain();
		
		i++;
		}
		
		
		
		
		
		
		
		
		
	}
	
	
}
