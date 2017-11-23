import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Sac {

	protected boolean vide; //Je l'ai mis car permettra peut etre par le suite de l'utiliser pour l'arrête du jeu, si le sac est vide le jeu est fini
	protected ArrayList<Lettre> contenusac; //Arraylist contenant les lettres dispo dans le sac
	
		
	public boolean isVide() {
		return vide;
	}


	public void setVide(boolean vide) {
		this.vide = vide;
	}


	public ArrayList<Lettre> getContenusac() {
		return contenusac;
	}


	public void setContenusac(ArrayList<Lettre> contenusac) {
		this.contenusac = contenusac;
	}
	
	

	public Sac(boolean vide, ArrayList<Lettre> contenusac) {
		super();
		this.vide = vide;
		this.contenusac = new ArrayList();
		
	}
	


//Permet de remplir le sac avec le bon nombre de lettre
	public void remplirsac(){
		
		//Création des lettres et definition de leur valeur et de la quantité
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
		
			
		int i;
		
		//on rempli le sac avec les différentes lettres
		for(i=0;i<A.nombre;i++){
			contenusac.add(A);			
			}
		
		for(i=0;i<B.nombre;i++){			
			contenusac.add(B);			
			}
		
		for(i=0;i<C.nombre;i++){			
			contenusac.add(C);			
			}	
		
		for(i=0;i<D.nombre;i++){			
			contenusac.add(D);			
			}
		
		for(i=0;i<E.nombre;i++){			
			contenusac.add(E);			
			}	
		
		for(i=0;i<F.nombre;i++){			
			contenusac.add(F);			
			}
		
		for(i=0;i<G.nombre;i++){			
			contenusac.add(G);			
			}
		
		for(i=0;i<H.nombre;i++){			
			contenusac.add(H);			
			}
		
		for(i=0;i<I.nombre;i++){			
			contenusac.add(I);			
			}
		
		for(i=0;i<J.nombre;i++){			
			contenusac.add(J);			
			}
		
		for(i=0;i<K.nombre;i++){			
			contenusac.add(K);			
			}
		
		for(i=0;i<L.nombre;i++){			
			contenusac.add(L);			
			}
		
		for(i=0;i<M.nombre;i++){			
			contenusac.add(M);			
			}
		
		for(i=0;i<N.nombre;i++){			
			contenusac.add(N);			
			}
		
		for(i=0;i<O.nombre;i++){			
			contenusac.add(O);			
			}
		
		for(i=0;i<P.nombre;i++){			
			contenusac.add(P);			
			}
		
		for(i=0;i<Q.nombre;i++){			
			contenusac.add(Q);			
			}
		
		for(i=0;i<R.nombre;i++){			
			contenusac.add(R);			
			}
		
		for(i=0;i<S.nombre;i++){			
			contenusac.add(S);			
			}
		
		for(i=0;i<T.nombre;i++){			
			contenusac.add(T);			
			}
		
		for(i=0;i<U.nombre;i++){			
			contenusac.add(U);			
			}
		
		for(i=0;i<V.nombre;i++){			
			contenusac.add(V);			
			}
		
		for(i=0;i<W.nombre;i++){			
			contenusac.add(W);			
			}
		
		for(i=0;i<X.nombre;i++){			
			contenusac.add(X);			
			}
		
		for(i=0;i<Y.nombre;i++){			
			contenusac.add(Y);			
			}
		
		for(i=0;i<Z.nombre;i++){			
			contenusac.add(Z);			
			}
		
		for(i=0;i<Joker.nombre;i++){			
			contenusac.add(Joker);			
			}
		
		
		
		
		Collections.shuffle(contenusac); //mélange les lettres dans le sac (utile par la suite pour la pioche)
	}
	/*Debut modification Faldji */
	
	//retourne le nombre de lettre restant dans le sac tailleSac()
	public int tailleSac() {
		return contenusac.size();
	}//fin tailleSac()
	
	//Fonction TireLettres() retire au hasard des lettres du sac 
	//peut servir pour remplire la main du Joueur en cours.
	public Lettre TireLettres() {
        int max = contenusac.size() - 1;
        Random hasard = new Random();
        int Lettretiree = hasard.nextInt(max + 1);

        return contenusac.remove(Lettretiree);
    }//fin TireLettres()
	
	/*Fin modification Faldji */
	
	//Pour tester le contenu du sac
	public void contenudusac(){
		
		System.out.println("Contenu actuel du sac : ");
		
		for (Lettre pi : contenusac){
			System.out.println(pi.nom);
		}
		
	}
	
}