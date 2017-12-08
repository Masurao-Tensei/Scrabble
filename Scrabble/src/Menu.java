import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
	Scanner sc= new Scanner(System.in);
	protected int choixaction;
	protected int possibilitechoix;
	protected Joueur joueur;
	protected Sac sac;
	protected ArrayList<Lettre> Let_P;//contient les caractere possible et leurs valeurs points;
	protected int[][] valD; //il va stocker l'indice des cases ou une lettre est placé ,utile pour lettrre*2, mot*2 etc..
	
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
	
	
	public void actionmenu(int choixaction, Joueur joueur, Sac sac, Plateau1 plateau){
		
		
		switch(choixaction)
	    {
	        case 1 :
	        	placermot(joueur, sac, plateau, plateau.tab);
	        break;
	        
	        case 2:	        	
	        	changerlettres(joueur,sac);
	        break;
	        
	        /*case 3:	        	
	        	annulerderniercoup();
	        break;*/
	        
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
		System.out.println("===Choix====\n 1_ Mot horizontal\n 2_ Mot Vertical\n 3_ Retour"); //choix de si le mot sera à la verticale ou horizontal
		hv = sc.nextInt();
		sc.nextLine();
		valD = new int[15][15];//7 2
		int x = 0,y =0;
		Score scorejoueur=new Score();
		
		switch (hv) {
			case 1:  //gestion des mots à l'horizontal
			{			
				int choix; String mot;
								
				if (plateau.vide(plateau.tab) == true) //si le plateau est complétement vide
				{
					ifplateauvidehorizontal(joueur, sac, plateau, plateau.tab,x, y, valD,scorejoueur);					
				} 				
				else 
				{ //si le plateau n'est pas vide au départ				
					elseplateauvidehorizontal(joueur, sac, plateau, plateau.tab, x, y, valD,scorejoueur);					
				} 			
			
			break;			
			}//end case1			
			
			case 2: //gestion des mots à la vertical
			{
				int choix; String mot;				
				
				if (plateau.vide(plateau.tab) == true) //si le plateau est complétement vide
				{	
					ifplateauvidevertical(joueur, sac, plateau, plateau.tab, x, y, valD,scorejoueur);					
				} 				
				else 
				{ //si le plateau n'est pas vide au départ				
					elseplateauvidevertical(joueur, sac, plateau, plateau.tab, x, y, valD,scorejoueur);						
				} 			
			
			break;			
			}//end case2
			
			case 3: 
								
				break;
		}//fin du switch
		
	}//fin méthode
	
	
	/**
	 *  Méthode pour gérer le premier mot du jeu, s'il est placé à l'horizontal
	 */
	
	
	public void ifplateauvidehorizontal(Joueur joueur, Sac sac, Plateau1 plateau, String tab[][], int x, int y, int[][] valD,Score scorejoueur){
		
		
		int lettre, ligne, colonne; String mot=null;
		int i=0;
		Dictionnaire dico=new Dictionnaire();
		VerifMot verif=new VerifMot();
		
		
	  	System.out.println("Choisissez la lettre à placer (indiquer son numero/1e lettre du mot) : ");	    
		lettre=sc.nextInt();  //choix de la lettre à placer
		
		while(lettre<1 || lettre>joueur.main.contenumain.size()){ //si l'entrée est incorrecte
			System.out.println("Choisissez la lettre à placer (indiquer son numero/1e lettre du mot) : ");	    
			lettre=sc.nextInt();
		}
		
		System.out.println("Choisissez la case où le placer (colonne)");						
		colonne=sc.nextInt();  //choix de la colonne (uniquement colonne car mot horizontal)
		
		while(colonne<1 || colonne>15){ //si l'entrée est incorrecte
			System.out.println("Choisissez la case où le placer (colonne)");						
			colonne=sc.nextInt();
		}
		
		if (plateau.tab[7][colonne - 1].equalsIgnoreCase(" ")) { //si la case est vide
		
			plateau.tab[7][colonne-1]=joueur.main.contenumain.get(lettre-1).nom;  ////7 pour la lignne car doit suivre la premiere lettre placée + horizontal
			valD[x][y]=7; valD[x][y+1]=colonne-1;//indice de la case joué 
    	 
	    	 if(mot==null){
	    		 mot=(plateau.tab[7][colonne-1]);//MAJ du mot
	    	 }
	    	 else mot+=(plateau.tab[7][colonne-1]); //MAJ du mot
	    	 
	    	 				 		
	 		plateau.plateauconsole(plateau.tab); //aff tableau
	 		
	 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
	 		
	 		joueur.main.affichermain();  //aff main apres coup
    	 
		}//fin if case vide
		
		
		int n1 = 1, choix2=0, cpt=1;
		
		
		while (n1<7 && (colonne-1+cpt)<15) //sept lettre dans la main
		{
		  System.out.println("===Choix====\n 1_ placer une letrre\n 2_ retirer la derniere lettre placee\n 0_ fin");
		  choix2 = sc.nextInt();  //nouveau choix de placer ou non
		  
		  
		  switch (choix2) {
		     case 1: {  //si on veut placer une lettre
		     	
		     	System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
				lettre=sc.nextInt();  //choix de la lettre à placer
				
				while(lettre<1 || lettre>joueur.main.contenumain.size()){ //si l'entrée est incorrecte
					System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
					lettre=sc.nextInt();
				}
				
				
				
				if (plateau.tab[7][(colonne - 1)+cpt].equalsIgnoreCase(" ")) { //si la case est vide
				
					plateau.tab[7][(colonne-1)+cpt]=joueur.main.contenumain.get(lettre-1).nom;  ////7 pour la lignne car doit suivre la premiere lettre placée + horizontal
			    	 
			    	 
			    	mot+=(plateau.tab[7][(colonne-1)+cpt]); //MAJ du mot
			    	valD[x][y]=7; valD[x][y+1]=colonne-1+cpt;//indice de la case joué 
			    	 				 		
			 		plateau.plateauconsole(plateau.tab); //aff tableau
			 		
			 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
			 		
			 		joueur.main.affichermain();  //aff main apres coup
			    	 
			    	n1++; 		    	 //compteur : pas plus de 7 lettres par tour
			    	cpt++;//compteur decalage pour case suivante
			    	
				}//fin if case vide
				else{
					System.out.println("Il y deja une lettre dans cette case");
				}
				
				
		    	 break;
		     }//fin case 1
		     
		     case 2:
		    	 plateau.tab[7][(colonne-1)+cpt-1]=" ";
		    	 plateau.plateauconsole(plateau.tab);
		    	 break;
		     case 0: { // si on ne veut plus placer de lettre ce tour ci
			     if(n1<2){
			    	 System.out.println("Le mot doit comporter au moins 2 lettres");
			    	 annulerderniercouphorizontal(plateau, plateau.tab, 8, colonne, cpt);
			     }
			      n1=7;
			     System.out.println("fin");
			     
			     
			     break;
		     }//fin case 0
		     
		  } //fin switch
		  
		}// fin while
		
		System.out.println("le mot est : ");
		
		System.out.println(mot);  //Affichage du mot obtenu
		
		if(plateau.tab[7][7].equalsIgnoreCase(" ")){			
			annulerderniercouphorizontal(plateau, tab, 8, colonne, cpt);			
		}
		
		if (verif.dico(mot).equalsIgnoreCase("Mot correcte")) { //Vérification avec le dico
			System.out.println("Le mot est correct\n");
			System.out.println("valD : " + valD.toString());
			joueur.score = joueur.score+scorejoueur.calculMot(sac,valD,mot);
			System.out.println("test : " + scorejoueur.calculMot(sac,valD,mot));
			System.out.println("score joueur : " + joueur.score);
			plateau.plateauconsole(plateau.tab);}  
		else {
			annulerderniercouphorizontal(plateau, tab, 8, colonne, cpt);
			System.out.println( verif.dico(mot));
			}
		
	}//fin méthode
	
	
	
	/**
	 *  Méthode pour placé un mot, s'il est placé à l'horizontal
	 */
	
	
	public void elseplateauvidehorizontal(Joueur joueur, Sac sac, Plateau1 plateau, String tab[][], int x, int y, int[][] valD,Score scorejoueur){
		
		int lettre, ligne, colonne; String mot=null;
		int i=0;
		Dictionnaire dico=new Dictionnaire();
		VerifMot verif=new VerifMot();
		boolean reutilise=false; //permet de savoir si le joueur à utilisé au moins 1 lettre deja placée pour faire son mot
		
	  	System.out.println("Choisissez la lettre à placer (indiquer son numero/1e lettre du mot) : ");	    
		lettre=sc.nextInt();  //choix de la lettre à placer
		
		while(lettre<1 || lettre>joueur.main.contenumain.size()){ //si l'entrée est incorrecte
			System.out.println("Choisissez la lettre à placer (indiquer son numero/1e lettre du mot) : ");	    
			lettre=sc.nextInt();
		}
		
		
		System.out.println("Choisissez la case où le placer (ligne/colonne)");						
		ligne=sc.nextInt();  //choix de la ligne
		
		while(ligne<1 || ligne>15){ //si l'entrée est incorrecte
			System.out.println("Choisissez la case où le placer (colonne)");						
			ligne=sc.nextInt();
		}
		
		colonne=sc.nextInt();  //choix de la colonne (uniquement colonne car mot horizontal)
		
		while(colonne<1 || colonne>15){ //si l'entrée est incorrecte
			System.out.println("Choisissez la case où le placer (colonne)");						
			colonne=sc.nextInt();
		}
		
		if (plateau.tab[ligne-1][colonne - 1].equalsIgnoreCase(" ")) { //si la case est vide
		
			plateau.tab[ligne-1][colonne-1]=joueur.main.contenumain.get(lettre-1).nom;  ////7 pour la lignne car doit suivre la premiere lettre placée + horizontal
	    	 
	    	 
	    	 if(mot==null){
	    		 mot=(plateau.tab[ligne-1][colonne-1]);//MAJ du mot
	    	 }
	    	 else mot+=(plateau.tab[ligne-1][colonne-1]); //MAJ du mot
	    	 
	    	 valD[x][y]=ligne-1; valD[x][y+1]=colonne-1;//indice de la case joué 
	    	 				 		
	 		plateau.plateauconsole(plateau.tab); //aff tableau
	 		
	 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
	 		
	 		joueur.main.affichermain();  //aff main apres coup
    	 
		}// fin if case vide
		else{
			//System.out.println("Il y deja une lettre dans cette case");
			mot+=(plateau.tab[ligne-1][(colonne-1)]);
			valD[x][y]=ligne-1; valD[x][y+1]=colonne-1;//indice de la case joué 
			reutilise=true;
		}
		
		
		int n1 = 1, choix2=0, cpt=1;
		
		
		while (n1<7 && (colonne-1+cpt)<15) //sept lettre dans la main
		{
		  System.out.println("===Choix====\n 1_ placer une letrre\n 2_ retirer la derniere lettre placee\n 0_ fin");
		  choix2 = sc.nextInt();  //nouveau choix de placer ou non
		  
		  
		  switch (choix2) {
		     case 1: {  //si on veut placer une lettre
		     	
		     	System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
				lettre=sc.nextInt();  //choix de la lettre à placer
				
				while(lettre<1 || lettre>joueur.main.contenumain.size()){ //si l'entrée est incorrecte
					System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
					lettre=sc.nextInt();
				}
				
				
				if (plateau.tab[ligne-1][(colonne - 1)+cpt].equalsIgnoreCase(" ")) { //si la case est vide
				
					plateau.tab[ligne-1][(colonne-1)+cpt]=joueur.main.contenumain.get(lettre-1).nom;  ////7 pour la lignne car doit suivre la premiere lettre placée + horizontal
			    	 
			    	 
			    	mot+=(plateau.tab[ligne-1][(colonne-1)+cpt]); //MAJ du mot
			    	valD[x][y]=ligne-1; valD[x][y+1]=colonne-1+cpt;//indice de la case joué  
			    	 				 		
			 		plateau.plateauconsole(plateau.tab); //aff tableau
			 		
			 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
			 		
			 		joueur.main.affichermain();  //aff main apres coup
			    	 
			    	n1++; 		    	 //compteur : pas plus de 7 lettres par tour
			    	cpt++;	//decalage
				}//fin if case vide
				else{
					//System.out.println("Il y deja une lettre dans cette case");
					mot+=(plateau.tab[ligne-1][(colonne-1)+cpt]);
					valD[x][y]=ligne-1; valD[x][y+1]=colonne-1+cpt;//indice de la case joué  
					n1++;
					cpt++;
					reutilise=true;
				}
				
				
		    	 break;
		     }//fin case 1
		     case 2:
		    	 plateau.tab[ligne-1][(colonne-1)+cpt-1]=" ";
		    	 plateau.plateauconsole(plateau.tab);
		    	 break;
		     case 0: { // si on ne veut plus placer de lettre ce tour ci
		    	 if(n1<2){
			    	 System.out.println("Le mot doit comporter au moins 2 lettres");
			    	 annulerderniercouphorizontal(plateau, plateau.tab, ligne, colonne, cpt);
			     }
			     n1=7;
			     System.out.println("fin");
			     	    	 
			     		     
			     break;
		     }//fin case 0
		     
		  } //fin switch
		  
		}// fin while
		
		System.out.println("le mot est : ");
		
		System.out.println(mot);   //affichage du mot obtenu
		
		if(reutilise==false){ annulerderniercouphorizontal(plateau, plateau.tab, ligne, colonne, cpt);}
		
		if (verif.dico(mot).equalsIgnoreCase("Mot correcte")) { //Vérification avec le dico
			System.out.println("Le mot est correct\n");
			joueur.score = joueur.score+scorejoueur.calculMot(sac,valD,mot);
			System.out.println("score joueur : " + joueur.score);
			plateau.plateauconsole(plateau.tab);}  
		else {
			annulerderniercouphorizontal(plateau, tab, ligne, colonne, cpt);
			System.out.println( verif.dico(mot));
			}
		
	}//fin méthode
	
	
	
	/**
	 *  Méthode pour gérer le premier mot du jeu, s'il est placé à la vertical
	 */
	
	
	public void ifplateauvidevertical(Joueur joueur, Sac sac, Plateau1 plateau, String tab[][], int x, int y, int[][] valD,Score scorejoueur){
		
		
		int lettre, ligne, colonne; String mot=null;
		int i=0;
		Dictionnaire dico=new Dictionnaire();
		VerifMot verif=new VerifMot();
		
		
	  	System.out.println("Choisissez la lettre à placer (indiquer son numero/1e lettre du mot) : ");	    
		lettre=sc.nextInt();  //choix de la lettre à placer
		
		while(lettre<1 || lettre>joueur.main.contenumain.size()){ //si l'entrée est incorrecte
			System.out.println("Choisissez la lettre à placer (indiquer son numero/1e lettre du mot) : ");	    
			lettre=sc.nextInt();
		}
		
		System.out.println("Choisissez la case où le placer (ligne)");						
		ligne=sc.nextInt();  //choix de la ligne (uniquement ligne car mot horizontal)
		
		while(ligne<1 || ligne>15){ //si l'entrée est incorrecte
			System.out.println("Choisissez la case où le placer (colonne)");						
			ligne=sc.nextInt();
		}
		
		if (plateau.tab[ligne-1][7].equalsIgnoreCase(" ")) { //si la case est vide
		
			plateau.tab[ligne-1][7]=joueur.main.contenumain.get(lettre-1).nom;  ////7 pour la colonne car doit suivre la premiere lettre placée + horizontal
	    	 
	    	 
	    	 if(mot==null){
	    		 mot=(plateau.tab[ligne-1][7]);//MAJ du mot
	    	 }
	    	 else mot+=(plateau.tab[ligne-1][7]); //MAJ du mot
	    	 
	    	 valD[x][y]=ligne-1; valD[x][y+1]=7;//indice de la case joué  
	    	 
	 		plateau.plateauconsole(plateau.tab); //aff tableau
	 		
	 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
	 		
	 		joueur.main.affichermain();  //aff main apres coup
    	 
		} // fin si case vide
		
		
		int n1 = 1, choix2=0, cpt=1;
		
		
		while (n1<7 && (ligne-1+cpt)<15) //sept lettre dans la main
		{
		  System.out.println("===Choix====\n 1_ placer une letrre\n 2_ retirer la derniere lettre placee\n 0_ fin");
		  choix2 = sc.nextInt();  //nouveau choix de placer ou non
		  
		  
		  switch (choix2) {
		     case 1: {  //si on veut placer une lettre
		     	
		     	System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
				lettre=sc.nextInt();  //choix de la lettre à placer
				
				while(lettre<1 || lettre>joueur.main.contenumain.size()){ //si l'entrée est incorrecte
					System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
					lettre=sc.nextInt();
				}
				
				
				if (plateau.tab[(ligne-1)+cpt][7].equalsIgnoreCase(" ")) { //si la case est vide
				
					plateau.tab[(ligne-1)+cpt][7]=joueur.main.contenumain.get(lettre-1).nom;  ////7 pour la lignne car doit suivre la premiere lettre placée + horizontal
			    	 
			    	 
			    	mot+=(plateau.tab[(ligne-1)+cpt][7]); //MAJ du mot
			    	
			    	valD[x][y]=ligne-1; valD[x][y+1]=7;//indice de la case joué   
			    	 				 		
			 		plateau.plateauconsole(plateau.tab); //aff tableau
			 		
			 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
			 		
			 		joueur.main.affichermain();  //aff main apres coup
			    	 
			    	n1++; 		    	 //compteur : pas plus de 7 lettres par tour
			    	cpt++;
				}//fin si case vide 
				else{
					System.out.println("Il y deja une lettre dans cette case");
				}
				
				
		    	 break;
		     }//fin case 1
		     case 2:
		    	 plateau.tab[(ligne-1)+cpt-1][7]=" ";
		    	 plateau.plateauconsole(plateau.tab);
		    	 break;
		     case 0: { // si on ne veut plus placer de lettre ce tour ci
		    	 if(n1<2){
			    	 System.out.println("Le mot doit comporter au moins 2 lettres");
			    	 annulerderniercoupvertical(plateau, plateau.tab, ligne, 8, cpt);
			     }
			     n1=7;
			     System.out.println("fin");
			     
			     break;
		     }//fin case 0
		     
		  } //fin switch
		  
		}// fin while
		
		System.out.println("le mot est : ");
		
		System.out.println(mot);
		
		if(tab[7][7].equalsIgnoreCase(" ")){			
			annulerderniercoupvertical(plateau, tab, ligne, 8, cpt);			
		}
		
		if (verif.dico(mot).equalsIgnoreCase("Mot correcte")) { //Vérification avec le dico
			System.out.println("Le mot est correct\n");
			joueur.score = joueur.score+scorejoueur.calculMot(sac,valD,mot);
			System.out.println("score joueur : " + joueur.score);
			plateau.plateauconsole(plateau.tab);}  
		else {
			annulerderniercouphorizontal(plateau, tab, ligne, 8, cpt);
			System.out.println( verif.dico(mot));
			}
		
	}//fin méthode
	
	
	
	/**
	 *  Méthode pour placé un mot, s'il est placé à la vertical
	 */
		
	
	public void elseplateauvidevertical(Joueur joueur, Sac sac, Plateau1 plateau, String tab[][], int x, int y, int[][] valD,Score scorejoueur){
		
		int lettre, ligne, colonne; String mot=null;
		int i=0;
		Dictionnaire dico=new Dictionnaire();
		VerifMot verif=new VerifMot();
		boolean reutilise=false; //permet de savoir si le joueur à réutilisé au moins une lettre deja placée
		
	  	System.out.println("Choisissez la lettre à placer (indiquer son numero/1e lettre du mot) : ");	    
		lettre=sc.nextInt();  //choix de la lettre à placer
		
		while(lettre<1 || lettre>joueur.main.contenumain.size()){ //si l'entrée est incorrecte
			System.out.println("Choisissez la lettre à placer (indiquer son numero/1e lettre du mot) : ");	    
			lettre=sc.nextInt();
		}
		
		
		System.out.println("Choisissez la case où le placer (ligne/colonne)");						
		ligne=sc.nextInt();  //choix de la ligne
		
		while(ligne<1 || ligne>15){ //si l'entrée est incorrecte
			System.out.println("Choisissez la case où le placer (colonne)");						
			ligne=sc.nextInt();
		}
		
		colonne=sc.nextInt();  //choix de la colonne (uniquement colonne car mot horizontal)
		
		while(colonne<1 || colonne>15){ //si l'entrée est incorrecte
			System.out.println("Choisissez la case où le placer (colonne)");						
			colonne=sc.nextInt();
		}
		
		
		if (plateau.tab[ligne-1][colonne - 1].equalsIgnoreCase(" ")) { //si la case est vide
		
			plateau.tab[ligne-1][colonne-1]=joueur.main.contenumain.get(lettre-1).nom;  ////7 pour la lignne car doit suivre la premiere lettre placée + horizontal
	    	 
	    	 
	    	 if(mot==null){
	    		 mot=(plateau.tab[ligne-1][colonne-1]);//MAJ du mot
	    	 }
	    	 else mot+=(plateau.tab[ligne-1][colonne-1]); //MAJ du mot
	    	 
	    	 valD[x][y]=ligne-1; valD[x][y+1]=colonne-1;//indice de la case joué  
	    	 				 		
	 		plateau.plateauconsole(plateau.tab); //aff tableau
	 		
	 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
	 		
	 		joueur.main.affichermain();  //aff main apres coup
    	 
		} // fin si case vide 
		else{
			System.out.println("Il y deja une lettre dans cette case");
			mot+=(plateau.tab[ligne-1][(colonne-1)]);
			reutilise=true;
			valD[x][y]=ligne-1; valD[x][y+1]=colonne-1;//indice de la case joué  
		}
		
		
		int n1 = 1, choix2=0, cpt=1;
		
		
		while (n1<7 && (ligne-1+cpt)<15) //sept lettre dans la main
		{
		  System.out.println("===Choix====\n 1_ placer une letrre\n 2_ retirer la derniere lettre placee\n 0_ fin");
		  choix2 = sc.nextInt();  //nouveau choix de placer ou non
		  
		  
		  switch (choix2) {
		     case 1: {  //si on veut placer une lettre
		     	
		     	System.out.println("Choisissez la lettre à placer (indiquer son numero) : ");	    
				lettre=sc.nextInt();  //choix de la lettre à placer
				
				
				
				
				if (plateau.tab[(ligne-1)+cpt][(colonne - 1)].equalsIgnoreCase(" ")) { //si la case est vide
				
					plateau.tab[(ligne-1)+cpt][(colonne-1)]=joueur.main.contenumain.get(lettre-1).nom;  ////7 pour la lignne car doit suivre la premiere lettre placée + horizontal
			    	 
			    	 
			    	mot+=(plateau.tab[(ligne-1)+cpt][(colonne-1)]); //MAJ du mot
			    	
			    	valD[x][y]=ligne-1+cpt; valD[x][y+1]=colonne-1+cpt;//indice de la case joué  
			    	 				 		
			 		plateau.plateauconsole(plateau.tab); //aff tableau
			 		
			 		joueur.main.contenumain.remove(lettre-1);  //MAJ main
			 		
			 		joueur.main.affichermain();  //aff main apres coup
			    	 
			    	n1++; 		    	 //compteur : pas plus de 7 lettres par tour
			    	cpt++;
				}
				else{
					System.out.println("Il y deja une lettre dans cette case");
					mot+=(plateau.tab[ligne-1+cpt][(colonne-1)]);
					valD[x][y]=ligne-1+cpt; valD[x][y+1]=colonne-1+cpt;//indice de la case joué  
					n1++;
					cpt++;
					reutilise=true;
				}
				
				
		    	 break;
		     }//fin case 1
		     case 2:
		    	 plateau.tab[(ligne-1)+cpt-1][colonne-1]=" ";
		    	 plateau.plateauconsole(plateau.tab);
		    	 break;
		     case 0: { // si on ne veut plus placer de lettre ce tour ci
		    	 if(n1<2){
			    	 System.out.println("Le mot doit comporter au moins 2 lettres");
			    	 annulerderniercoupvertical(plateau, plateau.tab, ligne, colonne, cpt);
			     }
			     n1=7;
			     System.out.println("fin");
			     
			     break;
		     }//fin case 0
		     
		  } //fin switch
		  
		}// fin while
		
		System.out.println("le mot est : ");
		
		System.out.println(mot);
		if(!reutilise){ annulerderniercoupvertical(plateau, plateau.tab, ligne, colonne, cpt);}
		if (verif.dico(mot).equalsIgnoreCase("Mot correcte")) { //Vérification avec le dico
			System.out.println("Le mot est correct\n");
			joueur.score = joueur.score+scorejoueur.calculMot(sac,valD,mot);
			System.out.println("score joueur 1 : " + joueur.score);
			plateau.plateauconsole(plateau.tab);}  
		else {
			annulerderniercouphorizontal(plateau, tab, ligne, colonne, cpt);
			System.out.println( verif.dico(mot));
			}
		
	}//fin méthode
	
	
	
	
	/**
	 * Méthode pour changer les lettres de la main du joueur
	 */
	
	public void changerlettres(Joueur joueur, Sac sac){
		
			int choixlettre, nblettres;
			int i=0;
					
			System.out.println("Combien de lettres souhaitez vous changer?\n");
			nblettres=sc.nextInt(); //choix du nombre de lettre à changer
			
			while(1>nblettres || nblettres>7){    //on ne peut pas rentrer autre chose qu'un nombre entre 1 et 7
				System.out.println("Combien de lettres souhaitez vous changer?\n"); //on repete la question en cas d'entree incorrecte
				nblettres=sc.nextInt();
			}
			
				
			while(i<nblettres){ //tant qu'on a pas changé suffsamment de lettre
				
			
				System.out.println("Quelle lettre souhaitez vous changer? Indiquez son numero : \n");
				
				choixlettre=sc.nextInt();  //choix de la lettre à changer				
								
				sac.contenusac.add(joueur.main.contenumain.get(choixlettre-1));  //on remmet la lettre dans le sac
				
				joueur.main.contenumain.remove(choixlettre-1); //on retire la lettre de la main
				
				joueur.main.pioche(sac);  //on pioche une nouvelle lettre
				
				joueur.main.affichermain(); //on affiche la main ainsi MAJ
				
				i++;
			}
			
			
		}
	
	/**
	 *  Méthode pour annuler un coup entier, si le mot est horizontal
	 */
	
	public void annulerderniercouphorizontal(Plateau1 plateau, String tab[][], int ligne, int colonne, int cpt){
		
		while(cpt>0){		
			plateau.tab[ligne-1][(colonne-1)+cpt-1]=" ";
		cpt--;
		}
		plateau.plateauconsole(plateau.tab);
		
		}
	
	/**
	 *  Méthode pour annuler un coup entier, si le mot est vertical
	 */
	
	public void annulerderniercoupvertical(Plateau1 plateau, String tab[][], int ligne, int colonne, int cpt){
		
		while(cpt>0){		
			plateau.tab[(ligne-1)+cpt-1][colonne-1]=" ";
		cpt--;
		}
		plateau.plateauconsole(plateau.tab);
		
		}
	
	public void tourjoueur(Sac sac, Joueur joueur, Plateau1 plateau){
		
	   
		joueur.main.creationmain();
		affichermenu();
		joueur.main.affichermain();
		System.out.println("\nVotre choix : ");
		choixaction=sc.nextInt();
		actionmenu(choixaction, joueur, sac, plateau);
	    
		
	}
	
	public void tourjoueur2(Sac sac, Joueur joueur, Plateau1 plateau){
		
	   
		joueur.main.creationmain();
		affichermenu();
		joueur.main.affichermain();
		System.out.println("\nVotre choix : ");
		choixaction=sc.nextInt();
		actionmenu(choixaction, joueur, sac, plateau);
	  
		
	}
	
	
}
