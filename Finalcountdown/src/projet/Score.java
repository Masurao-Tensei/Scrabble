package projet;

import java.util.ArrayList;
import java.util.List;

public class Score {

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
		
		Lettre A= new Lettre("A",9,1);
		Lettre B= new Lettre("B",2,3);
		Lettre C= new Lettre("C",2,3);
		Lettre D= new Lettre("D",3,2);
		Lettre E= new Lettre("E",15,1);
		Lettre F= new Lettre("F",2,4);
		Lettre G= new Lettre("G",2,2);
		Lettre H= new Lettre("H",2,4);
		Lettre I= new Lettre("I",8,1);
		Lettre J= new Lettre("J",1,8);
		Lettre K= new Lettre("K",1,10);
		Lettre L= new Lettre("L",5,1);
		Lettre M= new Lettre("M",3,2);
		Lettre N= new Lettre("N",6,1);
		Lettre O= new Lettre("O",6,1);
		Lettre P= new Lettre("P",2,3);
		Lettre Q= new Lettre("Q",1,8);
		Lettre R= new Lettre("R",6,1);
		Lettre S= new Lettre("S",6,1);
		Lettre T= new Lettre("T",6,1);
		Lettre U= new Lettre("U",6,1);
		Lettre V= new Lettre("V",2,4);
		Lettre W= new Lettre("W",1,10);
		Lettre X= new Lettre("X",1,10);
		Lettre Y= new Lettre("Y",1,10);
		Lettre Z= new Lettre("Z",1,10);
		
		Lettre Joker= new Lettre("_",2,0); //Voir comment le gérer
	
	
	public ArrayList lettre_Point(){
		
		ArrayList<Lettre> Let_P  = new ArrayList<Lettre>();
		
		Let_P.add(A);Let_P.add(B);Let_P.add(C);Let_P.add(D);Let_P.add(E);Let_P.add(F);Let_P.add(G);
		Let_P.add(H);Let_P.add(I);Let_P.add(J);Let_P.add(K);Let_P.add(L);Let_P.add(M);Let_P.add(N);
		Let_P.add(O);Let_P.add(P);Let_P.add(Q);Let_P.add(R);Let_P.add(S);Let_P.add(T);Let_P.add(U);
		Let_P.add(V);Let_P.add(W);Let_P.add(X);Let_P.add(Y);Let_P.add(Z);Let_P.add(Joker);
		
		return Let_P;
		
	}
		

		//
		public int calculmot(Sac sac, String mot) //calcul du mot du tout court, ça va servir après, pour le calcul dans les case pour mot*3 etc...
		{
			int n = 0;
			ArrayList Let_P=lettre_Point();
			for (int i = 0; i < mot.length(); i++) {
						for (int j = 0; j < Let_P.size(); j++) {
							if(mot.substring(i,i)==(((Lettre) Let_P.get(j)).getNom()))
							{
							 n += ((Lettre) Let_P.get(j)).getValeur();  
						    }
					}
			}
		
			return n;
	    }
		
		/* Calcul du mot en tenant compte des cases à valeur  mot*3 et mot*2, lettre*2 et lettre*3
		 * */ 
		public int calculMot(Sac sac, int[][] valD, String mot) // pour moi,renvoi un entier pour permettre de faire un cumul à chaque tour de joueur
		{
			int[][] t = new int[15][15];
			int n = 0;
			int m=0,mm=0,r=0,rr=0, n1=0;
			ArrayList<Lettre> Let_P=lettre_Point();
			
			tPoint(t);
			for (int i = 0; i < mot.length(); i++) {
				if(t[valD[i][0]][valD[i][1]]==1){
			    	n1++;
			    	if (n1 == mot.length()){ n=calculmot(sac,mot); }
				   }
				//si la lettre est placé sur la case lettre x2
			    if(t[valD[i][0]][valD[i][1]]==2){
			    	for (int j = 0; j < Let_P.size(); j++) {
						if(mot.substring(i,i)==(Let_P.get(j).getNom()))
						{
						 r=1;// elle sert a faire le calcul après si ce n"est pas la derniere lettre du mot
						 //au cas ou c"est la dernière lettre,elle tient compte d"une lettre placésur la case mot x2 ou 3
						 if(m==1){ n = (calculmot(sac,mot) +Let_P.get(j).getValeur())*2;}
						 else if(mm==1){ n = (calculmot(sac,mot) +Let_P.get(j).getValeur())*3;}
						      else {n = (calculmot(sac,mot) +Let_P.get(j).getValeur());}
					    }
				   }
						 
				 }
			  //si la lettre est placé sur la case lettre x3
	            if(t[valD[i][0]][valD[i][1]]==3){
					for (int j = 0; j < Let_P.size(); j++) {
						if(mot.substring(i,i)==(Let_P.get(j).getNom()))
						{
							rr = 1; // elle sert a faire le calcul après si ce n"est pas la derniere lettre du mot
							 //au cas ou c"est la dernière lettre,elle tient compte d"une lettre placésur la case mot x2 ou 3
							 if(m==1){ n = (calculmot(sac,mot) +(Let_P.get(j).getValeur()*2))*2;}
							 else if(mm==1){n = (calculmot(sac,mot) + (Let_P.get(j).getValeur()*2))*3;}
							      else {n = (calculmot(sac,mot) +(Let_P.get(j).getValeur()*2));}
					    }
				    }	
	            }
	          //si la lettre est placé sur la case Mot x2
	            if(t[valD[i][0]][valD[i][1]]==4){
	            	if ((i+1)!=mot.length())//elle verifie si la lettre n"est pas la dernière lettre du mot
	            		{
	                    m = 1;	
	             	}
	             	else // sinon si c"est la derniere lettre, elle tient 
	             		//compte d"une des lettre placé sur une case  lettre X2, X3 etc....
	             		{
	             		for (int j = 0; j < Let_P.size(); j++) {
	    					if(mot.substring(i,i)==(Let_P.get(j).getNom()))
	    					{
	    						if(r==1){ n = (calculmot(sac,mot)*2) + (Let_P.get(j).getValeur()*3);}
	    						else if(rr==1){ n = (calculmot(sac,mot)*2) +((Let_P.get(j).getValeur()*2)*3);}
	    						     else {n = calculmot(sac,mot)*2;}
	    				    }
	    			      }	 
	             	  }
	              }
	            
	          //si la lettre est placé sur la case Mot x2
	            if(t[valD[i][0]][valD[i][1]]==6){
	            	if ((i+1)!=mot.length()) //elle verifie si la lettre n"est pas la dernière lettre du mot
	            	{
	                    mm = 1;	
	             	}
	             	else  // sinon si c"est la derniere lettre, elle tient 
	             		//compte d"une des lettre placé sur une case  lettre X2, X3 etc....
	             	{
	             		for (int j = 0; j < Let_P.size(); j++) {
	    					if(mot.substring(i,i)==(Let_P.get(j).getNom()))
	    					{
	    						if(r==1){ n = (calculmot(sac,mot)*3) +(Let_P.get(j).getValeur()*3);}
	    						else if(rr==1){ n = (calculmot(sac,mot)*3) +((Let_P.get(j).getValeur()*2)*3);}
	    						else {n = calculmot(sac,mot)*3;}
	    				    }
	    			      }	 
	             	  }
	              }
	            
			}
			System.out.println(n);
			 return n;
			}
}
