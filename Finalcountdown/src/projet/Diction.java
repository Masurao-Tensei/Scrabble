package projet;

import java.io.*;
import java.util.Scanner;

public class Diction {
	private static Scanner sc;

	public static void main(String[] args){
	
	File fichier = new File ("Dico.txt");
	sc = new Scanner(System.in);

   int n = 0;


		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			System.out.println("Mot Scrabble");
			String Mot = sc.nextLine();
			while (((ligne=br.readLine())!=null)){
				
				if(Mot.equalsIgnoreCase(ligne))
				{
					n=1;
				}
				
				
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		if(n==1)
	{
			System.out.println("Mot correcte");
		}
	else System.out.println("Mot n'existe pas");
		
	}

}