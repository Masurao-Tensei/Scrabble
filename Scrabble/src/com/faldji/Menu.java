package com.faldji;
import java.util.Scanner;


public class Menu {

	protected int choixaction;
	protected int possibilitechoix;
	protected Joueur joueur;
	
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
	
	public void affichermenu(){
		
		
			System.out.println("\nChoisissez une action : \n "
					+ "1 : Poser un mot, \n "
			 		+ "2 : Changer des lettres, \n"
			 		+ "0 : Fin de tour. \n");
			
		}
	
	
	public void actionmenu(int choixaction, Joueur joueur, Sac sac){
		
		switch(choixaction)
	    {
        case 1 :
        	System.out.println("Faudra faire la méthode pour poser un mot");
        break;
        
        case 2:
        	
        	changerlettres(joueur,sac);
        break;
        default:
            System.out.println("Fin de tour."); 
        break;
	    }
		
	}
	
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
