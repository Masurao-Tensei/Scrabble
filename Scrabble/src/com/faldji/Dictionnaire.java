package com.faldji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;
public class Dictionnaire {
 private static ArrayList<String> Dictionnaire;
  
 private static Map dictionnaire = new HashMap();
 private static String[] lettres = { "A", "B", "C", "D", "E",
         "F", "G", "H", "I", "J",
         "K", "L", "M", "N", "O",
         "P", "Q", "R", "S", "T",
         "U", "V", "W", "X", "Y",
         "Z" };
 private static Set[] TousLesMots = new TreeSet[14];
 public static void dico() {
	 System.out.println("Chargement du dictionnaire en cours...");
	   Dictionnaire dico = new Dictionnaire();
	   System.out.println();
	   System.out.println("[Effectué]  Chargement du dictionnaire terminé");
	   System.out.println();
	   /*System.out.println("Tester la Fonction verifie ? 'O' ou 'N'");
	   Scanner scv1 = new Scanner(System.in);
	   String OuiNonv1 =  scv1.nextLine();
	   Scanner scMot1 = new Scanner(System.in);
	   while(OuiNonv1.charAt(0) == 'O'|| OuiNonv1.charAt(0) == 'o') {
		   System.out.println("Entrer un Mot à  verifier");
		   
	   // Test de mot avec la methode verifie des lettres ci-dessus 
	   System.out.println(dico.verifie1(scMot1.nextLine()));
	   System.out.println("Retester la Fonction verifie1 ? 'O' ou 'N'");
	   OuiNonv1 =  scv1.nextLine();}*/
	   
 }
 public static void dictionnaire() {  
	 BufferedReader br = null;
	    Vector res = new Vector();
	    String ligne;
	    boolean verif = false;
	    File file = new File("DICO.txt"); 
	 try
	    {  br = new BufferedReader(new FileReader(new File(Scrabble.class.getResource("DICO.txt").getFile())));}
	    catch (FileNotFoundException e)
	    { System.out.println("Pas de dictionnaire: " + file);
	      return; 
	    }
	 for (int i = 0; i < lettres.length; i++)
	    { 
	      Set[] conteneur = new TreeSet[14]; 
	      for (int j = 0; j < 14; j++)
	      { conteneur[j] = new TreeSet(); }
	    
	      dictionnaire.put(lettres[i],conteneur);
	    }
	    for (int k = 0; k < 14; k++)
	    { TousLesMots[k] = new TreeSet(); }
	    while (!verif)
	    { try { ligne = br.readLine(); }
	      catch (IOException e)
	      { verif = true;
	        return;
	      }
	      System.out.println(ligne); 
	      if (ligne == null) 
	      { verif = true; } 
	      chargeDico(ligne);    
	    }
 }
 public static void chargeDico( String ligne){
	
	    if (ligne == null) { return; }
	    StringTokenizer st = new StringTokenizer(ligne,",. {}()?!");
	    while (st.hasMoreTokens())
	    { String mot = st.nextToken();
	      String mot1 = mot.toUpperCase();
	      int taille = mot1.length();
	      if (taille <= 1 || taille > 15) { continue; }
	      for (int i = 0; i < taille; i++)
	      { String c = mot1.charAt(i) + "";
	        Set[] motc = (Set[]) dictionnaire.get(c);
	        if (motc != null)
	        { motc[taille-2].add(mot1);
	          dictionnaire.put(c,motc); 
	          TousLesMots[taille-2].add(mot1);
	        }
	      }}
 }
 public void initdico() {
	
}
public  Dictionnaire() {

    File file = new File("DICO.txt"); 
	//renvoie le fichier DICO.txt
	   try
	   { Scanner sc = new Scanner(new File(getClass().getResource("DICO.txt").getFile()));
        Dictionnaire = new ArrayList<>();
        while (sc.hasNext()) {
            Dictionnaire.add(sc.next());
        }
        }
	   catch (FileNotFoundException e)
	   { System.out.println("Le dictionnaire : " + file+" est introuvable");
	     return; 
	   }
}
    //recherche un mot dans le Dictionnaire
public static boolean verifie1(Mot _mot) {
  String mot = _mot+"";
  int taillemt = mot.length(); 
  String lett1 = mot.charAt(0)+"";
  Set[] mot1 = (Set[]) dictionnaire.get(lett1);
  //System.out.println(" Dictionary: " + mot1[taillemt]); 
  if (mot1 == null) 
  { System.out.println("motvide");
	  return false; } 
  return mot1[taillemt-2].contains(mot);     
} 
    public boolean verifie1(String mot) {
    	if(mot.length() <= 1) {
    		return false;
    	}
    	else {
        return Dictionnaire.stream().anyMatch((motactuel) -> (mot.equalsIgnoreCase(motactuel)));
    	}
    
    }//Fin verification
    
    
    public static Set verifie(List _lettre, int i){
      Set retour = new TreeSet();
      if (i < 2) { return retour; } 

      String lettre1 = (String) _lettre.get(0);
      if (lettre1.equals(" "))
      { retour.addAll(TousLesMots[i-2]); }
      else 
      { Set[] mot1 = (Set[]) dictionnaire.get(lettre1);
        if (mot1 != null) 
        { retour.addAll(mot1[i-2]); }
      }

      for (int j = 1; j < _lettre.size(); j++)
      { String lett = (String) _lettre.get(j);
        if (lett.equals(" "))
        { continue; }
        Set[] mots = (Set[]) dictionnaire.get(lett);
        if (mots != null) 
        { Set tailleMoti = mots[i-2];
          retour.retainAll(tailleMoti); // intersection
        } 
        else 
        { retour = new HashSet(); } 
      }
      return retour;
    }
        
    public static Set getList(String ch, int i)
    { Set[] words = (Set[]) dictionnaire.get(ch);
      return words[i-2];
    } 
    
    //Taille du dictionnaire
    public int size() {
        return Dictionnaire.size();
    }

    //Retourner un mot dans la liste du Dico au Param donnÃ©.
    public String get(int i) {
        return Dictionnaire.get(i);
    }
   /* public static void main(String[] args)
    {  System.out.println("Chargement du dictionnaire en cours...");
	   Dictionnaire dico = new Dictionnaire();
	   System.out.println();
	   System.out.println("[Effectué]  Chargement du dictionnaire terminé");
	   System.out.println();
	    System.out.println("Tester la Fonction verifie ? 'O' ou 'N'");
	   Scanner scv1 = new Scanner(System.in);
	   String OuiNonv1 =  scv1.nextLine();
	   Scanner scMot1 = new Scanner(System.in);
	   while(OuiNonv1.charAt(0) == 'O'|| OuiNonv1.charAt(0) == 'o') {
		   System.out.println("Entrer un Mot à  verifier");
		   
	   // Test de mot avec la methode verifie des lettres ci-dessus 
	   System.out.println(dico.verifie1(scMot1.nextLine()));
	   System.out.println("Retester la Fonction verifie1 ? 'O' ou 'N'");
	   OuiNonv1 =  scv1.nextLine();
	   }}*/
}//Fin de la classe Dictionnaire
