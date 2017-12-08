package projet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionnaire {
	
 private static ArrayList<String> Dictionnaire;
 
 public static void dico() {
	   System.out.println("Chargement du dictionnaire en cours...");
	   Dictionnaire dico = new Dictionnaire();
	   System.out.println();
	   System.out.println("[Effectué]  Chargement du dictionnaire terminé");
	   System.out.println();
	   System.out.println("Tester la Fonction verifie ? 'O' ou 'N'");
	   Scanner scv1 = new Scanner(System.in);
	   String OuiNonv1 =  scv1.nextLine();
	   Scanner scMot1 = new Scanner(System.in);
	   while(OuiNonv1.charAt(0) == 'O'|| OuiNonv1.charAt(0) == 'o') {
		   System.out.println("Entrer un Mot à verifier");
		   
	   // Test de mot avec la methode verifie des lettres ci-dessus 
	   System.out.println(dico.verifie1(scMot1.nextLine()));
	   System.out.println("Retester la Fonction verifie1 ? 'O' ou 'N'");
	   OuiNonv1 =  scv1.nextLine();}
	   
 }
 public Dictionnaire() {   
	 
	   File file= new File("DICO.txt");
	//renvoie le fichier DICO.txt
	   try
	   { Scanner sc = new Scanner(new File(getClass().getResource("DICO.txt").getFile()));
           Dictionnaire = new ArrayList<>();
           while (sc.hasNext()) {
               Dictionnaire.add(sc.next());
           }//end while
           }
	   catch (FileNotFoundException e)
	   { System.out.println("Le dictionnaire : " + file+" est introuvable");
	     return; 
	   }
 }

    //recherche un mot dans le Dictionnaire
    public boolean verifie1(String mot) {
    	if(mot.length() <= 1) {
    		return false;
    	}
    	else {
        return Dictionnaire.stream().anyMatch((motactuel) -> (mot.equalsIgnoreCase(motactuel)));
    	}
    
    }//Fin verification
    
    
    public boolean verifie2(String mot) {
       return false;
       //En cours de dev Faldji
       }
    
    //Taille du dictionnaire
    public int size() {
        return Dictionnaire.size();
    }

    //Retourner un mot dans la liste du Dico au Param donné.
    public String get(int i) {
        return Dictionnaire.get(i);
    }

}