package Scoring;

public class test {
	
	public static void main(String[] args) {
		
		// C'est du bidouillage juste pour le test
		
		Calcul cl = new Calcul();
		
		String[][] t = new String[15][15];
		for (int i = 0; i < 15; i++) 
		{
			for (int j = 0; j < 15; j++) 
			{
				t[i][j] = " ";
			}
		}
		t[6][6]= "B";t[6][7]= "U";t[6][8]= "T";
		
		cl.placerMot (t,"");
	  
	}
	
	}

	
