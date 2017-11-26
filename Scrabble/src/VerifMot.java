import java.io.*;

public class VerifMot {


	public String dico(String mot) {
		File fichier = new File ("DICO.txt");
	    int n = 0;


			try{
				InputStream ips=new FileInputStream(fichier); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String ligne;
				while (((ligne=br.readLine())!=null)){
					
					if(mot.equalsIgnoreCase(ligne))
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
				return "Mot correcte";
			}
			return  "Mot n'existe pas";
			
	}
}