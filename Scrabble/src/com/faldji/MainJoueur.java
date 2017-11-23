package com.faldji;
import java.util.ArrayList;
import java.util.Random;

public class MainJoueur {
		
	
		protected int nbmaxlettres; //nombre max de lettres dans la main du joueur
		protected ArrayList<Lettre> contenumain;
		protected ArrayList<Lettre> contenusac;
		Sac s1;
		
						
		public int getNbmaxlettres() {
			return nbmaxlettres;
		}


		public void setNbmaxlettres(int nbmaxlettres) {
			this.nbmaxlettres = nbmaxlettres;
		}


		public ArrayList<Lettre> getContenumain() {
			return contenumain;
		}


		public void setContenumain(ArrayList<Lettre> contenumain) {
			this.contenumain = contenumain;
		}
			

		public ArrayList<Lettre> getContenusac() {
			return contenusac;
		}


		public void setContenusac(ArrayList<Lettre> contenusac) {
			this.contenusac = contenusac;
		}


		public Sac getS1() {
			return s1;
		}


		public void setS1(Sac s1) {
			this.s1 = s1;
		}



		public MainJoueur(int nbmaxlettres, ArrayList<Lettre> contenumain, ArrayList<Lettre> contenusac, Sac s1) {
			super();
			this.nbmaxlettres = 7;
			this.contenumain = new ArrayList();
			this.contenusac = contenusac;
			this.s1 = s1;
		}
		

		
		//methode de pioche
		public void pioche(Sac s1){
					
			
			contenumain.add(s1.contenusac.get(0));//on ajoute la premiere lettre du sac dans la main
							
			s1.contenusac.remove(0); //on retire cette meme lettre du sac
							 
		}
		

		//creation de la main 
		public void creationmain(){
					
			
			
			while(contenumain.size()<7){
				pioche(s1);
			}
			
					
		}
		
		public void affichermain(){
			
			//Pour afficher le contenu de la main de départ
			System.out.println("Contenu de votre main : ");
			
			for (Lettre li : contenumain){
				System.out.println(li.nom);
			}
			
		}
				
				
			
		
		
		
	
}
