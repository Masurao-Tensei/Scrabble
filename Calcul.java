package Scoring;

import java.util.ArrayList;
import java.util.Scanner;



public class Calcul {
	  
	private static String mot = "";//mot que joue le joueur : concatenation de chaque lettre du joueur
	protected ArrayList<Lettre_Point> Let_P;//contient les caractere possible et leurs valeurs points;
	protected int[][] valD; //il va stocker l'indice des cases ou une lettre est placé ,utile pour lettrre*2, mot*2 etc..
	
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

	
	public void placerMot(String[][] t) {
		int i;
        int x = 0,y =0;
        valD = new int[7][2];
		
		System.out.println("===Choix====\n 1_ Mot horizontale\n 2_ Mot Verticale");
			i = sc.nextInt();
			sc.nextLine();

			switch (i) {
			case 1:
			{
				if (vide(t) == true)
				{
					System.out.println("Premier Lettre du jeu");
					t[7][7] = sc.nextLine();
					
					mot+=t[7][7];
					valD[x][y]=7; valD[x][y+1]=7;//indice de la case joué 
					int n1 = 1,n2 = 0;
					int j = 8; 
					while (n1<7) //sept lettre dans le sac
					{
					  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
					  n2 = sc.nextInt();
					  sc.nextLine();

					  switch (n2) {
					     case 1: {
					    	 t[7][j] = sc.nextLine();
					    	 mot+=t[7][j];
					    	 x++;
					    	 valD[x][y]=7; valD[x][y+1]=j;//indice de la case joué 
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
						valD[x][y]=lig - 1; valD[x][y+1]=col - 1;//indice de la case joué 
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
						    	 x++;
						    	 valD[x][y]=lig-1; valD[x][y+1]=col;//indice de la case joué 
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
					t[7][7] = sc.nextLine();
					valD[x][y]=7; valD[x][y+1]=7;//indice de la case joué 
					mot+=t[7][7];
					
					int n1 = 1,n2 = 0;
					int j = 8; 
					while (n1<7)
					{
					  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
					  n2 = sc.nextInt();
					  sc.nextLine();

					  switch (n2) {
					     case 1: {
					    	 t[j][7] = sc.nextLine();
					    	 x++;
					    	 valD[x][y]=j; valD[x][y+1]=7;//indice de la case joué 
					    	 mot+=t[j][7];
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
						valD[x][y]=lig - 1; valD[x][y+1]=col - 1;//indice de la case joué 
						int n1 = 1,n2 = 0;
						while (n1<7)
						{
						  System.out.println("===Choix====\n 1_ placer une letrre\n 0_ fin");
						  n2 = sc.nextInt();
						  sc.nextLine();

						  switch (n2) {
						     case 1: {
						    	 t[lig][col-1] = sc.nextLine();
						         x++;
						         valD[x][y]=lig; valD[x][y+1]=col - 1;//indice de la case joué 
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
			System.out.println("score : "+this.calculMot());
	}

	public static void affTableau(String[][] t) {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print("[" + t[i][j] + "]");
			}
			System.out.print("\n");
		}
	}
	
	//un tableau tempon qui est initialisé qui me permettra de sa voir si unr lettre est placé sur une case 
	//à valeur lettre ou mot double ou triple
	public static void tPoint(int[][] p)
	{
		for (int i = 0; i < 15; i++) 
		{
			for (int j = 0; j < 15; j++) 
			{
				p[i][j] = 1;
			}
		}
		
		//case  Mot X3
		p[0][0]=p[0][7]=p[0][14]= 6;
		p[8][0]=p[8][14]= 6;
		p[14][0]=p[14][7]=p[14][14]= 6;
		
		//case  Mot X2
				p[01][01]=p[02][02]=p[03][03]=p[04][04]= 4;
				p[13][01]=p[12][02]=p[11][03]=p[10][04]= 4;
				p[10][10]=p[11][11]=p[12][12]=p[13][13]= 4;
				p[01][13]=p[02][12]=p[03][11]=p[04][10]= 4;
				
		//case  Lettre X3
				     p[05][01]=p[9][01]= 3;
		        p[01][5]=p[05][5]=p[9][5]=p[13][5]= 3;
				p[01][9]=p[05][9]=p[9][9]=p[13][9]= 3;
				     p[05][13]=p[9][13]= 3;
				
		//case  Lettre X2
			  p[03][00]=p[11][00]= 2;
			  p[05][02]=p[9][02]= 2;
	          p[00][03]=p[07][03]=p[14][03]= 2;
			  p[02][06]=p[06][06]=p[8][06]=p[12][06]= 2;
			  p[03][07]=p[11][07]= 2;
			  p[02][8]=p[06][8]=p[8][8]=p[12][8]= 2;
			  p[00][11]=p[07][11]=p[14][11]= 2;
			  p[05][12]=p[9][12]= 2;
			  p[03][14]=p[11][14]= 2;
	}
	
	
	/* Chaque lettre du mot jouer est un char du coup j'ai créer une classe avec char et son point pour faciliter le scoring*/ 
	/* */
	public void lettre_Point()
	{
		Let_P  = new ArrayList<Lettre_Point>();
		Let_P.add(new Lettre_Point('A',1));
		Let_P.add(new Lettre_Point('B',3));
		Let_P.add(new Lettre_Point('C',3));
		Let_P.add(new Lettre_Point('D',2));
		Let_P.add(new Lettre_Point('E',1));
		Let_P.add(new Lettre_Point('F',4));
		Let_P.add(new Lettre_Point('G',2));
		Let_P.add(new Lettre_Point('H',4));
		Let_P.add(new Lettre_Point('I',1));
		Let_P.add(new Lettre_Point('J',8));
		Let_P.add(new Lettre_Point('K',10));
		Let_P.add(new Lettre_Point('L',1));
		Let_P.add(new Lettre_Point('M',2));
		Let_P.add(new Lettre_Point('N',1));
		Let_P.add(new Lettre_Point('O',1));
		Let_P.add(new Lettre_Point('P',3));
		Let_P.add(new Lettre_Point('Q',8));
		Let_P.add(new Lettre_Point('R',1));
		Let_P.add(new Lettre_Point('S',1));
		Let_P.add(new Lettre_Point('T',1));
		Let_P.add(new Lettre_Point('U',1));
		Let_P.add(new Lettre_Point('V',4));
		Let_P.add(new Lettre_Point('W',10));
		Let_P.add(new Lettre_Point('X',10));
		Let_P.add(new Lettre_Point('Y',10));
		Let_P.add(new Lettre_Point('Z',10));
	}
	
	//
	public int calculmot() //calcul du mot du tout court, ça va servir après, pour le calcul dans les case pour mot*3 etc...
	{
		int n = 0;
		lettre_Point();
		for (int i = 0; i < mot.length(); i++) {
					for (int j = 0; j < Let_P.size(); j++) {
						if(mot.charAt(i)==(Let_P.get(j).getLettre()))
						{
						 n += Let_P.get(j).getPoint();  
					    }
				}
		}
	
		return n;
    }
	
	/* Calcul du mot en tenant compte des cases à valeur  mot*3 et mot*2, lettre*2 et lettre*3
	 * */ 
	public int calculMot() // pour moi,renvoi un entier pour permettre de faire un cumul à chaque tour de joueur
	{
		int[][] t = new int[15][15];
		int n = 0;
		int m=0,mm=0,r=0,rr=0, n1=0;
		
		lettre_Point();
		tPoint(t);
		for (int i = 0; i < mot.length(); i++) {
			if(t[valD[i][0]][valD[i][1]]==1){
		    	n1++;
		    	if (n1 == mot.length()){ n=calculmot(); }
			   }
			//si la lettre est placé sur la case lettre x2
		    if(t[valD[i][0]][valD[i][1]]==2){
		    	for (int j = 0; j < Let_P.size(); j++) {
					if(mot.charAt(i)==(Let_P.get(j).getLettre()))
					{
					 r=1;// elle sert a faire le calcul après si ce n'est pas la derniere lettre du mot
					 //au cas ou c'est la dernière lettre,elle tient compte d'une lettre placésur la case mot x2 ou 3
					 if(m==1){ n = (calculmot() +Let_P.get(j).getPoint())*2;}
					 else if(mm==1){ n = (calculmot() +Let_P.get(j).getPoint())*3;}
					      else {n = (calculmot() +Let_P.get(j).getPoint());}
				    }
			   }
					 
			 }
		  //si la lettre est placé sur la case lettre x3
            if(t[valD[i][0]][valD[i][1]]==3){
				for (int j = 0; j < Let_P.size(); j++) {
					if(mot.charAt(i)==(Let_P.get(j).getLettre()))
					{
						rr = 1; // elle sert a faire le calcul après si ce n'est pas la derniere lettre du mot
						 //au cas ou c'est la dernière lettre,elle tient compte d'une lettre placésur la case mot x2 ou 3
						 if(m==1){ n = (calculmot() +(Let_P.get(j).getPoint()*2))*2;}
						 else if(mm==1){n = (calculmot() + (Let_P.get(j).getPoint()*2))*3;}
						      else {n = (calculmot() +(Let_P.get(j).getPoint()*2));}
				    }
			    }	
            }
          //si la lettre est placé sur la case Mot x2
            if(t[valD[i][0]][valD[i][1]]==4){
            	if ((i+1)!=mot.length())//elle verifie si la lettre n'est pas la dernière lettre du mot
            		{
                    m = 1;	
             	}
             	else // sinon si c'est la derniere lettre, elle tient 
             		//compte d'une des lettre placé sur une case  lettre X2, X3 etc....
             		{
             		for (int j = 0; j < Let_P.size(); j++) {
    					if(mot.charAt(i)==(Let_P.get(j).getLettre()))
    					{
    						if(r==1){ n = (calculmot()*2) + (Let_P.get(j).getPoint()*3);}
    						else if(rr==1){ n = (calculmot()*2) +((Let_P.get(j).getPoint()*2)*3);}
    						     else {n = calculmot()*2;}
    				    }
    			      }	 
             	  }
              }
            
          //si la lettre est placé sur la case Mot x2
            if(t[valD[i][0]][valD[i][1]]==6){
            	if ((i+1)!=mot.length()) //elle verifie si la lettre n'est pas la dernière lettre du mot
            	{
                    mm = 1;	
             	}
             	else  // sinon si c'est la derniere lettre, elle tient 
             		//compte d'une des lettre placé sur une case  lettre X2, X3 etc....
             	{
             		for (int j = 0; j < Let_P.size(); j++) {
    					if(mot.charAt(i)==(Let_P.get(j).getLettre()))
    					{
    						if(r==1){ n = (calculmot()*3) +(Let_P.get(j).getPoint()*3);}
    						else if(rr==1){ n = (calculmot()*3) +((Let_P.get(j).getPoint()*2)*3);}
    						else {n = calculmot()*3;}
    				    }
    			      }	 
             	  }
              }
            
		}
		 return n;
		}
	
	
	
}


